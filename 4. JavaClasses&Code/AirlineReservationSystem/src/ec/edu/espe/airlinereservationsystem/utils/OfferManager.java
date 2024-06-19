package ec.edu.espe.airlinereservationsystem.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio Blacio, Overnight Developers Squad, DCCO-ESPE
 */
public class OfferManager {

    private List<String> offers;

    public OfferManager() {
        this.offers = new ArrayList<>();
    }

    public void addOffer(String offer) {
        offers.add(offer);
    }

    public void listOffers() {
        System.out.println("Current Offers:");
        for (String offer : offers) {
            System.out.println("- " + offer);
        }
    }

    public List<String> getAllOffers() {
        return offers;
    }
}
