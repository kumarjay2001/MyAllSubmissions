class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int []freq1=new int[1001];
        int []freq2=new int[1001];
        ArrayList<Integer> al=new ArrayList<>();
        for(int i:nums1){
            freq1[i]++;
        }
        for(int i:nums2){
            freq2[i]++;
        }
        int []ans=new int[1001];
        int j=0;
        for(int i=0;i<1001;i++){
            int everys=Math.min(freq1[i],freq2[i]);
            if(everys>0){
                 while(everys>0){
                  al.add(i);
                  j++;
                  everys--;
                  }
            }
           
        }
        return al.stream().mapToInt(i -> i).toArray();
    }
}
