class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
       for(int i=0;i<flowerbed.length;i++){
           if(flowerbed[i]==0){
                int prev=(i==0 || flowerbed[i-1]==0)?0:1;
                int last=(i==flowerbed.length-1 || flowerbed[i+1]==0)?0:1;
                if(prev==0&& last==0){
                 flowerbed[i]=1;
                  n--;
               }
           }
          
       }
        return n<=0;
    }
}