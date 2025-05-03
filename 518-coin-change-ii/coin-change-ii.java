class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];

        for(int r = 0; r < dp.length; r++){
            for(int c = 0; c < dp[0].length; c++){
                if(r == 0 || c == 0){
                    if(c == 0){
                        dp[r][c] = 1;
                    }
                    else if(c - coins[0] == 0){
                        dp[r][c] = dp[0][0];
                    }
                    else {
                        dp[r][c] = (c - coins[r] >= 0) ? dp[0][c - coins[r]] : 0;
                    }
                }
                else{
                    if( c - coins[r] < 0){
                        dp[r][c] = dp[r-1][c];
                    }
                    else{
                        int waysWithoutCurrentCoin = dp[r-1][c];
                        int waysWithCurrentCoin = 0;
                        if( c - coins[r] >= 0){
                            waysWithCurrentCoin = waysWithoutCurrentCoin + dp[r][c - coins[r]];
                            dp[r][c] = waysWithCurrentCoin;
                        }else{
                            dp[r][c] = waysWithoutCurrentCoin;
                        }
                    }
                }
            }
        }

        return dp[coins.length-1][amount];
    }
}