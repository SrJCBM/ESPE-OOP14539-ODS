package ec.edu.espe.airlinereservationsystem.utils;

import ec.edu.espe.airlinereservationsystem.model.Flight;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class FlightManager {

    private List<Flight> flights;

    public FlightManager() {
        this.flights = new ArrayList<>();
    }

    public Flight createFlight(String origin, String destination, String airline, Date departureDate, Date arrivalDate) {
        int flightId = flights.size() + 1;
        Flight flight = new Flight(flightId, origin, destination, airline, departureDate, arrivalDate);
        flights.add(flight);
        return flight;
    }

    public Flight getFlight(int flightId) {
        for (Flight flight : flights) {
            if (flight.getFlightId() == flightId) {
                return flight;
            }
        }
        throw new IndexOutOfBoundsException("Flight not found");
    }

    public List<Flight> getAllFlights() {
        return flights;
    }
}
