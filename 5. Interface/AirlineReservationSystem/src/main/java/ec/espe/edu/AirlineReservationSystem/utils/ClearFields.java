package ec.espe.edu.AirlineReservationSystem.utils;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */
public class ClearFields {

    public static void clearFieldsTicket(JSpinner ticketsNumberSpn, JTextField userNameTxt, JTextField flightIdTxt, JComboBox<String> cmbClass) {
        ticketsNumberSpn.setValue(0);
        userNameTxt.setText("");
        flightIdTxt.setText("");
        cmbClass.setSelectedIndex(0);
    }

    public static void clearFieldsFlight(JComboBox<String> cmbOrigin, JComboBox<String> cmbDestination, JTextField txtAirline, JDateChooser jDateDeparture, JDateChooser jDateArrival) {
        cmbOrigin.setSelectedIndex(0);
        cmbDestination.setSelectedIndex(0);
        txtAirline.setText("");
        jDateDeparture.setDate(null);
        jDateArrival.setDate(null);
    }

    public static void clearFieldsUser(JTextField idDocumentTxt, JTextField nameTxt, JTextField lastNameTxt, JTextField emailTxt, JTextField phoneTxt,
            JTextField usernameTxt, JPasswordField passwordTxt, JTextField cityTxt, JTextField stateTxt, JTextField zipTxt,
            JDateChooser jDateChooser1, JComboBox<String> gendercmb) {
        idDocumentTxt.setText("");
        nameTxt.setText("");
        lastNameTxt.setText("");
        emailTxt.setText("");
        phoneTxt.setText("");
        usernameTxt.setText("");
        passwordTxt.setText("");
        cityTxt.setText("");
        stateTxt.setText("");
        zipTxt.setText("");
        jDateChooser1.setDate(null);
        gendercmb.setSelectedIndex(0);
    }
}
