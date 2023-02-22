class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min=0,max=0;
        for(int w:weights){
            min=Math.min(w,min);
            max+=w;
        }
        int start=min;
        int end=max;
        while(start<end){
            int mid=start+(end-start)/2;
            int d=solve(mid,weights);
            if(d<=days){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;
    }
     static int solve(int cap,int arr[])
    {
        int count=1;
        int sum=0;
        for(int a:arr)
        {
            if(a>cap)
            return Integer.MAX_VALUE;
            if(sum+a<=cap) {
                sum+=a;
            } else {
                count++;
                sum=a;
            }
        }
        return count;
    }
}