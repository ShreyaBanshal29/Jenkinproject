package cg.example.Assignment7.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.Assignment7.Exception.TraineeNotFoundException;
import com.example.Assignment7.entities.Trainee;
import com.example.Assignment7.repositories.ITraineeRepository;
import com.example.Assignment7.services.TraineeServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TraineeServiceImplTest {

    @Mock
    ITraineeRepository repo;

    @InjectMocks
    TraineeServiceImpl service;

    // ✅ Test addTrainee
    @Test
    void testAddTrainee() {
        Trainee t = new Trainee(1, "Shreya", "Java", "Delhi");

        Mockito.when(repo.save(t)).thenReturn(t);

        Trainee result = service.addTrainee(t);

        assertNotNull(result);
        assertEquals("Shreya", result.getTraineeName());

        Mockito.verify(repo, Mockito.times(1)).save(t);
    }

    // ✅ Test getAllTrainees
    @Test
    void testGetAllTrainees() {
        List<Trainee> list = new ArrayList<>();
        list.add(new Trainee(1, "Shreya", "Java", "Delhi"));

        Mockito.when(repo.findAll()).thenReturn(list);

        List<Trainee> result = service.getAllTrainees();

        assertNotNull(result);
        assertEquals(1, result.size());

        Mockito.verify(repo, Mockito.times(1)).findAll();
    }

    // ✅ Test getTrainee (found)
    @Test
    void testGetTraineeFound() {
        Trainee t = new Trainee(1, "Shreya", "Java", "Delhi");

        Mockito.when(repo.findById(1)).thenReturn(Optional.of(t));

        Optional<Trainee> result = service.getTrainee(1);

        assertTrue(result.isPresent());
        assertEquals("Shreya", result.get().getTraineeName());

        Mockito.verify(repo, Mockito.times(1)).findById(1);
    }

    // ❌ Test getTrainee (not found → exception)
    @Test
    void testGetTraineeNotFound() {
        Mockito.when(repo.findById(1)).thenReturn(Optional.empty());

        assertThrows(TraineeNotFoundException.class, () -> {
            service.getTrainee(1);
        });

        Mockito.verify(repo, Mockito.times(1)).findById(1);
    }

    // ✅ Test updateTrainee (success)
    @Test
    void testUpdateTraineeSuccess() {
        Trainee existing = new Trainee(1, "Old", "Python", "Noida");
        Trainee updated = new Trainee(1, "Shreya", "Java", "Delhi");

        Mockito.when(repo.findById(1)).thenReturn(Optional.of(existing));
        Mockito.when(repo.save(existing)).thenReturn(existing);

        Trainee result = service.updateTrainee(1, updated);

        assertNotNull(result);
        assertEquals("Shreya", result.getTraineeName());
        assertEquals("Java", result.getTraineeDomain());

        Mockito.verify(repo, Mockito.times(1)).findById(1);
        Mockito.verify(repo, Mockito.times(1)).save(existing);
    }

    // ❌ Test updateTrainee (not found)
    @Test
    void testUpdateTraineeNotFound() {
        Trainee updated = new Trainee(1, "Shreya", "Java", "Delhi");

        Mockito.when(repo.findById(1)).thenReturn(Optional.empty());

        Trainee result = service.updateTrainee(1, updated);

        assertNull(result);

        Mockito.verify(repo, Mockito.times(1)).findById(1);
    }

    // ✅ Test deleteTrainee (success)
    @Test
    void testDeleteTraineeSuccess() {
        Mockito.when(repo.existsById(1)).thenReturn(true);

        boolean result = service.deleteTrainee(1);

        assertTrue(result);

        Mockito.verify(repo, Mockito.times(1)).existsById(1);
        Mockito.verify(repo, Mockito.times(1)).deleteById(1);
    }

    // ❌ Test deleteTrainee (not found)
    @Test
    void testDeleteTraineeFailure() {
        Mockito.when(repo.existsById(1)).thenReturn(false);

        boolean result = service.deleteTrainee(1);

        assertFalse(result);

        Mockito.verify(repo, Mockito.times(1)).existsById(1);
    }

    // ✅ Test findByName
    @Test
    void testFindByName() {
        Trainee t = new Trainee(1, "Shreya", "Java", "Delhi");

        Mockito.when(repo.findBytraineeName("Shreya"))
                .thenReturn(Optional.of(t));

        Optional<Trainee> result = service.findBytraineeName("Shreya");

        assertTrue(result.isPresent());
        assertEquals("Shreya", result.get().getTraineeName());

        Mockito.verify(repo, Mockito.times(1))
                .findBytraineeName("Shreya");
    }
}