class Solution {
    public void moveZeroes(int[] nums) {
//  Method 1 - we traverse a loop on array and check if it is 0 then check for non zero and just swap them  
        // int n =nums.length;
        // for(int i=0;i<n;i++){
        //     if(nums[i]==0 && i!=n-1){
        //         int j=i+1;
        //         while(j<n-1 && nums[j]==0){
        //             j++;
        //         }
        //         nums[i]=nums[j];
        //         nums[j]=0;
               
        //     }
        // }


//  Method 2 (Best Approach)- we first copy the non zero element at the starting and then remaining is zero we update it after the non zeero 

        int k=0;
        int n =nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[k]=nums[i];
                k++;
            }
        }
        for(int i=k;i<n;i++){
            nums[i]=0;
        }

    }
}