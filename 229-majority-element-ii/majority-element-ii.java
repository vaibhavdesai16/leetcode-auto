class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        float oneThird = nums.length/3.0f;
        List<Integer> result = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++){
            
            count++;
            if(i == nums.length-1){
                if(count > oneThird){
                    result.add(nums[i]);
                }
            }

            else if(nums[i] < nums[i+1]){
                if(count > oneThird){
                    result.add(nums[i]);
                }
                count = 0;
            }
        }
        return result;

    }
}