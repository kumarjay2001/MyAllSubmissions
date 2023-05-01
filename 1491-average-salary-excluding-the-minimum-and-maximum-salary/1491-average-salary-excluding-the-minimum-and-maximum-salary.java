class Solution {
    public double average(int[] salary) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int n=salary.length;
        double sum=0;
        for(int i:salary){
            min=Math.min(min,i);
            max=Math.max(max,i);
            sum+=i;
        }
        return (sum-(min+max))/(n-2);
        
    }
}