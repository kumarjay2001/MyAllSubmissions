class Solution {
    public void nextPermutation(int[] nums) {
        // In this question we basically use basic visaulization 
        // Step 1 we traverse from right and find element whose a[i]<a[i+1]
        // reason is from here till end element in descending order and now we find the no which is just greater than it and we reverse it 
        //  so here we reverse(i+1 to last) bcz it is in descending order and we need next permutation...
        if(nums == null || nums.length <= 1) return;
        int n=nums.length;
        int i=n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
      if(i>=0){
            int j=n-1;
            while(j>=0 &&  nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1,n-1);
    }
    public void swap(int []nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int []nums,int l,int h){
        while(l<h){
            int temp=nums[l];
            nums[l]=nums[h];
            nums[h]=temp;
            l++;h--;
        }

    }
}