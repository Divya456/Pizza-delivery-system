/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza_delivery_system;

/**
 *
 * @author SIRI
 */
//import Pizza_delivary_system.Finalmenu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class extras extends JFrame {

    private JLabel v, v1, v2, v3, v4, v5, v6, v7, c, c1, c2, c3, c4, c5;
    private JCheckBox jv1, jv2, jv3, jv4, jv5, jv6, jv7, jc1, jc2, jc3, jc4, jc5;
    private JLabel i1, i2, i3, i5, i4, selectedpiz;
    private JButton b, b1;
    private JList list;
    private DefaultListModel dl;

    private JCheckBox[] ch;
    private JLabel[] top;

    ArrayList<Integer> topcost = new ArrayList<Integer>();
    ArrayList<String> seltop = new ArrayList<String>();
    ArrayList<String> selpizzatop = new ArrayList<String>();

    ArrayList<Integer> cost = new ArrayList<Integer>();
    ArrayList<Integer> quantity = new ArrayList<Integer>();
    ArrayList<String> pizzas = new ArrayList<String>();

    //Passing arraylists from veg menu frame to this JFrame
    public void setup(ArrayList<String> selpizza, ArrayList<Integer> qty, ArrayList<Integer> selprice) {
        //Setting attributes for the frame like Size,Title,Location,Icon,Background etc.
        this.setTitle("Extras");
        this.setSize(1200, 700);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setContentPane(new JPanel() {
            ImageIcon img = new ImageIcon("red.jpg");
            Image image = img.getImage();
            Image newimg = image.getScaledInstance(1200, 750, java.awt.Image.SCALE_SMOOTH);

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(newimg, 0, 0, 1200, 750, this);

            }
        });

        this.setLayout(null);

        ImageIcon ic = new ImageIcon("rsz_nonvegdot.jpg");
        ImageIcon ic1 = new ImageIcon("rsz_pureveg.png");
        //Setting text,Font,Foreground color and bounds for all the JLabels
        v = new JLabel("VEG", ic1, JLabel.LEFT);
        v.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
        v.setForeground(Color.white);
        v.setBounds(80, 40, 250, 30);

        v1 = new JLabel("Oregano");
        v1.setForeground(Color.white);
        v1.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        v1.setBounds(81, 80, 250, 20);

        //setting attributes like Font,Background,Color,Size  to the JCheckBoxes
        //Every JCheckBox has the price of the topping
        jv1 = new JCheckBox("Rs 20");
        jv1.setBackground(Color.GRAY);
        jv1.setBounds(250, 80, 60, 20);

        v2 = new JLabel("Extra cheese");
        v2.setForeground(Color.white);
        v2.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        v2.setBounds(81, 110, 250, 15);

        jv2 = new JCheckBox("Rs 20");
        jv2.setBackground(Color.GRAY);
        jv2.setBounds(250, 110, 60, 20);

        v3 = new JLabel("Mushrooms");
        v3.setForeground(Color.white);
        v3.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        v3.setBounds(81, 140, 250, 15);

        jv3 = new JCheckBox("Rs 20");
        jv3.setBackground(Color.GRAY);
        jv3.setBounds(250, 140, 60, 20);

        v4 = new JLabel("Black olives");
        v4.setForeground(Color.white);
        v4.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        v4.setBounds(81, 170, 250, 15);

        jv4 = new JCheckBox("Rs 20");
        jv4.setBackground(Color.GRAY);
        jv4.setBounds(250, 170, 60, 20);

        v5 = new JLabel("Green peppers");
        v5.setForeground(Color.white);
        v5.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        v5.setBounds(81, 200, 250, 15);

        jv5 = new JCheckBox("Rs 20");
        jv5.setBackground(Color.GRAY);
        jv5.setBounds(250, 200, 60, 20);

        v6 = new JLabel("Chillis");
        v6.setForeground(Color.white);
        v6.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        v6.setBounds(81, 230, 250, 15);

        jv6 = new JCheckBox("Rs 20");
        jv6.setBackground(Color.GRAY);
        jv6.setBounds(250, 230, 60, 20);

        v7 = new JLabel("Jalapenos");
        v7.setForeground(Color.white);
        v7.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        v7.setBounds(81, 260, 250, 15);

        jv7 = new JCheckBox("Rs 20");
        jv7.setBackground(Color.GRAY);
        jv7.setBounds(250, 260, 60, 20);

        c = new JLabel("NON-VEG", ic, JLabel.LEFT);
        c.setForeground(Color.white);
        c.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
        c.setBounds(600, 40, 250, 30);

        c1 = new JLabel("Barbeque chicken");
        c1.setForeground(Color.white);
        c1.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        c1.setBounds(600, 80, 250, 20);

        jc1 = new JCheckBox("Rs 50");
        jc1.setBackground(Color.GRAY);
        jc1.setBounds(800, 80, 60, 20);

        c2 = new JLabel("Hot n Spicy chicken");
        c2.setForeground(Color.white);
        c2.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        c2.setBounds(600, 110, 250, 15);

        jc2 = new JCheckBox("Rs 50");
        jc2.setBackground(Color.GRAY);
        jc2.setBounds(800, 110, 60, 20);

        c3 = new JLabel("Chunky chicken");
        c3.setForeground(Color.white);
        c3.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        c3.setBounds(600, 140, 250, 15);

        jc3 = new JCheckBox("Rs 50");
        jc3.setBackground(Color.GRAY);
        jc3.setBounds(800, 140, 60, 20);

        c4 = new JLabel("Pepperoni");
        c4.setForeground(Color.white);
        c4.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        c4.setBounds(600, 170, 250, 15);

        jc4 = new JCheckBox("Rs 50");
        jc4.setBackground(Color.GRAY);
        jc4.setBounds(800, 170, 60, 20);

        c5 = new JLabel("sausage");
        c5.setForeground(Color.white);
        c5.setFont(new Font("Monotype Corsiva", Font.ITALIC, 20));
        c5.setBounds(600, 200, 250, 15);

        jc5 = new JCheckBox("Rs 50");
        jc5.setBackground(Color.GRAY);
        jc5.setBounds(800, 200, 60, 20);
        //Creates object ImageIcon and set the path of the image as the parameter
        ImageIcon p = new ImageIcon("download.jpg");
        i1 = new JLabel(p);
        i1.setBounds(900, 0, 300, 170);

        ImageIcon p1 = new ImageIcon("download (1).jpg");
        i2 = new JLabel(p1);
        i2.setBounds(900, 170, 300, 190);

        ImageIcon p3 = new ImageIcon("rsz_mush.jpg");
        i3 = new JLabel(p3);
        i3.setBounds(910, 345, 300, 180);

        ImageIcon p4 = new ImageIcon("rsz_prp.jpg");
        i4 = new JLabel(p4);
        i4.setBounds(910, 481, 300, 210);

        //This JButton is to save the toppings the customer has selected
        b = new JButton("DONE");
        //Setting attributes like Font,Background color,Bounds for JButton
        b.setFont(new Font("Monotype Corsiva", Font.BOLD, 16));
        b.setBackground(new Color(225, 204, 153));
        b.setBounds(400, 600, 150, 30);
        //Adding Action listener for button b
        b.addActionListener(new doneaction());

        //This JButton takes the customer to billing section
        b1 = new JButton("SUMMARY");
        b1.setFont(new Font("Monotype Corsiva", Font.BOLD, 16));
        b1.setBackground(new Color(225, 204, 153));
        b1.setBounds(600, 600, 150, 30);
        b1.addActionListener(new orderaction());

        ImageIcon icon5 = new ImageIcon("info.png");
        //This Button is a help Button
        JButton help = new JButton(icon5);
        help.setToolTipText("Instructions to how to order");
        //adding action listener for help button
        help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(retobj(), "Select one pizza at a time and choose all toppings \n  for that pizza and then click Done!! ");

            }
        });

        help.setBounds(250, 330, 35, 28);

        //We add all components to the JFrame
        add(b1);
        add(b);
        add(i1);
        add(i2);
        add(i3);
        add(i4);
        add(v);
        add(c);
        add(v1);
        add(jc1);
        add(v2);
        add(v3);
        add(v4);
        add(v5);
        add(v6);
        add(v7);
        add(c1);
        add(c2);
        add(c3);
        add(c4);
        add(c5);
        add(jv1);
        add(jv2);
        add(jv3);
        add(jv4);
        add(jv5);
        add(jv6);
        add(jv7);
        add(jc1);
        add(jc2);
        add(jc3);
        add(jc4);
        add(jc5);
        add(help);
        ch = new JCheckBox[]{jv1, jv2, jv3, jv4, jv5, jv6, jv7, jc1, jc2, jc3, jc4, jc5};
        top = new JLabel[]{v1, v2, v3, v4, v5, v6, v7, c1, c2, c3, c4, c5};

        selectedpiz = new JLabel("The Selected pizzas are-");
        selectedpiz.setFont(new Font("Monotype Corsiva", Font.ITALIC | Font.BOLD, 16));
        selectedpiz.setBounds(81, 310, 180, 15);
        selectedpiz.setForeground(Color.WHITE);
        add(selectedpiz);

        JPanel jp = new JPanel();
        //Creating a new default list model
        dl = new DefaultListModel();
        //adding elements one by one to the list model
        for (int z = 0; z < selpizza.size(); z++) {
            dl.addElement(selpizza.get(z));
        }

        list = new JList(dl);
        list.setFont(new Font("Monotype Corsiva", Font.ITALIC, 16));
        list.setPreferredSize(new Dimension(150, 240));
        //list.setOpaque(false);
        jp.add(list);
        //Setting JList Sellection model and row count
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(3);
        //adding new JScrollPane to the JList
        JScrollPane scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jp.setBounds(81, 330, 165, 83);
        //jp.setBorder(BorderFactory.createLineBorder(Color.black));
        jp.setOpaque(false);
        //adding scrllpane to the panel
        jp.add(scroll);
        this.add(jp);

        pizzas = (ArrayList<String>) selpizza.clone();
        cost = (ArrayList<Integer>) selprice.clone();
        quantity = (ArrayList<Integer>) qty.clone();
        this.setResizable(false);
        this.setVisible(true);
    }

    public extras retobj() {
        return this;
    }

    public extras inst() {
        return this;
    }

    private class doneaction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            //JOptionPane opt = JOptionPane.showMessageDialog(null, "Have you selected all the toppings you want for the pizza?");
            try {
                if (list.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(retobj(), "Select pizza then toppings ");
                } else {
                    selpizzatop.add((String) list.getSelectedValue());
                    int k = list.getSelectedIndex();

                    int cost = 0;
                    StringBuffer st = new StringBuffer();

                    for (int i = 0; i < ch.length; i++) {
                        if (ch[i].isSelected()) {
                            st.append(top[i].getText() + " ");

                            if (i >= 0 && i <= 6) {
                                cost += 20;
                            } else {
                                cost += 50;
                            }

                            ch[i].setSelected(false);
                        }
                    }
                    topcost.add(cost);
                    seltop.add(st.toString());
                    dl.remove(k);
                }
            } catch (ArrayIndexOutOfBoundsException err) {
                System.out.println("error");
            }
        }
    }

    private class orderaction implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            /*for(int l=0;l<selpizzatop.size();l++)
             {
             System.out.println(selpizzatop.get(l));
             System.out.println(seltop.get(l));
             System.out.println(topcost.get(l));
           
             }*/

            closeframe();
            Finalmenu men = new Finalmenu();
            men.gui3(pizzas, quantity, cost, selpizzatop, topcost, seltop);
        }
    }

    public void closeframe() {

        this.setVisible(false);

    }

    public static void main(String args[]) {
        extras e = new extras();

        ArrayList<String> string = new ArrayList<String>();

        e.setup(string, null, null);

    }

}
