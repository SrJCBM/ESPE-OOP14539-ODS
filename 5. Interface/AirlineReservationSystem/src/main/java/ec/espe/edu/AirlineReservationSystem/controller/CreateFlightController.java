package ec.espe.edu.AirlineReservationSystem.controller;

import ec.espe.edu.AirlineReservationSystem.model.Flight;
import java.util.Date;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class CreateFlightController {

    public String createFlight(String origin, String destination, String airline, Date departureDate, Date arrivalDate) throws IllegalArgumentException {
        Date today = new Date();

        if (origin.equals("Ciudad") || destination.equals("Ciudad") || airline.isEmpty() || departureDate == null || arrivalDate == null) {
            throw new IllegalArgumentException("Por favor, complete todos los campos.");
        }

        if (departureDate.before(today)) {
            throw new IllegalArgumentException("La fecha de salida no puede ser anterior a la fecha actual.");
        }

        if (arrivalDate.before(departureDate)) {
            throw new IllegalArgumentException("La fecha de llegada no puede ser anterior a la fecha de salida.");
        }

        Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setAirline(airline);
        flight.setDepartureDate(departureDate);
        flight.setArrivalDate(arrivalDate);

        FlightController flightController = new FlightController();
        return flightController.saveFlight(flight);
    }
}
