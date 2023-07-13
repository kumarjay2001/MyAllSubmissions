class Solution {
    public int maxArea(int[] height) {
        int maxwater=0;
        int i=0,j=height.length-1;
        while(i<j){
            int area=Math.min(height[i],height[j]);
            area*=(j-i);
            if(area>maxwater){
                maxwater=area;
            }
            if(height[i]>height[j]){
                j--;
            }else{
                i++;
            }
        }
        return maxwater;
    }
}