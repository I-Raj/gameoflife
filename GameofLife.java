package gameoflifepackage;

import javax.swing.JFrame;

public class GameofLife {
	public static void main(String[] args) {
		Grid grid = new Grid();
		new View(grid);
	}
}

//Grid grid=new Grid();
//grid.setSize(800, 800);
//grid.setupgrid();
//grid.setLayout(null);
//grid.setVisible(true);
//grid.setLocationRelativeTo(null);
//grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);