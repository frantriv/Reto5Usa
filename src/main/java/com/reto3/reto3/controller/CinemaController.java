package com.reto3.reto3.controller;

import com.reto3.reto3.entities.Cinema;
import com.reto3.reto3.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Cinema")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;
    @GetMapping("/all")
    public List<Cinema> getAll(){ return cinemaService.getAll(); }

    @GetMapping("/{id}")
    public Optional<Cinema> getCinema(@PathVariable("id") int id){ return cinemaService.getCinema(id); }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cinema save (@RequestBody Cinema cinema){ return cinemaService.save(cinema); }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/update")
    public Cinema update (@RequestBody Cinema cinema){ return cinemaService.update(cinema); }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable("id") int carId){ return cinemaService.delete(carId); }
}
