import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();
        int sr = 0, sc = 0, cnt = 0;
        int[][] id = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }
                if (ch == 'L')
                    id[i][j] = cnt++;
            }

        int[][][] best = new int[m][n][1 << cnt];

        for (int[][] a : best)
            for (int[] b : a)
                Arrays.fill(b, -1);

        Queue<int[]> q = new ArrayDeque<>();

        // row, col, remaining energy, collected mask
        q.offer(new int[]{sr, sc, energy, 0});
        best[sr][sc][0] = energy;

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int moves = 0;
        int target = (1 << cnt) - 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];
                int e = cur[2], mask = cur[3];

                if (mask == target) return moves;
                if (e == 0) continue;

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n ||
                        classroom[nr].charAt(nc) == 'X')
                        continue;

                    int ne = e - 1;
                    int nm = mask;
                    char ch = classroom[nr].charAt(nc);

                    if (ch == 'R')
                        ne = energy;

                    if (ch == 'L')
                        nm |= (1 << id[nr][nc]);

                    // Only continue if we reached this state
                    // with MORE energy than before
                    if (ne > best[nr][nc][nm]) {
                        best[nr][nc][nm] = ne;
                        q.offer(new int[]{nr, nc, ne, nm});
                    }
                }
            }

            moves++;
        }

        return -1;
    }
}