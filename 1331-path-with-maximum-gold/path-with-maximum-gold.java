class Solution {
    int[][] grid;
    int ROW_MAX, COL_MAX;

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        this.ROW_MAX = grid.length;
        this.COL_MAX = grid[0].length;

        int ans = 0;

        for(int i=0; i<ROW_MAX; i++){
            for(int j=0; j<COL_MAX; j++){
                if(grid[i][j] != 0){
                    //String loc = i + " " + j;
                    ans = Math.max(dfs(i,j, new HashSet<String>()), ans);
                    //System.out.println(" loc " + loc + " ans " + ans);
                }
            }
        }
        return ans;

    }

    public int dfs(int row, int col, HashSet<String> visited){
        String loc = row + " " + col;

        if(row < 0 || col < 0 || row >= ROW_MAX || col >= COL_MAX || this.grid[row][col] == 0 || visited.contains(loc)){
            return 0;
        }

        visited.add(loc);

        // go left
        int left = dfs(row, col -1, visited);
        // go right
        int right = dfs(row, col +1, visited);
        // go top
        int top = dfs(row-1, col, visited);
        // go down
        int down = dfs(row+1, col, visited);

        int max1 = Math.max(left, right);
        int max2 = Math.max(top, down);

        int max = Math.max(max1, max2);
        visited.remove(loc);

        return this.grid[row][col] + max;

    }

    
}