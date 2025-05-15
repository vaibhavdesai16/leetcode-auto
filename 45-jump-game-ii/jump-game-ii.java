class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;

        for(int i = 1; i < dp.length; i++){
            dp[i] = 9999;
        }

        for(int i = 0; i < nums.length; i++){

            for(int j = 1; j <= nums[i]; j++){
                
                int idx = i + j;

                if(idx < dp.length){
                    dp[idx] = Math.min(dp[idx], dp[i] + 1);
                }
            }
        }

        // for(int i = 0; i < dp.length; i++){
        //     System.out.println("i = " + i + " val " + dp[i]);
        // }

        return dp[nums.length -1];
    }
}