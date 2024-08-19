package ec.espe.edu.AirlineReservationSystem.controller;

import com.mongodb.client.MongoCollection;
import ec.espe.edu.AirlineReservationSystem.utils.MongoDBManager;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * Author: Kerlly Chiriboga, ODS
 */
public class AdUsuariosController extends MongoDBManager {

    private MongoCollection<Document> usuariosCollection;

    public AdUsuariosController() {
        super("mongodb+srv://overnightdevelopersquad:Iq9R4i2czmCFcGBk@airlinedb.wbmwsfn.mongodb.net/", "CustomerDatabase");
        usuariosCollection = database.getCollection("customers");
    }

    public List<Document> getUsuarios() {
        List<Document> usuariosList = new ArrayList<>();
        try (var cursor = usuariosCollection.find().iterator()) {
            while (cursor.hasNext()) {
                Document user = cursor.next();
                usuariosList.add(user);
            }
        }
        return usuariosList;
    }

    public boolean updateUser(String userId, String newName, String newEmail, String newPhoneNumber, String newCity, String newState, String newPostalCode, Date newDateOfBirth, String newGender) {
        Document query = new Document("id", userId);
        Document update = new Document("name", newName)
                .append("email", newEmail)
                .append("phoneNumber", newPhoneNumber)
                .append("city", newCity)
                .append("state", newState)
                .append("postalCode", newPostalCode)
                .append("dateOfBirth", newDateOfBirth)
                .append("gender", newGender);

        return updateDocument(usuariosCollection, query, update);
    }

    public boolean deleteUser(String userId) {
        Document query = new Document("id", userId);
        return deleteDocument(usuariosCollection, query);
    }
}
