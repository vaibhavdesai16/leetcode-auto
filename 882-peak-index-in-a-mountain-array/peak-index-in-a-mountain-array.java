class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 1;
        int right = arr.length -1;
        int result = 0;

        while(left <= right){

            int mid = (int) Math.floor((left+right)/2);

            if(arr[mid] < arr[mid -1]){
                // move left
                right = mid -1;
            }
            else{
                // move right
                result = mid;
                left = mid + 1;
            }
        }
        
        return result;
    }
}