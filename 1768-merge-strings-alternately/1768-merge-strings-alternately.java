class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<word1.length() && i<word2.length()){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        while(i<word1.length()){
             sb.append(word1.charAt(i));
            i++;
        }
        while(i<word2.length()){
            sb.append(word2.charAt(i));
            i++;
        }
        return sb.toString();
    }
}