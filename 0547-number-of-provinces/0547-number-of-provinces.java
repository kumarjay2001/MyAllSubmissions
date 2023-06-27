class DisjointSet{
    int[]size;
    int []par;
    public DisjointSet(int n){
        size=new int[n];
        par=new int[n];
        for(int i=0;i<n;i++){
            size[i]=1;
            par[i]=i;
        }
    }
    public int parent(int u){
        if(u==par[u])return u;
        return par[u]=parent(par[u]);
    }
    public void union(int u,int v){
        int paru=parent(u);
        int parv=parent(v);
        if(paru==parv)return ;
        if(size[paru]<size[parv]){
            par[paru]=parv;
            size[parv]+=size[paru];
        }
        else{
            par[parv]=paru;
            size[paru]+=size[parv];
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    ds.union(i,j);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            if(ds.par[i]==i){
                cnt++;
            }
        }
        return cnt;
    }
}