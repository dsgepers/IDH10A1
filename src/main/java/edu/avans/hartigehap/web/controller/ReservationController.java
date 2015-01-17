package edu.avans.hartigehap.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.avans.hartigehap.domain.Customer;
import edu.avans.hartigehap.domain.IPeriod;
import edu.avans.hartigehap.domain.IRoom;
import edu.avans.hartigehap.domain.PeriodFactory;
import edu.avans.hartigehap.domain.Reservation;
import edu.avans.hartigehap.domain.RoomFactory;
import edu.avans.hartigehap.service.CustomerService;
import edu.avans.hartigehap.service.ReservationService;
import edu.avans.hartigehap.service.RoomService;

@Controller
//@PreAuthorize("hasRole('ROLE_EMPLOYEE')")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private RoomService roomService;
    

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

        DateTime startTime = DateTime.parse(startDateTime);
        DateTime endTime = DateTime.parse(endDateTime);
        
        
        RoomFactory roomFactory = new RoomFactory();
        IRoom room = roomFactory.buildRoom(roomService.findById(roomId), new ArrayList<String>(Arrays.asList(additions)));
        roomService.save(room);
        reservation.setRoom(room);
        
        PeriodFactory periodFactory = new PeriodFactory();
        List<IPeriod> periods = periodFactory.buildPeriod(startTime, endTime, reservation);
        reservation.setPeriods(periods);

        this.reservationService.save(reservation);
        return "redirect:/reservations";
    }
}
