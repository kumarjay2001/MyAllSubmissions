class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public int shortestBridge(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        boolean [][]vis=new boolean[m][n];
        boolean flag=false;
        for(int i=0;i<m &&!flag;i++){
            for(int j=0;j<n && !flag;j++){
                if(grid[i][j]==1){
                    dfs(i,j,grid,q,vis);
                    flag=true;
                }
            }
        }
        int lvl=0;
        int [] fcol={-1,0,1,0};
        int []frow={0,1,0,-1};
        
        while(!q.isEmpty()){
            int ni=q.size();
            while(ni-->0){
                int r=q.peek().r;
                int c=q.peek().c;
                q.remove();
                vis[r][c]=true;
                for(int i=0;i<4;i++){
                    int nr=r+fcol[i];
                    int nc=c+frow[i];
                    if(nr<0|| nc<0 || nr>=m || nc>=n || vis[nr][nc]==true){
                        continue;
                    }
                    if(grid[nr][nc]==1){
                        return lvl;
                    }
                    q.add(new Pair(nr,nc));
                    vis[nr][nc]=true;
                }
            }
            lvl++;
        }
        return lvl;
    }
    public void dfs(int i,int j,int [][]grid,Queue<Pair> q,boolean [][]vis){
        if(i<0 || j<0 ||i>=grid.length || j>=grid[0].length || vis[i][j]==true || grid[i][j]==0){
            return;
        }
        vis[i][j]=true;
        q.add(new Pair(i,j));
        dfs(i-1,j,grid,q,vis);
        dfs(i+1,j,grid,q,vis);
        dfs(i,j-1,grid,q,vis);
        dfs(i,j+1,grid,q,vis);
    }
}