package View;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class prescripcionView {
    private JTabbedPane tabbedPane1;
    private DatePicker datePicker1;
    private JTable tablaMedicamentos;
    private JButton buscarPacienteButton;
    private JButton agregarMedicamentoButton;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JButton descartarMedicamentoButton;
    private JButton detallesButton;
    private JPanel tablaPrincipal;
    private DefaultTableModel modeloTabla;
    public prescripcionView() {
        inicializarTabla();
    }

    private void inicializarTabla() {
        modeloTabla = new DefaultTableModel(
                new Object[]{"Medicamento", "Presentación", "Cantidad", "Duración"}, 0
        );
        tablaMedicamentos.setModel(modeloTabla);
        tablaMedicamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Fila de ejemplo para que se vea algo
        modeloTabla.addRow(new Object[]{"Acetaminofén", "100 mg", 60, 30});
    }

    public JPanel getPanelPrincipal() {
        return tablaPrincipal;
    }

}
