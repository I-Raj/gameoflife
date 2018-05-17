package gameoflifepackage;

public class GameManager {
	Grid grid;
	
	public GameManager(Grid grid) {
		this.grid = grid;
	}
	
	public int countLivingNeighbors(int row, int col) {
		int livingNeighbors = 0;

		int[] dxArray = {1, -1, 0};
	  int[] dyArray = {1, -1, 0};
	  
	  for (int dx : dxArray) {
	    for (int dy : dyArray) {
	    	int neighborRow = row + dy;
	    	int neighborCol = col + dx;
	    	if ((row != 0 || col != 0) 
	    			&& neighborRow >= 0 && neighborRow <= grid.getNumRows()
	    			&& neighborCol >= 0 && neighborCol <= grid.getNumCols()) {
	    		if (grid.getCell(neighborRow, neighborCol).isLiving()) {
	    			livingNeighbors++;
	    		}
	    	}
	    }
	  }
	  
    return livingNeighbors;
	}
	
	public void nextGeneration() {
//		Iterates through all cells of the grid and updates their willLive
//		Then will updates their isLiving (done)
		for (int row = 0; row < grid.getNumRows(); row++) {
			for (int col = 0; col < grid.getNumCols(); col++) {
				int livingNeighbors = countLivingNeighbors(row, col);
//				Update cell using grid.getCell(row, col).setWillLive(willLive);
				if (grid.getCell(row, col).isLiving()) {
//					Cell is alive
					
//					Update cell with these rules:
//					Each cell with one or no neighbors dies, as if by solitude.
//					Each cell with four or more neighbors dies, as if by overpopulation.
//					Each cell with two or three neighbors survives.
				} else {
//					Cell is dead
					
//					Update cell with these rules:
//					Each cell with three neighbors becomes populated.
				}
			}
		}
		
		for (int row = 0; row < grid.getNumRows(); row++) {
			for (int col = 0; col < grid.getNumCols(); col++) {
				grid.getCell(row, col).updateIsLiving();
			}
		}
	}
//	class Mananger(Integer[][] matrix) {
//    this.matrix = matrix;
//  }
//  // live (1) or dead (0)
//  public boolean nextStep(Integer[][] matrix) {
//    int rowLen = matrix.length;
//    int colLen = matrix[0].length;
//
//    for(int i = 0; i < rowLen; i++) {
//      for (int j = 0; j < colLen; j++) {
//        boolean change = ifChange(matrix, i, j);
//        if (change == false) {
//          continue;
//        } else {
//          if (matrix[i][j] == 1) {
//            matrix[i][j] = -1;
//          } else if (matrix[i][j] == 0) {
//            matrix[i][j] = -2;
//          }
//        }
//      }
//    }
//
//    for(int i = 0; i < rowLen; i++) {
//      for (int j = 0; j < colLen; j++) {
//        if (matrix[i][j] == -1) {
//          matrix[i][j] = 0;
//        } else if (matrix[i][j] == -2) {
//          matrix[i][j] = 1;
//        }
//      }
//    }
//  }
//
//  public boolean ifChange(int[][] matrix, int i, int j) {
//    int num = neighbor(matrix, i, j);
//    if (matrix[i][j] == 1){
//      if (num < 2){
//        return true;
//      }else if(num == 2 || num == 3){
//        return false;
//      }else if(num > 3){
//        return true;
//      }
//    }else if(matrix[i][j] == 0 && num == 3){
//      return true;
//    }
//  }
}
