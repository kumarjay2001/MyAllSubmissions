class DisjointSet{
    int []size;
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
        if(u==par[u]){
            return u;
        }
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
    public int makeConnected(int n, int[][] connections) {
        int V=connections.length;
        int exnd=0;
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<V;i++){
            // for(int j=0;j<V;j++){
                int u=connections[i][0];
                int v=connections[i][1];
                if(ds.parent(u)==ds.parent(v)){
                    exnd++;
                }else{
                    ds.union(u,v);
                }
            // }
        }
        int cmp=0;
        for(int i=0;i<n;i++){
           if(ds.par[i]==i){
               cmp++;
           } 
        }
        if(exnd>=cmp-1){
            return cmp-1;
        }
        return -1;
    }
}