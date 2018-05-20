package gameoflifepackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Grid extends JPanel implements MouseListener, MouseMotionListener, ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cell[][] grid = new Cell[100][100];
	private int numCols, numRows;
	private int cellSizeChange = 18;

	public Grid()	{
		// Can be changed later
		this.numCols = 80;
		this.numRows = 60;
		
		setBounds(100, 80, numCols * 10 + 1, numRows * 10 + 1);
		
		addMouseListener(this);
		addMouseMotionListener(this);
//		JButton next = new JButton("Next");
//		next.setBounds(130, 460, 60, 25);
//		add(next);
//		JButton start = new JButton("Start");
//		start.setBounds(208, 460, 60, 25);
//		add(start);
//		JSlider speed = new  JSlider(JSlider.HORIZONTAL,0,100,10);
//		speed.setBounds(280, 460, 110, 25);
//		add(speed);
//		JSlider resize = new  JSlider(JSlider.HORIZONTAL, 0, 100, 10);
//		resize.setBounds(410, 460, 110, 25);
//		add(resize);
//		resize.addComponentListener(new ComponentListener() {
//
//			public void componentHidden(ComponentEvent event) {
//				// TODO Auto-generated method stub
//
//			}
//
//			public void componentMoved(ComponentEvent event) {
//				// TODO Auto-generated method stub
//
//			}
//
//			public void componentResized(ComponentEvent event) {
//				// TODO Auto-generated method stub
//
//			}
//
//			public void componentShown(ComponentEvent event) {
//				// TODO Auto-generated method stub
//
//			}
//		});
		setupGrid();
	}

	public void setupGrid()	{
		for(int row = 0; row < numRows; row++) {
			for(int col = 0; col < numCols; col++) {
				grid[row][col] = new Cell(false);
			}
		}
	}
	
	public int getNumCols() {
		return numCols;
	}
	
	public int getNumRows() {
		return numRows;
	}
	
	public Cell getCell(int row, int col) {
		return grid[row][col];
	}
	
	public void actionPerformed(ActionEvent event) {
		
	}
	
	public void mouseClicked(MouseEvent event) {}

	public void mouseEntered(MouseEvent event) {}

	public void mouseExited(MouseEvent event) {}
	
	public void mouseReleased(MouseEvent event) {}

	public void mousePressed(MouseEvent event) {
		int row = event.getY() / 18;
		int col = event.getX() / 18;
		grid[row][col].swapIsLiving();
//		System.out.print(row+" "+col);
		repaint();
	}
	
	public void mouseDragged(MouseEvent event) {
		mousePressed(event);
	}
	
	public void mouseMoved(MouseEvent event) {}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int row = 0; row < numRows; row++)	{
			for(int col = 0; col < numCols; col++)	{
				g.setColor(Color.BLACK);
				g.drawRect(col * cellSizeChange, row * cellSizeChange, cellSizeChange, cellSizeChange);
//				if ((row + col) % 2 == 1) {
				if(grid[row][col].isLiving() == false)	{
					g.setColor(Color.GRAY);
				}
				else {
					g.setColor(Color.YELLOW);
				}
				g.fillRect(col * cellSizeChange + 1, row * cellSizeChange + 1, cellSizeChange-1, cellSizeChange-1);
			}
		}
	}
	public void setNewcellSize(int newSize) {
		cellSizeChange = (newSize >= 5 ? newSize : 18);
		repaint();
	}
}



