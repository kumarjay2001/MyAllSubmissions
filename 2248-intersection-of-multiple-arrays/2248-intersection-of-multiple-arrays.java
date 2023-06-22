class Solution {
    public List<Integer> intersection(int[][] nums) {
        ArrayList<Integer> al=new ArrayList<>();
        int []reso=new int[1001];
        for(int []arr:nums){
            for(int i:arr){
                reso[i]++;
            }
        }
        for(int i=0;i<reso.length;i++){
            if(reso[i]==nums.length){
                al.add(i);
            }
        }
        return al;
    }
}