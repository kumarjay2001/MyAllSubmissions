class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> al=new ArrayList<>();
         if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        int start=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]+1){
                if(start==nums[i-1]){
                    al.add(Integer.toString(start));
                }else{
                    al.add(start + "->" + nums[i - 1]);
                }
                start=nums[i];
            }
        }
        if (start == nums[nums.length - 1]) {
            al.add(Integer.toString(start));
        } else {
            al.add(start + "->" + nums[nums.length - 1]);
        }
        return al;
    }
}