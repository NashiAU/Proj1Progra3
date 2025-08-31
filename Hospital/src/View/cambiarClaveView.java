package View;

import javax.swing.*;

public class cambiarClaveView extends JDialog {
    private JPanel contentPane;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JLabel claveActualLabel;
    private JLabel claveNuevaLabel1;
    private JLabel claveNuevaLabel2;
    private JTextField claveActualField;
    private JTextField claveNuevaField1;
    private JTextField claveNuevaField2;

    public cambiarClaveView(JFrame parent) {
        super(parent, "Cambiar contraseña", true);
        setContentPane(contentPane);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(parent);
        getRootPane().setDefaultButton(aceptarButton);
    }
}
