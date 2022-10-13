package com.reto3.reto3.controller;

import com.reto3.reto3.entities.ReportClient;
import com.reto3.reto3.entities.Reservation;
import com.reto3.reto3.entities.Status;
import com.reto3.reto3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @GetMapping("/all")
    public List<Reservation> getAll(){ return reservationService.getAll(); }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation (@PathVariable("id") int id){ return reservationService.getReservation(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save (@RequestBody Reservation reservation){ return reservationService.save(reservation); }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Reservation update (@RequestBody Reservation reservation){ return reservationService.update(reservation); }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id") int carId){ return reservationService.delete(carId); }

    @GetMapping("/report-status")
    public Status getStatus(){
        return reservationService.getStatus();
    }
    @GetMapping("/report-clients")
    public List<ReportClient> getReportClient(){
        return reservationService.getReportClient();
    }

    @GetMapping("/report-dates/{startDate}/{devolutionDate}")
    public List<Reservation> getReportdate(@PathVariable String startDate,@PathVariable String devolutionDate) {
        Date date1= new Date();
        Date date2= new Date();
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            date2=new SimpleDateFormat("yyyy-MM-dd").parse(devolutionDate);
        } catch (ParseException ex) {
            Logger.getLogger(ReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reservationService.getReportDates(date1,date2);
    }

}
