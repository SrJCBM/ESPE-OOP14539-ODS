/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.airlinereservationsystem.model;

import ec.edu.espe.airlinereservationsystem.utils.CustomerManager;
import java.awt.GridLayout;
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
 private CustomerManager customerManager;

    public Login(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    
    public boolean authenticate(String userName, String password) {
        Customer customer = customerManager.getCustomerByUsername(userName);
        if (customer != null && customer.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

   
    public boolean mostrarMenuLogin() {
        JTextField fieldUserName = new JTextField();
        JPasswordField fieldPassword = new JPasswordField();

      
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("User Name:"));
        panel.add(fieldUserName);
        panel.add(new JLabel("password:"));
        panel.add(fieldPassword);

        
        int opcion = JOptionPane.showConfirmDialog(null, panel, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (opcion == JOptionPane.OK_OPTION) {
            String userName = fieldUserName.getText();
            char[] arrayPassword = fieldPassword.getPassword();
            String password = new String(arrayPassword);

           
            if (authenticate(userName, password)) {
                JOptionPane.showMessageDialog(null, "Succesful Login");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Username or password incorrect");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Login canceled");
            return false;
        }
    }
}

