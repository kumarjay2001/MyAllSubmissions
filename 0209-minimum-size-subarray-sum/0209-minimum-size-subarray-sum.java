class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0,j=0,sum=0,cnt=Integer.MAX_VALUE,n=nums.length;
        while(i<n){
            sum+=nums[i];
            i++;
            while(sum>=target){
                cnt=Math.min(cnt,i-j);
                sum-=nums[j];
                j++;
            }
        }
        return cnt==Integer.MAX_VALUE?0:cnt;
    }
}