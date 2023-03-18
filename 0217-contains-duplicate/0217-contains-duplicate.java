class Solution {
    public boolean containsDuplicate(int[] nums) {
        // HashMap<Integer,Integer>hm=new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     if(hm.containsKey(nums[i])) {
        //         return true;
        //     }else{
        //         hm.put(nums[i],1);
        //     }
        // }
        
        // return false;

        HashSet<Integer> hs=new HashSet<>();
        for(int i:nums){
            if(hs.contains(i)){
                return true;
            }else{
                hs.add(i);
            }
        }
        return false;

    }
}