class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int right = 0;
        int left = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        for(right=0; right<nums.length; right++){

            sum += nums[right];

            while(sum >= target){
                res = Math.min(res, right - left + 1);
                sum = sum - nums[left++];
            }

        }

        return res != Integer.MAX_VALUE ? res : 0;
    }
}