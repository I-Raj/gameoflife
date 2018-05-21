package gameoflifepackage;

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
    JButton nextButton, startButton;
    JSlider speedSlider, sizeSlider;
    JComboBox<String> comboBox;
//    JLabel label;
    static final String[] names = {"Clear", "Small Exploder", "Lightweight Spaceship", "Gosper Glider Gun", "COEN 275"};
//    Icon[] icons = {
//            new ImageIcon(getClass().getResource(names[0])),
//            new ImageIcon(getClass().getResource(names[1])),
//            new ImageIcon(getClass().getResource(names[2])),
//            new ImageIcon(getClass().getResource(names[3])),
//            new ImageIcon(getClass().getResource(names[4]))};
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

        this.speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        speedSlider.setBounds(350, 700, 110, 25);
        speedSlider.addChangeListener(this);
        add(speedSlider);

        this.sizeSlider = new JSlider(JSlider.HORIZONTAL, 0, 50, 0);
        sizeSlider.setBounds(500, 700, 110, 25);
        sizeSlider.addChangeListener(this);
        add(sizeSlider);

        this.comboBox = new JComboBox<String>(names);
        comboBox.setBounds(700, 700, 200, 25);
        comboBox.setMaximumRowCount(5);
        comboBox.addItemListener(this);

        add(comboBox);


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
                grid.gliderView();
                repaint();
            } else if (item.equals(names[4])){
                grid.coenView();
                repaint();
            }

        }
    }
}


