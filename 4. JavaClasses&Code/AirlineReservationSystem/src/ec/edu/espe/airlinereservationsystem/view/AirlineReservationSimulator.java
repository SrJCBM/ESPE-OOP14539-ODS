package ec.edu.espe.airlinereservationsystem.view;

import ec.edu.espe.airlinereservationsystem.model.Users;
import ec.edu.espe.airlinereservationsystem.utils.ReservationSystem;

public class AirlineReservationSimulator {

    public static void main(String[] args) {
        
          Users[] users = {
            new Users("JulioBlacio", "julio2024"),
            new Users("JoffreGomez", "20082004jegq")
        };
        Login login = new Login(users);
        if (login.showLoginMenu()) {
           ReservationSystem reservationSystemInt = ReservationSystem.getInstance();
        MenuManager menuManager = new MenuManager(reservationSystemInt);
        menuManager.displayMenu();
        } else {
            System.out.println("Exiting the system.");
        }
    }
    }
