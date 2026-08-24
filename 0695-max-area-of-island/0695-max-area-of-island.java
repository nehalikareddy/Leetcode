class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //int count = 0;
        int maxIsland = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    //count++;
                    int island = bfs(grid,i,j);
                    maxIsland = Math.max(maxIsland,island);
                }
            }
        }
        return maxIsland;
    }
    public int bfs(int[][] grid, int row,int col){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row,col});
        grid[row][col] = 0;
        int[][] directions = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        int number = 1;
        while(!q.isEmpty()){
            int[] curr = q.remove();
            int r = curr[0];
            int c = curr[1];
            for(int[] dir : directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if((nr >= 0 && nr < grid.length) && (nc >= 0 && nc < grid[0].length) ){
                    if(grid[nr][nc] == 1){
                        number++;
                        
                        grid[nr][nc] = 0;
                        q.add(new int[]{nr,nc});
                    }
                    
                }
            }
        }
        return number;
    }
    

}