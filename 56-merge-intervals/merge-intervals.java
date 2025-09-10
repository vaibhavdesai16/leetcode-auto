class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int merge = 0;
        int len = intervals.length;

        for(int i = 0; i < len - 1; i++){
            
            // check for overlap
            if(intervals[i+1][0] <= intervals[i][1]){
                // merge
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = intervals[i+1][1] > intervals[i][1] ? intervals[i+1][1] : intervals[i][1];
                // exclude curr
                intervals[i][0] = -1;
                intervals[i][1] = -1;
                merge++;
            }
            
        }

        int[][] ans = new int[len - merge][2];
        int pointer = 0;

        for(int i = 0; i < len; i++){

            if(intervals[i][0] != -1){
                ans[pointer][0] = intervals[i][0];
                ans[pointer][1] = intervals[i][1];
                pointer++;
            }

        }
        return ans;
        
    }
}