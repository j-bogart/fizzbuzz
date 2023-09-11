package fr.jbogart.fizzbuzz.application;

import fr.jbogart.fizzbuzz.domain.FizzbuzzService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fizzbuzz")
public class FizzbuzzController {

    private final FizzbuzzService fizzbuzzService;

    public FizzbuzzController(FizzbuzzService fizzbuzzService) {
        this.fizzbuzzService = fizzbuzzService;
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<List<String>> generateSequence(@RequestBody FizzbuzzDTO fizzbuzzDTO) {

        if (fizzbuzzDTO.getInt1() < 1 || fizzbuzzDTO.getInt2() < 1 || fizzbuzzDTO.getLimit() < 1) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        if (fizzbuzzDTO.getStr1() == null || fizzbuzzDTO.getStr2() == null) {
            return ResponseEntity.badRequest().build();
        }

        List<String> sequenceResult = fizzbuzzService.generateSequence(fizzbuzzDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(sequenceResult);
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<String> getStatistics() {
        return ResponseEntity.ok(fizzbuzzService.getStatistics());
    }

}
