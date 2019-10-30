package pizza_delivery_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
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
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

//code for feedback
public class feedback {

    JFrame f = new JFrame();
    JTextArea area = new JTextArea(5, 10);
    JLabel background = new JLabel(new ImageIcon("bg25.jpg"));

    feedback() {
        f.add(background);
        f.setTitle("Pizza Delivery Project");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setIconImage(new ImageIcon("piza.jpg").getImage());
        background.setLayout(new FlowLayout());
        
        //panel with field for entering feedback
        JPanel p1 = new JPanel();
        background.add(p1);
        JLabel spacer;
        JLabel o = new JLabel("Enter your valuable feedback: ");
        o.setForeground(Color.WHITE);
        p1.add(o, BorderLayout.NORTH);
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p1.add(spacer = new JLabel(" "), "span, grow");
        p1.setOpaque(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        o.setAlignmentX(Component.CENTER_ALIGNMENT);
        area.setBounds(10, 30, 300, 300);
        p1.add(area, BorderLayout.NORTH);
        p1.add(spacer = new JLabel(" "), "span, grow");
        JButton b1 = new JButton("Submit");
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setBackground(Color.yellow);
        ButtonHandler2 listener = new ButtonHandler2();
        p1.add(b1);
        b1.addActionListener(listener);
        p1.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        //setting the frame attributes
        f.setBounds(450, 170, 450, 300);
        f.setSize(530, 350);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    //button hander for submit button
    class ButtonHandler2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String s = area.getText();
            if (s.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter feedback");
                new feedback();

            } else {
                JOptionPane.showMessageDialog(null, "Thank for ordering through pizza maniacs!\n Your order will be delivered within 30 minutes!\n Contact 90908080 in case of any queries.");
            }
            f.setVisible(false);
        }
    }

    public static void main(String args[]) {
        new feedback();
    }
}
