class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int removed = 0;

        for(int i = 0; i < intervals.length - 1;  i++){
            
            int[] curr = intervals[i];
            int[] next = intervals[i+1];

            // check for overlapping
            if(curr[1] > next[0]){
                //look which one ends first
                if(curr[1] < next[1]){
                    // curr ends first
                    next[0] = curr[0];
                    next[1] = curr[1];
                    removed++;
                }
                else{
                    // next ends first
                    // do nothing
                    removed++;
                }
            }
        }

        return removed;
    }
}