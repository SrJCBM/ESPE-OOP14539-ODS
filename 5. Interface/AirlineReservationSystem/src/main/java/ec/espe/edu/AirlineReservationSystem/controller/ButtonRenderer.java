package ec.espe.edu.AirlineReservationSystem.controller;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

/**
 *
 * @author Kerlly Chiriboga, ODS
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
        setBorderPainted(false);
        setFocusPainted(false);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JPanel) {
            JPanel panel = (JPanel) value;
            setPreferredSize(panel.getPreferredSize());
            return panel;
        }
        return this;
    }
}
