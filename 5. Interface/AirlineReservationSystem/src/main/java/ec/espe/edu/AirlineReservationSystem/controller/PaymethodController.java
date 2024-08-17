/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.controller;

import ec.espe.edu.AirlineReservationSystem.view.PayMethod;

/**
 *
 * @author Joffre
 */
public class PaymethodController {
    public void paymethodUtilizate(){
        PayMethod payMethodDialog = new PayMethod();
        payMethodDialog.setLocationRelativeTo(null);
            payMethodDialog.setVisible(true);
    }
}
