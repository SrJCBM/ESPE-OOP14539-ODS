/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class AdFlightsController {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> flightsCollection;

    public AdFlightsController() {
        mongoClient = MongoClients.create("mongodb+srv://overnightdevelopersquad:Iq9R4i2czmCFcGBk@airlinedb.wbmwsfn.mongodb.net/");
        database = mongoClient.getDatabase("FlightDataBase"); 
        flightsCollection = database.getCollection("flights"); 
    }

    public List<Document> getFlights() {
        List<Document> flightsList = new ArrayList<>();
        try (MongoCursor<Document> cursor = flightsCollection.find().iterator()) {
            while (cursor.hasNext()) {
                Document flight = cursor.next();
                System.out.println("Flight retrieved: " + flight.toJson());
                flightsList.add(flight);
            }
        }
        return flightsList;
    }
    
    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión a MongoDB cerrada.");
        }
    }
}

