class Solution {
    public boolean canJump(int[] nums) {
        int lastIdx = nums.length - 1;
        int maxJump = 0;

        for(int i = 0; i <= lastIdx; i++){
            int jumpTo = i + nums[i];

            if(i > maxJump){
                return false;
            }

            if(jumpTo >= lastIdx && i <= maxJump){
                return true;
            }
            maxJump = Math.max(maxJump, jumpTo);
            
        }
        return false;
    }
}