//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    // {
    //     // add your code here
    //     int []vis=new int[V];
    //     Stack<Integer> s=new Stack<>();
    //     for(int i=0;i<V;i++){
    //         if(vis[i]==0){
    //             huehue(s,i,vis,adj);
    //         }
    //     }
    //     int i=0;
    //     while(!s.isEmpty()){
    //         vis[i]=s.pop();
    //         i++;
    //     }
    //     return vis;
    // }
    // static void huehue( Stack<Integer> s,int i,int []vis,ArrayList<ArrayList<Integer>> adj){
    //     vis[i]=1;
    //     for(int it:adj.get(i)){
    //         if(vis[it]==0){
    //             huehue(s,it,vis,adj);
    //         }
    //     }
    //     s.push(i);
    // }
    
    
    
    
    
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int []indeg=new int[V];
        int[] top=new int[V];
        for(int i=0;i<V;i++){
            for(Integer it:adj.get(i)){
                indeg[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        int r=0;
        while(!q.isEmpty()){
            int node=q.remove();
            top[r++]=node;
            for(Integer itr : adj.get(node)){
                indeg[itr]--;
                if(indeg[itr]==0){
                    q.add(itr);
                }
            }
        }
        
        return top;
        
    }
}
