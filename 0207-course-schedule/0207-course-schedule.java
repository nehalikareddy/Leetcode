class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];
    

        for(int[] pair : prerequisites){
            int course = pair[0];
            int req = pair[1];
            adj.get(req).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int courseTaken = 0;
        while(!q.isEmpty()){
            int curr = q.remove();
            courseTaken++;
            for(int neigh : adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    q.add(neigh);
                }
            }

        }

    return courseTaken == numCourses;
    }
}