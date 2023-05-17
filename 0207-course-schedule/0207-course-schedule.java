class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int m=prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int V=numCourses;
        int []indeg=new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indeg[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        List<Integer> al=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.remove();
            al.add(curr);
            for(int it:adj.get(curr)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.add(it);
                }
            }
        }
        if(al.size()==V){
            return true;
        }
        return false;
    }
}