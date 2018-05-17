package gameoflifepackage;

public class GameofLife {
	public static void main(String[] args) {
		Grid grid = new Grid();
		GameManager gameManager = new GameManager(grid);
		new View(grid, gameManager);
	}
}

//Grid grid=new Grid();
//grid.setSize(800, 800);
//grid.setupgrid();
//grid.setLayout(null);
//grid.setVisible(true);
//grid.setLocationRelativeTo(null);
//grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);