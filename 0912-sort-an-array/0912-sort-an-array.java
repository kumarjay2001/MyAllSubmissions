class Solution {
    public int[] sortArray(int[] nums) {
        merge(nums,0,nums.length-1);
        return nums;
    }
    public void merge(int []nums,int low,int high){
        if(low<high){
            int mid=low+(high-low)/2;
            merge(nums,low,mid);
        merge(nums,mid+1,high);
        mergesort(nums,low,mid,high);
        }
        
    }
    public void mergesort(int nums[],int low,int mid,int high){
        int []temp=new int[high-low+1];
        int i=low;int j=mid+1;int k=0;
        while(i<=mid && j<=high){
            if(nums[i]<=nums[j]){
                temp[k++]=nums[i++];
            }else{
                temp[k++]=nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }
        for (int p = 0; p < k; p++) {
            nums[low + p] = temp[p];
        }


    } 
}