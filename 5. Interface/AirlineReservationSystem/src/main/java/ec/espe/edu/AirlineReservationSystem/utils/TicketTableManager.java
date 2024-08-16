package ec.espe.edu.AirlineReservationSystem.utils;

import ec.espe.edu.AirlineReservationSystem.controller.AdTicketsController;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class TicketTableManager {

    private AdTicketsController ticketController;
    private JTable ticketsTable;

    public TicketTableManager(AdTicketsController ticketController, JTable ticketsTable) {
        this.ticketController = ticketController;
        this.ticketsTable = ticketsTable;
        populateTicketsTable();
        configureActionColumn();
    }

    private void populateTicketsTable() {
        DefaultTableModel model = (DefaultTableModel) ticketsTable.getModel();
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

                JPanel buttonPanel = createButtonPanel(row);

                row[5] = buttonPanel;
                model.addRow(row);
            }
        }
    }

    private JPanel createButtonPanel(Object[] row) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

        JButton btnUpdate = new JButton("Actualizar");
        JButton btnDelete = new JButton("Eliminar");

        btnUpdate.addActionListener(createUpdateActionListener(row));
        btnDelete.addActionListener(createDeleteActionListener(row));

        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        return buttonPanel;
    }

    private ActionListener createUpdateActionListener(Object[] row) {
        return new ActionListener() {
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
        };
    }

    private ActionListener createDeleteActionListener(Object[] row) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ticketId = (Integer) row[1];
                int response = JOptionPane.showConfirmDialog(null,
                        "¿Estás seguro de que quieres eliminar el Ticket con ID: " + ticketId + "?",
                        "Confirmar eliminación",
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
        };
    }

    private void configureActionColumn() {
        TableColumn actionColumn = ticketsTable.getColumnModel().getColumn(5);
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
}
