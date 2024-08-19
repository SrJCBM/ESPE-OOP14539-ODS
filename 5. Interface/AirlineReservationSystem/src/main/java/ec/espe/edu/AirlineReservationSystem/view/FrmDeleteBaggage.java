/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.view;

import ec.espe.edu.AirlineReservationSystem.controller.BaggageController;
import ec.espe.edu.AirlineReservationSystem.utils.ButtonBaggageManager;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Joffre
 */
public class FrmDeleteBaggage extends javax.swing.JFrame {
    
    int ticketId = BaggageController.getTicketId();
    /**
     * Creates new form FrmDeleteBaggage
     */
    public FrmDeleteBaggage() {
        initComponents();
        
     BaggageController.DeleteBaggageActivate(Baggage2Panel);
     BaggageController.AdministrateBaggagePanel(ticketId, Baggage2Panel);
     
        ButtonBaggageManager manager = new ButtonBaggageManager ();
        
        manager.updateBaggageLabels(ticketId, BaggageLbel2, BaggageLbel1);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        background = new javax.swing.JPanel();
        arstxt = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Baggage1Panel = new javax.swing.JPanel();
        Baggage1Bton = new javax.swing.JButton();
        BaggageLbel1 = new javax.swing.JLabel();
        Baggage2Panel = new javax.swing.JPanel();
        Baggage2Bton = new javax.swing.JButton();
        BaggageLbel2 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setRequestFocusEnabled(false);
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        arstxt.setFont(new java.awt.Font("Engravers MT", 0, 14)); // NOI18N
        arstxt.setForeground(new java.awt.Color(255, 255, 255));
        arstxt.setText("Airline Reservation System");
        background.add(arstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 300, 50));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/fondo.jpeg"))); // NOI18N
        background.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 48));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/equipaje-de-viaje.png"))); // NOI18N
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 160, 140));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/airline company icon .jpg"))); // NOI18N
        background.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 150, 140));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel3.setText("Elija el equipaje a eliminar");
        background.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 350, 110));

        jLabel4.setText("(C) Overnight Developerr Squad - ODS");
        background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, -1));

        jLabel5.setText("(R) Overnight Developer Squad");
        background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        Baggage1Panel.setBackground(new java.awt.Color(255, 255, 255));
        Baggage1Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Baggage1Bton.setBackground(new java.awt.Color(255, 0, 0));
        Baggage1Bton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Baggage1Bton.setForeground(new java.awt.Color(255, 255, 255));
        Baggage1Bton.setText("Eliminar");
        Baggage1Bton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Baggage1BtonActionPerformed(evt);
            }
        });

        BaggageLbel1.setBackground(new java.awt.Color(204, 255, 204));
        BaggageLbel1.setText("jLabel6");

        javax.swing.GroupLayout Baggage1PanelLayout = new javax.swing.GroupLayout(Baggage1Panel);
        Baggage1Panel.setLayout(Baggage1PanelLayout);
        Baggage1PanelLayout.setHorizontalGroup(
            Baggage1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Baggage1PanelLayout.createSequentialGroup()
                .addComponent(BaggageLbel1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Baggage1Bton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Baggage1PanelLayout.setVerticalGroup(
            Baggage1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Baggage1Bton, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
            .addComponent(BaggageLbel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        background.add(Baggage1Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 380, 100));

        Baggage2Panel.setBackground(new java.awt.Color(255, 255, 255));
        Baggage2Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        Baggage2Bton.setBackground(new java.awt.Color(255, 0, 0));
        Baggage2Bton.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        Baggage2Bton.setForeground(new java.awt.Color(255, 255, 255));
        Baggage2Bton.setText("Eliminar");
        Baggage2Bton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Baggage2BtonActionPerformed(evt);
            }
        });

        BaggageLbel2.setBackground(new java.awt.Color(255, 255, 204));
        BaggageLbel2.setText("Bgg");

        javax.swing.GroupLayout Baggage2PanelLayout = new javax.swing.GroupLayout(Baggage2Panel);
        Baggage2Panel.setLayout(Baggage2PanelLayout);
        Baggage2PanelLayout.setHorizontalGroup(
            Baggage2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Baggage2PanelLayout.createSequentialGroup()
                .addComponent(BaggageLbel2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Baggage2Bton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Baggage2PanelLayout.setVerticalGroup(
            Baggage2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Baggage2Bton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
            .addComponent(BaggageLbel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        background.add(Baggage2Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 380, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Baggage1BtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Baggage1BtonActionPerformed
      
  BaggageController baggageController = new BaggageController();


    baggageController.deleteBaggage(ticketId, 1);

   
    ButtonBaggageManager manager = new ButtonBaggageManager();
    manager.updateBaggageLabels(ticketId, BaggageLbel2, BaggageLbel1);

       BaggageController.DeleteBaggageActivate(Baggage2Panel);

   ButtonBaggageManager.closeWindowBaggageToEliminate(ticketId, Baggage1Bton);
        
    }//GEN-LAST:event_Baggage1BtonActionPerformed

    private void Baggage2BtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Baggage2BtonActionPerformed
    
   BaggageController baggageController = new BaggageController();


    baggageController.deleteBaggage(ticketId, 2);

   
    ButtonBaggageManager manager = new ButtonBaggageManager();
    manager.updateBaggageLabels(ticketId, BaggageLbel2, BaggageLbel1);

       BaggageController.DeleteBaggageActivate(Baggage2Panel);

    ButtonBaggageManager.closeWindowBaggageToEliminate(ticketId, Baggage2Bton);
    }//GEN-LAST:event_Baggage2BtonActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDeleteBaggage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDeleteBaggage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDeleteBaggage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDeleteBaggage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDeleteBaggage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Baggage1Bton;
    private javax.swing.JPanel Baggage1Panel;
    private javax.swing.JButton Baggage2Bton;
    private javax.swing.JPanel Baggage2Panel;
    private javax.swing.JLabel BaggageLbel1;
    private javax.swing.JLabel BaggageLbel2;
    private javax.swing.JLabel arstxt;
    private javax.swing.JPanel background;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
