class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 0;

        float half = nums.length/2.0f;
        //System.out.println(half);

        for(int i=0; i<nums.length; i++){
            
            count++;
            if(i == nums.length-1){
                if(count > half){
                    return nums[i];
                }
                nums[i] = count;
            }

            else if(nums[i] < nums[i+1]){
                if(count > half){
                    return nums[i];
                }
                nums[i] = count;
                count = 0;
            }
        }

        // for(int n : nums){
        //     System.out.println(n);
        // }

        return -1;
    }
}