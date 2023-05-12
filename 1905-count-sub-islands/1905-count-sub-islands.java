class Solution {
    boolean ans=false;
    int res=0;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m=grid1.length;
        int n=grid1[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1){
                    ans=true;
                    dfs(i,j,grid1,grid2);
                    if(ans==true){
                        res++;
                    }
                    
                }
            }
        }
        return res;
    }
    public void dfs(int i,int j,int [][]grid1,int [][]grid2){
        if(i<0|| i>=grid1.length ||j<0|| j>=grid1[0].length || grid2[i][j]==0 ) {
           return;
        }
        if(grid1[i][j]==0){
            ans=false;
            return;
        }
        grid2[i][j]=0;
        dfs(i-1,j,grid1,grid2);
        dfs(i+1,j,grid1,grid2);
        dfs(i,j-1,grid1,grid2);
        dfs(i,j+1,grid1,grid2);
        
    }
    
}