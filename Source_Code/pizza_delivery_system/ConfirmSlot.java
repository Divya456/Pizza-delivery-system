
package pizza_delivery_system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
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
import java.util.List;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ConfirmSlot extends JFrame {

    getFiveDates date = new getFiveDates();
    BookSlots slotScr;
    int head, time;

    //retieving the date selected
    public ConfirmSlot(getFiveDates date, int head, int i, BookSlots scrBtn) {
        this.date = date;
        this.head = head;
        slotScr = scrBtn;
        switch (i % 3) {
            case 0:
                time = 16;
                break;
            case 1:
                time = 18;
                break;
            case 2:
                time = 20;
                break;

        }

        //setting up the background image for the frame
        this.setContentPane(new JPanel() {
            ImageIcon img = new ImageIcon("bg5.jpg");
            Image image = img.getImage();
            Image newimg = image.getScaledInstance(400, 250, java.awt.Image.SCALE_SMOOTH);

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(newimg, 0, 0, 400, 250, this);

            }

        });
    }

    public void window() {
        ImageIcon img = new ImageIcon("icon.jpg");
        this.setIconImage(img.getImage());
        this.setLayout(new FlowLayout());
        this.setSize(400, 250);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        placeComponents();
        this.setResizable(false);
        this.setTitle("Confirm slot");
        this.setVisible(true);

    }

    public void close() {
        this.dispose();
    }

    public void placeComponents() {
        //declarations
        JLabel sure = new JLabel("Are you sure?");
        JLabel details = new JLabel("Here are your details");
        JLabel timeLabel = new JLabel("Time: " + time + ":00");
        JLabel dateLabel = new JLabel("Date: " + date.day + "/" + date.month + "/" + date.year);
        JLabel headCountLabel = new JLabel("Head count: " + this.head);
        final JButton ok = new JButton("Confirm");
        final JButton cancel = new JButton("Cancel");
        
        //Adding all the labels with slot details usinf box layout
        Box labelBox = Box.createVerticalBox();
        final long newBooking = (time * 1000000) + (date.day * 10000) + (date.month * 100) + (date.year % 100);

        //panel with confirm and cancel buttons
        JPanel confirmPanel = new JPanel();
        confirmPanel.setPreferredSize(new Dimension(400, 150));

        details.setAlignmentX(Component.CENTER_ALIGNMENT);
        details.setForeground(Color.WHITE);
        details.setOpaque(false);
        dateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setOpaque(false);
        timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setOpaque(false);
        headCountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        headCountLabel.setForeground(Color.WHITE);
        headCountLabel.setOpaque(false);
        sure.setAlignmentX(Component.CENTER_ALIGNMENT);
        sure.setForeground(Color.WHITE);
        sure.setOpaque(false);
        labelBox.add(details);
        labelBox.add(Box.createRigidArea(new Dimension(0, 20)));
        labelBox.add(dateLabel);
        labelBox.add(Box.createRigidArea(new Dimension(0, 5)));
        labelBox.add(timeLabel);
        labelBox.add(Box.createRigidArea(new Dimension(0, 5)));
        labelBox.add(headCountLabel);
        labelBox.add(Box.createRigidArea(new Dimension(0, 20)));
        labelBox.add(sure);
        confirmPanel.setOpaque(false);
        confirmPanel.add(labelBox);

        this.add(confirmPanel);
        this.add(ok);
        this.add(cancel);

        class ButtonListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == cancel) {
                    close();
                } else if (e.getSource() == ok) {
                    ArrayList<Long> booked = new ArrayList<>();

                    FileInputStream fis;
                    BufferedInputStream bis;
                    ObjectInputStream ois;

                    FileOutputStream fos;
                    BufferedOutputStream bos;
                    ObjectOutputStream oos;
                    long tempDate;

                    File path = new File(".");
                    List dateBooked = Arrays.asList(path.list());

                    //checking if booked slots file exists 
                    if (dateBooked.contains("BookedSlot.dat")) {
                        // read arraylist object from file

                        try {

                            fis = new FileInputStream("BookedSlot.dat");
                            bis = new BufferedInputStream(fis);
                            ois = new ObjectInputStream(bis);

                            //get the list of newBooking and append new newBooking details
                            booked = (ArrayList) ois.readObject();
                            booked.add(newBooking);

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

                        //creating output streams to store updated array list of newBookingomers
                        try {
                            fos = new FileOutputStream("BookedSlot.dat");
                            bos = new BufferedOutputStream(fos);
                            oos = new ObjectOutputStream(bos);

                            oos.writeObject(booked);

                            //closing all output streams
                            oos.close();
                            bos.close();
                            fos.close();

                        } catch (FileNotFoundException ex) {
                            System.out.println("File not found");
                        } catch (IOException ex) {
                            System.out.println("IOException");
                        }

                    } //if the slots booked list dat file does not exist 
                    else {
                        booked.add(newBooking);

                        //creating output streams to store updated array list of newBooking
                        try {
                            fos = new FileOutputStream("BookedSlot.dat");
                            bos = new BufferedOutputStream(fos);
                            oos = new ObjectOutputStream(bos);

                            oos.writeObject(booked);

                            //closing all output streams
                            oos.close();
                            bos.close();
                            fos.close();

                        } catch (FileNotFoundException ex) {
                            System.out.println("File not found");
                        } catch (IOException ex) {
                            System.out.println("IOException");
                        }

                        //checking if it has been updated correctly
                        try {
                            fis = new FileInputStream("BookedSlot.dat");
                            bis = new BufferedInputStream(fis);
                            ois = new ObjectInputStream(bis);
                            booked = (ArrayList) ois.readObject();

                            ois.close();
                            bis.close();
                            fis.close();

                        } catch (FileNotFoundException ex) {
                            System.out.println("File not found");
                        } catch (IOException | ClassNotFoundException ex) {
                            System.out.println("IOException or class not found");
                        }

                    }

                   
                    slotScr.dispose();
                    close();
                    Cake cakeMenu = new Cake();
                }
            }

        }
        ButtonListener cancelListener = new ButtonListener();
        cancel.addActionListener(cancelListener);
        ok.addActionListener(cancelListener);

    }

}
