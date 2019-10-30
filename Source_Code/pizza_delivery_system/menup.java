
package pizza_delivery_system;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Sneha Jhaveri
 */
public class menup extends JFrame {

    // public JFrame f;

    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17;
    private JCheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24;
    private JSpinner s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24;
    private JButton b1, b2, b3;
    private JPanel panel1;
    private JCheckBox[] c;
    private JSpinner[] s;
    ArrayList<String> allpizza = new ArrayList<String>(Arrays.asList("Margherita-s", "Margherita-m", "Margherita-l", "Country-s", "Country-m", "Country-l", "farmhouse-s", "farmhouse-m", "farmhouse-l", "triptang-s", "triptang-m", "triptang-l", "peppy-paneer-s", "peppy-paneer-m", "peppy-paneer-l", "vegpara-s", "vegpara-m", "vegpara-l", "romanveg-s", "romanveg-m", "romanveg-l", "milan-s", "milan-m", "milan-l"));
    ArrayList<String> selpizza = new ArrayList<String>();

    ArrayList<Integer> allprice = new ArrayList<Integer>(Arrays.asList(180, 210, 250, 180, 210, 250, 200, 250, 300, 220, 270, 310, 220, 270, 310, 210, 260, 300, 240, 300, 360, 250, 310, 380));
    ArrayList<Integer> selprice = new ArrayList<Integer>();

    ArrayList<Integer> qty = new ArrayList<Integer>();

    public void gui() {

        //Setting attributes for the frame like Size,Title,Location,Icon,Background etc.
        this.setTitle("PIZZA MANIACS");
        this.setSize(1200, 700);
        this.getContentPane().setBackground(Color.BLACK);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("pizza.png").getImage());

        this.setContentPane(new JPanel() {
            ImageIcon img = new ImageIcon("red.jpg");
            Image image = img.getImage();
            Image newimg = image.getScaledInstance(1200, 700, java.awt.Image.SCALE_SMOOTH);

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(newimg, 0, 0, 1200, 700, this);

            }
        });

        //we set layout of the frame as null
        this.setLayout(null);
        l2 = new JLabel("        Small            Medium            Large    ");
        l2.setBounds(440, 30, 350, 40);
        l2.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        l2.setForeground(Color.WHITE);

        //Creates object ImageIcon and set the path of the image as the parameter
        ImageIcon icon = new ImageIcon("rsz_pureveg.png");
        //assigning the attributes of JLabel to l1
        l1 = new JLabel("SIMPLY VEG", icon, JLabel.LEFT);
        //changing font and foreground color
        l1.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
        l1.setForeground(Color.WHITE);
        //setting the location of the labels
        l1.setBounds(20, 50, 300, 20);

        l3 = new JLabel("Margherita");
        l3.setFont(new Font("Monotype Corsiva", Font.ITALIC | Font.BOLD, 20));
        l3.setBounds(40, 90, 250, 20);
        l3.setForeground(Color.WHITE);

        l4 = new JLabel("Country Veg");
        l4.setFont(new Font("Monotype Corsiva", Font.ITALIC | Font.BOLD, 20));
        l4.setBounds(40, 140, 250, 20);
        l4.setForeground(Color.WHITE);

        l5 = new JLabel("VEG TREAT", icon, JLabel.LEFT);
        l5.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
        l5.setForeground(Color.WHITE);
        l5.setBounds(20, 190, 300, 20);

        l6 = new JLabel("Farmhouse");
        l6.setFont(new Font("Monotype Corsiva", Font.ITALIC | Font.BOLD, 20));
        l6.setBounds(40, 240, 250, 20);
        l6.setForeground(Color.WHITE);

        l7 = new JLabel("Spicy Triple Tango");
        l7.setFont(new Font("Monotype Corsiva", Font.ITALIC | Font.BOLD, 20));
        l7.setForeground(Color.WHITE);
        l7.setBounds(40, 290, 250, 20);

        l8 = new JLabel("VEG SPECIAL", icon, JLabel.LEFT);
        l8.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
        l8.setBounds(20, 340, 300, 20);
        l8.setForeground(Color.WHITE);

        l9 = new JLabel("Peppy Paneer");
        l9.setFont(new Font("Monotype Corsiva", Font.ITALIC | Font.BOLD, 20));
        l9.setBounds(40, 390, 250, 20);
        l9.setForeground(Color.WHITE);

        l10 = new JLabel("Veggie Paradise");
        l10.setFont(new Font("Monotype Corsiva", Font.ITALIC | Font.BOLD, 20));
        l10.setBounds(40, 440, 250, 20);
        l10.setForeground(Color.WHITE);

        l11 = new JLabel("EXOTIC ITALIAN VEG", icon, JLabel.LEFT);
        l11.setFont(new Font("Monotype Corsiva", Font.BOLD, 24));
        l11.setForeground(Color.WHITE);
        l11.setBounds(20, 490, 525, 20);

        l12 = new JLabel("Roman Veg Supreme");
        l12.setFont(new Font("Monotype Corsiva", Font.ITALIC | Font.BOLD, 20));
        l12.setBounds(40, 540, 350, 20);
        l12.setForeground(Color.WHITE);

        l13 = new JLabel("Milan Veg Fantasy");
        l13.setForeground(Color.WHITE);
        l13.setFont(new Font("Monotype Corsiva", Font.ITALIC | Font.BOLD, 20));
        l13.setBounds(40, 590, 350, 20);

         //setting attributes like Font,Background,Color,Size  to the JCheckBoxes
        //Every JCheckBox has the price of the pizza
        c1 = new JCheckBox("Rs180");
        c1.setBounds(480, 80, 70, 20);
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(204, 0, 0));

        c2 = new JCheckBox("Rs210");
        c2.setBounds(580, 80, 70, 20);
        c2.setBackground(new Color(204, 0, 0));
        c2.setForeground(Color.WHITE);

        c3 = new JCheckBox("Rs250");
        c3.setBounds(680, 80, 70, 20);
        c3.setBackground(new Color(204, 0, 0));
        c3.setForeground(Color.WHITE);
         //JSpinner has the quantity of every pizza
        //We assign the min ans max value of te JSpinner and set its bounds also
        s1 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s1.setBounds(480, 110, 60, 15);
        s1.setToolTipText("Enter your pizza quantity here");

        s2 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s2.setBounds(580, 110, 60, 15);
        s3 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s3.setBounds(680, 110, 60, 15);

        c4 = new JCheckBox("Rs180");
        c4.setForeground(Color.WHITE);
        c4.setBounds(480, 130, 70, 20);
        c4.setBackground(new Color(204, 0, 0));

        c5 = new JCheckBox("Rs210");
        c5.setBounds(580, 130, 70, 20);
        c5.setForeground(Color.WHITE);
        c5.setBackground(new Color(204, 0, 0));

        c6 = new JCheckBox("Rs250");
        c6.setForeground(Color.WHITE);
        c6.setBounds(680, 130, 70, 20);
        c6.setBackground(new Color(204, 0, 0));

        s4 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s4.setBounds(480, 160, 60, 15);
        s5 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s5.setBounds(580, 160, 60, 15);
        s6 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s6.setBounds(680, 160, 60, 15);

        c7 = new JCheckBox("Rs200");
        c7.setForeground(Color.WHITE);
        c7.setBounds(480, 230, 70, 20);
        c7.setBackground(new Color(204, 0, 0));

        c8 = new JCheckBox("Rs250");
        c8.setForeground(Color.WHITE);
        c8.setBounds(580, 230, 70, 20);
        c8.setBackground(new Color(204, 0, 0));

        c9 = new JCheckBox("Rs300");
        c9.setForeground(Color.WHITE);
        c9.setBounds(680, 230, 70, 20);
        c9.setBackground(new Color(204, 0, 0));

        s7 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s7.setBounds(480, 260, 60, 15);
        s8 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s8.setBounds(580, 260, 60, 15);
        s9 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s9.setBounds(680, 260, 60, 15);

        c10 = new JCheckBox("Rs220");
        c10.setForeground(Color.WHITE);
        c10.setBounds(480, 280, 70, 20);
        c10.setBackground(new Color(204, 0, 0));

        c11 = new JCheckBox("Rs270");
        c11.setBounds(580, 280, 70, 20);
        c11.setForeground(Color.WHITE);
        c11.setBackground(new Color(204, 0, 0));

        c12 = new JCheckBox("Rs310");
        c12.setForeground(Color.WHITE);
        c12.setBounds(680, 280, 70, 20);
        c12.setBackground(new Color(204, 0, 0));

        s10 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s10.setBounds(480, 310, 60, 15);
        s11 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s11.setBounds(580, 310, 60, 15);
        s12 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s12.setBounds(680, 310, 60, 15);

        c13 = new JCheckBox("Rs220");
        c13.setForeground(Color.WHITE);
        c13.setBounds(480, 380, 70, 20);
        c13.setBackground(new Color(204, 0, 0));

        c14 = new JCheckBox("Rs270");
        c14.setForeground(Color.WHITE);
        c14.setBounds(580, 380, 70, 20);
        c14.setBackground(new Color(204, 0, 0));

        c15 = new JCheckBox("Rs310");
        c15.setBounds(680, 380, 70, 20);
        c15.setForeground(Color.WHITE);
        c15.setBackground(new Color(204, 0, 0));

        s13 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s13.setBounds(480, 410, 60, 15);
        s14 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s14.setBounds(580, 410, 60, 15);
        s15 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s15.setBounds(680, 410, 60, 15);

        c16 = new JCheckBox("Rs210");
        c16.setBounds(480, 430, 70, 20);
        c16.setForeground(Color.WHITE);
        c16.setBackground(new Color(204, 0, 0));

        c17 = new JCheckBox("Rs260");
        c17.setForeground(Color.WHITE);
        c17.setBounds(580, 430, 70, 20);
        c17.setBackground(new Color(204, 0, 0));

        c18 = new JCheckBox("Rs300");
        c18.setForeground(Color.WHITE);
        c18.setBounds(680, 430, 70, 20);
        c18.setBackground(new Color(204, 0, 0));

        s16 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s16.setBounds(480, 460, 60, 15);
        s17 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s17.setBounds(580, 460, 60, 15);
        s18 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s18.setBounds(680, 460, 60, 15);

        c19 = new JCheckBox("Rs240");
        c19.setBounds(480, 510, 70, 20);
        c19.setForeground(Color.WHITE);
        c19.setBackground(new Color(204, 0, 0));

        c20 = new JCheckBox("Rs300");
        c20.setBounds(580, 510, 70, 20);
        c20.setForeground(Color.WHITE);
        c20.setBackground(new Color(204, 0, 0));

        c21 = new JCheckBox("Rs360");
        c21.setForeground(Color.WHITE);
        c21.setBounds(680, 510, 70, 20);
        c21.setBackground(new Color(204, 0, 0));

        s19 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s19.setBounds(480, 540, 60, 15);

        s20 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s20.setBounds(580, 540, 60, 15);

        s21 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s21.setBounds(680, 540, 60, 15);

        c22 = new JCheckBox("Rs250");
        c22.setForeground(Color.WHITE);
        c22.setBackground(new Color(204, 0, 0));
        c22.setBounds(480, 560, 70, 20);

        c23 = new JCheckBox("Rs310");
        c23.setForeground(Color.WHITE);
        c23.setBackground(new Color(204, 0, 0));
        c23.setBounds(580, 560, 70, 20);

        c24 = new JCheckBox("Rs380");
        c24.setForeground(Color.WHITE);
        c24.setBounds(680, 560, 70, 20);
        c24.setBackground(new Color(204, 0, 0));

        s22 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s22.setBounds(480, 590, 60, 15);
        s23 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s23.setBounds(580, 590, 60, 15);
        s24 = new JSpinner(new SpinnerNumberModel(1, 1, 200, 1));
        s24.setBounds(680, 590, 60, 15);

        ImageIcon icono = new ImageIcon("rsz_nonvegdot.jpg");
        //This JButton takes the customer to Non veg menu
        b2 = new JButton(" NONVEG ", icono);
        //setting attributes for te Jbutton
        b2.setBounds(450, 625, 150, 35);
        b2.setFont(new Font("Monotype Corsiva", Font.BOLD, 16));
        b2.setBackground(new Color(225, 204, 153));
        b2.addActionListener(new btnlisten());

        //This JButton takes the customer to billing section/ToppingsFrame
        b3 = new JButton("ORDER NOW");
        b3.setBounds(650, 625, 150, 35);
        b3.setFont(new Font("Monotype Corsiva", Font.BOLD, 16));
        b3.setBackground(new Color(225, 204, 153));
        b3.addActionListener(new btnlisten());

        ImageIcon icon2 = new ImageIcon("pizza3.jpg");
        l14 = new JLabel(icon2);
        l14.setBounds(990, 470, 200, 200);
        ImageIcon icon3 = new ImageIcon("pizza1.jpg");
        l15 = new JLabel(icon3);
        l15.setBounds(990, 270, 200, 200);
        ImageIcon icon4 = new ImageIcon("pizza6.jpg");
        l16 = new JLabel(icon4);
        l16.setBounds(990, 80, 200, 200);
        ImageIcon icon5 = new ImageIcon("rsz_pizza8.jpg");
        l17 = new JLabel(icon5);
        l17.setBounds(990, 0, 200, 80);

        //Adding all te components to the JFrame
        add(l2);
        add(l1);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);
        add(l9);
        add(l10);
        add(l11);
        add(l12);
        add(l13);
        add(c1);
        add(c2);
        add(c3);
        add(s1);
        add(s2);
        add(s3);
        add(c4);
        add(c5);
        add(c6);
        add(s4);
        add(s5);
        add(s6);
        add(c7);
        add(c8);
        add(c9);
        add(s7);
        add(s8);
        add(s9);
        add(c10);
        add(c11);
        add(c12);
        add(s10);
        add(s11);
        add(s12);
        add(c13);
        add(c14);
        add(c15);
        add(s13);
        add(s14);
        add(s15);
        add(c16);
        add(c17);
        add(c18);
        add(s16);
        add(s17);
        add(s18);
        add(c19);
        add(c20);
        add(c21);
        add(s19);
        add(s20);
        add(s21);
        add(c22);
        add(c23);
        add(c24);
        add(s22);
        add(s23);
        add(s24);
        add(b2);
        add(l14);
        add(l15);
        add(l16);
        add(l17);
        add(b3);
        //Here we create a JCheckBox and a JSpinner array
        c = new JCheckBox[]{c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24};
        s = new JSpinner[]{s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24};

        for (JSpinner item : s) {
            JFormattedTextField disableInput = ((JSpinner.DefaultEditor) item.getEditor()).getTextField();
            disableInput.setEditable(false);
        }
        this.setVisible(true);
    }

    public menup closeframe() {

        return this;

    }

//Action Listener for b1
    private class btnlisten implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                for (int i = 0; i < c.length; i++) {
                    //Checking for all checkboxes which are selected
                    if (c[i].isSelected()) {
                        //adding selected pizza to selpizza
                        if (selpizza == null || selpizza.isEmpty()) {
                            //System.out.println("List is empty will add data now");
                            selpizza.add((String) allpizza.get(i));
                        } else {
                            //System.out.println("No its not empty");
                            selpizza.add((String) allpizza.get(i));
                        }
                        //adding price of selected pizza to selprice
                        if (selprice == null || selprice.isEmpty()) {
                            selprice.add((Integer) allprice.get(i));
                        } else {
                            selprice.add((Integer) allprice.get(i));
                        }
                        //add quantity of selected pizza to arraylist
                        if (qty == null || qty.isEmpty()) {
                            qty.add((Integer) s[i].getValue());
                        } else {
                            qty.add((Integer) s[i].getValue());

                        }
                    }
                }

            } //catch block in case of Exceptions
            catch (NullPointerException npe) {
                System.out.println("error");
                npe.printStackTrace();
            }

            /*for(int k=0;k<selpizza.size();k++)
             {
             System.out.println(selpizza.get(k));
             System.out.println(selprice.get(k));
             System.out.println(qty.get(k));

             }*/
            if (e.getSource() == b3) {
                if (selpizza.isEmpty()) {
                    JOptionPane.showMessageDialog(closeframe(), "Select atleast one pizza!");
                } else {

                    closeframe().setVisible(false);
                    ordernowframe order = new ordernowframe();
                    order.gui2(selpizza, qty, selprice);
                }
            }
            if (e.getSource() == b2) {
                closeframe().setVisible(false);
                menunonveg non = new menunonveg();
                non.gui(selpizza, qty, selprice);
            }
        }

    }

    public static void main(String[] args) {
        menup me = new menup();

        me.gui();

    }

}
