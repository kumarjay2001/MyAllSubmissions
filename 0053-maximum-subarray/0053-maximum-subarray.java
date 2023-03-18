class Solution {
    public int maxSubArray(int[] nums) {
        int msum=nums[0];
        int currsum=0;
        for(int i:nums){
            currsum+=i;
            msum=Math.max(currsum,msum);
            if(currsum<0){
                currsum=0;
            }
            // msum=Math.max(currsum,msum);
        }
        return msum;
    }
}