class Solution {
    public int missingNumber(int[] nums) {
        // 1st approach
        /*
        int n=nums.length;
        int temp[]=new int[n+1];
        for(int i=0;i<n;i++){
            temp[nums[i]]++;
        }
        for(int i=0;i<temp.length;i++){
            if(temp[i]==0){
                return i;
            }
        }
        return nums[n-1]++;
       */
        
//         2nd approach : use basic formula if n is size then 1 to n no. must be present so we find sum of it and 
//         then we find the sum of element  in the array and simply subtract them and we got the n+o. 
       int n=nums.length;
       int sumofn=n*(n+1)/2;
       int sum=0;
       for(int i=0;i<n;i++){
           sum+=nums[i];
       }
       return sumofn-sum;
    }
}