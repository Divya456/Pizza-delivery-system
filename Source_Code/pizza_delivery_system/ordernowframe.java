
package pizza_delivery_system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ordernowframe extends JFrame {

    private JLabel msg;
    private JButton bill, topps;

    ArrayList<String> topselpizza = new ArrayList<>();
    ArrayList<Integer> topselprice = new ArrayList<>();
    ArrayList<Integer> qty = new ArrayList<>();

    public void gui2(ArrayList<String> selpizza, ArrayList<Integer> selqty, ArrayList<Integer> selprice) {
        //Setting attributes for the frame like Size,Title,Location,Icon,Background etc.
        this.setSize(330, 200);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.ORANGE);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(225, 204, 153));
        this.getContentPane().setForeground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //Creating a JLabel and setting its Bounds
        msg = new JLabel("Do you want more Toppings \r\n Select NO for Billing!");
        msg.setBounds(20, 50, 310, 15);
        //Creating two Jbuttons ->bill and topps
        bill = new JButton("NO");
        bill.setBounds(190, 120, 60, 20);
        //Adding ActionListener for bill button which is linked to billing section
        bill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeframe().setVisible(false);
                Finalmenu men = new Finalmenu();
                men.gui3(topselpizza, qty, topselprice, null, null, null);
            }
        });

        topps = new JButton("YES");
        topps.setBounds(70, 120, 60, 20);
        //Adding ActionListener for topps button which is linked to Toppings Frame
        topps.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeframe().setVisible(false);
                extras n = new extras();
                n.setup(topselpizza, qty, topselprice);

            }
        });

        add(msg);
        add(bill);
        add(topps);

        //The passed lists of pizzas, quantity and prices are saved to the class instance variables.
        topselpizza = (ArrayList<String>) selpizza.clone();
        topselprice = (ArrayList<Integer>) selprice.clone();
        qty = (ArrayList<Integer>) selqty.clone();

        this.setVisible(true);
    }

    public ordernowframe closeframe() {

        return this;

    }

    public static void main(String args[]) {
        ordernowframe n = new ordernowframe();
        //n.gui2();
    }

}
