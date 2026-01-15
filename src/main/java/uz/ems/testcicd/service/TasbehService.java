package uz.ems.testcicd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.ems.testcicd.model.TasbehCount;
import uz.ems.testcicd.model.repo.TasbehRepository;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TasbehService {

    private final TasbehRepository tasbehRepository;

    public Map<String, Object> getCounts(Long userId) {
        TasbehCount me = tasbehRepository.findByUserId(userId);
        TasbehCount other = tasbehRepository.findByUserId(userId == 1L ? 2L : 1L);

        return Map.of(
                "meName", me.getUser().getUsername(),
                "me", me.getCount(),
                "otherName", other.getUser().getUsername(),
                "other", other.getCount()
        );
    }

    public Map<String, Long> increase(Long userId) {
        TasbehCount me = tasbehRepository.findByUserId(userId);
        TasbehCount other = tasbehRepository.findByUserId(userId == 1L ? 2L : 1L);

        me.setCount(me.getCount() + 1);
        tasbehRepository.save(me);

        return Map.of(
                "me", me.getCount(),
                "other", other.getCount()
        );
    }
}
