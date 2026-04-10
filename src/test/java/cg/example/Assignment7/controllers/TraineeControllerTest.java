package cg.example.Assignment7.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.Assignment7.controllers.TraineeController;
import com.example.Assignment7.entities.Trainee;
import com.example.Assignment7.services.ITraineeService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TraineeControllerTest {

    @Mock
    ITraineeService traineeService;

    @InjectMocks
    TraineeController traineeController;

    @Test
    void testGetAllTrainees() {
        List<Trainee> list = new ArrayList<>();
        list.add(new Trainee(1, "Shreya","CSE","Noida"));

        Mockito.when(traineeService.getAllTrainees()).thenReturn(list);

        List<Trainee> result = traineeController.getAllTrainees();

        assertNotNull(result);
        assertEquals(1, result.size());

        Mockito.verify(traineeService, Mockito.times(1)).getAllTrainees();
    }

    @Test
    void testGetTraineeById() {
        Trainee t = new Trainee(1, "Shreya","CSE","Noida");

        Mockito.when(traineeService.getTrainee(1)).thenReturn(Optional.of(t));

        Trainee result = traineeController.getTrainee(1);

        assertNotNull(result);
        assertEquals("Shreya", result.getTraineeName());

        Mockito.verify(traineeService, Mockito.times(1)).getTrainee(1);
    }

    @Test
    void testGetTraineeById_NotFound() {
        Mockito.when(traineeService.getTrainee(1)).thenReturn(Optional.empty());

        Trainee result = traineeController.getTrainee(1);

        assertNull(result);

        Mockito.verify(traineeService, Mockito.times(1)).getTrainee(1);
    }

    @Test
    void testFindByName() {
        Trainee t = new Trainee(1, "Shreya","CSE","Noida");

        Mockito.when(traineeService.findBytraineeName("Shreya"))
                .thenReturn(Optional.of(t));

        Trainee result = traineeController.findBytraineeName("Shreya");

        assertNotNull(result);
        assertEquals("Shreya", result.getTraineeName());

        Mockito.verify(traineeService, Mockito.times(1))
                .findBytraineeName("Shreya");
    }

    @Test
    void testAddTrainee() {
        Trainee t = new Trainee(1, "Shreya","CSE","Noida");

        Mockito.when(traineeService.addTrainee(t)).thenReturn(t);

        Trainee result = traineeController.addTrainee(t);

        assertNotNull(result);
        assertEquals("Shreya", result.getTraineeName());

        Mockito.verify(traineeService, Mockito.times(1)).addTrainee(t);
    }

    @Test
    void testUpdateTrainee() {
        Trainee t = new Trainee(1, "Updated","CSE","Noida");

        Mockito.when(traineeService.updateTrainee(1, t)).thenReturn(t);

        Trainee result = traineeController.updateTrainee(1, t);

        assertNotNull(result);
        assertEquals("Updated", result.getTraineeName());

        Mockito.verify(traineeService, Mockito.times(1))
                .updateTrainee(1, t);
    }

    @Test
    void testDeleteTraineeSuccess() {
        Mockito.when(traineeService.deleteTrainee(1)).thenReturn(true);

        String result = traineeController.deleteTrainee(1);

        assertEquals("Trainee deleted successfully", result);

        Mockito.verify(traineeService, Mockito.times(1))
                .deleteTrainee(1);
    }

    @Test
    void testDeleteTraineeFailure() {
        Mockito.when(traineeService.deleteTrainee(1)).thenReturn(false);

        String result = traineeController.deleteTrainee(1);

        assertEquals("Trainee not found", result);

        Mockito.verify(traineeService, Mockito.times(1))
                .deleteTrainee(1);
    }
}