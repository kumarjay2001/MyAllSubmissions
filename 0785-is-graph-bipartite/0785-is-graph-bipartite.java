class Solution {
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        int V=graph.length;
        for(int i=0;i<V;i++){
            al.add(new ArrayList<>());
        }
         for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].length;j++){
                al.get(i).add(graph[i][j]);
            }
        }
        int m=graph.length;
        int[] col=new int[V];
        for(int i=0;i<V;i++){
            col[i]=-1;
        }
        for(int i=0;i<V;i++){
            if(col[i]==-1){
                if(check(i,al,col)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean check(int i,ArrayList<ArrayList<Integer>> al,int []col){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        col[i]=0;
        while(!q.isEmpty()){
            int curr=q.remove();
            for(int it:al.get(curr)){
                if(col[it]==-1){
                    q.add(it);
                    col[it]=col[curr]==1?0:1;
                }else if(col[it]==col[curr]){
                    return false;
                }
            }
        }
        return true;
    }
}