package ec.espe.edu.AirlineReservationSystem.view;

import ec.espe.edu.AirlineReservationSystem.controller.AdTicketsController;
import ec.espe.edu.AirlineReservationSystem.controller.PrintoutController;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.bson.Document;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */
public class FrmAdTickets extends javax.swing.JFrame {

    private AdTicketsController ticketController;

    public FrmAdTickets() {
        initComponents();
        ticketController = new AdTicketsController();
        populateTicketsTable();
        configureActionColumn();
        TicketsTable.setRowHeight(40);
    }

    public JPanel getTicketsPanel() {
        return Background;
    }

    private void populateTicketsTable() {
        DefaultTableModel model = (DefaultTableModel) TicketsTable.getModel();
        model.setRowCount(0);

        List<Document> tickets = ticketController.getTickets();

        for (Document ticket : tickets) {
            if (ticket != null && ticket.size() > 0) {
                Object[] row = new Object[6];
                row[0] = ticket.getInteger("Number of Ticket");
                row[1] = ticket.getInteger("Ticket ID");
                row[2] = ticket.getString("Customer Name");
                row[3] = ticket.getInteger("Id Flight");
                row[4] = ticket.getString("Ticket Class");

                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

                JButton btnUpdate = new JButton("Actualizar");
                JButton btnDelete = new JButton("Eliminar");

                btnUpdate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int ticketId = (Integer) row[1];
                        String customerName = (String) row[2];
                        int idFlight = (Integer) row[3];
                        String ticketClass = (String) row[4];
                        String newCustomerName = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del Usuario:", customerName);
                        String newTicketClass = JOptionPane.showInputDialog(null, "Ingrese la nueva clase:", ticketClass);
                        String idFlightStr = JOptionPane.showInputDialog(null, "Ingrese el nuevo ID del vuelo:", idFlight);

                        if (newCustomerName != null && newTicketClass != null && idFlightStr != null) {
                            try {
                                int newIdFlight = Integer.parseInt(idFlightStr);
                                boolean success = ticketController.updateTicket(ticketId, newCustomerName, newIdFlight, newTicketClass);

                                if (success) {
                                    JOptionPane.showMessageDialog(null, "Ticket actualizado correctamente.");
                                    populateTicketsTable();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Failed to update ticket.");
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Invalid input for flight ID.");
                            }
                        }
                    }
                });

                btnDelete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int ticketId = (Integer) row[1];
                        int response = JOptionPane.showConfirmDialog(null,
                                "¿Estás segura de que quieres eliminar el Ticket con ID: " + ticketId + "?",
                                "Confitmar eliminación",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            boolean success = ticketController.deleteTicket(ticketId);

                            if (success) {
                                JOptionPane.showMessageDialog(null, "Ticket eliminado correctamente.");
                                populateTicketsTable();
                            } else {
                                JOptionPane.showMessageDialog(null, "Failed to delete ticket.");
                            }
                        }
                    }
                });

                buttonPanel.add(btnUpdate);
                buttonPanel.add(btnDelete);
                row[5] = buttonPanel;

                model.addRow(row);
            }
        }
    }

    private void configureActionColumn() {
        TableColumn actionColumn = TicketsTable.getColumnModel().getColumn(5);
        actionColumn.setCellRenderer(new ButtonRenderer());
        actionColumn.setCellEditor(new ButtonEditor(new JCheckBox()));
        actionColumn.setPreferredWidth(150);
    }

    class ButtonRenderer extends JPanel implements TableCellRenderer {

        public ButtonRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            removeAll();
            if (value instanceof JPanel) {
                add((JPanel) value);
            }
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private JPanel panel;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            panel.removeAll();
            if (value instanceof JPanel) {
                panel.add((JPanel) value);
            }
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }

        @Override
        public boolean stopCellEditing() {
            return super.stopCellEditing();
        }
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
        arstxt = new javax.swing.JLabel();
        txtTickets = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TicketsTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPrintTickets = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Imagelogotxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/airline company icon .jpg"))); // NOI18N
        Imagelogotxt.setText("jLabel1");
        jPanel1.add(Imagelogotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 160, 130));

        arstxt.setFont(new java.awt.Font("Engravers MT", 0, 14)); // NOI18N
        arstxt.setForeground(new java.awt.Color(255, 255, 255));
        arstxt.setText("Airline Reservation System");
        jPanel1.add(arstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 300, 50));

        txtTickets.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        txtTickets.setForeground(new java.awt.Color(255, 255, 255));
        txtTickets.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTickets.setText("Tickets");
        jPanel1.add(txtTickets, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 78));

        lblDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/fondo.jpeg"))); // NOI18N
        lblDate.setText("jLabel1");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 930, -1));

        Background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 150));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setText("Tickets Registrados:");
        Background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        TicketsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Number Of Ticket", "Ticket ID", "Nombre del Cliente", "Flight ID", "Ticket Class", "Actions"
            }
        ));
        jScrollPane1.setViewportView(TicketsTable);

        Background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 780, 120));

        jLabel4.setText("(C) Overnight Developerr Squad - ODS");
        Background.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 430, -1, -1));

        jLabel5.setText("(R) Overnight Developer Squad");
        Background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, -1, -1));

        btnPrintTickets.setText("Print All Tickets");
        btnPrintTickets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintTicketsMouseClicked(evt);
            }
        });
        btnPrintTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintTicketsActionPerformed(evt);
            }
        });
        Background.add(btnPrintTickets, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, -1, -1));

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

    private void btnPrintTicketsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintTicketsMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar PDF");
        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf";
            }
            List<Document> tickets = ticketController.getTickets();
            PrintoutController printoutcontroller = new PrintoutController();
            printoutcontroller.createPdf(filePath, tickets);
        }
    }//GEN-LAST:event_btnPrintTicketsMouseClicked

    private void btnPrintTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintTicketsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintTicketsActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAdTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdTickets.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAdTickets().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JLabel Imagelogotxt;
    private javax.swing.JTable TicketsTable;
    private javax.swing.JLabel arstxt;
    private javax.swing.JButton btnPrintTickets;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel txtTickets;
    // End of variables declaration//GEN-END:variables
}
