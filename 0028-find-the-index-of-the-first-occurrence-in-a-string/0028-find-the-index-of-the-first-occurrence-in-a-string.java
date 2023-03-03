class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        for(int i=0;i<n;i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int k = i+1;
                int j=1;
               for(;j<needle.length();j++){
                if(k != n && haystack.charAt(k)==needle.charAt(j)){
                    k++;
                }else{
                    break;
                }
               }
               if(j == needle.length()){
                   return i;
               }
            }
        }
        return -1;
    }
}