class Solution {
       static class Pairs{
        int dest;
        int d;
        Pairs(int dest,int d){
            this.dest=dest;
            this.d=d;
        }
       
    }
     static class Tuple{
         int dest;
         int dis;
         int stops;
         Tuple(int dest,int dis,int stops){
             this.dest=dest;
             this.dis=dis;
             this.stops=stops;
         }
     }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       
         List<List<Pairs>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)  adj.add(new ArrayList<Pairs>());
        for(int i=0;i<flights.length;i++)
            adj.get(flights[i][0]).add(new Pairs(flights[i][1],flights[i][2]));
        int []dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(src,0,0));
        while(!q.isEmpty()){
            Tuple it=q.remove();
            int dest=it.dest;
            int cost=it.dis;
            int stops=it.stops;
            if(stops>k)continue;
            for(Pairs i:adj.get(dest)){
                int adjnode=i.dest;
                int adjwt=i.d;
                if(cost+adjwt<dis[adjnode] && stops<=k){
                    dis[adjnode]=cost+adjwt;
                    q.add(new Tuple(adjnode,dis[adjnode],stops+1));
                }
                    
            }
        }
        return dis[dst]==Integer.MAX_VALUE?-1:dis[dst];
    }
}