
package pizza_delivery_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Finalmenu extends JFrame {

    //declarations
    private JLabel pizza, quantity, price, topps, toppscost;
    private JLabel j, q, p, z, f;
    public int totcostpizza = 0;
    int totcosttoppings = 0;
    JButton b = new JButton("Next");

    //button handler for the next button
    class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new summary(totcostpizza, totcosttoppings);
            setVisible(false);
        }

    }

    public int getToppscost() {
        return totcostpizza;
    }

    public void gui3(ArrayList<String> selpizza, ArrayList<Integer> qty, ArrayList<Integer> selprice, ArrayList<String> topselpizza, ArrayList<Integer> topcost, ArrayList<String> seltop) {
        ButtonHandler handle = new ButtonHandler();
        b.addActionListener(handle);
        int n = 60;
        Integer quant;

        //setting up the frame
        this.setTitle("PIZZA MANIACS");
        this.setSize(850, 550);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(new ImageIcon("pizza.png").getImage());

        //adding background image to the frame
        this.setContentPane(new JPanel() {
            ImageIcon img = new ImageIcon("backbill.jpg");
            Image image = img.getImage();
            Image newimg = image.getScaledInstance(850, 550, java.awt.Image.SCALE_SMOOTH);

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(newimg, 0, 0, 1200, 700, this);

            }
        });

        this.setLayout(null);

        //displaying the headings for the order using labels
        pizza = new JLabel("PIZZAS");
        pizza.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        pizza.setBounds(15, 60, 100, 30);
        add(pizza);

        quantity = new JLabel("QTY");
        quantity.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        quantity.setBounds(145, 60, 100, 30);
        add(quantity);

        price = new JLabel("PRICE");
        price.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        price.setBounds(240, 60, 100, 30);
        add(price);

        topps = new JLabel("Toppings cost");
        topps.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        topps.setBounds(330, 60, 100, 30);
        add(topps);

        toppscost = new JLabel("Toppings");
        toppscost.setFont(new Font("Monotype Corsiva", Font.BOLD, 18));
        toppscost.setBounds(450, 60, 100, 30);
        add(toppscost);

        //displaying the selected pizzas
        for (int i = 0; i < selpizza.size(); i++) {
            n += 30;
            j = new JLabel(selpizza.get(i));
            j.setBounds(15, n, 120, 20);
            this.add(j);

        }

        n = 60;

        //displaying quantity
        for (int k = 0; k < qty.size(); k++) {
            n += 30;
            q = new JLabel(qty.get(k).toString());
            q.setBounds(145, n, 100, 20);
            this.add(q);

        }

        n = 60;

        //displaying total cost
        for (int k = 0; k < selprice.size(); k++) {
            n += 30;
            totcostpizza += (selprice.get(k)) * (qty.get(k));
            Integer temp = totcostpizza;
            p = new JLabel(temp.toString());
            p.setBounds(240, n, 100, 20);
            this.add(p);

        }

        n = 90;

        //displaying toppings
        if (topselpizza == null) {
            for (int i = 0; i < selpizza.size(); i++) {
                f = new JLabel("--");
                f.setBounds(360, n + (i) * 30, 100, 20);

                z = new JLabel("--");
                z.setBounds(480, n + (i) * 30, 300, 20);

                this.add(z);
                this.add(f);

            }
        } else {
            for (int i = 0; i < topselpizza.size(); i++) {
                for (int j = 0; j < selpizza.size(); j++) {
                    if (topselpizza.get(i).equals(selpizza.get(j))) {
                        quant = qty.get(i) * topcost.get(i);

                        f = new JLabel(quant.toString());
                        f.setBounds(360, n + (j) * 30, 100, 20);

                        totcosttoppings += (int) quant;

                        z = new JLabel(seltop.get(i));
                        z.setBounds(480, n + (j) * 30, 650, 20);

                        this.add(z);
                        this.add(f);
                    }
                }
            }
        }

        System.out.println(totcostpizza + "  " + totcosttoppings);
        add(b);
        b.setBounds(400, 450, 100, 30);
        this.setVisible(true);

    }

}
