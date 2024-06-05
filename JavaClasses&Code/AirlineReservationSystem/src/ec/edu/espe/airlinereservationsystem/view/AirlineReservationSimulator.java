package ec.edu.espe.airlinereservationsystem.view;

import utils.reservationSystem;


public class AirlineReservationSimulator {
    public static void main(String[] args) {
        reservationSystem reservationSystemInt = new reservationSystem();
        MenuManager menuManager = new MenuManager(reservationSystemInt);
        menuManager.displayMenu();
    }
}