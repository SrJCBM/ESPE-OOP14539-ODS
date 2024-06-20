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

    
    public boolean autenticar(String nombreUsuario, String contrasena) {
        Customer customer = customerManager.getCustomerByUsername(nombreUsuario);
        if (customer != null && customer.getPassword().equals(contrasena)) {
            return true;
        }
        return false;
    }

   
    public boolean mostrarMenuLogin() {
        JTextField campoNombreUsuario = new JTextField();
        JPasswordField campoContrasena = new JPasswordField();

      
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Nombre de usuario:"));
        panel.add(campoNombreUsuario);
        panel.add(new JLabel("Contraseña:"));
        panel.add(campoContrasena);

        
        int opcion = JOptionPane.showConfirmDialog(null, panel, "Inicio de sesión", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (opcion == JOptionPane.OK_OPTION) {
            String nombreUsuario = campoNombreUsuario.getText();
            char[] arrayContrasena = campoContrasena.getPassword();
            String contrasena = new String(arrayContrasena);

           
            if (autenticar(nombreUsuario, contrasena)) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Inicio de sesión cancelado");
            return false;
        }
    }
}

