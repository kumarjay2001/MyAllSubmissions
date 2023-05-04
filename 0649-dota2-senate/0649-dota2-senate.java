class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
                q1.add(i);
            }else{
                q2.add(i);
            }
        }
        int n=senate.length();
        while(!q1.isEmpty() && !q2.isEmpty()){
            int r=q1.poll();
            int s=q2.poll();
            if(r<s){
                q1.add(r+n);
            }else{
                q2.add(s+n);
            }
        }
        return q1.size()>q2.size()?"Radiant":"Dire";
    }
}