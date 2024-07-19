package ec.espe.edu.AirlineReservationSystem.controller;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.espe.edu.AirlineReservationSystem.model.Customer;
import org.bson.Document;
/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class CustomerController {

    private static MongoClient createMongoClient() {
        String connectionString = "mongodb+srv://SrJCBM:OOP14539ODS@firstdb.gtv30gi.mongodb.net/?appName=FirstDB";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        return MongoClients.create(settings);
    }

        public static void createCustomer(Customer customer) {
        try (MongoClient mongoClient = createMongoClient()) {
            MongoDatabase database = mongoClient.getDatabase("CustomerDatabase");

            saveCustomerToDatabase(customer, database);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
        private static void saveCustomerToDatabase(Customer customer, MongoDatabase database) {
        MongoCollection<Document> collection = database.getCollection("customers");

        Document carDocument = new Document("id", customer.get)
                .append("model", car.getModel())
                .append("year", car.getYear())
                .append("age", car.getAge())
                .append("depreciation", car.getDepreciation());

        try {
            collection.insertOne(carDocument);
            System.out.println("Car saved successfully!");
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    
    
}
