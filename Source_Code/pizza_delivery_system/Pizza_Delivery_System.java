package pizza_delivery_system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Pizza_Delivery_System {

    private JPanel contentPane, p2;
    JLabel m_title = new JLabel("Welcome to Pizza Mania");

    JFrame f = new JFrame();
    private String[] images = {
        "PizzaCapers1.jpg", "table.jpg", "pizza7.jpg", "pizza-1.jpg", "resized-resized-resized-pizza1.jpg"};

    public Pizza_Delivery_System() {

        //first frame
        m_title.setFont(new Font("Purisa", Font.BOLD, 30));
        m_title.setForeground(Color.black);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setBounds(420, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        f.add(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(225, 204, 153));
        final JLabel photo = new JLabel("");
        photo.setBounds(20, 10, 375, 215);
        photo.setSize(550, 350);
        contentPane.add(photo, BorderLayout.CENTER);

        //panel for the title
        p2 = new JPanel();
        f.add(p2, BorderLayout.NORTH);
        p2.setBackground(new Color(225, 204, 153));
        p2.add(m_title);

        //panel for next button
        JPanel p3 = new JPanel();
        p3.setBackground(new Color(225, 204, 153));
        JButton b = new JButton("Next");
        ButtonHandler listener = new ButtonHandler();
        b.addActionListener(listener);
        f.add(p3, BorderLayout.SOUTH);
        p3.add(b);

        //adding timer for the images
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = (int) Math.floor(Math.random() * 5);
                String image = images[n];
                photo.setIcon(new ImageIcon(image));
            }
        });
        timer.start();

        //setting up the frame
        ImageIcon img = new ImageIcon("icon.jpg");
        f.setIconImage(img.getImage());
        f.setSize(600, 510);
        f.setTitle("Pizza Maniacs");
        f.setVisible(true);
    }

    //go to next frame
    class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            IntroScreen is = new IntroScreen();
            is.window();
            f.setVisible(false);
            f.dispose();
        }
    }

    public static void main(String args[]) {
        Pizza_Delivery_System p = new Pizza_Delivery_System();

    }
}
