class Solution {
    class Pair{
        int i;int j;int t;
        Pair(int i,int j,int t){
            this.i=i;
            this.j=j;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int tnt=0;
        int [][] vis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    vis[i][j]=2;
                    q.add(new Pair(i,j,0));
                }else if(grid[i][j]==0){
                    vis[i][j]=0;
                }else{
                    tnt++;
                }
            }
        }
        
        int []fi={-1,0,1, 0};
        int []si={0 ,1,0,-1};
        int time=0;
        int cnte=0;
        while(!q.isEmpty()){
            int r=q.peek().i;
            int c=q.peek().j;
            int t=q.peek().t;
            time=Math.max(time,t);
            q.remove();
            for(int i=0;i<4;i++){
                int nr=r+fi[i];
                int nc=c+si[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n &&vis[nr][nc]!=2 && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    cnte++;
                    q.add(new Pair(nr,nc,t+1));
                }
            }
        }
        if(cnte!=tnt){
            return -1;
        }
        return time;
    }
}