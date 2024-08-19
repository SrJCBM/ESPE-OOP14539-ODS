package ec.espe.edu.AirlineReservationSystem.controller;

import ec.espe.edu.AirlineReservationSystem.model.Flight;
import ec.espe.edu.AirlineReservationSystem.utils.FieldValidator;
import java.awt.Component;
import java.util.Date;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class CreateFlightController {

    public String createFlight(String origin, String destination, String airline, Date departureDate, Date arrivalDate, Component parentComponent) {
        if (!FieldValidator.validateFlightFields(origin, destination, airline, departureDate, arrivalDate, parentComponent)) {
            return null;
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

