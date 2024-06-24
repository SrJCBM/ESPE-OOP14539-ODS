/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.airlinereservationsystem.view;

import ec.edu.espe.airlinereservationsystem.model.Users;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.prefs.Preferences;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
/**
 * Autor: Joffre
 * Fecha: 2024-06-19
 * Descripción:
 */
public class Login {
 private Users[] users;

    public Login(Users[] users) {
        this.users = users;
    }

    public boolean authenticate(String username, String password) {
        for (Users user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean showLoginMenu() {
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JLabel forgotPasswordLabel = new JLabel("<html><u>Forgot your password?</u></html>");
        forgotPasswordLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        forgotPasswordLabel.setForeground(Color.BLUE.darker());
        forgotPasswordLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username = JOptionPane.showInputDialog(null, "Enter your username:");
                if (username != null && !username.isEmpty()) {
                    Users user = findUser(username);
                    if (user != null) {
                        JOptionPane.showMessageDialog(null, "Your password is: " + user.getPassword());
                    } else {
                        JOptionPane.showMessageDialog(null, "Username not found. Please try again.");
                    }
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel()); // Espacio vacío para alinear correctamente el olvido de la contraseña
        panel.add(forgotPasswordLabel);

        int option = JOptionPane.showConfirmDialog(null, panel, "Login",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

             if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            char[] passwordArray = passwordField.getPassword();
            String password = new String(passwordArray);

            if (authenticate(username, password)) {
                JOptionPane.showMessageDialog(null, "Login successful");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect username or password");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login cancelled");
            return false;
        }
    }
    private Users findUser(String username) {
        for (Users user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

}


  

