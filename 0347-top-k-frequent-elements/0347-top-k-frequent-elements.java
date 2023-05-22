class Solution {
    class Pair{
        int val;
        int freq;
        Pair(int val,int freq){
            this.val=val;
            this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int num:nums){
            hm.put(num, hm.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.freq - y.freq);
        for(var entry : hm.entrySet()) {
            int value = entry.getKey();
            int freq = entry.getValue();
            
            pq.offer(new Pair(value,freq));
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = pq.poll().val;
        }
        return result;
    }
}