package gameoflifepackage;
java.lang.Math.abs()
public class Mananger {

    Integer[][] matrix = new Integer[rowLen][colLen];

    class Mananger(Integer[][] matrix) {
        this.matrix = matrix;
    }
// live (1) or dead (0)
    public boolean nextStep(Integer[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for(int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                boolean change = ifChange(matrix, i, j);
                if (change == false) {
                    continue;
                } else {
                    if (matrix[i][j] == 1) {
                        matrix[i][j] = -1;
                    } else if (matrix[i][j] == 0) {
                        matrix[i][j] = -2;
                    }
                }
            }
        }

        for(int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                } else if (matrix[i][j] == -2) {
                    matrix[i][j] = 1;
                }
            }
        }
    }

    public boolean ifChange(int[][] matrix, int i, int j) {
        int num = neighbor(matrix, i, j);
        if (matrix[i][j] == 1){
            if (num < 2){
                return true;
            }else if(num == 2 || num == 3){
                return false;
            }else if(num > 3){
                return true;
            }
        }else if(matrix[i][j] == 0 && num == 3){
            return true;
        }
    }

    public int neighbor(int[][] matrix, int i, int j) {
        int[] x = {1, -1, 0};
        int[] y = {1, -1, 0};
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int sum = 0;
        for (int x1 : x) {
            for (int y1 : y) {
                if (x1 == 0 && y1 == 0) {
                    continue;
                }
                if (i + x1 >= 0 && i + x1 < rowLen && j + y1 >= 0 && j + y1 < colLen and abs
                (matrix[i + x1][j + y1]) == 1){
                    sum++;
                }
            }
            return sum;
        }
    }
