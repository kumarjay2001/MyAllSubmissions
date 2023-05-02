class Solution {
    public int arraySign(int[] nums) {
        // int pro=1;
        // for(int i:nums){
        //     pro*=i;
        // }
        // if(pro>0){
        //     return 1;
        // }else if(pro<0){
        //     return -1;
        // }else{
        //     return 0;
        // }
        int negcount=0;
        int zerocount=0;
        for(int i:nums){
            if(i<0){
                negcount++;
            }else if(i==0){
                zerocount++;
            }
        }
        if(zerocount>0){
            return 0;
        }
        else if(negcount%2==0){
            return 1;
        }else{
            return -1;
        }
    }
}