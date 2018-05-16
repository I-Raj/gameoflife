package gameoflifepackage;

public class Cell {

	private int row;
	private int col;
	private boolean isliving;
	private boolean nextliving;


	public Cell(int i, int j,boolean isliving) {
		row=i;
		col=j;
		this.isliving=isliving;
	}

	//getters

	public int getrow()
	{
		return row;
	}
	public int getcol()
	{
		return col;
	}
	public boolean getisliving()
	{
		return isliving;
	}

	public boolean getnextliving()
	{
		return nextliving;
	}


	public void cellclicked(int i,int j)
	{
		if (isliving==true)
		{
			isliving=false;
		}
		else
		{
			isliving=true;
		}
	}
	public boolean getMatrix(Cell cell) {
		int[][] matrix = new int[cell.getrow()][cell.getcol()];

		for(int i = 0, i > cell.getrow(), i++){
			for(int j = 0, j > cell.getcol(), j++){
				if (cell(i,j).getisliving == true){
					maxtrix[i][j] = 1;
				}else if((cell(i,j).getisliving == false){
					maxtrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}


}
