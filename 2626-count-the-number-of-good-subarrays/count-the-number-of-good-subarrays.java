class Solution {
    public long countGood(int[] nums, int k) {
        
        int left = 0;
        long count = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        long result = 0;

        for (int right = 0; right < nums.length; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            count += freqMap.get(nums[right]) - 1; // Add the new pairs formed by the current element

            while (count >= k) {
                result += (nums.length - right); // All subarrays ending at or after 'right' are good
                freqMap.put(nums[left], freqMap.get(nums[left]) - 1);
                count -= freqMap.get(nums[left]); // Subtract the pairs lost by removing nums[left]
                left++;
            }
        }
        return result;

    }
}