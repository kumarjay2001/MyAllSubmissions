class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> al=new ArrayList<>();
        HashSet<Integer> hs1=new HashSet<>();
        HashSet<Integer> hs2=new HashSet<>();
        for(int i:nums1){
            hs1.add(i);
        }
        for(int i:nums2){
            hs2.add(i);
        }
        ArrayList<Integer> child1=new ArrayList<>();
        for(int i:hs1){
            if(!hs2.contains(i)){
                child1.add(i);
            }
        }
        ArrayList<Integer> child2=new ArrayList<>();
         for(int i:hs2){
            if(!hs1.contains(i)){
                child2.add(i);
            }
        }
        al.add(child1);
        al.add(child2);
        return al;
    }
}