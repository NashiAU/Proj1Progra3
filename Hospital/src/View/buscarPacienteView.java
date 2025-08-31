package View;

import Model.entidades.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class buscarPacienteView extends JDialog {
    private JPanel contentPane;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JComboBox filtroComboBox;
    private JTextField busquedaField;
    private JLabel opcionFiltrarLabel;
    private JTable pacientesTabla;

    private DefaultTableModel modeloTabla;

    private BiConsumer<String, String> onBuscarListener;

    public buscarPacienteView() {
        inicializarTabla();
    }

    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Fecha Nac.", "Teléfono"}, 0);
        pacientesTabla.setModel(modeloTabla);
        pacientesTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }





}