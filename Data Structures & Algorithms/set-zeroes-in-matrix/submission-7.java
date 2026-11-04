class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false, firstColZero = false;
        for (int j = 0; j < n; j++) if (matrix[0][j] == 0) firstRowZero = true;
        for (int i = 0; i < m; i++) if (matrix[i][0] == 0) firstColZero = true;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<n;i++){
            if(matrix[0][i]==0){
                turnColIntoZeros(matrix, i);
            }
        }

        for(int i=1;i<m;i++){
            if(matrix[i][0]==0){
                turnRowIntoZeros(matrix, i);
            }
        }

        if (firstRowZero)  turnRowIntoZeros(matrix, 0);
        if (firstColZero) turnColIntoZeros(matrix, 0);

    }

    public void turnRowIntoZeros(int[][] matrix, int rowIndex){
        for(int i=0;i<matrix[0].length;i++){
            matrix[rowIndex][i]=0;
        }
    }

    public void turnColIntoZeros(int[][] matrix, int colIndex){
        for(int i=0;i<matrix.length;i++){
            matrix[i][colIndex]=0;
        }
    }
}
