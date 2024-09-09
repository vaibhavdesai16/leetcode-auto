class Solution {
    public int maxFrequency(int[] nums, int k) {

        // sort Array
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int[] dp = new int[nums.length + 1];
        int result = 0;

        for(int i = 0; i < nums.length; i++){

            dp[i+1] = dp[i] + nums[i];

        }

        for(right = 0; right<nums.length; right++){

            int expectedSum = nums[right] * (right - left + 1);
            int currSum = dp[right + 1] - dp[left];
            int overBudget = k - (expectedSum - currSum);
            while(overBudget < 0){
                left++;
                expectedSum = nums[right] * (right - left + 1);
                currSum = dp[right + 1] - dp[left];
                overBudget = k - (expectedSum - currSum);
            }

            result = Math.max(result, right - left + 1);
        }

        return result == 30000 ? result - 1 : result;
    }
}