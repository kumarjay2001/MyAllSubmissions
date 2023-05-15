class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int [][]vis=new int[m][n];
        for(int i=0;i<n;i++){
            if(vis[0][i]==0 && board[0][i]=='O'){
                dfs(0,i,board,vis);
            }
            if(vis[m-1][i]==0 && board[m-1][i]=='O'){
                dfs(m-1,i,board,vis);
            }
        }
        for(int i=0;i<m;i++){
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,board,vis);
            }
            if(board[i][n-1]=='O'){
                dfs(i,n-1,board,vis);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }
    }
     int xdir[] = { 0, 0, 1, -1 };
    int ydir[] = { 1, -1, 0, 0 };
    private void dfs( int i, int j,char matrix[][],int [][]vis) {
        if (vis[i][j] == 1) {
            return;
        }
        vis[i][j] = 1;
        for (int a = 0; a < xdir.length; a++) {
            int x = xdir[a] + i;
            int y = ydir[a] + j;
            if (x >= 0 && y >= 0 && x < matrix.length && y < matrix[0].length && matrix[x][y] == 'O') {
                dfs( x, y,matrix,vis);
            }
        }
    }
}