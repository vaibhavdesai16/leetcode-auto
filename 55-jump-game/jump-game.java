class Solution {
    public boolean canJump(int[] nums) {

        int[] dp = new int[nums.length];
        int maxReach = 0;

        for(int i = 0; i < nums.length; i++){
            
            if(i > maxReach){
                return false;
            }

            dp[i] = i + nums[i];
            maxReach = Math.max(maxReach, dp[i]);
        }
        return true;
    }
}