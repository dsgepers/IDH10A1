package edu.avans.hartigehap.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.avans.hartigehap.domain.ConceptStatus;
import edu.avans.hartigehap.domain.Customer;
import edu.avans.hartigehap.domain.IPeriod;
import edu.avans.hartigehap.domain.IReservationStatus;
import edu.avans.hartigehap.domain.IRoom;
import edu.avans.hartigehap.domain.InvalidReservationStatusActionException;
import edu.avans.hartigehap.domain.PeriodFactory;
import edu.avans.hartigehap.domain.Reservation;
import edu.avans.hartigehap.domain.RoomFactory;
import edu.avans.hartigehap.service.ConceptStatusService;
import edu.avans.hartigehap.service.CustomerService;
import edu.avans.hartigehap.service.FinalStatusService;
import edu.avans.hartigehap.service.ReservationService;
import edu.avans.hartigehap.service.RoomService;
import edu.avans.hartigehap.web.form.Message;

@Controller
//@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private FinalStatusService finalStatusService;

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private RoomService roomService;
    

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
        List<IRoom> rooms = this.roomService.findAll();

        uiModel.addAttribute("reservation", new Reservation());
        uiModel.addAttribute("customers", customers);
        uiModel.addAttribute("rooms", rooms);
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
            status.setFinalStatusService(this.finalStatusService);
            status.setReservationService(this.reservationService);
            status.makeFinal(reservation);
            uiModel.addAttribute("message", new Message("success", "De status is veranderd"));
            return this.listReservations(uiModel);
        } catch (InvalidReservationStatusActionException exception) {
            uiModel.addAttribute("message", new Message("danger", "De status is niet gewijzigd: " + exception.getMessage()));
            return this.listReservations(uiModel);
        }
    }


    @RequestMapping(value = "/reservation/{reservationId}", method = RequestMethod.GET)
    public String showReservation(Model uiModel, @PathVariable("reservationId") Long reservationId) {
        Reservation reservation = this.reservationService.findById(reservationId);

        uiModel.addAttribute("reservation", reservation);
        return "reservations/show";
    }

    @RequestMapping(value = "/reservations/new", method = RequestMethod.POST)
    public String storeReservation(@RequestParam("customer") Long customerId,
                                   @RequestParam("name") String name,
                                   @RequestParam("groupSize") Integer groupSize,
                                   @RequestParam("description") String description,
                                   @RequestParam("startDateTime") String startDateTime,
                                   @RequestParam("endDateTime") String endDateTime,
                                   @RequestParam("room") Long roomId,
                                   @RequestParam(value="additions", required = false) String[] additions){

        Reservation reservation = new Reservation();

        Customer customer = this.customerService.findById(customerId);
        reservation.setCustomer(customer);
        reservation.setName(name);
        reservation.setDescription(description);
        reservation.setGroupSize(groupSize);

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm");
        DateTime startTime = formatter.parseDateTime(startDateTime);
        DateTime endTime = formatter.parseDateTime(endDateTime);

        RoomFactory roomFactory = new RoomFactory();
        List<String> roomAdditions = new ArrayList<String>();
        if (additions != null)
        	roomAdditions.addAll(Arrays.asList(additions));
        
        IRoom room = roomFactory.buildRoom(roomService.findById(roomId), roomAdditions);
        roomService.save(room);
        reservation.setRoom(room);
       
        
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
