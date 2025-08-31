import  View.loginView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           loginView view = new loginView();

           JFrame frame = new JFrame("Login");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setContentPane(view.getLoginPanel());
           frame.pack();
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);
        });
    }
}