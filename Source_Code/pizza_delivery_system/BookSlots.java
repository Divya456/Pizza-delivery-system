
package pizza_delivery_system;

import java.awt.Dimension;
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
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

//class with method that returns next five dates of a given date 
class getFiveDates {

    int day, month, year;

    public void getDates(getFiveDates[] dates, int day, int month, int year) {
        for (int i = 0; i < 5; i++) {
            switch (month) {
                case 2:
                    if (day == 28) {
                        day = 1;
                        month++;
                        dates[i].day = day;
                        dates[i].month = month;
                        dates[i].year = year;
                    } else {
                        day = day + 1;
                        dates[i].day = day;
                        dates[i].month = month;
                        dates[i].year = year;
                    }
                    break;
                case 1:

                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day >= 31) {
                        day = 1;
                        dates[i].day = day;
                        if (month == 12) {
                            month = 1;
                            dates[i].month = month;
                            year++;
                            dates[i].year = year;
                        } else {
                            dates[i].month = month;
                            dates[i].year = year;
                        }

                    } else {
                        day = day + 1;
                        dates[i].day = day;
                        dates[i].month = month;
                        dates[i].year = year;
                    }
                    break;
                default:
                    if (day >= 30) {
                        day = 1;
                        dates[i].day = day;
                        month = month + 1;
                        dates[i].month = month;
                        dates[i].year = year;
                    } else {
                        day = day + 1;
                        dates[i].day = day;
                        dates[i].month = month;
                        dates[i].year = year;
                    }

            }
        }
    }
}

public class BookSlots extends JFrame {

    public BookSlots getObj() {
        return this;
    }

    BookSlots() {

        this.setSize(650, 500);
        this.setContentPane(new JPanel() {
            ImageIcon img = new ImageIcon("bg11.jpg");
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
        this.setTitle("Select day and time");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setUp();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    void setUp() {

        //slotPanel : 5*3 grid of slots[] buttons + timeLabel[] 
        //countPanel : spinner + head label
        //datePanel : Vertically arrranged dateLabel[]
        //placePanel : comboBox for place selection
        JPanel slotPanel = new JPanel();
        slotPanel.setOpaque(false);
        JPanel countPanel = new JPanel();
        countPanel.setOpaque(false);
        JPanel placePanel = new JPanel();
        placePanel.setOpaque(false);
        JPanel datePanel = new JPanel();
        datePanel.setOpaque(false);
        JComboBox state;
        final JSpinner headSpin = new JSpinner(new SpinnerNumberModel(50, 50, 200, 50));
        final JButton[] slots = new JButton[15];
        JLabel head = new JLabel("Head count");
        JLabel[] dateLabel = new JLabel[5];
        JLabel[] timeLabel = new JLabel[3];
        JLabel slot = new JLabel("Slots", SwingConstants.CENTER);
        int j;

        class ListenForButton implements ActionListener {

            int i, j;
            getFiveDates d = new getFiveDates();
            getFiveDates[] date = new getFiveDates[5];
            int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
            int month = Calendar.getInstance().get(Calendar.MONTH);
            int year = Calendar.getInstance().get(Calendar.YEAR);

            void getDupDates() {
                for (int k = 0; k < 5; k++) {
                    date[k] = new getFiveDates();
                }

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                i = (Integer) ((JButton) e.getSource()).getClientProperty("index");
                BookSlots scrBtn = getObj();
                if (e.getSource() == slots[i]) {
                    j = ((3 - (i % 3) + i) / 3) - 1;
                    getDupDates();
                    d.getDates(date, day, month, year);
                    int headCount = (Integer) headSpin.getValue();
                    ConfirmSlot s = new ConfirmSlot(date[j], headCount, i, scrBtn);
                    s.window();
                }

            }

        }

        ListenForButton buttonListener = new ListenForButton();

        //setting layout and size of frame
        this.setLayout(new GridBagLayout());

        //adding comboBox for selecting place
        //ON placePanel
        String[] places = {"Bangalore", "Delhi", "Chennai", "Mumbai", "Kerala", "Hyderabad"};
        state = new JComboBox(places);
        state.setMaximumRowCount(3);
        placePanel.add(state);

        //adding date labels
        //ON datePanel
        Box dateBox = Box.createVerticalBox();
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        getFiveDates d = new getFiveDates();
        getFiveDates[] date = new getFiveDates[5];
        for (int i = 0; i < 5; i++) {
            date[i] = new getFiveDates();
        }
        //getting an array with next 5 from today with dates stored
        d.getDates(date, day, month, year);
        dateBox.add(new JLabel(" "));
        slot.setForeground(java.awt.Color.WHITE);
        dateBox.add(slot);
        dateBox.add(new JLabel(" "));
        for (int i = 0; i < 5; i++) {
            dateLabel[i] = new JLabel(date[i].day + "/" + date[i].month + "/" + date[i].year);
            dateLabel[i].setForeground(java.awt.Color.WHITE);
            dateBox.add(dateLabel[i]);
            dateBox.add(Box.createRigidArea(new Dimension(0, 15)));
        }
        datePanel.add(dateBox);

        //adding spinner and head count label
        //ON countPanel
        countPanel.setPreferredSize(new Dimension(700, 100));
        GridBagConstraints countConstraints = new GridBagConstraints();
        countConstraints.insets = new Insets(50, 5, 20, 5);
        countPanel.setLayout(new GridBagLayout());
        countConstraints.gridx = 1;
        countConstraints.gridy = 5;
        head.setPreferredSize(new Dimension(90, 20));
        head.setForeground(java.awt.Color.WHITE);
        countPanel.add(head, countConstraints);
        countConstraints.gridx = 4;
        countConstraints.gridy = 5;
        JFormattedTextField disableInput = ((JSpinner.DefaultEditor) headSpin.getEditor()).getTextField();
        disableInput.setEditable(false);
        countPanel.add(headSpin, countConstraints);

        //adding 5*3 grid of buttons for slots & time labels
        //ON slotPanel
        slotPanel.setPreferredSize(new Dimension(700, 300));
        slotPanel.setLayout(new GridBagLayout());
        GridBagConstraints slotConstraints = new GridBagConstraints();
        slotConstraints.gridx = 1;
        slotConstraints.gridy = 1;
        slotConstraints.insets = new Insets(5, 5, 5, 5);

        //adding time labels
        slotConstraints.gridy = 2;
        for (int i = 0; i < 3; i++) {
            timeLabel[i] = new JLabel(16 + (i * 2) + ":00", SwingConstants.CENTER);
            timeLabel[i].setPreferredSize(new Dimension(80, 20));
            timeLabel[i].setMinimumSize(new Dimension(80, 20));
            timeLabel[i].setMaximumSize(new Dimension(80, 20));
            slotConstraints.gridx = 1 + i * 4;
            timeLabel[i].setForeground(java.awt.Color.WHITE);
            slotPanel.add(timeLabel[i], slotConstraints);
        }

        slot.setPreferredSize(new Dimension(30, 20));
        slotConstraints.gridwidth = 1;
        slotConstraints.gridheight = 1;
        slotConstraints.insets = new Insets(5, 5, 5, 5);
        slotConstraints.fill = GridBagConstraints.BOTH;

        slotConstraints.gridy = 4;
        slotConstraints.gridx = 1;

        //opening file to check which slots are already booked
        File path = new File(".");
        List dateBooked = Arrays.asList(path.list());
        ArrayList<Long> booked = new ArrayList<>();

        FileInputStream fis;
        BufferedInputStream bis;
        ObjectInputStream ois;

        FileOutputStream fos;
        BufferedOutputStream bos;
        ObjectOutputStream oos;
        long tempDate;
        boolean fileExists = false;

        //reading the arraylist containg all slots booked from a file to colour the buttons accordingly
        if (dateBooked.contains("BookedSlot.dat")) {
            fileExists = true;
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
                System.out.println("IOException or Class not found");
            }
        }

        //adding slot buttons
        for (j = 0; j < 15; j++) {
            int k = ((3 - (j % 3) + j) / 3) - 1;
            long currentSlot = ((16 + (2 * (j % 3))) * 1000000) + (date[k].day * 10000) + (date[k].month * 100) + (date[k].year % 100);
            boolean flag = false;
            slots[j] = new JButton("  ");
            slots[j].putClientProperty("index", j);
            slots[j].addActionListener(buttonListener);

            Iterator itr = booked.iterator();
            while (itr.hasNext() && fileExists == true) {
                tempDate = (long) itr.next();
                if (tempDate == currentSlot) {
                    flag = true;
                }
            }

            if (flag) {
                slots[j].setBackground(java.awt.Color.DARK_GRAY);
                slots[j].setToolTipText("Not Available");
                slots[j].setEnabled(false);
            } else {
                slots[j].setBackground(java.awt.Color.LIGHT_GRAY);
                slots[j].setToolTipText("Available");
                slots[j].setText("Book");
            }

            slots[j].setPreferredSize(new Dimension(80, 20));
            slots[j].setMinimumSize(new Dimension(80, 20));
            slots[j].setMaximumSize(new Dimension(80, 20));
            slotConstraints.gridx = 1 + ((j % 3) * 4);

            if (j % 3 == 0) {
                slotConstraints.gridy = slotConstraints.gridy + 1;
            }
            slotPanel.add(slots[j], slotConstraints);
        }

        //for aliging all panels using GridBag layout
        GridBagConstraints slotPanelConstraints = new GridBagConstraints();
        GridBagConstraints countPanelConstraints = new GridBagConstraints();
        GridBagConstraints placePanelConstraints = new GridBagConstraints();
        GridBagConstraints datePanelConstraints = new GridBagConstraints();

        //setting location of countPanel
        countPanelConstraints.anchor = GridBagConstraints.NORTH;
        countPanelConstraints.gridx = 5;
        countPanelConstraints.gridy = 10;
        this.add(countPanel, countPanelConstraints);

        //setting location of placePanel
        placePanelConstraints.gridx = 5;
        placePanelConstraints.gridy = 0;
        this.add(placePanel, placePanelConstraints);

        //setting location of slotPanel
        slotPanelConstraints.gridx = 5;
        slotPanelConstraints.gridy = 20;
        slotPanelConstraints.insets = new Insets(5, 0, 5, 5);
        this.add(slotPanel, slotPanelConstraints);

        //setting location of datePanel
        datePanelConstraints.gridx = 1;
        datePanelConstraints.gridy = 20;
        this.add(datePanel, datePanelConstraints);

    }
}
