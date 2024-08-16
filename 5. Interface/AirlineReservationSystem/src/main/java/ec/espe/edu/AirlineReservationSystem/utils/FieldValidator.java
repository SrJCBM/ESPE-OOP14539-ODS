
package ec.espe.edu.AirlineReservationSystem.utils;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */
public class FieldValidator {

    public static boolean validateTicketFields(JSpinner ticketsNumberSpn, JTextField userNameTxt, JTextField flightIdTxt, JComboBox<String> cmbClass, Component parentComponent) {
        int ticketNumber = (int) ticketsNumberSpn.getValue();
        String customerName = userNameTxt.getText().trim();
        String flightId = flightIdTxt.getText().trim();
        String ticketClass = cmbClass.getSelectedItem().toString().trim();

        if (ticketNumber == 0 || customerName.isEmpty() || flightId.isEmpty() || ticketClass.isEmpty()) {
            JOptionPane.showMessageDialog(parentComponent, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!customerName.matches("[A-Za-z ]+")) {
            JOptionPane.showMessageDialog(parentComponent, "El nombre solo puede contener letras y espacios.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (!flightId.matches("\\d+")) {
            JOptionPane.showMessageDialog(parentComponent, "El ID del vuelo solo puede contener dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
}
