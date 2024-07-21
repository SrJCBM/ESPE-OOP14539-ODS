/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.controller;

/**
 *
 * @author Joffre
 */
public class BaggageController {
    private static int ticketId; // Variable para almacenar el ID del ticket

   
    public static void setTicketId(int id) {
        ticketId = id;
    }

    
    public static int getTicketId() {
        return ticketId;
    }
}

