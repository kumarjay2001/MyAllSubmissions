class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> hs=new HashSet<>();
        for(int i=0;i<jewels.length();i++){
            hs.add(jewels.charAt(i));
        }
        int count=0;
        for(int i=0;i<stones.length();i++){
            if(hs.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }
}