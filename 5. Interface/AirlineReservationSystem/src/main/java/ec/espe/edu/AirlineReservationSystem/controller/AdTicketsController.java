package ec.espe.edu.AirlineReservationSystem.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */

public class AdTicketsController {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> ticketsCollection;

    public AdTicketsController() {
        mongoClient = MongoClients.create("mongodb+srv://overnightdevelopersquad:Iq9R4i2czmCFcGBk@airlinedb.wbmwsfn.mongodb.net/");
        database = mongoClient.getDatabase("TicketDataBase");
        ticketsCollection = database.getCollection("tickets");
    }

    public List<Document> getTickets() {
        List<Document> ticketsList = new ArrayList<>();
        try (MongoCursor<Document> cursor = ticketsCollection.find().iterator()) {
            while (cursor.hasNext()) {
                Document ticket = cursor.next();
                ticketsList.add(ticket);
            }
        }
        return ticketsList;
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión a MongoDB cerrada.");
        }
    }

    public boolean updateTicket(int ticketId, String newCustomerName, int newFlightId, String newTicketClass) {
        try {
            Document query = new Document("Ticket ID", ticketId);
            Document update = new Document("$set", new Document("Customer Name", newCustomerName)
                .append("Id Flight", newFlightId)
                .append("Ticket Class", newTicketClass));

            ticketsCollection.updateOne(query, update);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteTicket(int ticketId) {
        try {
            Document query = new Document("Ticket ID", ticketId);
            ticketsCollection.deleteOne(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
