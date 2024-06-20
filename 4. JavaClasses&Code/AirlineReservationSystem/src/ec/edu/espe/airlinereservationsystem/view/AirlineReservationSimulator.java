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
        boolean loggingSuccessful = showMenuLogin(customerManager);

        if (loggingSuccessful) {
            // Si el login es exitoso, proceder con el menú principal de la aplicación
            MenuManager menuManager = new MenuManager(reservationSystem);
            menuManager.displayMenu();
        } else {
            // Manejar cualquier lógica adicional si el login falla o se cancela
            System.out.println("Login failed. Logging out of the system...");
        }
    }

    private static boolean showMenuLogin(CustomerManager customerManager) {
        String userName = JOptionPane.showInputDialog(null, "Enter your username:");
        if (userName == null) {
            JOptionPane.showMessageDialog(null, "Login canceled");
            return false;
        }

        String password = JOptionPane.showInputDialog(null, "Enter your password:");
        if (password == null) {
            JOptionPane.showMessageDialog(null, "Login canceled");
            return false;
        }

        Login login = new Login(customerManager);
        return login.authenticate(userName, password);
    }
}
