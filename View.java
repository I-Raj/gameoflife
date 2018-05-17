package gameoflifepackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;

public class View extends JFrame implements ActionListener {
	Grid grid;
	GameManager gameManager;
	JButton nextButton, startButton;
	JSlider speedSlider, sizeSlider;
	
	public View(Grid grid, GameManager gameManager) {
		this.grid = grid;
		this.gameManager = gameManager;
		
		setSize(800, 800);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(grid);
		
		this.nextButton = new JButton("Next");
		nextButton.setBounds(150, 550, 80, 25);
		nextButton.addActionListener(this);
		add(nextButton);
		
		this.startButton = new JButton("Start");
		startButton.setBounds(250, 550, 80, 25);
		startButton.addActionListener(this);
		add(startButton);
		
		this.speedSlider = new  JSlider(JSlider.HORIZONTAL,0,100,10);
		speedSlider.setBounds(350, 550, 110, 25);
		add(speedSlider);
		
		this.sizeSlider = new  JSlider(JSlider.HORIZONTAL, 0, 100, 10);
		sizeSlider.setBounds(500, 550, 110, 25);
		add(sizeSlider);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == nextButton) {
			gameManager.nextGeneration();
			repaint();
		} else if (event.getSource() == startButton) {
			
		}
	}
}

//package gameoflifepackage;
//
//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ComponentEvent;
//import java.awt.event.ComponentListener;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JSlider;
//
//public class Grid extends JFrame implements MouseListener, ActionListener {
//	private Cell[][] grid = new Cell[100][100];
//
//	public Grid()	{
//		addMouseListener(this);
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
//	}
//
//	public void setupgrid()	{
//		for(int row = 0; row < 60; row++) {
//			for(int col = 0; col < 40; col++) {
//				grid[row][col] = new Cell(false);
//			}
//		}
//	}
//
//	public void paint(Graphics g) {
//		super.paint(g);
//		for(int i = 0; i < 60; i++)	{
//			for(int j = 0; j < 40; j++)	{
//				g.setColor(Color.BLACK);
//				g.drawRect((i * 10) + 80, (j * 10) + 60, 10, 10);
//				if(grid[i][j].isLiving() == false)	{
//					g.setColor(Color.gray);
//					g.fillRect((i * 10) + 80, (j * 10) + 60, 10, 10);
//				}
//				else {
//					g.setColor(Color.YELLOW);
//					g.fillRect((i * 10) + 80, (j * 10) + 60, 10, 10);
//				}
//			}
//		}
//	}
//
//
//	public void mouseClicked(MouseEvent event) {
//
//	}
//
//
//	public void mouseEntered(MouseEvent event) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	public void mouseExited(MouseEvent event) {
//		// TODO Auto-generated method stub
//
//	}
//
//
//	public void mousePressed(MouseEvent event) {
//		int col = ((event.getY() - 60) / 10);
//		int row = ((event.getX() - 80) / 10);
//		grid[row][col].swapIsLiving();
//		//System.out.print(row+" "+col);
//		this.repaint();
//	}
//
//
//	public void mouseReleased(MouseEvent event) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public void actionPerformed(ActionEvent event) {
//
//	}
//}
