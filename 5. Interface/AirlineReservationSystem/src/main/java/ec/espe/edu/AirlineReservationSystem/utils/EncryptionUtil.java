package ec.espe.edu.AirlineReservationSystem.utils;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class EncryptionUtil {

    public static String encryptPassword(String password) {
        StringBuilder encryptedPassword = new StringBuilder();

        for (char c : password.toCharArray()) {
            encryptedPassword.append((char) (c + 1));
        }

        return encryptedPassword.toString();
    }

    public static String decryptPassword(String encryptedPassword) {
        StringBuilder decryptedPassword = new StringBuilder();

        for (char c : encryptedPassword.toCharArray()) {
            decryptedPassword.append((char) (c - 1));
        }

        return decryptedPassword.toString();
    }
}
