package edu.cscc.mvc;

import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RentalsSelect extends ApplicationView {

    /**
     * Sets the context and configures it to exit by default
     * unless a route is specified.
     *
     * @param context The {@link MVCContext}.
     */
    public RentalsSelect(MVCContext context) {
        super(context);
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> params = new HashMap<>();
        System.out.println("Rental ID");
        String rentalId = scanner.nextLine();
        params.put("Rental ID", rentalId);
        route("Rentals", "show", params);
    }

}
