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
import javax.swing.JProgressBar;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class online_payment {
//code for online payment

    JProgressBar pb;
    JButton b1;
    JButton loginButton;
    JFrame f = new JFrame();
    JLabel background = new JLabel(new ImageIcon("bg3.jpg"));
    JTextArea area = new JTextArea(2, 10);
    JTextArea area2 = new JTextArea(2, 10);
    JTextArea area1 = new JTextArea(2, 10);
    JTextArea area3 = new JTextArea(2, 10);

    online_payment() {
        f.add(background);
        f.setTitle("Pizza Delivery Project");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setIconImage(new ImageIcon("piza.jpg").getImage());
        background.setLayout(new FlowLayout());

        //panel with all fields for entering card details
        JPanel p1 = new JPanel();
        background.add(p1);
        JLabel spacer;
        JLabel o = new JLabel("Enter card no: ");
        o.setAlignmentX(Component.CENTER_ALIGNMENT);
        p1.add(o, BorderLayout.NORTH);

        p1.add(spacer = new JLabel(" "), "span, grow");
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setBounds(10, 30, 300, 300);

        p1.add(area, BorderLayout.NORTH);

        p1.add(spacer = new JLabel(" "), "span, grow");
        JLabel o1 = new JLabel("Enter name on card: ");
        o1.setAlignmentX(Component.CENTER_ALIGNMENT);
        p1.add(o1, BorderLayout.NORTH);
        String s1 = o.getText();

        p1.add(spacer = new JLabel(" "), "span, grow");
        JTextArea area1 = new JTextArea(2, 10);
        p1.add(area1, BorderLayout.NORTH);
        p1.add(spacer = new JLabel(" "), "span, grow");
        JLabel o2 = new JLabel("Enter expiry date: ");
        JSpinner dateSpin = new JSpinner(new SpinnerNumberModel(30, 1, 30, 1));
        JSpinner monthSpin = new JSpinner(new SpinnerNumberModel(12, 1, 12, 1));
        JSpinner yearSpin = new JSpinner(new SpinnerNumberModel(2015, 2015, 2020, 1));
        o2.setAlignmentX(Component.CENTER_ALIGNMENT);
        p1.add(o2, BorderLayout.NORTH);
        String s2 = o.getText();

        p1.add(spacer = new JLabel(" "), "span, grow");

        area.setBounds(10, 30, 300, 300);

        //panel for the spinners for the date
        JPanel datePanel = new JPanel();
        datePanel.add(dateSpin);
        datePanel.add(monthSpin);
        datePanel.add(yearSpin);
        datePanel.setOpaque(false);
        p1.add(datePanel);

        p1.add(spacer = new JLabel(" "), "span, grow");
        JLabel o3 = new JLabel("Enter CVV no: ");
        o3.setAlignmentX(Component.CENTER_ALIGNMENT);
        p1.add(o3, BorderLayout.NORTH);
        String s3 = o.getText();

        p1.add(spacer = new JLabel(" "), "span, grow");

        area.setBounds(10, 30, 300, 300);
        p1.add(area3, BorderLayout.NORTH);
        p1.add(spacer = new JLabel(" "), "span, grow");
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        p1.setBorder(new EmptyBorder(15, 15, 15, 15));
        b1 = new JButton("Submit");
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setBackground(Color.MAGENTA);
        b1.setForeground(Color.white);
        pb = new JProgressBar(1, 100);
        pb.setValue(0);
        pb.setStringPainted(true);
        pb.setForeground(Color.green);
        pb.setBackground(Color.white);
        b1.setBounds(20, 20, 80, 25);
        pb.setBounds(110, 20, 200, 25);

        ButtonHandler listener = new ButtonHandler();
        p1.add(b1);
        b1.addActionListener(listener);
        p1.add(spacer = new JLabel(" "), "span, grow");
        p1.add(pb);
        p1.setOpaque(false);
        p1.add(spacer = new JLabel(" "), "span, grow");
        p1.add(spacer = new JLabel(" "), "span, grow");

        ImageIcon image = new ImageIcon("button_cancel.png");
        JButton loginButton = new JButton("Cancel", image);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        p1.add(loginButton);

        ButtonHandler2 listener2 = new ButtonHandler2();
        loginButton.addActionListener(listener2);

        p1.add(spacer = new JLabel(" "), "span, grow");
        f.setBounds(450, 140, 450, 300);
        f.setSize(530, 550);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    //handler for pay button that checks if entered credentials are valid
    class ButtonHandler implements ActionListener {

        //code for progression bar
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = 0;
            if (e.getSource() == b1) {
                pb.setVisible(true);
                try {
                    while (i <= 100) {
                        Thread.sleep(50);
                        pb.paintImmediately(0, 0, 200, 25);
                        pb.setValue(i);
                        i++;
                    }
                    int l = 1;
                } catch (Exception e1) {
                    System.out.print("Caughted exception is =" + e1);
                }
                String s = area.getText();
                String s1 = area1.getText();
                String s2 = area2.getText();
                String s3 = area3.getText();
                //handling errors
                if (s.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Card no is empty", "Error", JOptionPane.ERROR_MESSAGE);
                    i = 0;
                } else if (!s.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "Invalid card number!", "Error", JOptionPane.ERROR_MESSAGE);
                    i = 0;
                }
                if (s1 == "") {
                    JOptionPane.showMessageDialog(null, "Name is a required field!", "Error", JOptionPane.ERROR_MESSAGE);
                    i = 0;
                } else if (!s1.matches("[a-zA-Z]*")) {
                    JOptionPane.showMessageDialog(null, "Enter valid name!", "Error", JOptionPane.ERROR_MESSAGE);
                    i = 0;
                }

                if (s3.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Cvv is a required field!", "Error", JOptionPane.ERROR_MESSAGE);
                    i = 0;
                } else if (!s3.matches("[0-9]+")) {
                    JOptionPane.showMessageDialog(null, "Enter valid Cvv", "Error", JOptionPane.ERROR_MESSAGE);
                    i = 0;
                }
                if (i == 0) {
                    JOptionPane.showMessageDialog(null, "Please enter again!", "Error", JOptionPane.ERROR_MESSAGE);
                    f.setVisible(false);
                    new online_payment();
                } else {
                    JOptionPane.showMessageDialog(null, "Your payment successfully is done");
                    new feedback();
                    f.setVisible(false);

                }
            }
        }
    }

    //handler for cancel button
    class ButtonHandler2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Are you sure you want to cancel?");
            new payment();
            f.setVisible(false);
        }
    }

    public static void main(String args[]) {
        new online_payment();
    }
}
