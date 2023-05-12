class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j));
                }else{
                    mat[i][j]=-1;
                }
            }
        }
        int []frow={-1,0,1,0};
        int []fcol={0,1,0,-1};
        while(!q.isEmpty()){
            int r=q.peek().r;
            int c=q.peek().c;
            q.remove();
            for(int i=0;i<4;i++){
                int nr=r+frow[i];
                int nc=c+fcol[i];
                if(nr>=0 && nc>=0 &&  nr<m && nc<n && mat[nr][nc]<0){
                    mat[nr][nc]=mat[r][c]+1;
                    q.add(new Pair(nr,nc));
                    
                }
            }
        }
        return mat;
    }
}