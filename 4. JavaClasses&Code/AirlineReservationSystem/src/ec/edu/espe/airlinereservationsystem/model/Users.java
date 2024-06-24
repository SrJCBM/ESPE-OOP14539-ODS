/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ec.edu.espe.airlinereservationsystem.model;
/**
 * Autor: Joffre
 * Fecha: 2024-06-24
 * Descripción:
 */
public class Users {
    String username;
    String password;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
     public void setPassword(String password) {
        this.password = password;
    }
}

