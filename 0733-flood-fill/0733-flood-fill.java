class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        // int [][]dummy=new int[m][n];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         dummy[i][j]=image[i][j];
        //     }
        // }
        int target=image[sr][sc];
        if(target==color){
            return image;
        }
        dfs(image,target,sr,sc,color);
        return image;
        
    }
    public void dfs(int [][]image,int target,int i,int j,int color){
        if(i>=0 && i<image.length && j>=0 && j<image[0].length && target==image[i][j]){
            image[i][j]=color;
            dfs(image,target,i+1,j,color);
            dfs(image,target,i-1,j,color);
            dfs(image,target,i,j+1,color);
            dfs(image,target,i,j-1,color);
        }
    }
}