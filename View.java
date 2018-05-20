package gameoflifepackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class View extends JFrame implements ActionListener, ChangeListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Grid grid;
	GameManager gameManager;
	JButton nextButton, startButton;
	JSlider speedSlider, sizeSlider;
	Timer timer = new Timer(1000, this);
	
	public View(Grid grid, GameManager gameManager) {
		this.grid = grid;
		this.gameManager = gameManager;
		
		setSize(1000, 1000);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(grid);
		
		this.nextButton = new JButton("Next");
		nextButton.setBounds(150, 700, 80, 25);
		nextButton.addActionListener(this);
		add(nextButton);
		
		this.startButton = new JButton("Start");
		startButton.setBounds(250, 700, 80, 25);
		startButton.addActionListener(this);
		add(startButton);
		
		this.speedSlider = new  JSlider(JSlider.HORIZONTAL, 0, 100, 0);
		speedSlider.setBounds(350, 700, 110, 25);
		speedSlider.addChangeListener(this);
		add(speedSlider);
		
		this.sizeSlider = new  JSlider(JSlider.HORIZONTAL, 0, 50, 0);
		sizeSlider.setBounds(500, 700, 110, 25);
		sizeSlider.addChangeListener(this);
		add(sizeSlider);
	}
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == nextButton) {
			gameManager.nextGeneration();
			repaint();
		} else if (event.getSource() == startButton) {
			if (startButton.getText() == "Start") {
				timer.start();
				startButton.setText("Stop");
			} else if (startButton.getText() == "Stop") {
				startButton.setText("Start");
				timer.stop();
			}
		} else if (event.getSource() == timer) {
			gameManager.nextGeneration();
			repaint();
		}
	}
	
	public void stateChanged(ChangeEvent event) {
		if(event.getSource() == sizeSlider) {
			int sizeValue = sizeSlider.getValue();
			this.grid.setNewcellSize(18 - (sizeValue/15));
		}
		if (event.getSource() == speedSlider) {
			// Speed can range from 1000ms-4000ms
			int speedValue = speedSlider.getValue();
			int hertz = 1 + speedValue * 3 / 100;
			timer.setDelay(1000 / hertz);
		}

	}
}

