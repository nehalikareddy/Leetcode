class Solution {
    public void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        // Check first and last row
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                bfs(0, j, board);
            }

            if (board[rows - 1][j] == 'O') {
                bfs(rows - 1, j, board);
            }
        }

        // Check first and last column
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                bfs(i, 0, board);
            }

            if (board[i][cols - 1] == 'O') {
                bfs(i, cols - 1, board);
            }
        }

        // Convert surrounded O -> X
        // Convert safe S -> O
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } 
                else if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void bfs(int i, int j, char[][] board) {

        int[][] dirs = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});
        board[i][j] = 'S';

        while (!q.isEmpty()) {

            int[] curr = q.remove();

            int r = curr[0];
            int c = curr[1];

            for (int[] dir : dirs) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < board.length &&
                    nc >= 0 && nc < board[0].length &&
                    board[nr][nc] == 'O') {

                    board[nr][nc] = 'S';
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}