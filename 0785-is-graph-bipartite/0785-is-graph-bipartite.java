class Solution {
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        int []col=new int[V];
        for(int i=0;i<V;i++){
            col[i]=-1;
        }
        for(int i=0;i<V;i++){
            if(col[i]==-1){
                if(checkMe(adj,V,col,i)==false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean checkMe(ArrayList<ArrayList<Integer>>adj,int V,int []col,int i){
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        col[i]=0;
        while(!q.isEmpty()){
            int curr=q.remove();
            for(int it:adj.get(curr)){
                if(col[it]==-1){
                    q.add(it);
                    col[it]=col[curr]==1?0:1;
                }
                else if(col[it]==col[curr]){
                    return false;
                }
            }
        }
        return true;
    } 
}