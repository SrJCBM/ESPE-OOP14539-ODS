
package ec.espe.edu.AirlineReservationSystem.utils;

import ec.espe.edu.AirlineReservationSystem.controller.AdUsuariosController;
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
public class UserTableManager {

    private JTable usuariosTable;
    private AdUsuariosController usuariosController;

    public UserTableManager(JTable usuariosTable) {
        this.usuariosTable = usuariosTable;
        this.usuariosController = new AdUsuariosController();
        populateUsuariosTable();
        configureActionColumn();
        usuariosTable.setRowHeight(40);
    }

    private void populateUsuariosTable() {
        DefaultTableModel model = (DefaultTableModel) usuariosTable.getModel();
        List<Document> usuarios = usuariosController.getUsuarios();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        model.setRowCount(0);

        for (Document usuario : usuarios) {
            Object[] row = new Object[10];
            row[0] = usuario.getString("id");
            row[1] = usuario.getString("name");
            row[2] = usuario.getString("email");
            row[3] = usuario.getString("phoneNumber");
            row[4] = usuario.getString("city");
            row[5] = usuario.getString("state");
            row[6] = usuario.getString("postalCode");
            row[7] = usuario.getDate("dateOfBirth") != null ? dateFormat.format(usuario.getDate("dateOfBirth")) : null;
            row[8] = usuario.getString("gender");

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));

            JButton btnUpdate = new JButton("Actualizar");
            JButton btnDelete = new JButton("Eliminar");

            btnUpdate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateUser(row);
                }
            });

            btnDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    deleteUser(row);
                }
            });

            buttonPanel.add(btnUpdate);
            buttonPanel.add(btnDelete);
            row[9] = buttonPanel;

            model.addRow(row);
        }
    }

    private void updateUser(Object[] row) {
        String userId = (String) row[0];
        String newName = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre:", row[1]);
        String newEmail = JOptionPane.showInputDialog(null, "Ingrese el email:", row[2]);
        String newPhoneNumber = JOptionPane.showInputDialog(null, "Ingrese el nuevo número de teléfono:", row[3]);
        String newCity = JOptionPane.showInputDialog(null, "Ingrese la nueva ciudad:", row[4]);
        String newState = JOptionPane.showInputDialog(null, "Ingrese la nueva provincia:", row[5]);
        String newPostalCode = JOptionPane.showInputDialog(null, "Ingrese el nuevo código postal:", row[6]);
        String newDateOfBirthStr = JOptionPane.showInputDialog(null, "Ingrese la nueva fecha de nacimiento (yyyy-MM-dd):", row[7]);
        String newGender = JOptionPane.showInputDialog(null, "Ingrese el nuevo género:", row[8]);

        if (newName != null && newEmail != null && newPhoneNumber != null
                && newCity != null && newState != null && newPostalCode != null
                && newDateOfBirthStr != null && newGender != null) {
            try {
                Date newDateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(newDateOfBirthStr);
                boolean success = usuariosController.updateUser(userId, newName, newEmail, newPhoneNumber, newCity, newState, newPostalCode, newDateOfBirth, newGender);

                if (success) {
                    JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.");
                    populateUsuariosTable();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el usuario.");
                }
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido.");
            }
        }
    }

    private void deleteUser(Object[] row) {
        String userId = (String) row[0];
        int response = JOptionPane.showConfirmDialog(null,
                "¿Estás segura de que quieres eliminar el usuario con ID: " + userId + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            boolean success = usuariosController.deleteUser(userId);

            if (success) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
                populateUsuariosTable();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario.");
            }
        }
    }

    private void configureActionColumn() {
        TableColumn actionColumn = usuariosTable.getColumnModel().getColumn(9);
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
}