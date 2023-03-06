class Solution {
     public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList <List<Integer>> al=new ArrayList<List<Integer>>();
//     SImilar to 3sum
//      we find reqsum(target-a[i]-a[j) and use 2 pointer to find that pairs which will be equal to our reqsum if we got it then we add it to our al
        if(nums.length==0){
            return al;
        }
        if(target==-294967296 || target==294967296) return al;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int tarsum=target-nums[i]-nums[j];
                int low=j+1,high=n-1;
                while(low<high){
                    int lssum=nums[low]+nums[high];
                    if(tarsum==lssum){
                       List<Integer> alinner=new ArrayList<>();
                       alinner.add(nums[i]);
                       alinner.add(nums[j]);
                       alinner.add(nums[low]);
                       alinner.add(nums[high]);
                       while(low<high && nums[low]==alinner.get(2)){
                           ++low;
                       }
                       while(low<high && nums[high]==alinner.get(3)){
                           --high;
                       }
                       al.add(alinner);
                    }else if(tarsum>lssum){
                        low++;
                    }else{
                        high--;
                    }
                }
                while(j+1<n && nums[j]==nums[j+1]){
                    ++j;
                }
                while(i+1<n && nums[i]==nums[i+1]){
                    ++i;
                }

            }
        }
        return al;
    }
}