class Solution {
    List<Integer> answer;

    public List<Integer> spiralOrder(int[][] matrix) {
        answer = new ArrayList<>();
        int startRow = 0;
        int endRow = matrix.length-1;

        int startCol = 0;
        int endCol=matrix[0].length-1;

        while(startRow<=endRow && startCol<=endCol){
            upper(matrix, startCol, endCol, startRow);
            startRow++;

            if(startRow<=endRow){
                right(matrix, startRow, endRow, endCol);
                endCol--;
            }
            
            if(startCol <= endCol && startRow <= endRow){
                down(matrix, startCol, endCol, endRow);
                endRow--;
            }
            
            if(startRow<=endRow && startCol<=endCol){
                left(matrix, startRow, endRow, startCol);
                startCol++;
            }
        }

        for(int i=0;i<answer.size();i++){
            System.out.print(" "+ answer.get(i)+", ");
        }

        return answer;
    }

    public void upper(int[][] matrix, int start, int end, int line){
        for(int i=start;i<=end;i++){
            System.out.println("upper: "+matrix[line][i]);
            answer.add(matrix[line][i]);
        }
    }

    public void right(int[][] matrix, int start, int end, int line){
        for(int i=start;i<=end;i++){
            System.out.println("right: "+matrix[i][line]);
            answer.add(matrix[i][line]);
        }
    }

    public void down(int[][] matrix, int start, int end, int line){
        for(int i=end;i>=start;i--){
            System.out.println("down: "+matrix[line][i]);
            answer.add(matrix[line][i]);
        }
    }

    public void left(int[][] matrix, int start, int end, int line){
        for(int i=end;i>=start;i--){
             System.out.println("left: "+matrix[i][line]);
            answer.add(matrix[i][line]);
        }
    }


}
