class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> al=new ArrayList<>();
        int maxi=0;
        for(int i:candies){
            maxi=Math.max(maxi,i);
        }
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=maxi){
                al.add(true);
            }else{
                al.add(false);
            }
        }
        return al;
    }
}