class Solution {
    public int findKthPositive(int[] arr, int k) {
        int ans=0;
         if(arr[0]-1>=k){
            return 0+k;          
        }
        k -= (arr[0]-1);
        for(int i=1;i<arr.length;i++){
            if(k>0){
                if( arr[i]-arr[i-1]>k){
                    ans=arr[i-1]+k;
                    k=0;
                } else {
                    k-=arr[i]-arr[i-1]-1;
                }
            }
        }
        if(k>0){
            ans=arr[arr.length-1]+k;
        }
        return ans;
    }
}