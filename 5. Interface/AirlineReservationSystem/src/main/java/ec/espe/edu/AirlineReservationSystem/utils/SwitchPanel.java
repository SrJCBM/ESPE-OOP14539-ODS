/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.utils;

import static ec.espe.edu.AirlineReservationSystem.view.FrmAirlineReservationSystem.content;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Joffre
 */
public class SwitchPanel {
    
    public static void switchPanel(JPanel newPanel) {
   
    newPanel.setSize(920, 580);
    newPanel.setLocation(0, 0);

   
    content.removeAll();

  
    content.add(newPanel, BorderLayout.CENTER);

   
    content.revalidate();
    content.repaint();
}
}
