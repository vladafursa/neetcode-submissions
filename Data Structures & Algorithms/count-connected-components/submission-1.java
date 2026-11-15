class Solution {
    public int countComponents(int n, int[][] edges) {
        int count =0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(adj, visited, i, i);
            }
        }

        return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int start, int parent){
        visited[start]=true;
        ArrayList<Integer> neighbours = adj.get(start);
        parent = start;
        for(int neighbour : neighbours){
            if(!visited[neighbour] && neighbour!=parent){
                dfs(adj, visited, neighbour, start);
            }
        }
    }
}
