package ec.espe.edu.AirlineReservationSystem.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */

public abstract class MongoDBManager {
    protected MongoClient mongoClient;

    public MongoDBManager(String connectionString) {
        this.mongoClient = MongoClients.create(connectionString);
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión a MongoDB cerrada.");
        }
    }
}
