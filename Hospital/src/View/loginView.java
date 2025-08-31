package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.cambiarClaveView.*;

public class loginView {
    private JPanel loginPanel;
    private JLabel idLabel;
    private JLabel claveLabel;
    private JTextField claveField;
    private JTextField idField;
    private JButton loginButton;
    private JButton cancelarButton;
    private JButton cambiarClaveButton;

    public loginView() {
        cambiarClaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(loginPanel);
                cambiarClaveView dialog = new cambiarClaveView(parentFrame);
                dialog.setVisible(true);

            }
        });
    }

    public JPanel getLoginPanel() {
        return loginPanel;
    }
}
