
package pizza_delivery_system;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class cakeConfirm extends JFrame {

    //declarations
    JPanel summary = new JPanel();
    JPanel confirm = new JPanel();
    FlowLayout flow = new FlowLayout(FlowLayout.CENTER); // Create a layout manager 
    JLabel sum = new JLabel("Order Summary");
    JButton next = new JButton("Confirm order");
    JButton cancel = new JButton("Cancel");
    ArrayList<CakeMenu> selList;
    Cake prevFrame;
    Integer total = 0;

    //retirving cake order details from array list passed to constructor
    public cakeConfirm(ArrayList<CakeMenu> selList, Cake prevFrame) {
        this.selList = selList;
        this.prevFrame = prevFrame;

        //setting background image
        this.setContentPane(new JPanel() {
            ImageIcon img = new ImageIcon("bg22.jpg");
            Image image = img.getImage();
            Image newimg = image.getScaledInstance(600, 400, java.awt.Image.SCALE_SMOOTH);

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(newimg, 0, 0, 900, 680, this);

            }

        });
        ImageIcon img = new ImageIcon("icon.jpg");
        this.setIconImage(img.getImage());
        setUp();
    }

    void setUp() {

        flow.setVgap(4);
        summary.setOpaque(false);
        summary.setLayout(flow);
        summary.setPreferredSize(new Dimension(600, 250));
        confirm.setPreferredSize(new Dimension(600, 150));
        int numCakes = selList.size();
        JLabel[] cakeLabels = new JLabel[4 * numCakes];
        JLabel[] heading = new JLabel[4];
        JLabel cost = new JLabel();
        String[] header = {"Item", "Quantity(kg)", "Cost(Rs)", "Price(Rs)"};

        //displaying the selected cakes witht their respective attributes
        for (int i = 0; i < header.length; i++) {
            heading[i] = new JLabel(header[i]);
            heading[i].setFont(new Font("Norasi", Font.BOLD, 18));
            if (i == 0) {
                heading[i].setPreferredSize(new Dimension(200, 20));
            } else {
                heading[i].setPreferredSize(new Dimension(110, 20));
            }
            summary.add(heading[i]);

        }

        //displaying cake name, weight and total cost 
        //by iterating over the arraylist of selected cakes
        for (CakeMenu c : selList) {

            total += c.getWeight() * c.getCost();
            for (int i = 0; i < 4; i++) {
                cakeLabels[i] = new JLabel();
                cakeLabels[i].setOpaque(false);
                cakeLabels[i].setFont(new Font("Norasi", Font.PLAIN, 16));
                if (i % 4 == 0) {

                    cakeLabels[i].setPreferredSize(new Dimension(230, 20));
                    cakeLabels[i].setText(c.getName());
                } else if (i % 4 == 1) {
                    cakeLabels[i].setPreferredSize(new Dimension(100, 20));
                    cakeLabels[i].setText(c.getWeight().toString());
                } else if (i % 4 == 2) {
                    cakeLabels[i].setPreferredSize(new Dimension(100, 20));
                    cakeLabels[i].setText(c.getCost().toString());
                } else if (i % 4 == 3) {
                    cakeLabels[i].setPreferredSize(new Dimension(100, 20));
                    cakeLabels[i].setText(c.getPrice().toString());

                }

                summary.add(cakeLabels[i]);
            }
        }

        //adding cancel and confirm buttons
        flow.setVgap(10);
        summary.setLayout(flow);
        cost.setOpaque(false);
        summary.add(cost);
        cost.setText("Total price: " + total.toString());
        confirm.setOpaque(false);
        confirm.setLayout(new GridBagLayout());
        GridBagConstraints confirmConstraints = new GridBagConstraints();
        confirmConstraints.gridx = 1;
        confirmConstraints.gridy = 10;
        confirmConstraints.insets = new Insets(5, 5, 5, 5);
        confirm.add(next, confirmConstraints);
        confirmConstraints.gridx = 5;
        confirm.add(cancel, confirmConstraints);

        ButtonHandler handle = new ButtonHandler();
        next.addActionListener(handle);
        cancel.addActionListener(handle);

        this.setLayout(new FlowLayout());
        this.setSize(600, 400);
        this.add(summary);
        this.add(confirm);
        this.setLocationRelativeTo(null);
        this.setTitle("Order Summary");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    void close() {
        this.dispose();
    }

    class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //if order is confirmed, writing the arraylist with selected cake objects to a file
            if (e.getSource() == next) {
                FileOutputStream fos;
                ObjectOutputStream oos;

                try {
                    fos = new FileOutputStream("cake.dat");
                    oos = new ObjectOutputStream(fos);
                    oos.writeObject(selList);
                    oos.close();
                    fos.close();

                    FileWriter fw = new FileWriter("bookingDetails.txt", true);
                    fw.write(total.toString());
                    fw.close();

                } catch (FileNotFoundException ex) {
                    System.out.println("File not found");
                } catch (IOException ex) {
                    System.out.println("IOException occurred");
                }

                close();
                prevFrame.dispose();
                menup me = new menup();
                me.gui();

                //if cancel order display cake menu again
            } else if (e.getSource() == cancel) {
                close();
            }
        }

    }

}
