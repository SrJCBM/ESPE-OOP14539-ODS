package ec.espe.edu.AirlineReservationSystem.controller;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import ec.espe.edu.AirlineReservationSystem.utils.MongoDBManager;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */
public class AdTicketsController extends MongoDBManager {

    private MongoCollection<Document> ticketsCollection;

    public AdTicketsController() {
        super("mongodb+srv://overnightdevelopersquad:Iq9R4i2czmCFcGBk@airlinedb.wbmwsfn.mongodb.net/", "TicketDataBase");
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

    public boolean updateTicket(int ticketId, String newCustomerName, int newFlightId, String newTicketClass) {
        Document query = new Document("Ticket ID", ticketId);
        Document update = new Document("Customer Name", newCustomerName)
                .append("Id Flight", newFlightId)
                .append("Ticket Class", newTicketClass);

        return updateDocument(ticketsCollection, query, update);
    }

    public boolean deleteTicket(int ticketId) {
        Document query = new Document("Ticket ID", ticketId);
        return deleteDocument(ticketsCollection, query);
    }
}
