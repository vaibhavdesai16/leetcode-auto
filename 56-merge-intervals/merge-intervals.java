class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int merge = 0;
        int len = intervals.length;

        for(int i = 0; i < intervals.length - 1; i++){
            
            int[] curr = intervals[i];
            int[] next = intervals[i+1];

            // check for overlap
            if(next[0] <= curr[1]){
                // merge
                next[0] = curr[0];
                next[1] = next[1] > curr[1] ? next[1] : curr[1];
                // exclude curr
                curr[0] = -1;
                curr[1] = -1;
                merge++;
            }
            
        }

        int[][] ans = new int[len - merge][2];
        int pointer = 0;

        for(int i = 0; i < intervals.length; i++){

            // System.out.println("first " + intervals[i][0] + " second " + intervals[i][1]);
            // System.out.println("merged " + merge);

            if(intervals[i][0] != -1){
                ans[pointer][0] = intervals[i][0];
                ans[pointer][1] = intervals[i][1];
                pointer++;
            }

        }
        return ans;
        
    }
}