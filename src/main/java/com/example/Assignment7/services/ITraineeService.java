package com.example.Assignment7.services;

import java.util.List;
import java.util.Optional;

import com.example.Assignment7.entities.Trainee;



public interface ITraineeService {
    Trainee addTrainee(Trainee t);
    boolean deleteTrainee(int id);
    Trainee updateTrainee(int id, Trainee t);
    Optional<Trainee> getTrainee(int id);
    List<Trainee> getAllTrainees();
    Optional<Trainee> findBytraineeName(String name);


}
