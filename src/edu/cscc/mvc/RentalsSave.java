package edu.cscc.mvc;

import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

public class RentalsSave extends ApplicationView {
    Rental rental;
    /**
     * Sets the context and configures it to exit by default
     * unless a route is specified.
     *
     * @param context The {@link MVCContext}.
     */
    public RentalsSave(MVCContext context, Rental rental) {
        super(context);
        this.rental = rental;
    }

    @Override
    public void show() {
        System.out.println("***************************");
        System.out.println("ID: " + rental.getId().toString());
        System.out.println("Name: " + rental.getName());
        System.out.println("Format: " + rental.getFormat());
        System.out.println("Genre: " + rental.getGenre());
        System.out.println("Director: " + rental.getDirector());
        System.out.println("Year: " + rental.getYear());
        System.out.println("***************************");

        route("Rentals", "index");
    }
}
