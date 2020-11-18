package edu.cscc.mvc;

import edu.cscc.mvc.domain.Format;
import edu.cscc.mvc.domain.Genre;
import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class RentalsCreate extends ApplicationView {
    /**
     * Sets the context and configures it to exit by default
     * unless a route is specified.
     *
     * @param context The {@link MVCContext}.
     */
    public RentalsCreate(MVCContext context) {
        super(context);
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        Map<String, Object> params = new HashMap<>();
        System.out.println("Create a rental");
        System.out.println("Name: ");
        String rentalName = scanner.nextLine();
        params.put("Name", rentalName);


        System.out.println("Format: ");
        System.out.println("1. DVD");
        System.out.println("2. VHS");
        System.out.println("3. BLU_RAY");
        System.out.println("Choice: ");
        int rentalFormat = scanner.nextInt();
        switch (rentalFormat) {
            case 1 :
                params.put("Format", Format.DVD);
                break;
            case 2 :
                params.put("Format", Format.VHS);
                break;
            case 3 :
                params.put("Format", Format.BLU_RAY);
                break;
        }


        System.out.println("Genre: ");
        System.out.println("1. HORROR");
        System.out.println("2. ACTION");
        System.out.println("3. COMEDY");
        System.out.println("4. DRAMA");
        System.out.println("5. ROMANCE");
        System.out.println("Choice: ");
        int rentalGenre = scanner.nextInt();
        switch (rentalGenre) {
            case 1:
                params.put("Genre", Genre.HORROR);
                break;
            case 2:
                params.put("Genre", Genre.ACTION);
                break;
            case 3:
                params.put("Genre", Genre.COMEDY);
                break;
            case 4:
                params.put("Genre", Genre.DRAMA);
                break;
            case 5:
                params.put("Genre", Genre.ROMANCE);
                break;
        }

        System.out.println("Director: ");
        scanner.nextLine();
        String movieDirector = scanner.nextLine();
        params.put("Director", movieDirector);


        System.out.println("Year: ");
        int movieYear = scanner.nextInt();
        params.put("Year", movieYear);

                    route("Rentals", "save", params);

            }

    }

