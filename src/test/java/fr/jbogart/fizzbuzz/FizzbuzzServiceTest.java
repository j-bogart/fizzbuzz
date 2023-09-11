package fr.jbogart.fizzbuzz;

import fr.jbogart.fizzbuzz.application.FizzbuzzDTO;
import fr.jbogart.fizzbuzz.domain.FizzbuzzEntity;
import fr.jbogart.fizzbuzz.domain.FizzbuzzService;
import fr.jbogart.fizzbuzz.generic.FizzbuzzRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FizzbuzzServiceTest {

    @InjectMocks
    private FizzbuzzService service;

    @Mock
    private FizzbuzzRepository repository;

    @Test
    void generateSequence_with_valid_input_should_return_expected_result() {
        // Arrange
        List<String> expectedResult = List.of("1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz", "16", "17", "fizz", "19", "buzz");
        when(repository.findByRequest(any())).thenReturn(Optional.of(new FizzbuzzEntity()));

        // Act
        List<String> result = service.generateSequence(new FizzbuzzDTO(3, 5, 20, "fizz", "buzz"));

        // Assert
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getStatistics_with_empty_database_should_return_empty_string() {
        //Arrange
        String expectedResult = "";
        when(repository.findFirstByOrderByCounterDesc()).thenReturn(Optional.empty());

        //Act
        String result = service.getStatistics();

        //Assert
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void getStatistics_should_return_expected_result() {
        // Arrange
        String expectedResult = "{\"int1\":3,\"int2\":5,\"limit\":20,\"str1\":\"fizz\",\"str2\":\"buzz\",\"count\":1}";

        FizzbuzzEntity entity = new FizzbuzzEntity();
        entity.setRequest("{\"int1\":3,\"int2\":5,\"limit\":20,\"str1\":\"fizz\",\"str2\":\"buzz\"}");
        entity.setCounter(1);
        when(repository.findFirstByOrderByCounterDesc()).thenReturn(Optional.of(entity));

        //Act
        String result = service.getStatistics();

        //Assert
        assertThat(result).isEqualTo(expectedResult);
    }

}