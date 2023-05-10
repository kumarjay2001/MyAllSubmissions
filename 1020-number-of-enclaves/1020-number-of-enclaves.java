class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int incnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    incnt++;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && (i==0||j==0||i==m-1 || j==n-1)){
                    dfs(i,j,grid);
                }
            }
        }
        return incnt-cnt;
        
    }
    int cnt=0;
    public void dfs(int i,int j,int [][]grid){
        int m=grid.length;
        int n=grid[0].length;
        if(i<0||i>=m||j<0||j>=n||grid[i][j]!=1){
            return;
        }
        cnt++;
        grid[i][j]=0;
        dfs(i-1,j,grid);
        dfs(i+1,j,grid);
        dfs(i,j-1,grid);
        dfs(i,j+1,grid);
        
    }
}