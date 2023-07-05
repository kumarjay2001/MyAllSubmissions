class Solution {
    public int longestSubarray(int[] nums) {
        int cnt=0;
        int maxcnt=0;
        int res=-1;
        int i=0;
        while(i<nums.length){
            if(nums[i]==1){
                cnt++;
            }else{
                if(res==-1){
                    res=i;
                    // cnt++;
                }else{
                    maxcnt=Math.max(cnt,maxcnt);
                    cnt = i - res - 1;
                    res=i;
                }
            }
            i++;
        }
        if(res==-1){
            return nums.length-1;
        }
        maxcnt=Math.max(cnt,maxcnt);
        return maxcnt;
    }
}