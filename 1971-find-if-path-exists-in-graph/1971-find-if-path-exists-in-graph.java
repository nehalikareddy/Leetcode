class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] vis = new boolean[n];
        return dfs(graph,source,destination,vis);
    }

    public boolean dfs(ArrayList<Integer>[] graph,int curr,int destination,boolean[] vis){
        if(curr == destination){
            return true;
        }
        vis[curr]=true;
        for(int neighbor : graph[curr]){
            if(!vis[neighbor]){
                if(dfs(graph,neighbor,destination,vis)){
                    return true;
                }
            }
        }
        return false;
    }

}