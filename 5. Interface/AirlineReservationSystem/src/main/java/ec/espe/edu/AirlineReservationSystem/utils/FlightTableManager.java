package ec.espe.edu.AirlineReservationSystem.utils;

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
public class FlightTableManager {

    private JTable vuelosTable;
    private AdFlightsController flightsController;

    public FlightTableManager(JTable vuelosTable) {
        this.vuelosTable = vuelosTable;
        this.flightsController = new AdFlightsController();
        populateFlightsTable();
        configureActionColumn();
        vuelosTable.setRowHeight(40);
    }

    private void populateFlightsTable() {
        DefaultTableModel model = (DefaultTableModel) vuelosTable.getModel();
        model.setRowCount(0);

        List<Document> flights = flightsController.getFlights();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (Document flight : flights) {
            if (flight != null && flight.size() > 0) {
                Object[] row = new Object[7];
                row[0] = flight.getString("flightID");
                row[1] = flight.getString("airline");
                row[2] = flight.getString("origin");
                row[3] = flight.getString("destination");
                row[4] = formatDate(flight.getDate("departureDate"), dateFormat);
                row[5] = formatDate(flight.getDate("arrivalDate"), dateFormat);

                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

                JButton btnUpdate = new JButton("Actualizar");
                JButton btnDelete = new JButton("Eliminar");

                btnUpdate.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateFlight(row);
                    }
                });

                btnDelete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        deleteFlight(row);
                    }
                });

                buttonPanel.add(btnUpdate);
                buttonPanel.add(btnDelete);
                row[6] = buttonPanel;
                model.addRow(row);
            }
        }
    }

    private String formatDate(Date date, SimpleDateFormat dateFormat) {
        return date != null ? dateFormat.format(date) : "";
    }

    private void configureActionColumn() {
        TableColumn actionColumn = vuelosTable.getColumnModel().getColumn(6);
        actionColumn.setCellRenderer(new ButtonRenderer());
        actionColumn.setCellEditor(new ButtonEditor(new JCheckBox(), vuelosTable, flightsController));
        actionColumn.setPreferredWidth(200);
    }

    private void updateFlight(Object[] row) {
        String flightID = (String) row[0];
        String newAirline = JOptionPane.showInputDialog(null, "Ingrese la nueva aerolínea:", row[1]);
        String newOrigin = JOptionPane.showInputDialog(null, "Ingrese el nuevo origen:", row[2]);
        String newDestination = JOptionPane.showInputDialog(null, "Ingrese el nuevo destino:", row[3]);
        String newDepartureDateStr = JOptionPane.showInputDialog(null, "Ingrese el nuevo día de salida (yyyy-MM-dd HH:mm:ss):", row[4]);
        String newArrivalDateStr = JOptionPane.showInputDialog(null, "Ingrese el nuevo día de llegada (yyyy-MM-dd HH:mm:ss):", row[5]);

        if (newAirline != null && newOrigin != null && newDestination != null
                && newDepartureDateStr != null && newArrivalDateStr != null) {
            try {
                Date newDepartureDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(newDepartureDateStr);
                Date newArrivalDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(newArrivalDateStr);
                boolean success = flightsController.updateFlight(flightID, newAirline, newOrigin, newDestination, newDepartureDate, newArrivalDate);

                if (success) {
                    JOptionPane.showMessageDialog(null, "Vuelo actualizado correctamente.");
                    populateFlightsTable();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el vuelo.");
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido.");
            }
        }
    }

    private void deleteFlight(Object[] row) {
        String flightID = (String) row[0];
        int response = JOptionPane.showConfirmDialog(null,
                "¿Estás seguro de que quieres eliminar el vuelo con ID: " + flightID + "?",
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

        public ButtonEditor(JCheckBox checkBox, JTable vuelosTable1, AdFlightsController flightsController1) {
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
}
