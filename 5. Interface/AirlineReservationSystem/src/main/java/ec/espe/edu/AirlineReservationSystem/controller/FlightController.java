package ec.espe.edu.AirlineReservationSystem.controller;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ec.espe.edu.AirlineReservationSystem.model.Flight;

public class FlightController {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> flightCollection;

    public FlightController() {
        mongoClient = MongoClients.create("mongodb+srv://kachiriboga:chiriboga@cluster0.mstbyy5.mongodb.net/");
        database = mongoClient.getDatabase("AirlineReservationSystem");
        flightCollection = database.getCollection("flights");
    }

    public String saveFlight(Flight flight) {
        Document flightDoc = new Document("origin", flight.getOrigin())
                .append("destination", flight.getDestination())
                .append("airline", flight.getAirline())
                .append("departureDate", flight.getDepartureDate())
                .append("arrivalDate", flight.getArrivalDate());
        flightCollection.insertOne(flightDoc);
        
                String flightId = flightDoc.getObjectId("_id").toString();

        // Actualizar el objeto Flight con el ID generado
        flight.setFlightId(flightId);

        return flightId;
    }
}
