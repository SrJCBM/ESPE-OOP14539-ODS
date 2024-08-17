/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.utils;

import javax.swing.JLabel;

/**
 *
 * @author Joffre
 */
public class ButtonBaggageManager {
 
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
   public static void updateEquipajeLabel(JLabel etiquetaEquipaje, String baggageId, String baggageType, int baggageWeight) {
       
        String texto = String.format("<html><b>%s</b><br>Tipo: %s<br>Peso: %d kg</html>", baggageId, baggageType, baggageWeight);
       
        etiquetaEquipaje.setText(texto);
        
    }
}
