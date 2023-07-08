class Solution {
    public long putMarbles(int[] weights, int k) {
        ArrayList<Integer> al=new ArrayList<>();
        int n=weights.length;
        for(int i=0;i<n-1;i++){
            al.add(weights[i]+weights[i+1]);
        }
        Collections.sort(al);
        long mini=0,maxi=0;
        for(int i=0;i<k-1;i++){
            mini+=al.get(i);
            maxi+=al.get(n-2-i);
        }
        return maxi-mini;
    }
}