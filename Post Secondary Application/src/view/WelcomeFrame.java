package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
		
		setVisible(true);

		// Set up the background image
		ImageIcon backgroundImg = new ImageIcon("images/welcomeFrameBg.png");
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(backgroundImg.getIconWidth(), backgroundImg.getIconHeight()));

		JLabel imageLabel = new JLabel(backgroundImg);
		imageLabel.setBounds(0, 0, backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
		Dimension imageSize = new Dimension(backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
		imageLabel.setPreferredSize(imageSize);

		// add login text fields
		// Add two text fields
		//JTextField studentNumField = new JTextField();
		studentNumField.setBounds(100, 100, 200, 30);
		studentNumField.addActionListener(this);

		//JTextField passwordField = new JTextField();
		passwordField.setBounds(100, 150, 200, 30);
		passwordField.addActionListener(this);

		// adding components to the layered pane
		layeredPane.add(imageLabel, Integer.valueOf(0));
		layeredPane.add(studentNumField, Integer.valueOf(1));
		layeredPane.add(passwordField, Integer.valueOf(1));

		// add the layered pane to the scroll pane
		JScrollPane jsp = new JScrollPane(layeredPane);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.getVerticalScrollBar().setUnitIncrement(12);

		// add the scroll pane to the content pane
		getContentPane().add(jsp);

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == studentNumField) {
            // Handle data from textField1
            String dataStudentNum = studentNumField.getText();
            System.out.println("Data from textField1: " + dataStudentNum);
        } else if (e.getSource() == passwordField) {
            // Handle data from textField2
            String dataPassword = passwordField.getText();
            System.out.println("Data from textField2: " + dataPassword);
        }
	}

}
