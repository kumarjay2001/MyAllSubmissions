class Solution {
    public int maxArea(int[] height) {
        // using the approach which is used in trapping rainwater (waterlevel)*width and water level is min of heights
        int i=0,j=height.length-1,area=0;
        while(i<j){
            int w=j-i;
            int h=Math.min(height[i],height[j]);
            area=Math.max(area,w*h);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return area;
    }
}