/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.espe.edu.AirlineReservationSystem.controller.TicketController;
import ec.espe.edu.AirlineReservationSystem.view.WeigthBaggagePanel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author Joffre
 */
public class ButtonBaggageManager {
 
    
      private static final Logger logger = Logger.getLogger(TicketController.class.getName());

    private static final String DATABASE_NAME = "TicketDataBase";
    private static final String TICKET_COLLECTION = "tickets";
    private static final String COUNTER_COLLECTION = "counters";
    private static final String COUNTER_NAME = "ticketId";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> ticketCollection;
    private MongoCollection<Document> counterCollection;
    
    
    public ButtonBaggageManager() {
        mongoClient = MongoClients.create("mongodb+srv://overnightdevelopersquad:Iq9R4i2czmCFcGBk@airlinedb.wbmwsfn.mongodb.net/");
        database = mongoClient.getDatabase(DATABASE_NAME);
        ticketCollection = database.getCollection(TICKET_COLLECTION);
        counterCollection = database.getCollection(COUNTER_COLLECTION);
    }
    
    public class ButtonManager {

        
        
        private static javax.swing.JButton checkedBton;
        private static javax.swing.JButton cleanBaggageBton;
        private static javax.swing.JButton carryOnBton;

        public static void setButtons(javax.swing.JButton checkedBton, javax.swing.JButton cleanBaggageBton, javax.swing.JButton carryOnBton) {
            ButtonManager.checkedBton = checkedBton;
            ButtonManager.cleanBaggageBton = cleanBaggageBton;
            ButtonManager.carryOnBton = carryOnBton;
        }

        public static void enableButtons(boolean enable) {
            if (checkedBton != null && cleanBaggageBton != null && carryOnBton != null) {
                checkedBton.setEnabled(enable);
                cleanBaggageBton.setEnabled(enable);
                carryOnBton.setEnabled(enable);
            }
        }
    }
   public static void updateBaggageLabel(JLabel etiquetaEquipaje, String baggageId, String baggageType, int baggageWeight) {
       
        String texto = String.format("<html><b>%s</b><br>Tipo: %s<br>Peso: %d kg</html>", baggageId, baggageType, baggageWeight);
       
        etiquetaEquipaje.setText(texto);
        
    }
   
   public  void updateBaggageLabels(int ticketId, JLabel baggageLabel1, JLabel baggageLabel2) {
    try {
        Document filter = new Document("Ticket ID", ticketId);
        Document ticket = ticketCollection.find(filter).first();

        if (ticket != null) {
            List<Document> baggages = (List<Document>) ticket.get("Equipaje");

            if (baggages != null) {
               
                baggageLabel1.setText("");
                baggageLabel2.setText("");

                 
                if (baggages.size() > 0) {
                    Document baggage1 = baggages.get(0);
                    String baggageId1 = baggage1.getString("Baggage ID");
                    String baggageType1 = baggage1.getString("Baggage Type");
                    int baggageSize1 = baggage1.getInteger("Baggage Size");

                    updateBaggageLabel(baggageLabel2, baggageId1, baggageType1, baggageSize1);
                   
                }
                if (baggages.size() > 1) {
                    Document baggage2 = baggages.get(1);
                    String baggageId2 = baggage2.getString("Baggage ID");
                    String baggageType2 = baggage2.getString("Baggage Type");
                    int baggageSize2 = baggage2.getInteger("Baggage Size");

                    updateBaggageLabel(baggageLabel1, baggageId2, baggageType2, baggageSize2);
                }
            }
        }
    } catch (Exception e) {
        logger.log(Level.SEVERE, "Error al actualizar los labels de equipaje", e);
    }
}
   
   
   public static void insertWeigthBaggagePanel (String baggageType , int BaggageCounter ){
       
         if (BaggageCounter >= 2) {

           JOptionPane.showMessageDialog(null,"No se pueden añadir más maletas. Ya se han añadido 2 maletas.","Límite Alcanzado",JOptionPane.INFORMATION_MESSAGE);
            return;
        }
       
            JFrame newFrame = new JFrame("WeightBaggagePanel");
        newFrame.setResizable(false);
        newFrame.setSize(700, 500);
        newFrame.setLocationRelativeTo(null);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        WeigthBaggagePanel weightPanel = new WeigthBaggagePanel(baggageType);

        newFrame.add(weightPanel);

        newFrame.setVisible(true);
   }
}
