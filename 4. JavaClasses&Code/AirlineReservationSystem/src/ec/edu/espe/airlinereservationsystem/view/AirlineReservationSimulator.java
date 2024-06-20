package ec.edu.espe.airlinereservationsystem.view;

import ec.edu.espe.airlinereservationsystem.model.Login;
import ec.edu.espe.airlinereservationsystem.utils.CustomerDataManager;
import ec.edu.espe.airlinereservationsystem.utils.CustomerManager;
import ec.edu.espe.airlinereservationsystem.utils.ReservationSystem;
import javax.swing.JOptionPane;

public class AirlineReservationSimulator {

    public static void main(String[] args) {
        // Obtener una instancia del sistema de reservas
        ReservationSystem reservationSystem = ReservationSystem.getInstance();
        
        // Configurar el sistema de reservas en el CustomerDataManager
        CustomerDataManager.setReservationSystem(reservationSystem);
        
        // Crear un CustomerManager y cargar los clientes
        CustomerManager customerManager = new CustomerManager();
        
        // Mostrar el menú de inicio de sesión y autenticar al usuario
        boolean loginExitoso = mostrarMenuLogin(customerManager);

        if (loginExitoso) {
            // Si el login es exitoso, proceder con el menú principal de la aplicación
            MenuManager menuManager = new MenuManager(reservationSystem);
            menuManager.displayMenu();
        } else {
            // Manejar cualquier lógica adicional si el login falla o se cancela
            System.out.println("Login fallido. Saliendo del sistema...");
        }
    }

    private static boolean mostrarMenuLogin(CustomerManager customerManager) {
        String nombreUsuario = JOptionPane.showInputDialog(null, "Ingrese su nombre de usuario:");
        if (nombreUsuario == null) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión cancelado");
            return false;
        }

        String contrasena = JOptionPane.showInputDialog(null, "Ingrese su contraseña:");
        if (contrasena == null) {
            JOptionPane.showMessageDialog(null, "Inicio de sesión cancelado");
            return false;
        }

        Login login = new Login(customerManager);
        return login.autenticar(nombreUsuario, contrasena);
    }
}
