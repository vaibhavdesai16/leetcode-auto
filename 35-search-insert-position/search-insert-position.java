class Solution {
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length-1;

        while(left <= right){

            int mid = left + (right - left)/2;
            
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] > target){
                // shift search to left
                right = mid -1;
            }
            else{
                // shift to right
                left = mid + 1;
            }
        }

        return left;
    }
}