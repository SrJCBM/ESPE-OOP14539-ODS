package ec.espe.edu.AirlineReservationSystem.controller;

import com.mongodb.client.MongoCollection;
import ec.espe.edu.AirlineReservationSystem.utils.MongoDBManager;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */
public class AdFlightsController extends MongoDBManager {

    private MongoCollection<Document> flightsCollection;

    public AdFlightsController() {
        super("mongodb+srv://overnightdevelopersquad:Iq9R4i2czmCFcGBk@airlinedb.wbmwsfn.mongodb.net/", "FlightDataBase");
        flightsCollection = database.getCollection("flights");
    }

    public List<Document> getFlights() {
        List<Document> flightsList = new ArrayList<>();
        try (var cursor = flightsCollection.find().iterator()) {
            while (cursor.hasNext()) {
                Document flight = cursor.next();
                flightsList.add(flight);
            }
        }
        return flightsList;
    }

    public boolean updateFlight(String flightID, String newAirline, String newOrigin, String newDestination, Date newDepartureDate, Date newArrivalDate) {
        Document query = new Document("flightID", flightID);
        Document update = new Document("airline", newAirline)
                .append("origin", newOrigin)
                .append("destination", newDestination)
                .append("departureDate", newDepartureDate)
                .append("arrivalDate", newArrivalDate);

        return updateDocument(flightsCollection, query, update);
    }

    public boolean deleteFlight(String flightID) {
        Document query = new Document("flightID", flightID);
        return deleteDocument(flightsCollection, query);
    }
}
