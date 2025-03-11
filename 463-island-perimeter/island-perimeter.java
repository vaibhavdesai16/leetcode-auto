class Solution {
    public int islandPerimeter(int[][] grid) {
        int rowMax = grid.length - 1;
        int colMax = grid[0].length - 1;
        int peri = 0;
        
        for(int row=0; row<grid.length; row++){
            for(int col=0; col<grid[0].length; col++){

                if(grid[row][col] == 1){

                    //check left
                    int cl = col - 1;
                    if(cl >= 0 && cl <= colMax && grid[row][cl] == 0){
                        peri++;
                    }
                    else if(cl < 0 || cl > colMax){
                        peri++;
                    }

                    //check right
                    cl = col + 1;
                    if(cl >= 0 && cl <= colMax && grid[row][cl] == 0){
                        peri++;
                    }
                    else if(cl < 0 || cl > colMax){
                        peri++;
                    }

                    // check top
                    int cr = row - 1;
                    if(cr >= 0 && cr <= rowMax && grid[cr][col] == 0){
                        peri++;
                    }
                    else if(cr < 0 || cr > rowMax){
                        peri++;
                    }

                    //check bottom
                    cr = row + 1;
                    if(cr >= 0 && cr <= rowMax && grid[cr][col] == 0){
                        peri++;
                    }
                    else if(cr < 0 || cr > rowMax){
                        peri++;
                    }
                }
            }
        }

        return peri;
    }
}