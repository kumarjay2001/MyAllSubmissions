class Solution {
    // class Pair{
    //     int val;
    //     int freq;
    //     Pair(int val,int freq){
    //         this.val=val;
    //         this.freq=freq;
    //     }
    // }
//     public int[] topKFrequent(int[] nums, int k) {
//         HashMap<Integer,Integer>hm=new HashMap<>();
//         for(int num:nums){
//             hm.put(num, hm.getOrDefault(num,0)+1);
//         }
//         PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.freq - y.freq);
//         for(var entry : hm.entrySet()) {
//             int value = entry.getKey();
//             int freq = entry.getValue();
            
//             pq.offer(new Pair(value,freq));
            
//             if(pq.size() > k){
//                 pq.poll();
//             }
//         }
//         int[] result = new int[k];
//         for(int i=0; i<k; i++){
//             result[i] = pq.poll().val;
//         }
//         return result;
//     }
    
    
    
     public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int num:nums){
            mp.put(num, mp.getOrDefault(num,0)+1);
        }
         int n=nums.length;
        List<Integer>[] bucket = new ArrayList[n + 1];
        for(int value : mp.keySet()){
            int freq = mp.get(value);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList();
            }
            bucket[freq].add(value);
        }
           int res[] = new int[k];
        int index = 0;
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(int v : bucket[i]){
                    res[index++] = v;
                    if(index == k) return res;
                }
            }
        }
        return res;
     }    
}