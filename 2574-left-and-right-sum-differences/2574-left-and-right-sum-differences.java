class Solution {
    public int[] leftRightDifference(int[] nums) {
        int leftsum=0,rightsum=0;
        int n=nums.length;
        for(int i:nums){
            rightsum+=i;
        }
        int []ans=new int[n];
        for(int i=0;i<n;i++){
            rightsum-=nums[i];
            ans[i]=Math.abs(rightsum-leftsum);
            leftsum+=nums[i];

        }
        return ans;
    }
}