class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        ArrayList<Integer> al=new ArrayList<>();
        int n=spells.length;
        int count=0;
        int m=potions.length;
        for(int i=0;i<n;i++){
            int low=0,high=m-1;
            
            while(low<=high){
                int mid=low+(high-low)/2;
                if((long)spells[i]*(long)potions[mid]>=success){
                    count+=high-mid+1;
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            al.add(count);
            count=0;
        }
        return al.stream().mapToInt(i->i).toArray();
    }
}