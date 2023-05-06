class Solution {
    
    public void dfs(int row,int col,char[][] grid,int [][] vis){
        vis[row][col]=1;
        int m=grid.length;
        int n=grid[0].length;
        for(int delrow=-1;delrow<=1;delrow++){
            for(int delcol=-1;delcol<=1;delcol++){
               
                  if((delrow==-1&&delcol==-1) || (delrow==-1&&delcol==1) || (delrow==1&&delcol==-1) || (delrow==1&&delcol==1)){
                        continue;
                    }
                 int nrow=row+delrow;
                int ncol=col+delcol;
                if(nrow>=0 &&nrow<m && ncol>=0 &&ncol<n &&grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                    // vis[nrow][ncol]=1;
                    dfs(nrow,ncol,grid,vis);
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int cnt=0;
        int [][] vis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'  ){
                    cnt++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return cnt;
    }
}