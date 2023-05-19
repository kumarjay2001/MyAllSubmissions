//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    class Pair{
        int u;
        int wt;
        Pair(int u,int wt){
            this.u=u;
            this.wt=wt;
        }
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
        for(int i=0;i<N;i++){
            ArrayList<Pair> A = new ArrayList<Pair>();
            adj.add(A);
        }
        
        for(int i=0;i<M;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            adj.get(u).add(new Pair(v, wt));
        }
        
	
		
		
		 boolean[] vis = new boolean[N];
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0;i<N;i++){
            if(!vis[i])
                DFS(i, adj, vis, s);
        }
        
        int[] dist = new int[N];
        for(int i=0;i<N;i++){   
            dist[i] = (int)1e9;
        }
		

		dist[0]=0;
		while(!s.isEmpty()){
		    int node = s.peek();
            s.pop();
		  for(int i=0;i<adj.get(node).size();i++){
                int u = adj.get(node).get(i).u;
                int wt = adj.get(node).get(i).wt;
                
                if(dist[node]+wt<dist[u])
                    dist[u] = dist[node]+wt;
            }
		}
		 for(int i=0;i<N;i++){
            if(dist[i]==(int)1e9)
                dist[i] = -1;
        }
		return dist;
	}
    public void DFS(int node, ArrayList<ArrayList<Pair>> adj, boolean[] vis, Stack<Integer> st){
        vis[node] = true;
        
        for(int i=0;i<adj.get(node).size();i++){
            int u = adj.get(node).get(i).u;
            if(!vis[u])
                DFS(u, adj, vis, st);
        }
        st.add(node);
    }
}