class Solution {
    public long minCost(int[] nums, int[] cost) {
        long ans=0;
        int l=Integer.MAX_VALUE,r=Integer.MIN_VALUE;
       for(int i=0;i<nums.length;i++){
           l=Math.min(l,nums[i]);
           r=Math.max(r,nums[i]);
       } 
        while(l<=r){
            int mid=l+(r-l)/2;
            long cost1=findcost(nums,cost,mid);
            long cost2=findcost(nums,cost,mid+1);
            ans=Math.min(cost1,cost2);
            if(cost1>=cost2){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
    public long findcost(int []nums,int []cost,int mid){
      long ans=0;
       for(int i=0;i<cost.length;i++){
           ans+=(long)((long)Math.abs(nums[i]-mid))*cost[i];
       } 
        return ans;
    }
}