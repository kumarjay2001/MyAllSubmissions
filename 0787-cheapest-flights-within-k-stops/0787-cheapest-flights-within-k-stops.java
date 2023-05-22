class Solution {
    class Pairs{
        int dest;
        int d;
        Pairs(int dest,int d){
            this.dest=dest;
            this.d=d;
        }
    }
    class Tuple{
        int src;
        int dist;
        int stops;
        Tuple(int src,int dist,int stops){
            this.src=src;
            this.dist=dist;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pairs>> adj=new ArrayList<>();
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
            int curr=it.src;
            int cost=it.dist;
            int stops=it.stops;
            if(stops>k)continue;
            for(Pairs i:adj.get(curr)){
                int adjnode=i.dest;
                int nw=i.d;
                if(cost+nw<dis[adjnode]){
                    dis[adjnode]=cost+nw;
                    q.add(new Tuple(adjnode,dis[adjnode],stops+1));
                }
            }
        }
                return dis[dst]==Integer.MAX_VALUE?-1:dis[dst];

    }
}