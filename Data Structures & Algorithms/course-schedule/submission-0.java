class Solution {
    boolean canBeFinished = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0;i<prerequisites.length;i++){
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            adj.get(from).add(to);
        }

        char[] visited = new char[numCourses];
        Arrays.fill(visited, 'u');
        for(int i=0;i<numCourses;i++){
            if(!canBeFinished){
                return false;
            }
            detectCycle(adj, visited, i);
        }

        return canBeFinished;
    }

    private void detectCycle(ArrayList<ArrayList<Integer>> adj, char[] visited, int i){
        if(visited[i]=='u'){
            visited[i]='v';
            ArrayList<Integer> neighbours = adj.get(i);
            for(int neighbour : neighbours){
                
                detectCycle(adj, visited, neighbour);
                
            }
            visited[i]='p';
        }else if(visited[i]=='v'){
            canBeFinished = false;
        }
    }
}
