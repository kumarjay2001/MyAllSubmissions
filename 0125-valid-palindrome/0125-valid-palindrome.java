class Solution {
    public boolean isPalindrome(String s) {
// ..............  Method 1.............
 /*
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
*/
        
        
// ..............  Method 2.............   
       s= s.toLowerCase().replaceAll("[^a-z0-9]", "");
        StringBuilder sb=new StringBuilder();
        sb.append(s).reverse();
        return s.equals(sb.toString());
        

    }
}