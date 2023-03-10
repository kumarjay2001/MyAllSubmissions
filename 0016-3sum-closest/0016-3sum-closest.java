class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int close=Integer.MAX_VALUE;
        int sum=0;
        Arrays.sort(nums);
        
        for(int i=0;i<nums.length;i++){
            
            int low=i+1,high=nums.length-1;
            while(low<high){
               sum=nums[low]+nums[high]+nums[i];
               if(sum==target){
                   return sum;
               }
               else if(Math.abs(target-close)>Math.abs(target-sum)){
                   close=sum;
               }
              else  if(target>=sum){ 
                  low++;
               }else{
                   high--;
               }
            }
        }
        return close;
    }
}