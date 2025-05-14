class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = 0;
        int endIdx = cost.length - 1;
        
        for(int i = 2; i < cost.length; i++){
            int fPre = dp[i-1] + cost[i-1];
            int sPre = dp[i-2] + cost[i-2];
            dp[i] = Math.min(fPre, sPre);
        }

        return Math.min((dp[endIdx] + cost[endIdx]) , dp[endIdx -1] + cost[endIdx -1]);
    }
}