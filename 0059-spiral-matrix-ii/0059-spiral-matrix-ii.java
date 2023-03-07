class Solution {
    public int[][] generateMatrix(int n) {
        int [][]matrix=new int[n][n];
        int strow=0,stcol=0,endcol=n-1,endrow=n-1;
        int content=1;
    while(strow<=endrow && stcol<=endcol){
            
        for(int i=stcol;i<=endcol;i++){
                matrix[strow][i]=content;
                content++;
        }
        
        for(int j=strow+1;j<=endrow;j++){
            matrix[j][endcol]=content;
            content++;
        }
        for(int i=endcol-1;i>=stcol;i--){
            matrix[endrow][i]=content;
            content++;
        }
        for(int j=endrow-1;j>=strow+1;j--){
            matrix[j][stcol]=content;
            content++;
        } 
        strow++;stcol++;endrow--;endcol--;
      }
       
        return matrix;
    }
}