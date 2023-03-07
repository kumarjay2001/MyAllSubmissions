class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       ArrayList<Integer> al=new ArrayList<>();
        int m=matrix.length;
        int n=matrix[0].length;
        int startrow=0,startcol=0,endrow=m-1,endcol=n-1;
        while(startrow<=endrow && startcol<=endcol){
            for(int i=startcol;i<=endcol;i++){
                 System.out.println("Huehue");
                al.add(matrix[startrow][i]);
            }
            for(int j=startrow+1;j<=endrow;j++){
               
                al.add(matrix[j][endcol]);
            }
            for(int i=endcol-1;i>=startcol;i--){
                 if(startrow==endrow){ // if there is a single row
                    return al;
                }
                al.add(matrix[endrow][i]);
            }
            for(int j=endrow-1;j>=startrow+1;j--){
                 if(startcol==endcol){ // if there is a single col
                    return al;
                }
                al.add(matrix[j][startcol]);
            }
            startrow++;endrow--;startcol++;endcol--;
        }
        return al;
    }
}