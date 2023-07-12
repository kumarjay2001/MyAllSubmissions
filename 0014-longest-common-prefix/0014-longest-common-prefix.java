class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1)return strs[0];
        Arrays.sort(strs);
        String first=strs[0];
        String second =strs[strs.length-1];
        int i=0;
        while(i<strs[0].length() && i<second.length()){
            if(first.charAt(i)==second.charAt(i)){
                i++;
            }else{
                 break;
            }
           
        }
        return strs[0].substring(0,i);
        
    }
}