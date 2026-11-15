class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }


        return count;
    }

    public void dfs(char[][] grid, boolean[][] visited, int i, int j){
        if(i<0 || i==grid.length || j<0 || j==grid[0].length){
            return;
        }

        if(grid[i][j]=='0'){
            return;
        }
        if(visited[i][j]){
            return;
        }

        visited[i][j]=true;

        dfs(grid, visited, i-1, j);
        
        dfs(grid, visited, i+1, j);

        dfs(grid, visited, i, j-1);

        dfs(grid, visited, i, j+1);
        
    }
}
