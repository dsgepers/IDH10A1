package edu.avans.hartigehap.web.controller;

import edu.avans.hartigehap.domain.*;
import edu.avans.hartigehap.service.ConceptStatusService;
import edu.avans.hartigehap.service.CustomerService;
import edu.avans.hartigehap.service.ReservationService;
import edu.avans.hartigehap.service.impl.ConceptStatusServiceImpl;
import edu.avans.hartigehap.web.form.Message;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

@Controller
//@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ConceptStatusService conceptStatusService;

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

    @RequestMapping(value = "/reservations/finalize/{reservationId}", method = RequestMethod.GET)
    public String makeFinal(Model uiModel, @PathVariable("reservationId") Long reservationId) {
        Reservation reservation = this.reservationService.findById(reservationId);

        if(reservation == null) {
            uiModel.addAttribute("message", new Message("danger", "Deze reservering werd niet gevonden :-("));
            return this.listReservations(uiModel);
        }

        try {
            IReservationStatus status = reservation.getStatus();
            status.makeFinal(reservation);
            uiModel.addAttribute("message", new Message("success", "De status is veranderd"));
            return this.listReservations(uiModel);
        } catch (InvalidReservationStatusActionException exception) {
            uiModel.addAttribute("message", new Message("danger", "De status is niet gewijzigd: " + exception.getMessage()));
            return this.listReservations(uiModel);
        }
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

        List<IPeriod> periods = periodFactory.buildPeriod(startTime, endTime, reservation);
        reservation.setPeriods(periods);

        List<ConceptStatus> conceptStatuses = this.conceptStatusService.findAll();
        ConceptStatus conceptStatus= conceptStatuses.get(0);

        reservation.setStatus(conceptStatus);

        this.reservationService.save(reservation);
        return "redirect:/reservations";
    }
}
