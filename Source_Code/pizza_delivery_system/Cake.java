package pizza_delivery_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.border.Border;

//class cake that has all the attributes associates with a cake
class CakeMenu implements Serializable {

    private String name;
    private int cost;
    private int price;
    private int weight;

    CakeMenu() {
    }

    CakeMenu(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    void setPrice(int weight) {
        this.weight = weight;
        price = (cost) * weight;
    }

    Integer getPrice() {
        return price;
    }

    Integer getWeight() {
        return weight;
    }

    String getName() {
        return name;
    }

    Integer getCost() {
        return cost;
    }
}

public class Cake extends JFrame {

    Cake() {

        this.setContentPane(new JPanel() {
            ImageIcon img = new ImageIcon("bg2.jpg");
            Image image = img.getImage();
            Image newimg = image.getScaledInstance(900, 680, java.awt.Image.SCALE_SMOOTH);

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(newimg, 0, 0, 900, 680, this);

            }

        });
        ImageIcon img = new ImageIcon("icon.jpg");
        this.setIconImage(img.getImage());
        this.window();
    }

    //Declarations
    JLabel[] weightLabel = new JLabel[6];
    JPanel[] panel = new JPanel[6];
    JPanel[] radioPanel = new JPanel[6];
    JLabel[] sliderLabel = new JLabel[6];
    CakeMenu[] menu = new CakeMenu[6];
    JButton next = new JButton("Cake order summary");
    String[] imageNames = {"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg"};
    String[] cakeNames = {"Nutty Gateaux Cake", "Silky Truffle Cake", "Ferrero Rocher Delight", "Summer Paradise", "Espresso Strawberry Mousse", "Hawaiian Pineapple Cake"};
    int[] cost = {150, 200, 320, 170, 340, 240};
    ImageIcon img, finalCakeImg;
    Image image, scaledCakeImg;
    JRadioButton[] select = new JRadioButton[6];
    JRadioButton[] cancel = new JRadioButton[6];
    ButtonGroup[] addDel = new ButtonGroup[6];
    JSpinner[] weightSpin = new JSpinner[6];
    JLabel[] textLabel = new JLabel[6];
    JLabel[] imgLabel = new JLabel[6];
    JLabel[] priceLabel = new JLabel[6];
    radioListener listenToRadio = new radioListener();
    ArrayList<CakeMenu> selectedCakes = new ArrayList<CakeMenu>();

    int i;

    //obtaining current frame object
    Cake getFrameObj() {
        return this;
    }

    public void window() {
        this.setTitle("Cake Menu");
        this.setLayout(new FlowLayout());
        this.setSize(900, 680);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        placeComponents();
        this.setResizable(false);
        this.setVisible(true);
    }

    public void placeComponents() {

        for (i = 0; i < 6; i++) {

            menu[i] = new CakeMenu(cakeNames[i], cost[i]);
            panel[i] = new JPanel();
            priceLabel[i] = new JLabel("Price: Rs." + menu[i].getCost());
            weightSpin[i] = new JSpinner(new SpinnerNumberModel(0, 0, 5, 1));
            weightLabel[i] = new JLabel("Select weight in kg");
            Border raisedbevel = BorderFactory.createRaisedBevelBorder();
            panel[i].setBorder(raisedbevel);
            radioPanel[i] = new JPanel();
            textLabel[i] = new JLabel(menu[i].getName());
            textLabel[i].setOpaque(false);

            addDel[i] = new ButtonGroup();
            sliderLabel[i] = new JLabel();

            panel[i].setLayout(new FlowLayout(FlowLayout.CENTER, 5, 3));
            panel[i].setPreferredSize(new Dimension(260, 300));

            //setting up the radio buttons
            select[i] = new JRadioButton("Select");
            select[i].putClientProperty("index", i);
            select[i].addActionListener(listenToRadio);
            cancel[i] = new JRadioButton("Cancel");
            cancel[i].putClientProperty("index", i);
            cancel[i].addActionListener(listenToRadio);
            select[i].setOpaque(false);
            cancel[i].setOpaque(false);
            addDel[i].add(select[i]);
            addDel[i].add(cancel[i]);
            radioPanel[i].setLayout(new FlowLayout());
            radioPanel[i].setOpaque(false);
            radioPanel[i].add(select[i]);
            radioPanel[i].add(cancel[i]);
            cancel[i].setSelected(true);

            //image labels
            img = new ImageIcon(imageNames[i]);
            image = img.getImage();
            scaledCakeImg = image.getScaledInstance(220, 180, java.awt.Image.SCALE_SMOOTH);
            finalCakeImg = new ImageIcon(scaledCakeImg);
            imgLabel[i] = new JLabel(finalCakeImg);
            imgLabel[i].setPreferredSize(new Dimension(220, 180));

            JFormattedTextField disableInput = ((JSpinner.DefaultEditor) weightSpin[i].getEditor()).getTextField();
            disableInput.setEditable(false);

            //adding components to the panel
            panel[i].add(textLabel[i]);
            panel[i].add(imgLabel[i]);
            priceLabel[i].setPreferredSize(new Dimension(260, 20));
            priceLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
            panel[i].add(priceLabel[i]);
            panel[i].add(weightLabel[i]);
            panel[i].add(weightSpin[i]);
            panel[i].add(radioPanel[i]);
            this.add(panel[i]);
        }
        next.addActionListener(listenToRadio);
        this.add(next);
    }

    class radioListener implements ActionListener {

        int j;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JRadioButton) {
                j = (Integer) ((JRadioButton) e.getSource()).getClientProperty("index");

                int weight = (Integer) weightSpin[j].getValue();

                //adding a cake object corresponding to the one selected
                if (e.getSource() == select[j]) {
                    if (weight == 0) {
                        JOptionPane.showMessageDialog(Cake.this, "The weight cannot be zero!", "Error", JOptionPane.ERROR_MESSAGE);
                        cancel[j].setSelected(true);
                    } else {
                        menu[j].setPrice(weight);
                        selectedCakes.add(menu[j]);
                    }

                } //if cancel selected, respective cake removed from the arrayList
                else if (e.getSource() == cancel[j]) {

                    if (selectedCakes.contains(menu[j])) {
                        selectedCakes.remove(menu[j]);
                    }

                }

                //handling the next button
            } else {

                if (e.getSource() == next) {

                    if (selectedCakes.size() == 0) {
                        JOptionPane.showMessageDialog(Cake.this, "No cake selected!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        cakeConfirm confirmGUI = new cakeConfirm(selectedCakes, getFrameObj());
                    }
                }
            }
        }

    }

}
