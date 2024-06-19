package ec.edu.espe.airlinereservationsystem.model;

import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class Flight {

    private int flightId;
    private String origin;
    private String destination;
    private String airline;
    private Date departureDate;
    private Date arrivalDate;

    public Flight(int flightId, String origin, String destination, String airline, Date departureDate, Date arrivalDate) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.airline = airline;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    /**
     * @return the flightId
     */
    public int getFlightId() {
        return flightId;
    }

    /**
     * @param flightId the flightId to set
     */
    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the airline
     */
    public String getAirline() {
        return airline;
    }

    /**
     * @param airline the airline to set
     */
    public void setAirline(String airline) {
        this.airline = airline;
    }

    /**
     * @return the departureDate
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departureDate to set
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * @return the arrivalDate
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @param arrivalDate the arrivalDate to set
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flightId", flightId);
        jsonObject.put("origin", origin);
        jsonObject.put("destination", destination);
        jsonObject.put("airline", airline);
        jsonObject.put("departureDate", departureDate.toString());
        jsonObject.put("arrivalDate", arrivalDate.toString());
        return jsonObject;
    }

    public static Flight fromJSON(JSONObject jsonObject) {
        int flightId = jsonObject.getInt("flightId");
        String origin = jsonObject.getString("origin");
        String destination = jsonObject.getString("destination");
        String airline = jsonObject.getString("airline");
        Date departureDate = Date.from(java.time.Instant.parse(jsonObject.getString("departureDate")));
        Date arrivalDate = Date.from(java.time.Instant.parse(jsonObject.getString("arrivalDate")));

        return new Flight(flightId, origin, destination, airline, departureDate, arrivalDate);
    }
    
    
}
