package edu.cscc.mvc;

import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.List;

public class RentalsList extends ApplicationView {
    private List<Rental> rentals;

    /**
     * Sets the context and configures it to exit by default
     * unless a route is specified.
     *
     * @param context The {@link MVCContext}.
     */
    public RentalsList(MVCContext context, List<Rental> rentals) {
        super(context);
        this.rentals = rentals;
    }

    @Override
    public void show() {
        rentals.forEach(rental -> {
            System.out.println("***************************");
            System.out.println("ID: " + rental.getId().toString());
            System.out.println("Name: " + rental.getName());
            System.out.println("Format: " + rental.getFormat());
            System.out.println("Genre: " + rental.getGenre());
            System.out.println("Director: " + rental.getDirector());
            System.out.println("Year: " + rental.getYear());
            System.out.println("***************************");
        });
        route("Rentals", "index");
    }
}
