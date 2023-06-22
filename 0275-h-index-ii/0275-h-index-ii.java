class Solution {
    public int hIndex(int[] citations) {
       int i=0;
        int n=citations.length;
        while(i<n && citations[i]<n-i){
            i++;
        }
        return n-i;
    }
    
}