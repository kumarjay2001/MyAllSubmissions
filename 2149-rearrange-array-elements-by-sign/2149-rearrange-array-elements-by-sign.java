class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int []ans=new int[n];
    //     List<Integer> pos=new ArrayList<>();
    //     ArrayList<Integer> neg=new ArrayList<>();
    //     for(int i=0;i<n;i++){
    //         if(nums[i]<0){
    //             neg.add(nums[i]);
    //         }else{
    //             pos.add(nums[i]);
    //         }
    //     }
    //     int k=0,l=0;
    // for(int i=0;i<ans.length;i++)
    // {
    //     if(i%2==0)
    //     {
    //         ans[i]=pos.get(k);
    //         k++;
    //     }else{
    //         ans[i]=neg.get(l);
    //         l++;
    //     }
    // }
    //     return ans;


        
    //      OR  
    //  Without Extra arraylist and all
    int start=0,end=1;
      for(int i=0;i<n;i++){
          if(nums[i]>0){
              ans[start]=nums[i];
              start+=2;
          }else if(nums[i]<0){
              ans[end]=nums[i];
              end+=2;
          }
      }
      return ans;
    }  
}