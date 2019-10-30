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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Address implements Serializable {

    private String city, addr;
    private long pin;

    long getPin() {
        return pin;
    }

    String getCity() {
        return city;
    }

    public String getAddress() {
        return addr;
    }

    void setPin(long pin) {
        this.pin = pin;
    }

    void setCity(String city) {
        this.city = city;
    }

    void setAddress(String addr) {
        this.addr = addr;
    }
}

//class for customer
//used aggregation for associating address to the customer
class Customer implements Serializable {

    private String name;
    long phoneNum;
    Address a = new Address();

    public String getName() {
        return name;
    }

    public long getPhNo() {
        return phoneNum;
    }

    void setName(String name) {
        this.name = name;
    }

    void setPhNo(long phoneNum) {
        this.phoneNum = phoneNum;
    }
}

public class Register extends JFrame {

    public static void main(String[] args) {
        new Register();
    }

    Register() {

        File path = new File(".");
        List filesList = Arrays.asList(path.list());

        //if the booking details file already exists
        if (filesList.contains("bookingDetails.txt")) {
            System.out.println("in delete");
            File file = new File("bookingDetails.txt");
            file.delete();
        }

        //setting frame attributes 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(new JPanel() {
            ImageIcon img = new ImageIcon("bg1.jpg");
            Image image = img.getImage();
            Image newimg = image.getScaledInstance(700, 500, java.awt.Image.SCALE_SMOOTH);

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(newimg, 0, 0, 700, 500, this);
            }
        });
        ImageIcon img = new ImageIcon("icon.jpg");
        this.setIconImage(img.getImage());
        this.setUp();
    }

    //Declarations 
    ArrayList<Customer> custFile = new ArrayList<>();
    Customer cust = new Customer();
    JLabel name = new JLabel("Name : ");
    JLabel phoneNo = new JLabel("Phone No. : ");
    JLabel address = new JLabel("Address: ");
    JLabel city = new JLabel("City: ");
    JLabel pincode = new JLabel("Pin Code: ");
    JTextField enterName = new JTextField("", 20);
    JTextField enterPhNo = new JTextField("", 20);
    JTextField enterAddress = new JTextField("", 20);
    JTextField enterPin = new JTextField("", 10);
    JPanel infoPanel = new JPanel();    //name(Label)+enterName(TextField)+phNo(Label)+enterPhNo(Label)
    JPanel placePanel = new JPanel();   //state comboBox
    JPanel nextPanel = new JPanel();    //nextPizza(button) + nextParty(button)
    JButton nextPizza = new JButton("Order your personal pizzas"); //move to pizza frame
    JButton nextParty = new JButton("Book a party hall         "); //move to book party hall frame
    JComboBox state;

    //methos to close current frame
    public void close() {
        this.dispose();

    }

    void setUp() {

        this.setLayout(new FlowLayout());
        this.setSize(700, 500);

        //adding name label to infoPanel
        GridBagConstraints infoPanelConstraints = new GridBagConstraints();
        GridBagConstraints placePanelConstraints = new GridBagConstraints();
        placePanel.setLayout(new GridBagLayout());
        infoPanel.setLayout(new GridBagLayout());
        infoPanel.setOpaque(false);
        infoPanel.setPreferredSize(new Dimension(700, 150));
        infoPanelConstraints.gridx = 0;
        infoPanelConstraints.gridy = 500;
        infoPanel.add(name, infoPanelConstraints);

        //adding enterName textField to infoPanel
        infoPanelConstraints.gridx = 5;
        infoPanelConstraints.gridy = 500;
        infoPanel.add(enterName, infoPanelConstraints);

        //adding phoneNo label to infoPanel
        infoPanelConstraints.gridx = 0;
        infoPanelConstraints.gridy = 700;
        infoPanelConstraints.insets = new Insets(10, 0, 60, 5);
        infoPanel.add(phoneNo, infoPanelConstraints);

        //adding phoneNoName textField to infoPanel
        infoPanelConstraints.gridx = 5;
        infoPanelConstraints.gridy = 700;
        infoPanelConstraints.insets = new Insets(10, 0, 60, 0);
        infoPanel.add(enterPhNo, infoPanelConstraints);

        //adding address label to infoPanel
        infoPanelConstraints.gridx = 0;
        infoPanelConstraints.gridy = 700;
        infoPanelConstraints.insets = new Insets(10, 0, 5, 5);
        infoPanel.add(address, infoPanelConstraints);

        //adding enterAddress textField to infoPanel
        infoPanelConstraints.gridx = 5;
        infoPanelConstraints.gridy = 700;
        infoPanelConstraints.insets = new Insets(10, 0, 0, 0);
        infoPanel.add(enterAddress, infoPanelConstraints);

        //adding states comboBox to placePanel
        placePanel.setPreferredSize(new Dimension(700, 210));
        placePanel.setOpaque(false);
        String[] places = {"Bangalore", "Delhi", "Chennai", "Mumbai", "Kerala", "Hyderabad"};
        state = new JComboBox(places);
        state.setMaximumRowCount(3);

        //adding city label to infoPanel
        placePanelConstraints.gridx = 0;
        placePanelConstraints.gridy = 2;
        placePanelConstraints.insets = new Insets(0, 0, 45, 5);
        placePanel.add(city, placePanelConstraints);

        placePanelConstraints.gridx = 5;
        placePanelConstraints.gridy = 2;
        placePanelConstraints.insets = new Insets(0, 0, 45, 5);
        placePanel.add(state, placePanelConstraints);

        //adding address pincodelabel to infoPanel
        placePanelConstraints.gridx = 0;
        placePanelConstraints.gridy = 7;
        placePanelConstraints.insets = new Insets(10, 0, 5, 5);
        placePanel.add(pincode, placePanelConstraints);

        //adding enterPin textField to infoPanel
        placePanelConstraints.gridx = 5;
        placePanelConstraints.gridy = 7;
        placePanelConstraints.insets = new Insets(10, 0, 0, 0);
        placePanel.add(enterPin, placePanelConstraints);

        //adding nextPizza button and nextParty buttons to nextPanel
        Box nextBox = Box.createHorizontalBox();
        nextBox.add(nextPizza);
        nextBox.add(Box.createRigidArea(new Dimension(24, 0)));
        nextBox.add(nextParty);
        nextPanel.setOpaque(false);
        nextPanel.add(nextBox);

        //adding panels to frame
        this.add(infoPanel);
        this.add(placePanel);
        this.add(nextPanel);

        //setting frame attributes
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Registration");
        this.setVisible(true);

        // action listener for buttons 
        class buttonListener implements ActionListener {

            boolean addFlag = false, pinFlag = false, nameFlag = false, phFlag = false;

            public boolean storeDetails() {

                String addressDetails = enterAddress.getText();
                String nameDetails = enterName.getText();
                String phNoDetails = enterPhNo.getText();
                String pinDetails = enterPin.getText();
                String cityDetails = (String) state.getSelectedItem();
                long phNum, pinNum;

                cust.a.setCity(cityDetails);
                //address
                if (addressDetails.equals("")) {
                    JOptionPane.showMessageDialog(Register.this, "Address is a required field.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {

                    if (!(addressDetails.length() >= 10)) {
                        JOptionPane.showMessageDialog(Register.this, "Address is too short.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        addFlag = true;
                        cust.a.setAddress(addressDetails);
                    }

                }

                //pin
                if (pinDetails.equals("")) {
                    JOptionPane.showMessageDialog(Register.this, "PinCode is a required field.", "Error", JOptionPane.ERROR_MESSAGE);

                } else {
                    try {
                        int noOfDigits = pinDetails.length();
                        pinNum = Long.parseLong(pinDetails);
                        if (!(noOfDigits == 6 || noOfDigits == 7)) {
                            throw new NumberFormatException();
                        } else {
                            pinFlag = true;

                            cust.a.setPin(pinNum);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(Register.this, "Enter valid pin number", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                //phone number
                if (phNoDetails.equals("")) {
                    JOptionPane.showMessageDialog(Register.this, "Phone number is a required field.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int noOfDigits = phNoDetails.length();
                        phNum = Long.parseLong(phNoDetails);
                        if (!(noOfDigits >= 8 && noOfDigits <= 11)) {
                            throw new NumberFormatException();
                        } else {
                            phFlag = true;
                            cust.setPhNo(phNum);
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(Register.this, "Enter valid phone number with atleast 8 digits", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

                //name
                if (nameDetails.equals("")) {
                    JOptionPane.showMessageDialog(Register.this, "Name is a required field.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {

                        char[] chars = nameDetails.toCharArray();

                        for (char c : chars) {
                            if (!Character.isLetter(c)) {
                                throw new Exception();
                            }
                        }
                        nameFlag = true;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(Register.this, "Enter a valid name.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    cust.setName(nameDetails);

                }
                return (addFlag && pinFlag && phFlag && nameFlag);
            }

            @Override
            public void actionPerformed(ActionEvent e) {

                //go to party hall booking frame 
                if (true) {

                    boolean check = storeDetails();
                    if (check) {

                        //declarations for input streams
                        FileInputStream fis;
                        BufferedInputStream bis;
                        ObjectInputStream ois;

                        //declarations for output streams
                        FileOutputStream fos;
                        BufferedOutputStream bos;
                        ObjectOutputStream oos;

                        File path = new File(".");
                        List filesList = Arrays.asList(path.list());

                        //if the customer list file already exists
                        if (filesList.contains("Customer.dat")) {
                            // read arraylist object from file

                            try {

                                fis = new FileInputStream("Customer.dat");
                                bis = new BufferedInputStream(fis);
                                ois = new ObjectInputStream(bis);

                                //get the list of customers and append new customers details
                                custFile = (ArrayList) ois.readObject();
                                custFile.add(cust);

                                //closing all input streams
                                ois.close();
                                bis.close();
                                fis.close();
                            } catch (FileNotFoundException ex) {
                                System.out.println("File not found");
                            } catch (IOException ex) {
                                System.out.println("IOException");
                            } catch (ClassNotFoundException ex) {
                                System.out.println("Class not found");
                            }

                            //creating output streams to store updated array list of customers
                            try {
                                fos = new FileOutputStream("Customer.dat");
                                bos = new BufferedOutputStream(fos);
                                oos = new ObjectOutputStream(bos);

                                oos.writeObject(custFile);

                                //closing all output streams
                                oos.close();
                                bos.close();
                                fos.close();

                                fos = new FileOutputStream("currentCustomer.dat");
                                bos = new BufferedOutputStream(fos);
                                oos = new ObjectOutputStream(bos);

                                oos.writeObject(cust);

                                //closing all output streams
                                oos.close();
                                bos.close();
                                fos.close();

                            } catch (FileNotFoundException ex) {
                                System.out.println("File not found");
                            } catch (IOException ex) {
                                System.out.println("IOException");
                            }

                        } //if the customer list dat file does not exist 
                        else {
                            custFile.add(cust);

                            //creating output streams
                            try {
                                fos = new FileOutputStream("Customer.dat");
                                bos = new BufferedOutputStream(fos);
                                oos = new ObjectOutputStream(bos);

                                oos.writeObject(custFile);

                                //closing all output streams
                                oos.close();
                                bos.close();
                                fos.close();

                            } catch (FileNotFoundException ex) {
                                System.out.println("File not found");
                            } catch (IOException ex) {
                                System.out.println("IOException");
                            }

                        }

                        if (e.getSource() == nextParty) {
                            close();
                            PartyPreIntro preIntro = new PartyPreIntro();
                        } else {
                            close();
                            menup pizza = new menup();
                            pizza.gui();
                        }
                    }

                }
            }

        }

        buttonListener IntroListener = new buttonListener();
        nextParty.addActionListener(IntroListener);
        nextPizza.addActionListener(IntroListener);

    }
}
