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
}
