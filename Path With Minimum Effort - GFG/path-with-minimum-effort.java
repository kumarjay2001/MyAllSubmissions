//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
     class Pair{
        int r;
        int c;
        int diff;
        Pair(int r,int c,int diff){
            this.r=r;
            this.c=c;
            this.diff=diff;
        }
    }
    int MinimumEffort(int heights[][]) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)-> x.diff-y.diff);
        int m=heights.length;
        int n=heights[0].length;
        int [][]dest=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dest[i][j]=Integer.MAX_VALUE;
            }
        }
        dest[0][0]=0;
        pq.add(new Pair(0,0,0));
        int []fr={-1,0,1,0};
        int []fc={0,1,0,-1};
        while(!pq.isEmpty()){
            Pair it=pq.remove();
            int r=it.r;
            int c=it.c;
            int diff=it.diff;
            if(r==m-1 && c==n-1){
                return diff;
            }
            for(int i=0;i<4;i++){
                int nr=r+fr[i];
                int nc=c+fc[i];
                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    int newme=Math.max(Math.abs(heights[r][c]-heights[nr][nc]),diff);
                    if(newme<dest[nr][nc]){
                        dest[nr][nc]=newme;
                        pq.add(new Pair(nr,nc,newme));
                    }
                }
            }
        }
        // return 0;
       return dest[m-1][n-1];
    }
}