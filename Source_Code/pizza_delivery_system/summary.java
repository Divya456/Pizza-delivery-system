package pizza_delivery_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class summary {
//code for full display of customer

    final JFrame f = new JFrame();
    int i, j;
    JButton pizza = new JButton("pizza summary");
    JButton party = new JButton("party summary");
    Customer c2 = new Customer();
    String s = "";
    Long s2 = (long) 0;
    String s3 = "";
    int costParty = 0;

    summary(int costpizza, int costtoppings) {

        //declarations
        CakeMenu c = new CakeMenu();
        i = costpizza;
        j = costtoppings;
        int tot = c.getPrice();
        JPanel p = new JPanel();
        JLabel t1 = new JLabel("   Pizza & toppings total cost(Rs): " + (costpizza + costtoppings));
        read();
        JLabel o = new JLabel("   Phone no: " + s2);
        JLabel n = new JLabel("   Name: " + s);
        JLabel a = new JLabel("   Address: " + s3);
        JLabel t2 = new JLabel("   Cakes and party hall total cost(Rs): " + costParty);

        JLabel t = new JLabel("   Total " + (costpizza + costtoppings + costParty));
        JLabel background = new JLabel(new ImageIcon("bg26.jpg"));
        o.setForeground(Color.white);
        n.setForeground(Color.white);
        a.setForeground(Color.white);
        t2.setForeground(Color.white);
        t1.setForeground(Color.white);
        t.setForeground(Color.white);
        f.add(background);
        background.setLayout(new GridLayout(5, 1));
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(o);
        p.add(n);
        p.add(a);
        p.add(t1);
        p.add(t2);
        p.add(t);
        p.setOpaque(false);

        //code for the summary title
        JLabel m_title = new JLabel("   SUMMARY");
        m_title.setFont(new Font("TimesRoman", Font.BOLD, 24));
        m_title.setForeground(Color.white);
        background.add(m_title, BorderLayout.NORTH);
        p.setPreferredSize(new Dimension(500, 300));
        p.setOpaque(false);
        background.add(p, BorderLayout.CENTER);
        f.setTitle("Pizza Delivery Project");
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setIconImage(new ImageIcon("piza.jpg").getImage());

        //panel for the buttons
        JPanel bottombtnPnl = new JPanel();
        bottombtnPnl.setPreferredSize(new Dimension(500, 100));
        ImageIcon image = new ImageIcon("coupon_save_icon.jpg");
        JButton couponButton = new JButton("Coupon Code", image);

        ButtonHandler listener = new ButtonHandler();
        couponButton.addActionListener(listener);
        JButton btnPrint = new JButton("Payment");
        ButtonHandler2 listener2 = new ButtonHandler2();
        btnPrint.addActionListener(listener2);
        bottombtnPnl.add(btnPrint);
        bottombtnPnl.setOpaque(false);
        bottombtnPnl.add(couponButton);
        background.add(bottombtnPnl);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setBounds(450, 100, 450, 300);
        f.setSize(500, 400);
        f.setVisible(true);

    }

    //handler for coupon code
    class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new enter_code(i, j);
            f.setVisible(false);
            f.dispose();
        }
    }

    //handler for pay button
    class ButtonHandler2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Are you sure you want to proceed?");
            new payment();
            f.setVisible(false);
            f.dispose();
        }
    }

    void read() {
        //retrieving customer details from file
        try {
            FileInputStream fis = new FileInputStream("currentCustomer.dat");
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);

            c2 = (Customer) ois.readObject();
            s = c2.getName();
            s2 = c2.getPhNo();
            s3 = c2.a.getAddress();

            ois.close();
            bis.close();
            fis.close();

            FileReader fr = new FileReader("bookingDetails.txt");
            BufferedReader bir = new BufferedReader(fr);
            String temp;
            while ((temp = (String) bir.readLine()) != null) {
                System.out.println("party " + temp);
                costParty = Integer.parseInt(temp);
                costParty += 500;
            }

            bir.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");
        } catch (IOException ex) {
            System.out.println("IOException!");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException!");
        }

    }

}

class sum {

    public static void main(String[] args) {

          // new summary();
    }

}
