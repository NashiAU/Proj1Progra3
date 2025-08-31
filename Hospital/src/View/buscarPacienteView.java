package View;

import Model.entidades.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.List;

public class buscarPacienteView extends JDialog {
    private JPanel contentPane;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JComboBox filtroComboBox;
    private JTextField busquedaField;
    private JLabel opcionFiltrarLabel;
    private JTable pacientesTabla;

    private DefaultTableModel modeloTabla;

    public buscarPacienteView() {
        inicializarTabla();
    }

    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Fecha Nac.", "Teléfono"}, 0);
        pacientesTabla.setModel(modeloTabla);
        pacientesTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void actualizarTabla(List<Paciente> pacientes) {
        modeloTabla.setRowCount(0); // Limpia la tabla
        for (Paciente p : pacientes) {
            modeloTabla.addRow(new Object[]{
                    p.getId(),
                    p.getNombre(),
                    p.getFechaNacimiento(),
                    p.getTelefono()
            });
        }
    }
    public JPanel getBuscarPane() {
        return contentPane;
    }

}