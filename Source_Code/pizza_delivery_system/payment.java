
package pizza_delivery_system;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class payment {

    JFrame f = new JFrame();
    JLabel background = new JLabel(new ImageIcon("red.jpg"));

    payment() {
        //code for choosing online payment or cash on delivary
        f.add(background);
        f.setTitle("Pizza Delivery Project");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setIconImage(new ImageIcon("piza.jpg").getImage());
        background.setLayout(new FlowLayout());
        JPanel p = new JPanel();
        JButton b1 = new JButton("Cash on delivery");
        ButtonHandler listener = new ButtonHandler();
        b1.addActionListener(listener);
        JButton b2 = new JButton("Online payment");
        ButtonHandler2 listener2 = new ButtonHandler2();
        b2.addActionListener(listener2);
        background.add(p);
        JLabel spacer;
        p.add(b1);
        p.add(spacer = new JLabel(" "), "span, grow");
        p.add(b2);
        p.setOpaque(false);
        p.add(spacer = new JLabel(" "), "span, grow");
        ImageIcon image = new ImageIcon("button_cancel.png");
        JButton loginButton = new JButton("cancel", image);
        p.add(loginButton);
        ButtonHandler3 listener3 = new ButtonHandler3();
        loginButton.addActionListener(listener3);
        p.setBorder(new EmptyBorder(15, 15, 15, 15));
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        f.setBounds(450, 200, 450, 300);
        f.setSize(400, 300);
        f.setVisible(true);
    }

    //hander for cash on delivery option button
    class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Are you sure?");
            new feedback();
            f.setVisible(false);
            f.dispose();
        }
    }

    //hander for online payment
    class ButtonHandler2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new online_payment();
            f.setVisible(false);
            f.dispose();
        }
    }

    //handler for cancel button
    class ButtonHandler3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Are you sure you want to cancel?");
            //new payment();
            f.setVisible(false);
        }
    }

    public static void main(String args[]) {
        new payment();
    }
}
