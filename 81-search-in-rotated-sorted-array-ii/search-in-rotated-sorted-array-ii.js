/**
 * @param {number[]} nums
 * @param {number} target
 * @return {boolean}
 */
var search = function(nums, target) {
    //base condtions;
    if(nums.length == 1){
       return  nums[0] == target ? true : false;
    }

    let left = 0;
    let right = nums.length-1;

    while(left <= right){
        let mid = parseInt((left+right)/2);
        
        if(nums[mid] == target) return true;

        //if we are in sorted array
        if(nums[left] < nums[mid]){
            if(target >= nums[left] && target < nums[mid]){
                //target present in sorted section
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        else if(nums[left] == nums[mid]){
            left++;
        }
        else if(nums[right] == nums[mid]){
            right--;
        }
        else{
            //we are not in the sorted array
            if(target <   nums[mid] || target >= nums[left]){
                //target is present in this section
                right = mid-1;
            }
            else{
                left = mid +1;
            }
        }
    }
    return false;
};