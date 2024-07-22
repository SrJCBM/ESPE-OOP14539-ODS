package ec.espe.edu.AirlineReservationSystem.controller;

import ec.espe.edu.AirlineReservationSystem.controller.AdTicketsController;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ButtonEditor extends DefaultCellEditor {

    private JButton btnUpdate;
    private JButton btnDelete;
    private JPanel buttonPanel;
    private JTable table;
    private AdTicketsController adTicketsController;

    public ButtonEditor(JCheckBox checkBox, JTable table) {
        super(checkBox);
        this.table = table;
        this.adTicketsController = adTicketsController;

        // Configura el panel de botones
        buttonPanel = new JPanel(new GridLayout(1, 2)); // Usa un GridLayout para hacer que los botones ocupen el mismo espacio

        // Configura los botones
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        // Añade los botones al panel
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        // Acción para el botón de actualización
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int ticketId = (Integer) table.getValueAt(row, 1); // Asumiendo que el Ticket ID está en la columna 1
                JOptionPane.showMessageDialog(null, "Update functionality for Ticket ID: " + ticketId);
                // Implementa la lógica de actualización aquí
                // Puedes abrir un formulario para actualizar el ticket
            }
        });

        // Acción para el botón de eliminación
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                int ticketId = (Integer) table.getValueAt(row, 1); // Asumiendo que el Ticket ID está en la columna 1
                int response = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete Ticket ID: " + ticketId + "?",
                        "Confirm Delete",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {
                    // Llama al método del controlador para eliminar el ticket
                    adTicketsController.deleteTicket(ticketId);
                    ((DefaultTableModel) table.getModel()).removeRow(row); // Elimina la fila de la tabla
                }
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // Configura el tamaño del panel de botones para que ocupe todo el espacio de la celda
        buttonPanel.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getWidth(), table.getRowHeight()));
        return buttonPanel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}