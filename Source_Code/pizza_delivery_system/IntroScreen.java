
package pizza_delivery_system;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class JavaApplication3_ProjectIntro {

    public static void main(String[] args) {
        IntroScreen is = new IntroScreen();
        is.window();
    }

}

public class IntroScreen extends JFrame {

    //Declarations
    ArrayList<Customer> customerFile = new ArrayList<>();
    Customer customer = new Customer();
    JLabel member = new JLabel("Already a member?");
    JLabel numLabel = new JLabel("Enter registered phone Number");
    JTextField number = new JTextField("", 20);
    JButton register = new JButton("Not a member? Register now");
    JButton nextPizza = new JButton("Order your personal pizzas");
    JButton nextParty = new JButton("Book a party hall         ");
    JPanel intro = new JPanel();        // member(label)+numLabel(label)+number(TextField)
    JPanel buttonPanel = new JPanel();    // nextPizza(button)+nextParty(button)

    public void window() {

        //deleting previous booking details of party hall
        File path = new File(".");
        List filesList = Arrays.asList(path.list());

        //if the booking details file already exists
        if (filesList.contains("bookingDetails.txt")) {
            File file = new File("bookingDetails.txt");
            file.delete();
        }

        //setting frame attributes  
        this.setLayout(new FlowLayout());
        this.setSize(650, 400);
        this.setContentPane(new JPanel() {
            ImageIcon img = new ImageIcon("bg7.jpg");
            Image image = img.getImage();
            Image newimg = image.getScaledInstance(650, 400, java.awt.Image.SCALE_SMOOTH);

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(newimg, 0, 0, 650, 400, this);

            }

        });
        ImageIcon img = new ImageIcon("icon.jpg");
        this.setIconImage(img.getImage());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUp();
        this.setTitle("Pizza Maniacs welcomes you!");
        this.setResizable(false);
        this.setVisible(true);
    }

    //function to close current frame
    public void close() {
        this.dispose();
    }

    void setUp() {

        //setting layouts and sizes for panels 
        intro.setLayout(new GridBagLayout());
        intro.setOpaque(false);
        intro.setPreferredSize(new Dimension(700, 130));
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.setPreferredSize(new Dimension(700, 120));
        GridBagConstraints introConstraints = new GridBagConstraints();

        //adding member label to intro panel
        introConstraints.gridx = 1;
        introConstraints.gridy = 2;
        introConstraints.insets = new Insets(20, 0, 5, 0);
        intro.add(member, introConstraints);

        //adding numLabel to intro panel
        introConstraints.gridx = 1;
        introConstraints.gridy = 4;
        introConstraints.insets = new Insets(8, 0, 5, 0);
        member.setForeground(java.awt.Color.WHITE);
        intro.add(numLabel, introConstraints);

        //add number text field
        introConstraints.gridx = 1;
        introConstraints.gridy = 6;
        introConstraints.insets = new Insets(8, 0, 5, 0);
        numLabel.setForeground(java.awt.Color.WHITE);
        intro.add(number, introConstraints);

        //adding buttons to button panel
        buttonPanel.add(nextPizza);

        buttonPanel.add(nextParty);

        //adding panels to the frame
        this.add(intro);
        this.add(buttonPanel);
        this.add(register);

        //common action listener class for all buttons
        class buttonListener implements ActionListener {

            long phNum;
            boolean phFlag = false;

            //obtaining input from Jcomponents and checking if valid
            public boolean storeDetails() {
                String phNoDetails = number.getText();
                if (phNoDetails.equals("")) {
                    JOptionPane.showMessageDialog(IntroScreen.this, "Phone number is a required field.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int noOfDigits = phNoDetails.length();
                        phNum = Long.parseLong(phNoDetails);
                        if (!(noOfDigits >= 8 && noOfDigits <= 11)) {
                            throw new NumberFormatException();
                        } else {
                            phFlag = true;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(IntroScreen.this, "Enter valid phone number with atleast 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                return phFlag;
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                //go to register frame
                if (e.getSource() == register) {
                    close();
                    Register reg = new Register();

                } else {

                    boolean check = storeDetails();

                    //read from file and check if number is valid
                    if (check) {

                        //declarations for input streams
                        FileInputStream fis;
                        BufferedInputStream bis;
                        ObjectInputStream ois;

                        File path = new File(".");
                        List filesList = Arrays.asList(path.list());

                        //check if the customer list file already exists
                        if (filesList.contains("Customer.dat")) {
                            boolean exists = false;

                            try {

                                fis = new FileInputStream("Customer.dat");
                                bis = new BufferedInputStream(fis);
                                ois = new ObjectInputStream(bis);

                                // read arraylist object from file
                                customerFile = (ArrayList) ois.readObject();

                                //check if number exists 
                                Iterator itr1 = customerFile.iterator();
                                while (itr1.hasNext()) {
                                    customer = (Customer) itr1.next();
                                    if (phNum == customer.getPhNo()) {
                                        exists = true;

                                        //saving current customer in a file
                                        //declarations for input streams
                                        FileInputStream fisCurr;
                                        BufferedInputStream bisCurr;
                                        ObjectInputStream oisCurr;
                                        //declarations for output streams
                                        FileOutputStream fosCurr;
                                        BufferedOutputStream bosCurr;
                                        ObjectOutputStream oosCurr;
                                        try {
                                            fosCurr = new FileOutputStream("currentCustomer.dat");
                                            bosCurr = new BufferedOutputStream(fosCurr);
                                            oosCurr = new ObjectOutputStream(bosCurr);

                                            oosCurr.writeObject(customer);

                                            //closing all output streams
                                            oosCurr.close();
                                            bosCurr.close();
                                            fosCurr.close();

                                        } catch (FileNotFoundException ex) {
                                            System.out.println("File not found. File does NOT exist");
                                        } catch (IOException ex) {
                                            System.out.println("IOException. File does NOT exist");
                                        }

                                        //checking if it has been updated correctly
                                        try {

                                            fisCurr = new FileInputStream("currentCustomer.dat");
                                            bisCurr = new BufferedInputStream(fisCurr);
                                            oisCurr = new ObjectInputStream(bisCurr);
                                            customer = (Customer) oisCurr.readObject();

                                            oisCurr.close();
                                            bisCurr.close();
                                            fisCurr.close();

                                        } catch (FileNotFoundException ex) {
                                            System.out.println("File not found ");
                                        } catch (IOException ex) {
                                            System.out.println("ioexception ");
                                        }

                                        if (e.getSource() == nextParty) {
                                            close();
                                            PartyPreIntro book = new PartyPreIntro();

                                        } else if (e.getSource() == nextPizza) {
                                            close();
                                            menup me = new menup();
                                            me.gui();
                                        }

                                        break;
                                    }
                                }

                                //closing all input streams
                                ois.close();
                                bis.close();
                                fis.close();

                                //if entered number does not exist in Customer list file
                                if (exists == false) {
                                    JOptionPane.showMessageDialog(IntroScreen.this, "The phone number entered does not exist in our database.\nRe-enter correct phone number or kindly register your self.", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                            } catch (FileNotFoundException ex) {
                                System.out.println("File not found");
                            } catch (IOException ex) {
                                System.out.println("IOException ");
                            } catch (ClassNotFoundException ex) {
                                System.out.println("Class not found");
                                ex.printStackTrace();
                            }
                        } //customer list file does not exist
                        else {
                            JOptionPane.showMessageDialog(IntroScreen.this, "The phone number entered does not exist in our database.\nRe-enter correct phone number or kindly register your self.", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }

                }
            }

        }

        buttonListener IntroListener = new buttonListener();
        register.addActionListener(IntroListener);
        nextParty.addActionListener(IntroListener);
        nextPizza.addActionListener(IntroListener);

    }
}
