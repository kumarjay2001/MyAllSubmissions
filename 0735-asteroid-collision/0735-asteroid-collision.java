class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s=new Stack<>();
        int n=asteroids.length;
        for(int i=0;i<n;i++){
            if(asteroids[i]>0){
                s.push(asteroids[i]);
            }else{
                while(!s.isEmpty() && s.peek()>0 && s.peek()<Math.abs(asteroids[i])){
                    s.pop();
                }
               
                if(!s.isEmpty() && Math.abs(asteroids[i])==s.peek()){
                    s.pop();
                }
                else if(!s.isEmpty() && Math.abs(asteroids[i])<s.peek()){
                    
                }else{
                    s.push(asteroids[i]);
                }
            }
        }
        
        
        
        
        ArrayList<Integer> al=new ArrayList<>();
        while(!s.isEmpty()){
            al.add(s.pop());

        }
        Collections.reverse(al);
        return al.stream().mapToInt(i -> i).toArray();
    }
}