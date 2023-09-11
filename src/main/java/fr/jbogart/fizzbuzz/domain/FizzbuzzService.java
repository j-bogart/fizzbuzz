package fr.jbogart.fizzbuzz.domain;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.jbogart.fizzbuzz.application.FizzbuzzDTO;
import fr.jbogart.fizzbuzz.generic.FizzbuzzRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FizzbuzzService {

    final FizzbuzzRepository fizzbuzzRepository;

    public FizzbuzzService(FizzbuzzRepository fizzbuzzRepository) {
        this.fizzbuzzRepository = fizzbuzzRepository;
    }

    public List<String> generateSequence(FizzbuzzDTO fizzbuzzDTO) {
        String request = new Gson().toJson(fizzbuzzDTO);

        FizzbuzzEntity fizzbuzzEntity = fizzbuzzRepository.findByRequest(request).orElse(new FizzbuzzEntity());
        fizzbuzzEntity.setRequest(request);
        fizzbuzzEntity.setCounter(fizzbuzzEntity.getCounter() + 1);

        fizzbuzzRepository.save(fizzbuzzEntity);

        return calculate(fizzbuzzDTO.getInt1(), fizzbuzzDTO.getInt2(), fizzbuzzDTO.getLimit(), fizzbuzzDTO.getStr1(), fizzbuzzDTO.getStr2());
    }

    public String getStatistics() {
        Optional<FizzbuzzEntity> entity = fizzbuzzRepository.findFirstByOrderByCounterDesc();

        if (entity.isPresent()) {
            JsonObject statistics = JsonParser.parseString(entity.get().getRequest()).getAsJsonObject();
            statistics.addProperty("count", entity.get().getCounter());

            return statistics.toString();
        }

        return "";
    }

    private List<String> calculate(int int1, int int2, int limit, String str1, String str2) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= limit; ++i) {
            if (i % (int1 * int2) == 0) {
                result.add(str1.concat(str2));
            } else if (i % int1 == 0) {
                result.add(str1);
            } else if (i % int2 == 0) {
                result.add(str2);
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

}
