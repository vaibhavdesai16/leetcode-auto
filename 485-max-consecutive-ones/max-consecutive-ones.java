class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {

         int[] lastZeroIdx = new int[nums.length];

        int lastIdx = -1;
        for(int i=0; i< nums.length; i++){
            if(nums[i] == 0){
                lastIdx = i;
            }
            lastZeroIdx[i] = lastIdx;
        }

        int longest = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                int subArraySize = i - lastZeroIdx[i];
                longest = Math.max(subArraySize, longest);
            }
        }

        return longest;
        
    }
}