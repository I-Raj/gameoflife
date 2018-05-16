package gameoflifepackage;

public class Cell {
	private boolean isLiving;
	private boolean willLive;

	public Cell(boolean isLiving) {
		this.isLiving = isLiving;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean isLiving() {
		return isLiving;
	}

	public boolean getnextliving() {
		return nextliving;
	}

	public void swapIsLivingState() {
		isLiving = !isLiving;
	}
}
