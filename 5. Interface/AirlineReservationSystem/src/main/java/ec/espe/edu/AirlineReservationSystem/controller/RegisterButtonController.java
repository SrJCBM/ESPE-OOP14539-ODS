package ec.espe.edu.AirlineReservationSystem.controller;

import ec.espe.edu.AirlineReservationSystem.model.Customer;
import java.util.Date;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class RegisterButtonController {

    public void registerCustomer(String idDocument, String name, String lastName, String email, String phoneNumber,
            String username, String password, String city, String state, String postalCode,
            Date dateOfBirth, String gender) throws Exception {

        if (idDocument.isEmpty() || name.isEmpty() || lastName.isEmpty() || email.isEmpty() || phoneNumber.isEmpty()
                || username.isEmpty() || password.isEmpty() || city.isEmpty() || state.isEmpty() || postalCode.isEmpty()
                || dateOfBirth == null || gender.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }

        if (!validarCedula(idDocument)) {
            throw new IllegalArgumentException("La cédula ingresada no es válida.");
        }

        if (!name.matches("[A-Za-z]+( [A-Za-z]+)*")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras y un espacio entre palabras.");
        }

        if (!lastName.matches("[A-Za-z]+( [A-Za-z]+)*")) {
            throw new IllegalArgumentException("El apellido solo puede contener letras y un espacio entre palabras.");
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("El correo electrónico no es válido.");
        }

        if (!phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("El número de teléfono solo puede contener dígitos.");
        }

        if (!postalCode.matches("\\d+")) {
            throw new IllegalArgumentException("El código postal solo puede contener dígitos.");
        }

        if (username.length() > 10) {
            throw new IllegalArgumentException("El nombre de usuario no puede tener más de 10 caracteres.");
        }

        if (password.length() > 10) {
            throw new IllegalArgumentException("La contraseña no puede tener más de 10 caracteres.");
        }

        Customer customer = new Customer(idDocument, name, email, phoneNumber, username, password, city, state, postalCode, dateOfBirth, gender);
        CustomerController.createCustomer(customer);
    }

    private boolean validarCedula(String cedula) {
        if (cedula.length() != 10) {
            return false;
        }

        int provincia = Integer.parseInt(cedula.substring(0, 2));
        if (provincia < 1 || provincia > 24) {
            return false;
        }

        int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
        if (tercerDigito < 0 || tercerDigito > 6) {
            return false;
        }

        int suma = 0;
        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        for (int i = 0; i < 9; i++) {
            int digito = Integer.parseInt(cedula.substring(i, i + 1));
            int producto = digito * coeficientes[i];
            suma += (producto > 9) ? producto - 9 : producto;
        }

        int ultimoDigito = Integer.parseInt(cedula.substring(9, 10));
        int decenaSuperior = ((suma + 9) / 10) * 10;
        int digitoVerificador = decenaSuperior - suma;

        return digitoVerificador == ultimoDigito;
    }
}
