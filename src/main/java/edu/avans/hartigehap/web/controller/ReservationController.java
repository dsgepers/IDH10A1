package edu.avans.hartigehap.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class ReservationController {

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public String listReservations() {
        return "reservations/index";
    }
    @RequestMapping(value = "/reservations/new", method = RequestMethod.GET)
    public String newReservation() {
        return "reservations/new";
    }
}
