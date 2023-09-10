package fr.jbogart.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class FizzbuzzServiceTest {

    @InjectMocks
    private FizzbuzzService service;

    @Test
    void generateSequence_with_valid_input_should_return_expected_result() {

        // Arrange
        List<String> expectedResult = List.of("1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz", "16", "17", "fizz", "19", "buzz");

        // Act
        List<String> result = service.generateSequence(3, 5, 20, "fizz", "buzz");

        // Assert
        assertThat(result).isEqualTo(expectedResult);
    }

}