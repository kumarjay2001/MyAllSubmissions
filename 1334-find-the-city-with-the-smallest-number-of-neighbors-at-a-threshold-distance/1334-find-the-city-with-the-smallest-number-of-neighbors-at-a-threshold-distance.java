class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
     int[][] dist = new int[n][n];
        for (int[] dp : dist) Arrays.fill(dp, (int) 1e4 + 1); 

         for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
          for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == (int) 1e4 + 1 || dist[k][j] == (int) 1e4 + 1) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
        
       int city = n;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) if (dist[i][j] <= distanceThreshold) count++;
            if (count <= city) {
                city = count;
                ans = i;
            }
        }
        return ans;
        

    }
} 