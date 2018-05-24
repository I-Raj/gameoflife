package gameoflifepackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class View extends JFrame implements ActionListener, ChangeListener, ItemListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Grid grid;
    GameManager gameManager;
    JButton nextButton, startButton, cellcolChoosBtn, gridcolChoosBtn;
    JSlider speedSlider, sizeSlider;
    JComboBox<String> comboBox;
    JLabel speedImg,sizeImg,paintImg,gameOfLife;
    static final String[] names = {"Clear", "Small Exploder","Lightweight Spaceship", "Pulsar","Gosper Glider Gun", "COEN 275"};

    ImageIcon speedIcon = new ImageIcon("/Users/umasurakod/Desktop/speed2.jpeg");
    ImageIcon zoomIcon = new ImageIcon("/Users/umasurakod/Desktop/zoom.jpeg");
    ImageIcon paintIcon = new ImageIcon("/Users/umasurakod/Desktop/paint2.jpeg");
    ImageIcon headingIcon = new ImageIcon("/Users/umasurakod/Desktop/golHeading.png");
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
        startButton.setBounds(230, 700, 80, 25);
        startButton.addActionListener(this);
        add(startButton);

        this.speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        speedSlider.setBounds(385, 700, 110, 25);
        speedSlider.addChangeListener(this);
        add(speedSlider);

        this.sizeSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 0);
        sizeSlider.setBounds(535, 700, 110, 25);
        sizeSlider.addChangeListener(this);
        add(sizeSlider);

        this.comboBox = new JComboBox<String>(names);
        comboBox.setBounds(700, 700, 200, 25);
        comboBox.setMaximumRowCount(5);
        comboBox.addItemListener(this);
        add(comboBox);
        
        this.speedImg = new JLabel(speedIcon);
        speedImg.setBounds(340,695,50,30);
        add(speedImg);
     
        this.sizeImg = new JLabel(zoomIcon);
        sizeImg.setBounds(492,700,50,30);
        add(sizeImg);
        
        this.paintImg = new JLabel(paintIcon);
        paintImg.setBounds(700,735,50,30);
        add(paintImg);
        
        this.gameOfLife = new JLabel(headingIcon);
        gameOfLife.setBounds(300,20,440,50);
        add(gameOfLife);
         
        this.cellcolChoosBtn = new JButton("Cell"); 
        cellcolChoosBtn.setBounds(750, 728, 80, 25);
        cellcolChoosBtn.addActionListener(this);
        add(cellcolChoosBtn);
        
        this.gridcolChoosBtn = new JButton("Grid"); 
        gridcolChoosBtn.setBounds(750, 755, 80, 25);
        gridcolChoosBtn.addActionListener(this);
        add(gridcolChoosBtn);

        this.getContentPane().setBackground(Color.white);
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
        else if(event.getSource() == cellcolChoosBtn) {
        	Color initialcolor=Color.YELLOW;    
    		Color color1=JColorChooser.showDialog(this,"Select a color",initialcolor); 
    		grid.setcellColor(color1);
            repaint();
        }
        else if(event.getSource() == gridcolChoosBtn) {
        	Color initialcolor=Color.GRAY;    
    		Color color2=JColorChooser.showDialog(this,"Select a color",initialcolor); 
    		grid.setgridColor(color2);
            repaint();
        }
    }

    public void stateChanged(ChangeEvent event) {
        if (event.getSource() == sizeSlider) {
            int sizeValue = sizeSlider.getValue();
            this.grid.setNewcellSize(18 - (sizeValue / 15));
        }
        if (event.getSource() == speedSlider) {
            // Speed can range from 1000ms-4000ms
            int speedValue = speedSlider.getValue();
            int hertz = 1 + speedValue * 50 / 100;
            timer.setDelay(1000 / hertz);
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String item = e.getItem().toString();
        int stateChange = e.getStateChange();
        if (stateChange == ItemEvent.SELECTED) {
            if (item.equals(names[0])){
                grid.setInitailView();
                repaint();
            } else if (item.equals(names[1])){
                grid.exploreView();
                repaint();
            } else if (item.equals(names[2])){
                grid.SpaceshipView();
                repaint();
            } else if (item.equals(names[3])){
                grid.pulsarView();
                repaint();
            } else if (item.equals(names[4])){
                grid.gliderView();
                repaint();
            } else if (item.equals(names[5])){
                grid.coenView();
                repaint();
            }
        }
    }
}

