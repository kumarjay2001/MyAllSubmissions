class Solution {
    public int firstMissingPositive(int[] nums) {
       int n=nums.length;
       int i=0;
        while(i<n){
            int a=nums[i];
            if(a>=1 && a<=n){
                if(nums[a-1]!=a){
                    nums[i]=nums[a-1];
                    nums[a-1]=a;
                    
                }else{
                    i++;
                }
            }else{
                i++;
            }
        }
        for(int j=0;j<n;j++){
            if(nums[j]!=j+1){
                return j+1;
            }
        }
        return n+1;
        
    }
}