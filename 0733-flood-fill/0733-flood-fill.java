class Solution {
    /*
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
    
    */
    
//      BFS
    class Pair{
        int sr;int sc;
            Pair(int sr,int sc){
            this.sr=sr;this.sc=sc;
        }
    }
     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
         int target=image[sr][sc];
         image[sr][sc]=color;
         if(target==color){
             return image;
         }
         final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
         Queue<Pair> q=new LinkedList<>();
         q.add(new Pair(sr,sc));
         while(!q.isEmpty()){
             Pair curr=q.remove();
             for(int []dir:directions){
                 int nrow=curr.sr+dir[0];
                 int ncol=curr.sc+dir[1];
                 if(isValid(nrow,ncol,image,target)){
                     image[nrow][ncol]=color;
                     q.add(new Pair(nrow,ncol));
                 }
             }
         }
         return image;
     }
    public boolean isValid(int nrow,int ncol,int [][]image,int target){
        if(nrow<0 || nrow>=image.length || ncol<0 || ncol>=image[0].length || image[nrow][ncol]!=target){
            return false;
        }else{
            return true;
        }
    }
    
}