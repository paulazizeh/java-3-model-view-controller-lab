package edu.cscc.mvc;

import edu.cscc.mvc.domain.Format;
import edu.cscc.mvc.domain.Genre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RentalsControllerTest extends MVCTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    public void itCanRouteToRentalsIndex() {
        assertRouteExists("Rentals", "index", RentalsController.class);
    }

    @Test
    public void itRendersTheRentalsIndexView() {
        routeRequest("Rentals", "index");
        assertViewRendered(RentalsIndex.class);
    }

    @Test
    void list() {
        routeRequest("Rentals", "list");
        assertViewRendered(RentalsList.class);
    }

    @Test
    void save() {
        Map<String, Object> params = new HashMap<>();
        params.put("Name", "Alien");
        params.put("Format", Format.DVD);
        params.put("Genre", Genre.HORROR);
        params.put("Director", "RIDLEY SCOTT");
        params.put("Year", "1979");
        routeRequest("Rentals", "save", params);
        assertViewRendered(RentalsSave.class);
    }

    @Test
    void create() {
        routeRequest("Rentals", "create");
        assertViewRendered(RentalsCreate.class);
    }

    @Test
    void edit() {
        routeRequest("Rentals", "edit");
        assertViewRendered(RentalsEdit.class);
    }

    @Test
    void delete() {
        assertRouteExists("Rentals", "delete", RentalsController.class);
    }

    @Test
    void show() {
        assertRouteExists("Rentals", "show", RentalsController.class);
    }

    @Test
    void select() {
        assertRouteExists("Rentals", "select", RentalsController.class);
    }

    @Test
    void update() {
        Map<String, Object> params = new HashMap<>();
        params.put("Name", "Alien");
        params.put("Format", Format.DVD);
        params.put("Genre", Genre.HORROR);
        params.put("Director", "RIDLEY SCOTT");
        params.put("Year", "1979");
        routeRequest("Rentals", "edit", params);
        assertViewRendered(RentalsEdit.class);

    }
}