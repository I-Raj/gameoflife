package gameoflifepackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Grid extends JFrame implements MouseListener,ActionListener{
Cell cell[][]=new Cell[100][100];


public Grid()
{
	addMouseListener(this);
	JButton next = new JButton("Next");
	next.setBounds(130,460,60,25);
	add(next);
	JButton start = new JButton("Start");
	start.setBounds(208,460,60,25);
	add(start);
	JSlider speed = new  JSlider(JSlider.HORIZONTAL,0,100,10);
	speed.setBounds(280,460,110,25);
	add(speed);
	JSlider resize = new  JSlider(JSlider.HORIZONTAL,0,100,10);
	resize.setBounds(410,460,110,25);
	add(resize);
	resize.addComponentListener(new ComponentListener() {

		public void componentHidden(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void componentMoved(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void componentResized(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		public void componentShown(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}
        
            
	});
   

	
}

public void setupgrid()
{
	for(int i=0;i<60;i++)
	{
		for(int j=0;j<40;j++)
		{
			cell[i][j]=new Cell(i,j,false);
		}
	}
}


public void paint(Graphics g)
{
	super.paint(g);
	for(int i=0;i<60;i++)
	{
		for(int j=0;j<40;j++)
		{
			g.setColor(Color.BLACK);
			g.drawRect((i*10)+80, (j*10)+60,10 , 10);
			if(cell[i][j].getisliving()==false)
			{
				
				g.setColor(Color.gray);
				g.fillRect((i*10)+80, (j*10)+60, 10, 10);
			}
			else
			{
				g.setColor(Color.YELLOW);
				g.fillRect((i*10)+80, (j*10)+60, 10, 10);
			}
		}
	}
	
}


public void mouseClicked(MouseEvent arg0) {
	
}


public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}


public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}


public void mousePressed(MouseEvent arg0) {
	int col=((arg0.getY()-60)/10);
	int row=((arg0.getX()-80)/10);
	cell[row][col].cellclicked(row, col);
	//System.out.print(row+" "+col);
	this.repaint();
}


public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

public void actionPerformed(ActionEvent arg0) {
	
}
}


