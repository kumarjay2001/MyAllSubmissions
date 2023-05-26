class Solution {
    class Pair{
        int node;
        int dis;
        // int wt;
        Pair(int node,int dis){
            this.node=node;
            this.dis=dis;
            // this.wt=wt;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0;i<n;i++)adj.add(new ArrayList<>());
		for(int i=0;i<roads.length;i++){
			adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
			 adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
		}
        int []dist=new int[n];
        int []ways=new int[n];
        
         Arrays.fill(ways , 0);
        int mod=(int) 1e9+7;
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        PriorityQueue<Pair>pq=new PriorityQueue<>((x,y)-> x.dis-y.dis);
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair it=pq.remove();
            int node=it.node;
            int dis=it.dis;
            
            for(Pair p:adj.get(node)){
                int adjnode=p.node;
                int nw=p.dis;
                
                if(nw+dis<dist[adjnode]){
                    dist[adjnode]=nw+dis;
                    pq.add(new Pair(adjnode,dist[adjnode]));
                    ways[adjnode]=ways[node]  ;
                }
                else if(nw+dis==dist[adjnode]){
                     ways[adjnode]=(ways[adjnode]+ways[node]) % mod; 
                 }    
            }    
        }
        return ways[n - 1] % mod;

    }
}