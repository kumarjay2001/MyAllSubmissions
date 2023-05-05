class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        int V=isConnected.length;
        for(int i=0;i<V;i++){
            al.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++ ){
                if(isConnected[i][j]==1 && i!=j){
                    al.get(i).add(j);
                    al.get(j).add(i);
                }
            }
        }
        int count=0;
        boolean []vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                count++;
                dfs(al,i,vis);
            }
        }
        return count;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int curr,boolean []vis){
        vis[curr]=true;
        for(Integer it:adj.get(curr)){
            while(!vis[it]){
                dfs(adj,it,vis);
            }
        }
    }
}