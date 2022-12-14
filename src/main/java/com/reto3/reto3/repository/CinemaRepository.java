package com.reto3.reto3.repository;

import com.reto3.reto3.entities.Cinema;
import com.reto3.reto3.repository.crudRepository.CinemaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CinemaRepository {

    @Autowired
    private CinemaCrudRepository cinemaCrudRepository;

    public List<Cinema> getAll() { return (List<Cinema>) cinemaCrudRepository.findAll(); }
    public Optional<Cinema> getCinema (int id) {
        return cinemaCrudRepository.findById(id);
    }
    public Cinema save (Cinema cinema) {
        return cinemaCrudRepository.save(cinema);
    }
    public void delete (Cinema cinema) {
        cinemaCrudRepository.delete(cinema);
    }
}
