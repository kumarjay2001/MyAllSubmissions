class Solution {
    public int hIndex(int[] citations) {
//         Arrays.sort(citations);
//         int i=0;
        int n=citations.length;
//         while(i<n && citations[i]<n-i){
//             i++;
//         }
//         return n-i;
        
        
//         Bucket sort
       int []bucket=new int[n+1];
        for(int i=0;i<n;i++){
            if(citations[i]>n){
                bucket[citations.length]++;
            }else{
                bucket[citations[i]]++;
            }
        }
        int count=0;
        for(int i=bucket.length-1;i>=0;i--){
            count+=bucket[i];
            if(count>=i){
                return i;
            }
        }
        return 0;
    }
}