class Solution {
    // public int makeConnected(int n, int[][] connections) {
    //     int m=connections.length;
    //     int ni=connections[0].length;
    //     if(n-1>m)return -1;
    //    List<List<Integer>> al=new ArrayList<>();
    //     for(int i=0;i<=n;i++){
    //         al.add(new ArrayList<>());
    //     }
    //     int res=0;
    //     for(int i=0;i<m;i++){
    //         for(int j=0;j<ni;j++){
    //             al.get(i).add(j);
    //             al.get(j).add(i);
    //         }
    //     }
    //     int []vis=new int[n];
    //     for(int i=0;i<n;i++){
    //         if(vis[i]==0){
    //             res++;
    //             dfs(i,al,vis);
    //         }
    //     }
    //     return res-1;
    // }
    // public void dfs(int i,List<List<Integer>> al,int []vis){
    //     vis[i]=1;
    //     for(Integer j:al.get(i)){
    //         if(vis[j]==0){
    //             dfs(j,al,vis);
    //         }
    //     }
    // }
    public int makeConnected(int n, int[][] c) {
        if(c.length<n-1) return -1;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n+1;i++) ans.add(new ArrayList<>());
        for(int k[]:c){
            ans.get(k[0]).add(k[1]);
            ans.get(k[1]).add(k[0]);
        }
        int res=0, vis[] = new int[n];
        for(int i=0;i<n;i++)
            if(vis[i]==0){
                res++;
                dfs(i,ans,vis);
            }
        return res-1;
    }
    void dfs(int node,List<List<Integer>> ans,int vis[] ){
        vis[node]=1;
        for(int k:ans.get(node))
            if(vis[k]==0) dfs(k,ans,vis);
    }
}