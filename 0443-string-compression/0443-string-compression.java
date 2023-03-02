class Solution {
    public int compress(char[] chars) {
//  we run a loop and keep on comparing next element and keep on incraesng the index if it is same  and if it is different we create a variable which will help us to add count next to every element in form of character and if count>=10 we have to add both digit seperately that'swhy we use a string to store 
        
        int i=0;
        int n=chars.length;
        if(n==1)return n;
        int k=0;
        while(i<n){
            int count=1;
            while(i<n-1 && chars[i]==chars[i+1]){
                count++;
                i++;
            }  
            chars[k++]=chars[i++];
            if(count>1){
                String countl=String.valueOf(count);
                for(int z=0;z<countl.length();z++){
                    chars[k++]=countl.charAt(z);
                }
            }
        }
        return k;

  
    }
}