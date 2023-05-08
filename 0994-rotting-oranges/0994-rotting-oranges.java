class Solution {
     int res=0;
    class Pair{
        int r;int c;int t;
        Pair(int r,int c,int t){
            this.r=r;
            this.c=c;
            this.t=t; 
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int mycount=0;
        int n=grid[0].length;
        int [][]vis=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }else if(grid[i][j]==0){
                    vis[i][j]=0;
                }else{
                    mycount++;
                }
            }
        }
        int tm=0;
        int cnt=0;
        int []delr={-1,0,1,0};
        int []delc={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().r;
            int c=q.peek().c;
            int t=q.peek().t;
            tm=Math.max(tm,t);
            q.remove();
            for(int i=0;i<4;i++){
                int nr=r+delr[i];
                int nc=c+delc[i];
                if(nr>=0&&nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && vis[nr][nc]!=2){
                    q.add(new Pair(nr,nc,t+1));
                    vis[nr][nc]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=mycount){
            return -1;
        }
        return tm;
    }
   
}