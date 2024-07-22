/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.view;

import ec.espe.edu.AirlineReservationSystem.controller.OffersController;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

/**
 *
 * Author: Kerlly Chiriboga, ODS
 */
public class FrmOffers extends javax.swing.JFrame {

    /**
     * Creates new form FrmOffers
     */
    public FrmOffers() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel) tblOffers.getModel();
        model.addColumn("N°");
        model.addColumn("Origen");
        model.addColumn("Destino");
        model.addColumn("Aerolínea");
        model.addColumn("Fecha de Salida");
        model.addColumn("Fecha de Llegada");
        model.addColumn("Precio");
        populateOffersTable();
    }

    public JPanel getOffersPanel() {
        return BackGround;
    }

    private void populateOffersTable() {
        DefaultTableModel model = (DefaultTableModel) tblOffers.getModel();
        OffersController offersController = new OffersController();
        List<Document> offers = offersController.getOffers();

        for (Document offer : offers) {
            Object[] row = new Object[7];
            row[0] = offer.getInteger("N°"); 
            row[1] = offer.getString("origin");
            row[2] = offer.getString("destination");
            row[3] = offer.getString("airline");
            row[4] = offer.getString("departureDate");
            row[5] = offer.getString("arrivalDate");

            Object priceObj = offer.get("price");
            if (priceObj instanceof Double) {
                row[6] = (Double) priceObj;
            } else if (priceObj instanceof String) {
                try {
                    row[6] = Double.parseDouble((String) priceObj);
                } catch (NumberFormatException e) {
                    row[6] = null;
                }
            } else {
                row[6] = null; 
            }

            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        lblOffers = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOffers = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackGround.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOffers.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblOffers.setForeground(new java.awt.Color(255, 255, 255));
        lblOffers.setText("Ofertas de Temporada");
        BackGround.add(lblOffers, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(153, 51, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jScrollPane1.setForeground(new java.awt.Color(153, 51, 255));

        tblOffers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblOffers);

        BackGround.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 920, 170));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/fondo.jpeg"))); // NOI18N
        BackGround.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackGround, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmOffers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOffers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOffers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOffers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(FrmOffers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(FrmOffers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(FrmOffers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(FrmOffers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> {
        new FrmOffers().setVisible(true);
    });
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblOffers;
    private javax.swing.JTable tblOffers;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JPanel background;
}
