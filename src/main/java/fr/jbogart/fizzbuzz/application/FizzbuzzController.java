package fr.jbogart.fizzbuzz.application;

import fr.jbogart.fizzbuzz.domain.FizzbuzzService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fizzbuzz")
public class FizzbuzzController {

    private final FizzbuzzService fizzbuzzService;

    public FizzbuzzController(FizzbuzzService fizzbuzzService) {
        this.fizzbuzzService = fizzbuzzService;
    }

    @PostMapping(consumes = {"application/json"})
    public ResponseEntity<List<String>> generateFizzbuzz(@RequestBody FizzbuzzRequest body) {

        if (body.getInt1() < 1 || body.getInt2() < 1 || body.getLimit() < 1) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        if (body.getStr1() == null || body.getStr2() == null) {
            return ResponseEntity.badRequest().build();
        }

        List<String> strings = fizzbuzzService.generateSequence(body.getInt1(), body.getInt2(), body.getLimit(), body.getStr1(), body.getStr2());
        return ResponseEntity.status(HttpStatus.CREATED).body(strings);
    }

}
