package com.example.Assignment7.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Assignment7.entities.Trainee;

@Repository
public interface ITraineeRepository extends JpaRepository<Trainee, Integer>{
	
	Optional<Trainee> findBytraineeName(String name);

}
