package ec.espe.edu.AirlineReservationSystem.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */
public abstract class MongoDBManager {

    protected MongoClient mongoClient;
    protected MongoDatabase database;

    public MongoDBManager(String connectionString, String databaseName) {
        this.mongoClient = MongoClients.create(connectionString);
        this.database = mongoClient.getDatabase(databaseName);
    }

    public boolean updateDocument(MongoCollection<Document> collection, Document query, Document update) {
        try {
            UpdateResult result = collection.updateOne(query, new Document("$set", update));
            return result.getModifiedCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDocument(MongoCollection<Document> collection, Document query) {
        try {
            DeleteResult result = collection.deleteOne(query);
            return result.getDeletedCount() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void close() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("Conexión a MongoDB cerrada.");
        }
    }

}
