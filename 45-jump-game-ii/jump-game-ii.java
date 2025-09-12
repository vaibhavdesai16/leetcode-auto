class Solution {
    public int jump(int[] nums) {

        int[] dp = new int[nums.length];

        dp[0] = 0;

        for (int i = 0; i< nums.length; i++){

            for(int j = 1; j <= nums[i]; j++){
                int idx = i + j;
                if(idx < nums.length){

                    if(dp[idx] == 0){
                        dp[idx] = dp[i] + 1;
                    }
                    else{
                        int jupms = dp[i] + 1;
                        dp[idx] = Math.min(dp[idx], jupms);
                    }
                }
            }

        }

        return dp[nums.length-1];
    }
}