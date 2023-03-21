class Solution {
    public int[] buildArray(int[] nums) {
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            al.add(nums[nums[i]]);
        }
       int []res= al.stream().mapToInt(i->i).toArray();
        return res;
    }
}