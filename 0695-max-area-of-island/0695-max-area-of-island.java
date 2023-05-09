class Solution {
    int res=0;int ans=0;
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    res=0;
                    dfs(i,j,grid);
                }
            }
        }
        return ans;
    }
    public void dfs(int i,int j,int [][]grid){
        if(i<0 || j<0||i>=grid.length||j>=grid[0].length|| grid[i][j]!=1){
            return;
        }
        res++;
        grid[i][j]=-1;
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
        ans=Math.max(ans,res);
    }
}