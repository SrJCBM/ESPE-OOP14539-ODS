/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.utils;

import ec.espe.edu.AirlineReservationSystem.view.WeigthBaggagePanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
