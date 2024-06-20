package ec.edu.espe.airlinereservationsystem.model;

import ec.edu.espe.airlinereservationsystem.enums.BaggageType;
import java.io.Serializable;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class Baggage implements Serializable {

    private BaggageType baggageType;
    private double weight;

    public Baggage(BaggageType baggageType, double weight) {
        this.baggageType = baggageType;
        this.weight = weight;
    }

    /**
     * @return the baggageType
     */
    public BaggageType getBaggageType() {
        return baggageType;
    }

    /**
     * @param baggageType the baggageType to set
     */
    public void setBaggageType(BaggageType baggageType) {
        this.baggageType = baggageType;
    }

    /**
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

}
