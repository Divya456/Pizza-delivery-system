package pizza_delivery_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class booking extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x1 = 20, y1 = 30, x2 = 40, y2 = 20, i, j;
        for (i = 0; i < 2; i++) {

            for (j = 0; j < 3; j++) {

                g.setColor(Color.BLUE);
                g.fillRect(x1, y1, x2, y2);
                x1 += 60;
            }
            x1 = 20;
            y1 += 40;

        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.getContentPane().add(new booking(), BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 400);
        f.setVisible(true);
    }
}
