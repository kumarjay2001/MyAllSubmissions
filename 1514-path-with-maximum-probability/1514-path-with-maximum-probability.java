class Solution {
   class Pair{
       int node;
       double dis;
       public Pair(int node,double dis){
           this.node=node;
           this.dis=dis;
       }
   }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p));
        }
        double[]dist=new double[n];
        Arrays.fill(dist,0.0);
        dist[start]=1.0;
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int curr=q.remove();
            for(Pair it:adj.get(curr)){
                int node=it.node;
                double dis=it.dis;
                double prob=dist[curr]*dis;
                if(prob>dist[node]){
                    dist[node]=prob;
                    q.add(node);
                }
            }
        }
        return dist[end];
    }
}