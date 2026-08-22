class Solution {
    public int numIslands(char[][] grid) {
        //bfs
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void bfs(char[][] grid, int row,int col){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        grid[row][col] = '0';
        int[][] directions = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int r = curr[0];
            int c = curr[1];
            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if((nr >= 0 && nr < grid.length) && (nc >= 0 && nc < grid[0].length) ){
                    if(grid[nr][nc] == '1'){
                        grid[nr][nc] = '0';
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
    }
}