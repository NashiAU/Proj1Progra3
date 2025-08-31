import Controller.PrescripcionController;
import Model.entidades.Medicamento;
import Model.entidades.Medico;
import Model.entidades.Paciente;
import Model.entidades.Receta;
import Service.ListaMedicosService;
import Service.PrescripcionService;
import View.buscarPacienteView;
import  View.loginView;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           //loginView view = new loginView();
            buscarPacienteView view = new buscarPacienteView();

           JFrame frame = new JFrame("Login");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.setContentPane(view.getBuscarPane());
           frame.pack();
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);

           //-----------------------------------------------------------------------------------------------------------------------------------------
            ListaMedicosService medicoService = new ListaMedicosService();

            // PRUEBA TABLA PACIENTES
            System.out.println("\nPRUEBA TABLA PACIENTES\n");

            List<Paciente> pacientesPrueba = List.of(
                    new Paciente("P001", "1234", "Juan Perez", LocalDate.of(1990, 5, 12), "8888-1111"),
                    new Paciente("P002", "abcd", "María López", LocalDate.of(1985, 8, 23), "8888-2222"),
                    new Paciente("P003", "pass", "Carlos Gómez", LocalDate.of(2000, 1, 3), "8888-3333")
            );


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


            // *********PRUEBAS PRESCRIPCION DE RECETAS*******

            System.out.println("\nPRUEBAS PRESCRIPCION DE RECETAS\n");

            // Instanciar el service y el controller
            PrescripcionService service = new PrescripcionService();
            PrescripcionController controller = new PrescripcionController(service);

            // Crear entidades base
            Medico medico = new Medico("M001", "M001", "Dr.House","Otorrinolaringologo");
            Paciente paciente = new Paciente("P001", "P001", "Joel",LocalDate.of(1980, 5, 12),"8888-8888");
            Medicamento ibuprofeno = new Medicamento("MED001", "Ibuprofeno", "Anti-inflamatorio", 100);
            Medicamento paracetamol = new Medicamento("MED002", "Paracetamol", "Analgésico",250);

            // Crear receta
            Receta receta = controller.iniciarReceta("R001", medico, paciente, LocalDate.now().plusDays(3));
            System.out.println("Receta creada: " + receta);

            // Agregar medicamentos
            controller.agregarMedicamento("R001", ibuprofeno, 20, "1 cada 8h", 5);
            controller.agregarMedicamento("R001", paracetamol, 10, "1 cada 12h", 3);
            System.out.println("Medicamentos agregados.");

            // Modificar medicamento
            controller.modificarMedicamento("R001", 0, ibuprofeno, 30, "1 cada 6h", 7);
            System.out.println("Medicamento modificado.");

            // Eliminar medicamento
            controller.eliminarMedicamento("R001", 1);
            System.out.println("Medicamento eliminado.");

            // Retirar receta
            controller.retirarReceta("R001");
            System.out.println("Receta retirada.");

            // Obtener receta
            Receta recetaFinal = controller.obtenerReceta("R001");
            System.out.println("Receta final:");
            System.out.println(recetaFinal);

            // Listar todas las recetas
            List<Receta> todas = controller.listarRecetas();
            System.out.println("Todas las recetas:");
            todas.forEach(System.out::println);

        });
    }
}