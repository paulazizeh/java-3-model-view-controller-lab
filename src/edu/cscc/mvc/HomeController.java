package edu.cscc.mvc;

import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.framework.ApplicationController;
import edu.cscc.mvc.framework.MVCContext;

import java.util.List;

public class HomeController extends ApplicationController {
    public HomeController(MVCContext context) {
        super(context);
    }
    public void index() {
        render(new HomeIndex(context));
    }

}
