/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.view;

import ec.espe.edu.AirlineReservationSystem.controller.AdFlightsController;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import org.bson.Document;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */
public class FrmAdFlights extends javax.swing.JFrame {

    public FrmAdFlights() {
        initComponents();
        populateFlightsTable();
        configureActionColumn();
        VuelosTable.setRowHeight(40);
    }

    public JPanel getFlightsPanel() {
        return Background;
    }

    private void populateFlightsTable() {
        DefaultTableModel model = (DefaultTableModel) VuelosTable.getModel();
        model.setRowCount(0);

        AdFlightsController flightsController = new AdFlightsController();
        List<Document> flights = flightsController.getFlights();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (Document flight : flights) {
            if (flight != null && flight.size() > 0) {
                Object[] row = new Object[8];
                row[0] = flight.getString("flightID");
                row[1] = flight.getString("airline");
                row[2] = flight.getString("origin");
                row[3] = flight.getString("destination");
                row[4] = formatDate(flight.getDate("departureDate"), dateFormat);
                row[5] = formatDate(flight.getDate("arrivalDate"), dateFormat);

                Object priceObj = flight.get("price");
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

                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

                JButton btnUpdate = new JButton("Actualizar");
                JButton btnDelete = new JButton("Eliminar");

                btnUpdate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String flightID = (String) row[0];
                        String newAirline = JOptionPane.showInputDialog(null, "Ingrese la nueva aerolìnea:", row[1]);
                        String newOrigin = JOptionPane.showInputDialog(null, "Ingrese el nuevo origen:", row[2]);
                        String newDestination = JOptionPane.showInputDialog(null, "Ingrese el nuevo destino:", row[3]);
                        String newDepartureDateStr = JOptionPane.showInputDialog(null, "Ingrese el nuevo dia de salida (yyyy-MM-dd HH:mm:ss):", row[4]);
                        String newArrivalDateStr = JOptionPane.showInputDialog(null, "Ingrese el nuevo dia de llegada (yyyy-MM-dd HH:mm:ss):", row[5]);
                        String newPriceStr = JOptionPane.showInputDialog(null, "Ingrese el nuevo precio:", row[6]);

                        if (newAirline != null && newOrigin != null && newDestination != null
                                && newDepartureDateStr != null && newArrivalDateStr != null && newPriceStr != null) {
                            try {
                                Date newDepartureDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(newDepartureDateStr);
                                Date newArrivalDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(newArrivalDateStr);
                                double newPrice = Double.parseDouble(newPriceStr);
                                boolean success = flightsController.updateFlight(flightID, newAirline, newOrigin, newDestination, newDepartureDate, newArrivalDate, newPrice);

                                if (success) {
                                    JOptionPane.showMessageDialog(null, "Vuelo actualizado correctamente.");
                                    populateFlightsTable();
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el vuelo.");
                                }
                            } catch (ParseException | NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Formato de fecha o precio inválido.");
                            }
                        }
                    }
                });

                btnDelete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String flightID = (String) row[0];
                        int response = JOptionPane.showConfirmDialog(null,
                                "¿Estás segura de que quieres eliminar el vuelo con ID: " + flightID + "?",
                                "Confirmar eliminación",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.WARNING_MESSAGE);

                        if (response == JOptionPane.YES_OPTION) {
                            boolean success = flightsController.deleteFlight(flightID);

                            if (success) {
                                JOptionPane.showMessageDialog(null, "Vuelo eliminado correctamente.");
                                populateFlightsTable();
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pudo eliminar el vuelo.");
                            }
                        }
                    }
                });

                buttonPanel.add(btnUpdate);
                buttonPanel.add(btnDelete);
                row[7] = buttonPanel;
                model.addRow(row);
            }
        }
    }

    private String formatDate(Date date, SimpleDateFormat dateFormat) {
        return date != null ? dateFormat.format(date) : "";
    }

    private boolean isRowEmpty(Object[] row) {
        for (Object cell : row) {
            if (cell != null && !cell.toString().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void configureActionColumn() {
        TableColumn actionColumn = VuelosTable.getColumnModel().getColumn(7);
        actionColumn.setCellRenderer(new ButtonRenderer());
        actionColumn.setCellEditor(new ButtonEditor(new JCheckBox()));
        actionColumn.setPreferredWidth(200);
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
        txtVuelos = new javax.swing.JLabel();
        arstxt = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        VuelosTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Imagelogotxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/airline company icon .jpg"))); // NOI18N
        Imagelogotxt.setText("jLabel1");
        jPanel1.add(Imagelogotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 160, 130));

        txtVuelos.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        txtVuelos.setForeground(new java.awt.Color(255, 255, 255));
        txtVuelos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtVuelos.setText("Vuelos");
        jPanel1.add(txtVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 78));

        arstxt.setFont(new java.awt.Font("Engravers MT", 0, 14)); // NOI18N
        arstxt.setForeground(new java.awt.Color(255, 255, 255));
        arstxt.setText("Airline Reservation System");
        jPanel1.add(arstxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 300, 50));

        lblDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/espe/airlinereservationsystem/images/fondo.jpeg"))); // NOI18N
        lblDate.setText("jLabel1");
        jPanel1.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 930, -1));

        Background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 140));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Vuelos Registrados:");
        Background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        VuelosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Flight ID", "Airline", "Origin", "Destination", "Departure Date", "Arrival Date", "Price", "Actions"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(VuelosTable);
        if (VuelosTable.getColumnModel().getColumnCount() > 0) {
            VuelosTable.getColumnModel().getColumn(7).setResizable(false);
        }

        Background.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 840, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
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
    private javax.swing.JTable VuelosTable;
    private javax.swing.JLabel arstxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel txtVuelos;
    // End of variables declaration//GEN-END:variables
}
