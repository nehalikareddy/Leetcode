class Solution {
    public boolean isBipartite(int[][] graph) {
        //bipartile means neighbors are enemies 
        //-1 = no color, 0 = blue, 1 = pink
        //bfs
        int n = graph.length;
        int[] color = new int[n];
        for(int i=0;i<n;i++){
            color[i] = -1;
        }
        //or can write Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i]=0;
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int neigh : graph[curr]){
                        if(color[neigh] == -1){
                            color[neigh] = (color[curr]==0)?1:0;
                            q.add(neigh);
                        }
                        else if(color[neigh] == color[curr]){
                            return false;
                        }
            
                    

                    }
                }
            }
        }

        return true;

        
    }
}