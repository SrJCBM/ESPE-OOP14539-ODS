package ec.espe.edu.AirlineReservationSystem.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import java.awt.HeadlessException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.bson.Document;

/**
 *
 * @author Joffre
 */
public class BaggageController {

      private static final Logger logger = Logger.getLogger(TicketController.class.getName());

    private static final String DATABASE_NAME = "TicketDataBase";
    private static final String TICKET_COLLECTION = "tickets";
    private static final String COUNTER_COLLECTION = "counters";
    private static final String COUNTER_NAME = "ticketId";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> ticketCollection;
    private MongoCollection<Document> counterCollection;

        

    private static int ticketId;

    public BaggageController(int ticketId) {
        this.ticketId = ticketId;
    }

       public BaggageController() {
        mongoClient = MongoClients.create("mongodb+srv://overnightdevelopersquad:Iq9R4i2czmCFcGBk@airlinedb.wbmwsfn.mongodb.net/");
        database = mongoClient.getDatabase(DATABASE_NAME);
        ticketCollection = database.getCollection(TICKET_COLLECTION);
        counterCollection = database.getCollection(COUNTER_COLLECTION);
    }
    
public BaggageController(MongoClient mongoClient, int ticketId) {
    this.ticketId = ticketId;
    this.mongoClient = mongoClient;
    this.database = mongoClient.getDatabase("TicketDataBase");
    this.ticketCollection = database.getCollection("tickets");
}



    public static void setTicketId(int id) {
        ticketId = id;
    }

    public static int getTicketId() {
        return ticketId;
    }
    
      public void handleBaggageProcess(JComponent component, int weightValue, String baggageType) {
          
            if (weightValue <= 0) {
                JOptionPane.showMessageDialog(component, "El peso debe ser mayor que 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int ticketId= BaggageController.getTicketId();
            
            TicketController controller = new TicketController ();
          controller.updateTicketWithBaggage(ticketId, baggageType, weightValue);

            JOptionPane.showMessageDialog(component, "Peso confirmado: " + weightValue + " kilogramos", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(component, "El equipaje se ha añadido a su Ticket!", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(component,
                    "<html><body style='width: 300px;'>"
                    + "<p style='font-size: 14px;'>Por favor, proceda con el pago.</p>"
                    + "</body></html>",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

        }
      
     public static void DeleteBaggageActivate ( JPanel panel ){
      panel.setVisible(false);  
      panel.getComponent(0).setVisible(false); 
      panel.getComponent(1).setVisible(false);
     }
     
  
     
 public static void AdministrateBaggagePanel (int ticketId, JPanel panelToDesactivate){

      try {
          TicketController ticketController = new TicketController();
      int BaggageCounter = ticketController.getBaggageCount(ticketId);
      
      if (BaggageCounter == 2){
          
          panelToDesactivate.setVisible(true);  
      panelToDesactivate.getComponent(0).setVisible(true); 
      panelToDesactivate.getComponent(1).setVisible(true);
      } else if(BaggageCounter == 0){
      JOptionPane.showMessageDialog(null, "No hay equipaje vinculado a esta maleta.", "Error", JOptionPane.ERROR_MESSAGE);      }
      
      }catch (HeadlessException e) {
        JOptionPane.showMessageDialog(null, "Error al procesar el equipaje: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

    }
      
    }
 

    public int getNextBaggage(int ticketId) {
        try {
            Document filter = new Document("Ticket ID", ticketId);
            Document ticket = ticketCollection.find(filter).first();

            if (ticket != null) {
                List<Document> baggages = (List<Document>) ticket.get("Equipaje");
                if (baggages != null) {
                    return baggages.size() + 1;
                }
            }
            return 1;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al obtener el siguiente ID de equipaje", e);
            return 1;
        }
    }

  public void deleteBaggage(int ticketId, int baggageIndex) {
        try {
            Document filter = new Document("Ticket ID", ticketId);
            Document ticket = ticketCollection.find(filter).first();

            if (ticket != null) {
                List<Document> baggages = (List<Document>) ticket.get("Equipaje");
                if (baggages != null && baggageIndex >= 1 && baggageIndex <= baggages.size()) {
                    Document baggageToRemove = baggages.get(baggageIndex - 1);
                    String baggageId = baggageToRemove.getString("Baggage ID");

                    Document update = new Document("$pull", new Document("Equipaje", new Document("Baggage ID", baggageId)));
                    UpdateResult result = ticketCollection.updateOne(filter, update);

                    if (result.getModifiedCount() > 0) {
                        JOptionPane.showMessageDialog(null, "Equipaje eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró equipaje para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el equipaje: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
    




