/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.view;

import ec.espe.edu.AirlineReservationSystem.controller.FlightController;
import ec.espe.edu.AirlineReservationSystem.model.Flight;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */
public class FrmCreateFlight extends javax.swing.JFrame {

    /**
     * Creates new form FrmCreateFlight
     */
    public FrmCreateFlight() {
        initComponents();
    }
public JPanel getCreateFlight() {
        return background;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ArrivalDate = new javax.swing.JLabel();
        Origin = new javax.swing.JLabel();
        Destination = new javax.swing.JLabel();
        Airline = new javax.swing.JLabel();
        DepartureDate = new javax.swing.JLabel();
        cmbOrigin = new javax.swing.JComboBox<>();
        cmbDestination = new javax.swing.JComboBox<>();
        jDateDeparture = new com.toedter.calendar.JDateChooser();
        jDateArrival = new com.toedter.calendar.JDateChooser();
        txtAirline = new javax.swing.JTextField();
        btnCreate = new javax.swing.JToggleButton();
        btnBack = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Crear Vuelo");
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 230, 40));

        ArrivalDate.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        ArrivalDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ArrivalDate.setText("Fecha de Llegada:");
        background.add(ArrivalDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, 20));

        Origin.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        Origin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Origin.setText("Origen:");
        background.add(Origin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 60, 20));

        Destination.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        Destination.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Destination.setText("Destino:");
        background.add(Destination, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, 20));

        Airline.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        Airline.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Airline.setText("Aerolínea:");
        background.add(Airline, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, -1, 20));

        DepartureDate.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        DepartureDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DepartureDate.setText("Fecha de Salida:");
        background.add(DepartureDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, -1, 20));

        cmbOrigin.setForeground(new java.awt.Color(204, 204, 204));
        cmbOrigin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ciudad", "Quito  ", "Guayaquil  ", "Cuenca  ", "Manta  ", "Esmeraldas  ", "Santa Rosa  ", "Latacunga  ", "Loja  ", "Tena  ", "Galápagos (Baltra)  ", "Galápagos (San Cristóbal)" }));
        background.add(cmbOrigin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 180, 40));

        cmbDestination.setForeground(new java.awt.Color(204, 204, 204));
        cmbDestination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ciudad", "Quito  ", "Guayaquil  ", "Cuenca  ", "Manta  ", "Esmeraldas  ", "Santa Rosa  ", "Latacunga  ", "Loja  ", "Tena  ", "Galápagos (Baltra)  ", "Galápagos (San Cristóbal)" }));
        cmbDestination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDestinationActionPerformed(evt);
            }
        });
        background.add(cmbDestination, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 180, 40));
        background.add(jDateDeparture, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 190, 30));
        background.add(jDateArrival, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 200, 30));

        txtAirline.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        txtAirline.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        background.add(txtAirline, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 220, 40));

        btnCreate.setBackground(new java.awt.Color(157, 117, 185));
        btnCreate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCreate.setForeground(new java.awt.Color(255, 255, 255));
        btnCreate.setText("CREAR");
        btnCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCreateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCreateMouseExited(evt);
            }
        });
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });
        background.add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 120, 40));

        btnBack.setBackground(new java.awt.Color(157, 117, 185));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("REGRESAR");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        background.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbDestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDestinationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDestinationActionPerformed

    private void btnCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateMouseClicked

    }//GEN-LAST:event_btnCreateMouseClicked

    private void btnCreateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateMouseEntered
        btnCreate.setBackground(new Color(173, 129, 204));
    }//GEN-LAST:event_btnCreateMouseEntered

    private void btnCreateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateMouseExited
        btnCreate.setBackground(new Color(157, 117, 185));
    }//GEN-LAST:event_btnCreateMouseExited

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        try {
            String origin = cmbOrigin.getSelectedItem().toString();
            String destination = cmbDestination.getSelectedItem().toString();
            String airline = txtAirline.getText();
            Date departureDate = jDateDeparture.getDate();
            Date arrivalDate = jDateArrival.getDate();

            if (origin.equals("País") || destination.equals("País") || airline.isEmpty() || departureDate == null || arrivalDate == null) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Flight flight = new Flight();
            flight.setOrigin(origin);
            flight.setDestination(destination);
            flight.setAirline(airline);
            flight.setDepartureDate(departureDate);
            flight.setArrivalDate(arrivalDate);

            FlightController flightController = new FlightController();
            String flightId = flightController.saveFlight(flight);
            //flightController.saveFlight(flight);

            JOptionPane.showMessageDialog(this, "Vuelo creado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            cmbOrigin.setSelectedIndex(0);
            cmbDestination.setSelectedIndex(0);
            txtAirline.setText("");
            jDateDeparture.setDate(null);
            jDateArrival.setDate(null);

        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al crear el vuelo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackMouseExited

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        FrmAirlineReservationSystem frmAirlineReservationSystem = new FrmAirlineReservationSystem();
        this.setVisible(false);
        frmAirlineReservationSystem.setVisible(true);

    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCreateFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCreateFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCreateFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCreateFlight.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCreateFlight().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Airline;
    private javax.swing.JLabel ArrivalDate;
    private javax.swing.JLabel DepartureDate;
    private javax.swing.JLabel Destination;
    private javax.swing.JLabel Origin;
    private javax.swing.JPanel background;
    private javax.swing.JToggleButton btnBack;
    private javax.swing.JToggleButton btnCreate;
    private javax.swing.JComboBox<String> cmbDestination;
    private javax.swing.JComboBox<String> cmbOrigin;
    private com.toedter.calendar.JDateChooser jDateArrival;
    private com.toedter.calendar.JDateChooser jDateDeparture;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtAirline;
    // End of variables declaration//GEN-END:variables
}
