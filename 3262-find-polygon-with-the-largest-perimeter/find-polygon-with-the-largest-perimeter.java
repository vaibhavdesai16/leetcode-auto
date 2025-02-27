class Solution {
    public long largestPerimeter(int[] nums) {

        Arrays.sort(nums);

        long[] agg = new long[nums.length];
        agg[0] = nums[0];
        
        for(int i=1; i<nums.length; i++){
            agg[i] = agg[i-1] + nums[i];
        }

        long para = -1;

        for(int i=2; i<nums.length; i++){
            if(agg[i-1] >  nums[i]){
                para = agg[i];
            }
        }

        return para;
        
    }
}