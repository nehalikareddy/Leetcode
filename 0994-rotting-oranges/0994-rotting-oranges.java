class Solution {
    public int orangesRotting(int[][] grid) {

        int mins = 0;
        int fresh = 0;

        Queue<int[]> q = new LinkedList<>();

        // Put ALL rotten oranges into queue
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {

                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }

                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] directions = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };

        while(!q.isEmpty() && fresh > 0) {

            int size = q.size();

            // Process one complete minute
            for(int i = 0; i < size; i++) {

                int[] curr = q.remove();

                int r = curr[0];
                int c = curr[1];

                for(int[] dir : directions) {

                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >= 0 && nr < grid.length &&
                       nc >= 0 && nc < grid[0].length) {

                        if(grid[nr][nc] == 1) {

                            grid[nr][nc] = 2;
                            fresh--;

                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }

            mins++;
        }

        if(fresh > 0) {
            return -1;
        }

        return mins;
    }
}