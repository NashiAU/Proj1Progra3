import Model.entidades.Medico;
import Service.ListaMedicosService;
import  View.loginView;

import javax.swing.*;
import java.util.List;

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

           //-----------------------------------------------------------------------------------------------------------------------------------------
            ListaMedicosService medicoService = new ListaMedicosService();

            // 1. Incluir Médicos
            Medico m1 = new Medico("001","001", "Ana Gomez", "Pediatría");
            Medico m2 = new Medico("002","002", "Juan Perez", "Cardiología");
            Medico m3 = new Medico("003","003", "Maria Lopez", "Dermatología");
            medicoService.incluir(m1);
            medicoService.incluir(m2);
            medicoService.incluir(m3);

            // 2. Consultar todos los médicos
            System.out.println("Todos los médicos:");
            for (Medico m : medicoService.listarTodos()) {
                System.out.println(m.getId() + " - " + m.getNombre() + " - " + m.getEspecialidad());
            }

            // 3. Buscar por id
            System.out.println("\nBuscar por id '002':");
            Medico encontrado = medicoService.buscarPorId("002");
            if (encontrado != null) {
                System.out.println(encontrado.getId() + " - " + encontrado.getNombre() + " - " + encontrado.getEspecialidad());
            }

            // 4. Buscar por nombre
            System.out.println("\nBuscar por nombre 'Maria':");
            List<Medico> resultados = medicoService.buscarPorNombre("Maria");
            for (Medico m : resultados) {
                System.out.println(m.getId() + " - " + m.getNombre() + " - " + m.getEspecialidad());
            }

            // 5. Modificar un médico (cambiar especialidad y clave)
            System.out.println("\nModificar médico '003':");
            Medico mMod = new Medico("003","003", "Maria Lopez", "Neurología");
            mMod.setClave("nuevaClave123"); // El médico puede cambiar su clave
            boolean modificado = medicoService.modificar("003", mMod);
            System.out.println(modificado ? "Médico modificado exitosamente." : "No se encontró el médico.");

            // 6. Consultar médico modificado
            System.out.println("\nConsultar médico '003' modificado:");
            Medico modificadoObj = medicoService.buscarPorId("003");
            if (modificadoObj != null) {
                System.out.println(modificadoObj.getId() + " - " + modificadoObj.getNombre()
                        + " - " + modificadoObj.getEspecialidad() + " - Clave: " + modificadoObj.getClave());
            }

            // 7. Borrar un médico
            System.out.println("\nBorrar médico '002':");
            boolean borrado = medicoService.borrar("002");
            System.out.println(borrado ? "Médico borrado exitosamente." : "No se encontró el médico para borrar.");

            // 8. Mostrar todos los médicos al final
            System.out.println("\nTodos los médicos después de borrar:");
            for (Medico m : medicoService.listarTodos()) {
                System.out.println(m.getId() + " - " + m.getNombre() + " - " + m.getEspecialidad());
            }
        });
    }
}