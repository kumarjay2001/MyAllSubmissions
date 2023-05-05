class Solution {
    public int maxVowels(String s, int k) {
        // int vow=0;
        // for(int i=0;i<s.length()-2;i++){
        //    vow= Math.max(vow,countvowel(s,i,i+2));
        // }
        // return vow;
        int ans=0;
        int sum=0;
        for(int i=0;i<s.length();i++){
            if(i<k){
                ans+=countvowel(s.charAt(i));
            }else{
                ans+=countvowel(s.charAt(i));
                ans-=countvowel(s.charAt(i-k));
            }
            if(ans>sum){
                sum=ans;
            }
            if(sum==k){
                return k;
            }
            
        }
        return sum;
    }
    public int countvowel(char x){
        if(x=='a'||x=='e'||x=='i'||x=='o'||x=='u'){
            return 1;
        }else{
            return 0;
        }
    }
}