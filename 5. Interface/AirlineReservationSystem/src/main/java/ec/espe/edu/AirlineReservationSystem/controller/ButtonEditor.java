package ec.espe.edu.AirlineReservationSystem.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * Author: Kerlly Chiriboga, ODS
 */
public class ButtonEditor extends DefaultCellEditor {

    private JButton btnUpdate;
    private JButton btnDelete;
    private JPanel buttonPanel;
    private JTable table;
    private AdFlightsController flightsController;

    public ButtonEditor(JCheckBox checkBox, JTable table, AdFlightsController flightsController) {
        super(checkBox);
        this.table = table;
        this.flightsController = flightsController;

        buttonPanel = new JPanel(new GridLayout(1, 2));

        btnUpdate = new JButton("Actualizar");
        btnDelete = new JButton("Eliminar");

        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    String flightID = (String) table.getValueAt(row, 0);
                    updateFlight(flightID);
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    String flightID = (String) table.getValueAt(row, 0);
                    int response = JOptionPane.showConfirmDialog(null,
                            "¿Estás seguro de que quieres eliminar el vuelo con ID: " + flightID + "?",
                            "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {
                        boolean success = flightsController.deleteFlight(flightID);
                        if (success) {
                            ((DefaultTableModel) table.getModel()).removeRow(row);
                            JOptionPane.showMessageDialog(null, "Vuelo eliminado correctamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo eliminar el vuelo.");
                        }
                    }
                }
            }
        });
    }

    private void updateFlight(String flightID) {
        JOptionPane.showMessageDialog(null, "Funcionalidad de actualización para el vuelo ID: " + flightID);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        buttonPanel.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getWidth(), table.getRowHeight()));
        return buttonPanel;
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
