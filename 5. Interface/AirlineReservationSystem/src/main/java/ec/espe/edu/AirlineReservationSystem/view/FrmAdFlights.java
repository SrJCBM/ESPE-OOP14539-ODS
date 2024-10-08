package ec.espe.edu.AirlineReservationSystem.view;

import ec.espe.edu.AirlineReservationSystem.controller.AdFlightsController;
import ec.espe.edu.AirlineReservationSystem.controller.PrintoutFlightController;
import ec.espe.edu.AirlineReservationSystem.utils.FlightTableManager;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.bson.Document;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */
public class FrmAdFlights extends javax.swing.JFrame {

    private FlightTableManager tableManager;

    public FrmAdFlights() {
        initComponents();
        tableManager = new FlightTableManager(VuelosTable);
    }

    public JPanel getFlightsPanel() {
        return Background;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Imagelogotxt = new javax.swing.JLabel();
        txtVuelos = new javax.swing.JLabel();
        arstxt = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        VuelosTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PrintFlightsbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Imagelogotxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/airline company icon .jpg"))); // NOI18N
        Imagelogotxt.setText("jLabel1");
        jPanel1.add(Imagelogotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 160, 130));

        txtVuelos.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        txtVuelos.setForeground(new java.awt.Color(255, 255, 255));
        txtVuelos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtVuelos.setText("Vuelos");
        jPanel1.add(txtVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 78));

        arstxt.setFont(new java.awt.Font("Engravers MT", 0, 14)); // NOI18N
        arstxt.setForeground(new java.awt.Color(255, 255, 255));
        arstxt.setText("Airline Reservation System");
        jPanel1.add(arstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 300, 50));

        lblDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/fondo.jpeg"))); // NOI18N
        lblDate.setText("jLabel1");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 930, -1));

        Background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 140));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("Vuelos Registrados:");
        Background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, 30));

        VuelosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Flight ID", "Airline", "Origin", "Destination", "Departure Date", "Arrival Date", "Actions"
            }
        ));
        jScrollPane1.setViewportView(VuelosTable);

        Background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 840, 150));

        jLabel4.setText("(C) Overnight Developerr Squad - ODS");
        Background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, -1, -1));

        jLabel5.setText("(R) Overnight Developer Squad");
        Background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 430, -1, -1));

        PrintFlightsbtn.setText("Imprimir");
        PrintFlightsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrintFlightsbtnActionPerformed(evt);
            }
        });
        Background.add(PrintFlightsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PrintFlightsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrintFlightsbtnActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }

            AdFlightsController flightController = new AdFlightsController();
            List<Document> flights = flightController.getFlights();

            PrintoutFlightController printoutController = new PrintoutFlightController();
            printoutController.createPdf(filePath, flights);
            JOptionPane.showMessageDialog(this, "PDF generado con éxito.");
            flightController.close();
        }

    }//GEN-LAST:event_PrintFlightsbtnActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAdFlights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdFlights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdFlights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdFlights.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdFlights().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JLabel Imagelogotxt;
    private javax.swing.JButton PrintFlightsbtn;
    private javax.swing.JTable VuelosTable;
    private javax.swing.JLabel arstxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel txtVuelos;
    // End of variables declaration//GEN-END:variables
}
