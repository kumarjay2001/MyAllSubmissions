//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    class Pair{
        int curr;
        int par;
        Pair(int curr,int par){
            this.curr=curr;
            this.par=par;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean []vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(checkMe(V,adj,vis,i)==true){
                    return true;
                }
            }
        }
         return false;
        
    }
    public boolean checkMe(int V, ArrayList<ArrayList<Integer>> adj,boolean []vis,int cur){
        vis[cur]=true;
         Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(cur,-1));
        while(!q.isEmpty()){
            int curr=q.peek().curr;
            int par=q.peek().par;
            q.remove();
            for(int i:adj.get(curr)){
                if(!vis[i]){
                    q.add(new Pair(i,curr));
                    vis[i]=true;
                }else if(par!=i){
                    return true;
                }
            }
        }
        return false;
    }
}