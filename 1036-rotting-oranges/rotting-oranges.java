class Solution {
    int ROW_MAX;
    int COL_MAX;
    int[][] grid;
    LinkedList<int[]> nextToVisit = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        //edge case
        if(grid.length == 1 && grid[0].length == 1){
            if(grid[0][0] == 0 || grid[0][0] == 2){
                return 0;
            }
            else if(grid[0][0] == 1){
                return -1;
            }
        }

        this.grid = grid;
        this.ROW_MAX = grid.length;
        this.COL_MAX = grid[0].length;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(this.grid[i][j] == 2){
                    bfs(i,j, new HashSet<>());
                }
            }
        }
        
        int minDays = -1;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
                minDays = Math.max(minDays, grid[i][j]);
            }
        }
        return minDays > 10 ? minDays-10 : 0;
    }

    public void bfs(int row, int col,  HashSet<String> visited){
        String location = row + " " + col;

        if(visited.contains(location)){
            return;
        }
        this.grid[row][col] = 10;
        this.nextToVisit.add(new int[]{row,col});
        while(!nextToVisit.isEmpty()){
            int[] loc = nextToVisit.remove();
            int r = loc[0];
            int c = loc[1];
            visited.add(r + " " + c);

            // add neighbours

            // left
            if(isValidLoc(r, c-1, visited)){
                nextToVisit.add(new int[]{r, c-1});
                this.grid[r][c-1] = this.grid[r][c-1] < 10 ? this.grid[r][c] + 1 : Math.min(this.grid[r][c-1], this.grid[r][c] + 1);
            }
            //right
            if(isValidLoc(r,c+1, visited)){
                nextToVisit.add(new int[]{r, c+1});
                this.grid[r][c+1] = this.grid[r][c+1] < 10 ? this.grid[r][c] + 1 : Math.min(this.grid[r][c+1], this.grid[r][c] + 1);
            }
            // up
            if(isValidLoc(r-1, c, visited)){
                nextToVisit.add(new int[]{r-1, c});
                this.grid[r-1][c] = this.grid[r-1][c] < 10 ? this.grid[r][c] + 1 : Math.min(this.grid[r-1][c], this.grid[r][c] + 1);
            }

            // down
            if(isValidLoc(r+1, c, visited)){
                nextToVisit.add(new int[]{loc[0]+1, loc[1]});
                this.grid[r+1][c] = this.grid[r+1][c] < 10 ? this.grid[r][c] + 1 : Math.min(this.grid[r+1][c], this.grid[r][c] + 1);
            }
        }
    }

    public boolean isValidLoc(int row, int col,  HashSet<String> visited){
        if(row < 0 || row >= ROW_MAX || col < 0 || col >= COL_MAX || visited.contains(row + " " + col)
                || this.grid[row][col] == 0 || this.grid[row][col] == 2){
            return false;
        }
        return true;
    }
}