class Solution {
    public int addDigits(int num) {
     int ans=num;
         int sum=0;
        while(ans>=10){
           sum=0;
           while(ans>0){
            int res=ans%10;
            sum+=res;
            ans=ans/10;
          }
            ans=sum;
        }
        return ans;
    }
}