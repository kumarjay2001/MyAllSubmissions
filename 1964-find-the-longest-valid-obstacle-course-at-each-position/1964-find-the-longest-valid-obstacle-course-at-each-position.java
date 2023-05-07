class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        ArrayList<Integer> Al = new ArrayList<>();
        int[] ans = new int[obstacles.length];
        for(int i=0;i<obstacles.length;i++){
            if(Al.size() == 0 || obstacles[i]>=Al.get(Al.size()-1)){
                Al.add(obstacles[i]);
                ans[i] = Al.size();
            }
            else{
                int ub = upper_bound(Al,obstacles[i]);
                Al.set(ub,obstacles[i]);
                ans[i] = ub+1;
            }

        }
        return ans;
    }
      int upper_bound(ArrayList<Integer> Al,int target){
        int low = 0,high = Al.size()-1;
        int mid = low+(high-low)/2;
        int ans = -1;

        while(low<=high){
            if(Al.get(mid) > target){
                ans = mid;
                high = mid-1;
            }
            else if(Al.get(mid)<=target)
                low = mid+1;
            
            mid = low+(high-low)/2;
        }
        return ans;
    }


}