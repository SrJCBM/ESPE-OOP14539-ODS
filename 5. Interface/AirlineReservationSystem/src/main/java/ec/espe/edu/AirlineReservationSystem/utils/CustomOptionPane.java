/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.utils;

import ec.espe.edu.AirlineReservationSystem.view.FrmCustomOptionPane;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Joffre
 */
public class CustomOptionPane {
    
    
 public static int showCustomConfirmation(Component parent, String htmlMessage) {
        return JOptionPane.showOptionDialog(
            parent,
            htmlMessage,
            "Confirmación",
            JOptionPane.OK_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            new Object[] {"OK"},
            "OK"
        );
    }


  public static  void showCustomConfirmation(String confirmationText, String extraData) {
        
    FrmCustomOptionPane customPane = new FrmCustomOptionPane();
    
    customPane.setConfirmationText(confirmationText);
    customPane.setExtraData(extraData);
    
    customPane.setLocationRelativeTo(null);
    
  
    customPane.setVisible(true);
}
}