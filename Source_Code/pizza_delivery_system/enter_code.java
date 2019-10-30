package pizza_delivery_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.EmptyBorder;

public class enter_code {

    //code for coupon code
    //declarations
    int i1, j1;
    JProgressBar pb;
    JButton b1;
    JButton loginButton;
    JFrame f = new JFrame();
    JTextArea area = new JTextArea(2, 10);

    enter_code(int i, int j) {
        i1 = i;
        j1 = j;

        //adding background image
        JLabel background = new JLabel(new ImageIcon("bg18.jpg"));
        f.add(background);

        //panel with the fields to enter coupon code
        JPanel p1 = new JPanel();
        background.add(p1);
        background.setLayout(new FlowLayout());
        JLabel spacer;
        JLabel o = new JLabel("Enter coupon code: ");
        o.setAlignmentX(Component.CENTER_ALIGNMENT);
        p1.add(o, BorderLayout.NORTH);
        p1.add(spacer = new JLabel(" "), "span, grow");

        area.setBounds(10, 30, 300, 300);
        area.setAlignmentX(Component.CENTER_ALIGNMENT);
        p1.add(area, BorderLayout.NORTH);
        p1.setOpaque(false);
        p1.add(spacer = new JLabel(" "), "span, grow");

        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        f.setTitle("Pizza Delivery Project");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setIconImage(new ImageIcon("piza.jpg").getImage());

        // valid only when coupon code is right
        b1 = new JButton("Submit");
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setBackground(Color.yellow);
        pb = new JProgressBar(1, 100);
        pb.setAlignmentX(Component.CENTER_ALIGNMENT);
        pb.setValue(0);
        pb.setStringPainted(true);
        pb.setForeground(Color.green);
        pb.setBackground(Color.white);
        b1.setBounds(20, 20, 80, 25);
        pb.setBounds(110, 20, 200, 25);
        p1.setBorder(new EmptyBorder(15, 15, 15, 15));
        ButtonHandler listener = new ButtonHandler();

        p1.add(b1);
        b1.addActionListener(listener);
        p1.add(spacer = new JLabel(" "), "span, grow");
        p1.add(pb);
        p1.add(spacer = new JLabel(" "), "span, grow");
        p1.add(spacer = new JLabel(" "), "span, grow");
        ImageIcon image = new ImageIcon("button_cancel.png");
        JButton loginButton = new JButton("Cancel", image);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        p1.add(loginButton);
        ButtonHandler2 listener2 = new ButtonHandler2();
        loginButton.addActionListener(listener2);

        //setting up the frame
        p1.add(spacer = new JLabel(" "), "span, grow");
        f.setSize(330, 300);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        callit();
    }

    void callit() {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - f.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - f.getHeight()) / 2);
        f.setLocation(x, y);
    }

    //button handler for 'check if coupon code exits' button
    class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int i = 0, j = 0;
            String printString = area.getText();
            try (BufferedReader br = new BufferedReader(new FileReader("coupon_code.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.equals(printString)) {
                        j = 1;
                    }
                }
            } catch (Exception f) {
                System.out.println(f);
            }
            if (e.getSource() == b1) {
                try {
                    while (i <= 100) {
                        Thread.sleep(50);
                        pb.paintImmediately(0, 0, 200, 25);
                        pb.setValue(i);
                        i++;
                    }
                } catch (Exception e1) {
                    System.out.print("Exception caught");
                }
            }
            int l = 1;
            String s = area.getText();
            if (s.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Coupon code is empty");
                l = 0;
            } else if (!s.matches("[a-zA-Z0-9]*")) {
                JOptionPane.showMessageDialog(null, "Please enter alphanumeric characters!");
                i = 0;
            }
            if (l == 0) {
                JOptionPane.showMessageDialog(null, "Please enter again!");
                f.setVisible(false);
                new enter_code(i1, j1);

            } else {
                if (j == 1) {
                    JOptionPane.showMessageDialog(null, "You have successfully got an discount Rs.200");
                    new payment();
                    f.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry, there is no such coupon code!Proceed to payment");
                    new payment();
                    f.setVisible(false);
                }
            }

        }
    }

    //button handler for cancel button
    class ButtonHandler2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Are you sure you want to cancel?");
            new summary(i1, j1);
            f.setVisible(false);
        }
    }

    public static void main(String arg[]) {
        //new enter_code();

    }
}
