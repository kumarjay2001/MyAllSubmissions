class Solution {
    class Pair{
        int r;
        int c;
        int d;
        Pair(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if (grid[0][0] == 1) return -1;
		if (grid[m-1][n-1] == 1) return -1;
        if (m - 1 == 0 && n - 1 == 0) return 1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,1));
        grid[0][0]=1;
         int []frow={0,0,1,-1,1,-1,1,-1};
        int []fcol={1,-1,0,0,1, -1,-1,1};
        while(!q.isEmpty()){
            int r=q.peek().r;
            int c=q.peek().c;
            int d=q.peek().d;
            q.remove();
            for(int i=0;i<8;i++){
                int nr=r+frow[i];
                int nc=c+fcol[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==0){
                    q.add(new Pair(nr,nc,d+1));
                    grid[nr][nc]=1;
                    if(nr==m-1 && nc==n-1){
                        return d+1;
                    }
                }
            }
            
            
        }
        return -1;
    }
}