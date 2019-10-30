package pizza_delivery_system;

//import Pizza_delivary_system.BookSlots;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PartyPreIntro extends JFrame {

    PartyPreIntro() {
        
        //setting up background image for frame
        this.setContentPane(new JPanel() {
            ImageIcon img = new ImageIcon("bg21.jpg");
            Image image = img.getImage();
            Image newimg = image.getScaledInstance(700, 450, java.awt.Image.SCALE_SMOOTH);

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(newimg, 0, 0, 700, 450, this);
            }
        });
        ImageIcon img = new ImageIcon("icon.jpg");
        this.setIconImage(img.getImage());
        this.setUp();
    }

    //method to close current frame
    public void close() {
        this.dispose();
    }

    void setUp() {

        //Declarations
        JLabel celeb = new JLabel("Celebrating a special occassion?");
        JLabel celeb1 = new JLabel("Look no more. We've got everything you need!");
        final JButton proceed = new JButton("Proceed to booking the hall");
        JButton cancel = new JButton("Not interested. Order pizza instead!");
        JPanel panel = new JPanel();
        Box labelBox = Box.createVerticalBox();

        //adding buttons using boxLayout
        celeb.setAlignmentX(Component.CENTER_ALIGNMENT);
        celeb.setOpaque(false);
        celeb1.setAlignmentX(Component.CENTER_ALIGNMENT);
        celeb1.setOpaque(false);
        proceed.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancel.setAlignmentX(Component.CENTER_ALIGNMENT);

        labelBox.add(Box.createRigidArea(new Dimension(0, 130)));
        labelBox.add(celeb);
        labelBox.add(Box.createRigidArea(new Dimension(0, 5)));
        labelBox.add(celeb1);
        labelBox.add(Box.createRigidArea(new Dimension(0, 25)));
        labelBox.add(proceed);
        labelBox.add(Box.createRigidArea(new Dimension(0, 5)));
        labelBox.add(cancel);

        panel.setOpaque(false);
        panel.add(labelBox);
        this.setLayout(new FlowLayout());
        this.setTitle("Pizza Maniacs");
        this.add(panel);
        this.setSize(600, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        
        class ButtonHandler2 implements ActionListener {

            //go to pizza section 
            @Override
            public void actionPerformed(ActionEvent e) {
                menup me = new menup();
                close();
                me.gui();
            }
        }
        class ButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                //go to party hall booking frame 
                if (e.getSource() == proceed) {
                    close();
                    BookSlots book = new BookSlots();
                }
            }
        }
        ButtonHandler btnHandler = new ButtonHandler();
        proceed.addActionListener(btnHandler);
        ButtonHandler2 b = new ButtonHandler2();
        cancel.addActionListener(b);
    }
}
