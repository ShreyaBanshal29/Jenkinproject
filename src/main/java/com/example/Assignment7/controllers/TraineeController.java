package com.example.Assignment7.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.Assignment7.entities.Trainee;
import com.example.Assignment7.services.ITraineeService;

import jakarta.validation.Valid;

@RestController

public class TraineeController {
	
	@Autowired
	ITraineeService iTraineeService;
	
	@GetMapping("/trainees")
  public List<Trainee> getAllTrainees(){
		return iTraineeService.getAllTrainees();
	}
	
	@GetMapping("/trainees/{id}")
    public Trainee getTrainee(@PathVariable int id) {
        Optional<Trainee> trainee = iTraineeService.getTrainee(id);

        if (trainee.isPresent()) {
            return trainee.get();
        }
        return null;
    }

    @GetMapping("/trainees/BytraineeName/{name}")
    public Trainee findBytraineeName(@PathVariable String name) {
        Optional<Trainee> trainee = iTraineeService.findBytraineeName(name);

        if (trainee.isPresent()) {
            return trainee.get();
        }
        return null;
    }

    @PostMapping("/trainees")
    public Trainee addTrainee(@Valid @RequestBody Trainee trainee) {
        return iTraineeService.addTrainee(trainee);
    }

    @PutMapping("/trainees/{id}")
    public Trainee updateTrainee(@PathVariable int id, @RequestBody Trainee trainee) {

        Trainee updated = iTraineeService.updateTrainee(id, trainee);
        return updated;
    }
    
    @DeleteMapping("/trainees/{id}")
    public String deleteTrainee(@PathVariable int id) {

        boolean status = iTraineeService.deleteTrainee(id);

        if (status) {
            return "Trainee deleted successfully";
        } else {
            return "Trainee not found";
        }
    }
    }
	



