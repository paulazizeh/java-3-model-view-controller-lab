package edu.cscc.mvc;

import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class RentalsShow extends ApplicationView {
    Rental rental;
    /**
     * Sets the context and configures it to exit by default
     * unless a route is specified.
     *
     * @param context The {@link MVCContext}.
     */
    public RentalsShow(MVCContext context, Rental rental) {
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

        System.out.println("Manage rental:");
        System.out.println("1. Update rental");
        System.out.println("2. Delete rental");
        System.out.println("3. Rentals menu");
        System.out.println("Choice:");
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    route("Rentals", "edit");
                    break;
                case 2:
                    route("Rentals", "delete");
                    break;
                case 3:
                    route("Rentals", "index");
                    break;

            }
        } catch (InputMismatchException ex) {
            Map<String, Object> params = new HashMap<>();
            params.put("Rental ID", rental.getId().toString());
            route("Rentals", "show", params);

        }

    }
}
