package view;

import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Navigation Bar Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            NavigationBarPanel navBarPanel = new NavigationBarPanel();
            frame.getContentPane().add(navBarPanel);

            frame.setSize(1440, 900);  
            frame.setLocationRelativeTo(null);  
            frame.setVisible(true);
        });
    }
}
