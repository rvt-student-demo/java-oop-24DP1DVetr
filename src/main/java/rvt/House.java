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
		g.drawOval(10, 10, 200, 200);
    }
}