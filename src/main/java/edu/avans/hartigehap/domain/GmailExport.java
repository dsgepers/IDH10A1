package edu.avans.hartigehap.domain;

import edu.avans.hartigehap.service.PeriodService;
import edu.avans.hartigehap.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service("googleExport")
public class GmailExport implements ICalendarAdapter {

    @Autowired
    private ReservationService reservationService;

    @Override
    public void sendPeriods() {

        String message = "";
        List<Reservation> reservations = reservationService.findAll();

        for (Reservation reservation : reservations) {
            message += "---" + reservation.getName() + " (" + reservation.getCustomer().getFirstName() + " " + reservation.getCustomer().getLastName() + ")";
            for (IPeriod period : reservation.getPeriods()) {
                message += "\n-"+ period.getDate() + ": " + period.toString();
            }
        }
        message += "\n\n";

        this.sendMessage(message);

    }

    private void sendMessage(String body) {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        sender.setHost("smtp.gmail.com");
        sender.setPort(587);
        sender.setUsername("tyranox@gmail.com");
        sender.setPassword("!!C8aa83ad!!");
        sender.setJavaMailProperties(properties);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("tyranox@gmail.com");
        message.setTo("tyranox@gmail.com");
        message.setSubject("Reserverings Export");
        message.setText(body);

        sender.send(message);

    }
}
