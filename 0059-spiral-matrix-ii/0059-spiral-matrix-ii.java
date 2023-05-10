class Solution {
    public int[][] generateMatrix(int n) {
        int stcol=0,strow=0,endrow=n-1,endcol=n-1;
        int [][]renew=new int[n][n];
        int reso=1;
      while(stcol<=endcol && strow<=endrow){
        for(int i=stcol;i<=endcol;i++){
            renew[strow][i]=reso++;
        }
        for(int j=strow+1;j<=endrow;j++){
            renew[j][endcol]=reso++;
        }
        for(int i=endcol-1;i>=stcol;i--){
            if(strow==endrow){
                break;
            }
            renew[endrow][i]=reso++;
        }
        for(int j=endrow-1;j>=stcol+1;j--){
            if(stcol==endcol){
                break;
            }
            renew[j][stcol]=reso++;
        }
        stcol++;endcol--;strow++;endrow--;
      }    
        return renew;
    }
}