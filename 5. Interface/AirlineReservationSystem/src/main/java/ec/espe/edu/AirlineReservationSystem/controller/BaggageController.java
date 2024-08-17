package ec.espe.edu.AirlineReservationSystem.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import org.bson.Document;

/**
 *
 * @author Joffre
 */
public class BaggageController {

    private static int ticketId;

    private static final String DATABASE_NAME = "TicketDataBase";
    private static final String TICKET_COLLECTION = "tickets";
    private static final String COUNTER_COLLECTION = "counters";
    private static final String COUNTER_NAME = "ticketId";

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> ticketCollection;
    private MongoCollection<Document> counterCollection;

    public BaggageController(int ticketId) {
        this.ticketId = ticketId;
    }
    public BaggageController() {
        
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
            TicketController ticketController = new TicketController();
            ticketController.updateTicketWithBaggage(ticketId, baggageType, weightValue);

            JOptionPane.showMessageDialog(component, "Peso confirmado: " + weightValue + " kilogramos", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(component, "El equipaje se ha añadido a su Ticket!", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(component,
                    "<html><body style='width: 300px;'>"
                    + "<p style='font-size: 14px;'>Por favor, proceda con el pago.</p>"
                    + "</body></html>",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

        }
      
      private void eliminarEquipaje(String baggageId, JDialog dialog) {
        int ticketId = BaggageController.getTicketId();
        TicketController controlador = new TicketController();
        controlador.removeBaggage(ticketId, baggageId);

        JOptionPane.showMessageDialog(null, baggageId + " eliminado exitosamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, " La devolucion del pago se ha reflejado a su cuenta.", "ATENCION", JOptionPane.INFORMATION_MESSAGE);

        dialog.dispose();
    }
      
    }

