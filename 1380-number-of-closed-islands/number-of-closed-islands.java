class Solution {
    HashSet<String> visited = new HashSet<>();
    int rowMax;
    int colMax;
    int[][] grid;
    public int closedIsland(int[][] grid) {
        rowMax = grid.length;
        colMax = grid[0].length;
        this.grid = grid;
        int count = 0;

        for(int i=0; i<rowMax; i++){
            String str = i + "," + 0;
            String str1 = i + "," + (colMax - 1);
             if(!visited.contains(str)){
                dfs(i, 0);
             }
             if(!visited.contains(str1)){
                dfs(i, colMax-1);
             }
        }

        for(int j=0; j<colMax; j++){
            String str = 0 + "," + j;
            String str1 = rowMax-1 + "," + j;
            if(!visited.contains(str)){
                dfs(0, j);
            }
            if(!visited.contains(str1)){
                dfs(rowMax -1, j);
            }
        }

        for(int j=0; j<colMax; j++){
        }

        for(int i=1; i<rowMax-1; i++){
            for(int j=1; j<colMax-1; j++){
                String str = i + "," + j;
                if( grid[i][j] == 0 && !visited.contains(str)){
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void  dfs(int row, int col){
        String str = row + "," + col;
        if(visited.contains(str)){
            return;
        }

        // check bounderies
        if(row >= rowMax || col >= colMax){
            return;
        }

        if(row < 0 || col < 0){
            return;
        }

        if(grid[row][col] == 1){
            return;
        }

        visited.add(str);

        // go top
        dfs(row-1, col);
        // go left
        dfs(row, col-1);
        // go down
        dfs(row+1, col);
        // go right
        dfs(row, col+1);

        return;
    }
}