class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> al=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int strow=0,stcol=0,endrow=m-1,endcol=n-1;
        while(strow<=endrow && stcol<=endcol){
            for(int i=stcol;i<=endcol;i++){
                al.add(matrix[strow][i]);
            }
            for(int j=strow+1;j<=endrow;j++){
                al.add(matrix[j][endcol]);
            }
            for(int i=endcol-1;i>=stcol;i--){
                 if(strow==endrow){
                     break;
                 }
                 al.add(matrix[endrow][i]);
            }
            for(int i=endrow-1;i>=strow+1;i--){
                if(stcol==endcol){
                    break;
                }
                 al.add(matrix[i][stcol]);
            }
            strow++;stcol++;endrow--;endcol--;
        }
        return al;
    }
}