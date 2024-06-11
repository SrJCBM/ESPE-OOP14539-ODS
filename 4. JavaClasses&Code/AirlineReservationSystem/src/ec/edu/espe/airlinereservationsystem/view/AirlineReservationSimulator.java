package ec.edu.espe.airlinereservationsystem.view;

import utils.ReservationSystem;

public class AirlineReservationSimulator {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = ReservationSystem.getInstance();
        MenuManager menuManager = new MenuManager(reservationSystem);
        menuManager.displayMenu();
    }
}
