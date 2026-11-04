class Solution {
    boolean isValid = true;
    public boolean validTree(int n, int[][] edges) {

        // construct list
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
             list.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }

        char[] visited = new char[n];
        Arrays.fill(visited, 'u');

        check(0, -1, visited, list);

         if (isValid) {
            for (int i = 0; i < n; i++) {
                if (visited[i] == 'u') return false;
            }
        }


        return isValid;
    }

    public void check(int i,  int parent, char[] visited, ArrayList<ArrayList<Integer>> list){
        if(visited[i]=='u'){
            visited[i]='v';
            for(int j=0;j<list.get(i).size();j++){
                int currNum = list.get(i).get(j);
                
                if (currNum == parent) continue;  
                check(currNum, i, visited, list);
            }
            visited[i]='p';
        }else if(visited[i]=='v'){
            isValid = false;
        }
    }

    public boolean isParent(int parent, int child, ArrayList<ArrayList<Integer>> list){
        ArrayList<Integer> needed = list.get(parent);
        for(int i=0;i<needed.size();i++){
            if(needed.get(i)==child){
                return true;
            }
        }
        return false;
    }
}
