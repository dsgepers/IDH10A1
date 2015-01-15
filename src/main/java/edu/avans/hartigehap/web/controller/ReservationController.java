package edu.avans.hartigehap.web.controller;

import edu.avans.hartigehap.domain.Customer;
import edu.avans.hartigehap.domain.IPeriod;
import edu.avans.hartigehap.domain.PeriodFactory;
import edu.avans.hartigehap.domain.Reservation;
import edu.avans.hartigehap.service.CustomerService;
import edu.avans.hartigehap.service.ReservationService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    public String listReservations(Model uiModel) {

        List<Reservation> reservations = this.reservationService.findAll();

        uiModel.addAttribute("reservations", reservations);
        return "reservations/index";
    }

    @RequestMapping(value = "/reservations/new", method = RequestMethod.GET)
    public String newReservation(Model uiModel) {
        List<Customer> customers = this.customerService.findAll();

        uiModel.addAttribute("reservation", new Reservation());
        uiModel.addAttribute("customers", customers);
        return "reservations/new";
    }

    @RequestMapping(value = "/reservations/new", method = RequestMethod.POST)
    public String storeReservation(@RequestParam("customer") Long customerId,
                                   @RequestParam("name") String name,
                                   @RequestParam("groupSize") Integer groupSize,
                                   @RequestParam("description") String description,
                                   @RequestParam("startDateTime") String startDateTime,
                                   @RequestParam("endDateTime") String endDateTime) {

        Reservation reservation = new Reservation();
        Customer customer = this.customerService.findById(customerId);
        reservation.setCustomer(customer);
        reservation.setName(name);
        reservation.setDescription(description);
        reservation.setGroupSize(groupSize);

        DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm");
        DateTime startTime = formatter.parseDateTime(startDateTime);
        DateTime endTime = formatter.parseDateTime(endDateTime);

        PeriodFactory periodFactory = new PeriodFactory();

        List<IPeriod> periods = periodFactory.buildPeriod(startTime, endTime);
        reservation.setPeriods(periods);

        this.reservationService.save(reservation);
        return "redirect:/reservations";
    }
}
