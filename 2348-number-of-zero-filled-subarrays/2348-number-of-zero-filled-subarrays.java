class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0;
        long ans=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                while(i<nums.length && nums[i]==0){
                    count++;
                    i++;
                }
                ans+=(count*(count+1))/2;
                count=0;
            }
        }
        return ans;
    }
}