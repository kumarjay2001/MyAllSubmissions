class Solution {
    public int maxValue(int n, int index, int maxSum) {
       long emptyright=n-index-1;
       long emptyleft=index;
       long l=1;
       long h=maxSum;
       long leftsum=0;
       long rightsum=0;
       long totsum =0;
        long res=0;
        while(l<=h){
            long mid=(h-l)/2+l;
            long el=mid-1;
            if(emptyright<=el){
                rightsum=(el*(el+1))/2-((el-emptyright)*(el-emptyright+1)/2);
            }else{
                rightsum=(el*(el+1))/2+(emptyright-el);
            }
            if(emptyleft<=el){
                leftsum=(el*(el+1))/2-((el-emptyleft)*(el-emptyleft+1)/2);
            }else{
                leftsum=(el*(el+1))/2+(emptyleft-el);
            }
            totsum=leftsum+mid+rightsum;
            if(totsum>maxSum){
                h=mid-1;
            }else{
                l=mid+1;
                res=mid;
            }
        }
        return (int)res;
    }
}