class Solution {
    public int[] findOrder(int numCourses, int[][] prereq) {
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        for(int i=0; i<numCourses; i++) al.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        for(int i=0; i<prereq.length; i++){
            al.get(prereq[i][1]).add(prereq[i][0]);
            indegree[prereq[i][0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int idx=0;
        while(!q.isEmpty()){
            int curr=q.remove();
            // al1.add(curr);
            ans[idx++] = curr;
            for(int it:al.get(curr)){
                indegree[it]--;
                if(indegree[it]==0)
                    q.add(it);
            }
        }
        if(idx!=numCourses) return new int[0];
        else{
            return ans;
        }
        
        
        
        
        
    }
}