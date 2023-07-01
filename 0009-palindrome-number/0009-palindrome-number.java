class Solution {
    public boolean isPalindrome(int x) {
        int rev=reverse(x);
        return rev==x;
    }
    public int reverse(int n){
        int ans=0;
        while(n>0){
            ans=ans*10+n%10;
            n/=10;
        }
        return ans;
    }
}