/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.AirlineReservationSystem.utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Joffre
 */
public class CustomOptionPane {
    
    public static void showCustomDialog(Component parentComponent, String message) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255)); // Fondo blanco
        panel.setBorder(BorderFactory.createLineBorder(new Color(41, 128, 185), 2)); // Borde azul
        panel.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel(message);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        messageLabel.setForeground(new Color(44, 62, 80)); // Texto gris oscuro
        messageLabel.setHorizontalAlignment(JLabel.CENTER);
        messageLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espaciado interno

        panel.add(messageLabel, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(parentComponent, panel, "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }
}