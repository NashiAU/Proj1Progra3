package View;

import Model.entidades.Medico;
import Service.ListaMedicosService;
import  Model.TableModel.AbstractTableModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class medicoView {
    private JPanel panel1;
    private JLabel idLabel;
    private JTextField idField;
    private JLabel nombreLabel;
    private JTextField nombreField;
    private JLabel especialidadLabel;
    private JTextField especialidadField;
    private JLabel nombreBusquedaLabel;
    private JTextField nombreBusquedaField;
    private JButton guardarButton;
    private JButton borrarButton;
    private JButton limpiarButton;
    private JTable medicosListaTable;

    private ListaMedicosService medicos;

    public medicoView() {
        medicos = new ListaMedicosService();
        AbstractTableModel<Medico> tableModel= new AbstractTableModel(5, medicos.getUsuarios());
        medicosListaTable.setModel(tableModel);

        // Guardar (alta o modificación)
        guardarButton.addActionListener(e -> {
            String id = idField.getText().trim();
            String nombre = nombreField.getText().trim();
            String especialidad = especialidadField.getText().trim();
            if (id.isEmpty() || nombre.isEmpty() || especialidad.isEmpty()) {
                JOptionPane.showMessageDialog(panel1, "Completa todos los campos.");
                return;
            }
            Medico existente = medicos.buscarPorId(id);
            if (existente != null) {
                existente.setNombre(nombre);
                existente.setEspecialidad(especialidad);
            } else {
                medicos.add(new Medico(id, nombre, especialidad));
            }
            refrescarTabla(medicos.listarTodos());
            limpiarCampos();
        });

        // Limpiar campos
        limpiarButton.addActionListener(e -> limpiarCampos());

        // Borrar médico (por selección o id)
        borrarButton.addActionListener(e -> {
            int row = medicosListaTable.getSelectedRow();
            String id = idField.getText().trim();
            if (row >= 0) {
                String idSeleccionado = (String) tableModel.getValueAt(row, 0);
                medicos.borrar(idSeleccionado);
                refrescarTabla(medicos.listarTodos());
                limpiarCampos();
            } else if (!id.isEmpty()) {
                medicos.borrar(id);
                refrescarTabla(medicos.listarTodos());
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(panel1, "Selecciona un médico en la lista o ingresa el ID.");
            }
        });

        // Buscar por nombre
        // Supongo que tienes un botón buscarButton, si no, agrega:
        // private JButton buscarButton;
        buscarButton.addActionListener(e -> {
            String nombre = nombreBusquedaField.getText().trim().toLowerCase();
            List<Medico> filtrados = new ArrayList<>();
            for (Medico m : medicos.listarTodos()) {
                if (m.getNombre().toLowerCase().contains(nombre)) {
                    filtrados.add(m);
                }
            }
            refrescarTabla(filtrados);
        });

        // Selección en tabla
        medicosListaTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = medicosListaTable.getSelectedRow();
                if (row >= 0) {
                    idField.setText((String) tableModel.getValueAt(row, 0));
                    nombreField.setText((String) tableModel.getValueAt(row, 1));
                    especialidadField.setText((String) tableModel.getValueAt(row, 2));
                }
            }
        });

        // Inicializa la tabla
        refrescarTabla(medicos.listarTodos());
    }

    private void refrescarTabla(List<Medico> lista) {
        tableModel.setRowCount(0);
        for (Medico m : lista) {
            tableModel.addRow(new Object[]{m.getId(), m.getNombre(), m.getEspecialidad()});
        }
    }

    private void limpiarCampos() {
        idField.setText("");
        nombreField.setText("");
        especialidadField.setText("");
        nombreBusquedaField.setText("");
        medicosListaTable.clearSelection();
    }
}
