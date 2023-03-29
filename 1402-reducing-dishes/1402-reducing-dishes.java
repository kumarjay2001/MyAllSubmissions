class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort( satisfaction);
        
        int [][]dp=new int[satisfaction.length+1][satisfaction.length+1];
        
        for(int[] d : dp)
            Arrays.fill(d,-1);
        
        return solve(satisfaction,dp,0,1);
    }
    public int solve(int []satisfaction,int [][]dp,int i,int t){
        if(i== satisfaction.length) {
            return 0;     
        }
        if(dp[i][t]!=-1){
            return dp[i][t];
        }
        int include=satisfaction[i]*t+solve(satisfaction,dp,i+1,t+1);
        int exclude=solve(satisfaction,dp,i+1,t);
        dp[i][t]=Math.max(include,exclude);
        return dp[i][t];
    }
}