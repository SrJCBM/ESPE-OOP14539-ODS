/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.espe.edu.AirlineReservationSystem.model.Ticket;
import org.bson.Document;


/**
 *
 * @author Joffre
 */
public class TicketController {
      private static final String DATABASE_NAME = "TicketDataBase";
    private static final String TICKET_COLLECTION = "tickets";
    private static final String COUNTER_COLLECTION = "counters";
    private static final String COUNTER_NAME = "ticketId";
    
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> ticketCollection;
    private MongoCollection<Document> counterCollection;

    public TicketController() {
        mongoClient = MongoClients.create("mongodb+srv://overnightdevelopersquad:Iq9R4i2czmCFcGBk@airlinedb.wbmwsfn.mongodb.net/");
        database = mongoClient.getDatabase(DATABASE_NAME);
        ticketCollection = database.getCollection(TICKET_COLLECTION);
        counterCollection = database.getCollection(COUNTER_COLLECTION);
    }

    private int getNextTicketId() {
        Document query = new Document("_id", COUNTER_NAME);
        Document update = new Document("$inc", new Document("seq", 1));
        
        Document result = counterCollection.findOneAndUpdate(query, update);
        if (result != null) {
            return result.getInteger("seq");
        } else {
            Document newCounter = new Document("_id", COUNTER_NAME).append("seq", 1);
            counterCollection.insertOne(newCounter);
            return 1;
        }
    }

    public String saveTicket(Ticket ticket) {
        try {
            int nextTicketId = getNextTicketId();
            ticket.setIdTicket(nextTicketId);

            Document ticketDoc = new Document("Number of Ticket", ticket.getTicketNumber())
                .append("Ticket ID", ticket.getIdTicket())
                .append("Customer Name", ticket.getCustomerName())
                .append("Id Flight", ticket.getIdFlight())
                .append("Ticket Class", ticket.getTicketClass());

            ticketCollection.insertOne(ticketDoc);
            return String.valueOf(ticket.getIdTicket());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   public String findTicketById(int ticketId) {
    Document query = new Document("Ticket ID", ticketId);
    Document ticket = ticketCollection.find(query).first();
    
    if (ticket != null) {
        String customerName = ticket.getString("Customer Name");
        int flightId = ticket.getInteger("Id Flight");
        String ticketClass = ticket.getString("Ticket Class"); // Corregido: agregada la falta de punto y coma
        
        return "<html>Cliente Encontrado <br><br> Nombre del Cliente: " + customerName + 
               "<br><br>ID del Vuelo: " + flightId + 
               "<br><br>Clase: " + ticketClass + 
               "<br><br>Por favor, estimado cliente, revise que sus datos sean correctos.</html>";
    } else {
        return "<html>No se encontró el ticket con ID: " + ticketId + "</html>";
    }
  }
}



