class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row=mat.length;
        int col=mat[0].length;
        if((row*col)!=(r*c)){
            return mat;
        }
        int [][]ans=new int[r][c];
        int rowans=0;
        int colans=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                ans[rowans][colans]=mat[i][j];
                colans++;
                if(colans==c){
                    colans=0;
                    rowans++;
                }
            }
        }
        return ans;
    }
}