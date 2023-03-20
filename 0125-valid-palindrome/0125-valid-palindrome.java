class Solution {
    public boolean isPalindrome(String s) {
        s= s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int low=0;
		int high=s.length()-1;
		while(low<=high){
		    if(s.charAt(low)==s.charAt(high)){
		        low++;high--;
		    }else{
		      	return false;
		    }
		}
	  return true;
    }
}