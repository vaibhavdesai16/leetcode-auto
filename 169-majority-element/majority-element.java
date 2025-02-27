class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        float half = nums.length/2.0f;
        for(int i=0; i<nums.length; i++){
            
            count++;
            if(i == nums.length-1){
                if(count > half){
                    return nums[i];
                }
            }

            else if(nums[i] < nums[i+1]){
                if(count > half){
                    return nums[i];
                }
                count = 0;
            }
        }
        return -1;
    }
}