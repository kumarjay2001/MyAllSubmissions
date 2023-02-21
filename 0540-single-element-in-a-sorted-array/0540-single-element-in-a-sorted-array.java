class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        return binarymod(nums,0,nums.length-1);
    }
    public int binarymod(int []a,int i,int j){
        int  n=a.length;
        if(a[0]!=a[1]){
            return a[0];
        }
        if(a[n-2]!=a[n-1]){
            return a[n-1];
        }
        while(i<=j){
            int md=(i+j)/2; 
            if(a[md]!=a[md-1] && a[md]!=a[md+1]){
                 return a[md];
            }
            else if(a[md]==a[md-1]){
                int lc=md-i+1;
                if(lc%2!=0){
                    j=md-2;
                }else{
                    i=md+1;
                }
            }else{
                int rc=j-md+1;
                if(rc%2!=0){
                    i=md+2;
                }else{
                    j=md-1;
                }
            }          
        }
        return -1;
    }
}