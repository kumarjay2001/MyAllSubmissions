class Solution {
    public boolean isPalindrome(String s) {
        s= s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int l=0,h=s.length()-1;
        while(l<h){
            if(s.charAt(l)==s.charAt(h)){
                l++;h--;
            }else{
               return false; 
            }
        }
        return true;
    }
}