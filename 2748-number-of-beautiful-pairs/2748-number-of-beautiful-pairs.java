class Solution {
    public int countBeautifulPairs(int[] nums) {
        int n=nums.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int fini=first(nums[i]);
                if(gcd(fini,nums[j]%10)==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public int first(int a){
        while(a>9){
            a=a/10;
        }
        return a;
    }
    public int gcd(int a,int b){
        if (b == 0){
            return a;
        }
        else{
          return gcd(b, Math.abs(a - b));
        }
    }
}