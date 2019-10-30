package pizza_delivery_system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class party2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        screen p = new screen();
        p.window();

    }

}

class screen extends JFrame {

    /**
     *
     */

    JLabel heading, img_label;
    JComboBox state;
	//JPanel panel=new JPanel();
    //JPanel footer =new JPanel();
    ImageIcon img;

    public void window() {
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pizza Delivery System");
        placeComponents();
        this.setVisible(true);
        //this.pack();
    }

    public void placeComponents() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        ImageIcon icon = new ImageIcon("C:\\Users\\Divi\\Desktop\\party_time.jpg");
        this.setIconImage(icon.getImage());
	//setContentPane(new JLabel(new ImageIcon("C:\\Users\\Divi\\Desktop\\IMG_20150110_145318.jpg")));
        //setIcon(new ImageIcon("party_time.jpg"));
        //panel.setIcon(new ImageIcon(image));

	//this.setBackground(getBackground("l.jpg"));
	//JLabel background=new JLabel(new ImageIcon("C:\\Users\\Divi\\Desktop\\IMG_20150110_145318.jpg"));
        //this.add(background);
        heading = new JLabel("<html>ITS PARTY TIME!<br>Celebrating something special?<br>Then you are in the right place...!!</html>");
        Font font = new Font("Arial Black", Font.BOLD, 15);
        heading.setFont(font);
        heading.setForeground(Color.red);
        addComp(panel, heading, 0, 10, 1, 1, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE);

        img = new ImageIcon(getClass().getResource(""));

        img_label = new JLabel(img);
        Dimension size = img_label.getPreferredSize();
        size.width = 200;
        size.height = 200;
        img_label.setPreferredSize(size);

        addComp(panel, img_label, 2, 10, 2, 2, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);

        JPanel paintpane = new JPanel();
        paintpane.setBackground(Color.green);

	//paintpane.setBorder(BorderFactory.createLineBorder(Color.black)); // set a testing border to help you position the elements better
        //pane.setBounds(300, 200, 400, 220);
        //pane.setLayout(BorderLayout.SOUTH);
        paintpane.setPreferredSize(new Dimension(550, 100));
        JLabel place = new JLabel("Bangalore|Chennai|Mumbai");

        place.setFont(new Font("Arial Black", Font.BOLD, 15));
        // place.setLocation(100,200);
        place.setForeground(Color.blue);
        paintpane.add(place);
        addComp(panel, paintpane, 0, 5, 60, 60, GridBagConstraints.SOUTH, GridBagConstraints.NONE);

        String[] places = {"Kammanahalli", "Hebbal", "IndiraNagar", "Koramangala", "RajajiNagar", "M.G Road"};
        state = new JComboBox(places);
        state.setMaximumRowCount(3);

        this.add(panel);
//this.add(paintpane);

    }

    /*	 public void paint(Graphics g)
     {
     //super.paintComponent(g);
     g.setColor(Color.MAGENTA);
     int x1=100,y1=200,x2=400,y2=400;
     g.fillRect(0,250,600,400);
     }
	
     */
    private void addComp(JPanel panel, JComponent comp, int xpos, int ypos, int compWidth, int compHeight, int place, int stretch) {

        GridBagConstraints gridConstraints = new GridBagConstraints();
		//gridConstraints.fill=GridBagConstraints.HORIZONTAL;
        //System.out.println("hi");
        gridConstraints.gridx = xpos;
        gridConstraints.gridy = ypos;
        gridConstraints.gridwidth = compWidth;
        gridConstraints.gridheight = compHeight;
        gridConstraints.weightx = 10;
        gridConstraints.weighty = 10;
        gridConstraints.insets = new Insets(15, 4, 0, 5);
        gridConstraints.anchor = place;
        gridConstraints.fill = stretch;

        panel.add(comp, gridConstraints);

    }

}
