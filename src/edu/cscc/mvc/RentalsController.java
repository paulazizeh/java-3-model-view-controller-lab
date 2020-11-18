package edu.cscc.mvc;

import edu.cscc.mvc.domain.Format;
import edu.cscc.mvc.domain.Genre;
import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.domain.RentalRepository;
import edu.cscc.mvc.framework.ApplicationController;
import edu.cscc.mvc.framework.MVCContext;

import java.util.List;
import java.util.UUID;

public class RentalsController extends ApplicationController {

    private UUID currentUuid;

    private final RentalRepository rentalRepository;

    public RentalsController(MVCContext context) {
        super(context);
        rentalRepository = RentalRepository.getInstance();
    }
    public void index() {
        render(new RentalsIndex(context));
    }

    public void list() {
            List<Rental> rental = rentalRepository.readAll();
            render(new RentalsList(context, rental));
        }

    public void save() {
        Rental rental = new Rental(context.getRequest().getParams().get("Name").toString(), (Format) context.getRequest().getParams().get("Format"), (Genre) context.getRequest().getParams().get("Genre"), context.getRequest().getParams().get("Director").toString(), context.getRequest().getParams().get("Year").toString());
        render(new RentalsSave(context, rentalRepository.create(rental)));
    }

    public void create() {
        render(new RentalsCreate(context));
    }

    public void edit() {
        render(new RentalsEdit(context));
    }

    public void delete() {
        rentalRepository.delete(currentUuid);
        render(new RentalsIndex(context));
    }

    public void show(){
        UUID rentalUuid = UUID.fromString(context.getRequest().getParams().get("Rental ID").toString());
        currentUuid = rentalUuid;
        Rental rentalId = rentalRepository.read(rentalUuid);
        render(new RentalsShow(context, rentalId));
    }

    public void select(){
        render(new RentalsSelect(context));
    }

    public void update() {
        Rental rental = new Rental(currentUuid, context.getRequest().getParams().get("Name").toString(), (Format) context.getRequest().getParams().get("Format"), (Genre) context.getRequest().getParams().get("Genre"), context.getRequest().getParams().get("Director").toString(), context.getRequest().getParams().get("Year").toString());
        Rental updatedRental = rentalRepository.update(rental);
        render(new RentalsShow(context, updatedRental));
    }



}
