class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        // long count=0;
        int mini=-1, maxi=-1,culprit=-1;
        long ans=0;
        int temp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==minK){
                mini=i;
            }
            if(nums[i]==maxK){
                maxi=i;
            }
            if(nums[i]<minK || nums[i]>maxK){
                culprit=i;
            }
             temp=Math.min(mini,maxi)-culprit;
            ans+=(temp<=0)?0:temp;
        }
        return ans;
    }
}