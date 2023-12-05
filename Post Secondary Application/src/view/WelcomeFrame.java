package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class WelcomeFrame extends JFrame implements ActionListener {
    private JTextField studentNumField;
    private JTextField passwordField;

    public WelcomeFrame() {
        // Set up the frame
        super("Welcome Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1440, 900);

        // Set up the background image
        ImageIcon backgroundImg = new ImageIcon("images/welcomeFrameBg.png");
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(backgroundImg.getIconWidth(), backgroundImg.getIconHeight()));

        JLabel imageLabel = new JLabel(backgroundImg);
        imageLabel.setBounds(0, 0, backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
        Dimension imageSize = new Dimension(backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
        imageLabel.setPreferredSize(imageSize);

        // Add login text fields
        studentNumField = new JTextField();  // Instantiate the JTextField
        studentNumField.setBounds(290, 1425, 800, 80);
        studentNumField.addActionListener(this);
        studentNumField.setBackground(Color.LIGHT_GRAY);
        studentNumField.setFont(new Font("Arial", Font.PLAIN, 23));

        passwordField = new JTextField();  // Instantiate the JTextField
        passwordField.setBounds(290, 1600, 800, 80);
        passwordField.addActionListener(this);
        passwordField.setBackground(Color.LIGHT_GRAY);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 23));
        
        //add the get started button
        ImageIcon getStartedIcon = new ImageIcon("images/getStartedBtn.png"); 
        JButton getStartedBtn = new JButton(getStartedIcon);
        getStartedBtn.setOpaque(false);
        getStartedBtn.setContentAreaFilled(false);
        getStartedBtn.setBorderPainted(false);
        getStartedBtn.setBounds(550, 1725, getStartedIcon.getIconWidth(), getStartedIcon.getIconHeight()); 
        getStartedBtn.addActionListener(this);
        

        // Adding components to the layered pane
        layeredPane.add(imageLabel, Integer.valueOf(0));
        layeredPane.add(studentNumField, Integer.valueOf(1));
        layeredPane.add(passwordField, Integer.valueOf(1));
        layeredPane.add(getStartedBtn, Integer.valueOf(1));

        // add the layered pane to the scroll pane
        JScrollPane jsp = new JScrollPane(layeredPane);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsp.getVerticalScrollBar().setUnitIncrement(12);

        // add the scroll pane to the content pane
        getContentPane().add(jsp);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == studentNumField) {
            // Handle data from studentNumField
            String dataStudentNum = studentNumField.getText();
            System.out.println("Data from studentNumField: " + dataStudentNum);
        } else if (e.getSource() == passwordField) {
            // Handle data from passwordField
            String dataPassword = passwordField.getText();
            System.out.println("Data from passwordField: " + dataPassword);
        } else if (e.getSource() instanceof JButton) {
            // Handle button click (submitButton)
            String dataStudentNum = studentNumField.getText();
            String dataPassword = passwordField.getText();
            System.out.println("Data submitted - StudentNum: " + dataStudentNum + ", Password: " + dataPassword);
            // Add your code to store or process the collected data
        }
    }

}
