class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;

        while(left <= right){

            long mid = left + (right - left)/2;
            long sq = (mid * mid);
            
            if( sq == x){
                return (int) mid;
            }

            if(sq > x){
                // shift search to left
                right = mid -1;
            }
            else{
                // shift to right
                left = mid + 1;
            }
        }

        return (int) left-1;
    }
}