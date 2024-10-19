class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i] , nums[i] + dp[i-1]);
            globalMax = Math.max(globalMax, dp[i]);
        }

        return globalMax;
        
    }
}