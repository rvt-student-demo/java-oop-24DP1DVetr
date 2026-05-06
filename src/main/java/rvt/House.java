package rvt;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class House {
    private JFrame frame;
    public House(){
        frame = new JFrame("House");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
        
        ComponentHouse c = new ComponentHouse();
        frame.add(c);

        frame.setVisible(true); 
    }
    public static void main(String[] args) {
        new House();
    }   
}

class ComponentHouse extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
		g.drawRect(100, 100, 100, 100);
        g.drawRect(150, 170, 20, 30);
        g.drawLine(100, 100, 150, 50);
        g.drawLine(150, 50, 200, 100);
    }
}