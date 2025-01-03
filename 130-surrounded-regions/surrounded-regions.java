class Solution {
    int rMax;
    int cMax;
    char[][] board;
    HashSet<String> visited = new HashSet<>();

    public void solve(char[][] board) {
        if (board.length == 0) return;

        // Create a visited array to track cells connected to the boundary
        boolean vis[][] = new boolean[board.length][board[0].length];

        // Perform DFS for the first row (top boundary)
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O' && !vis[0][i]) {
                dfs(board, 0, i, vis);
            }
        }

        // Perform DFS for the last row (bottom boundary)
        for (int i = board[0].length - 1; i >= 0; i--) {
            if (board[board.length - 1][i] == 'O' && !vis[board.length - 1][i]) {
                dfs(board, board.length - 1, i, vis);
            }
        }

        // Perform DFS for the first column (left boundary, excluding corners)
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][0] == 'O' && !vis[i][0]) {
                dfs(board, i, 0, vis);
            }
        }

        // Perform DFS for the last column (right boundary, excluding corners)
        for (int i = 1; i < board.length - 1; i++) {
            if (board[i][board[0].length - 1] == 'O' && !vis[i][board[0].length - 1]) {
                dfs(board, i, board[0].length - 1, vis);
            }
        }

        // Update the board based on the visited array
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // If a cell is not visited, it is surrounded by 'X', so flip it to 'X'
                if (!vis[i][j]) {
                    board[i][j] = 'X';
                } else {
                    // Otherwise, keep it as 'O'
                    board[i][j] = 'O';
                }
            }
        }
        
    }

    public void dfs(char[][] board, int r, int c, boolean[][] vis) {
        // Base case: if out of bounds, cell is 'X', or already visited, stop the recursion
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == 'X' || vis[r][c]) {
            return;
        }

        // Mark the current cell as visited
        vis[r][c] = true;

        // Recursively visit all adjacent cells (up, down, left, right)
        dfs(board, r - 1, c, vis); // Up
        dfs(board, r + 1, c, vis); // Down
        dfs(board, r, c - 1, vis); // Left
        dfs(board, r, c + 1, vis); // Right
    }


}