package uz.ems.testcicd.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import uz.ems.testcicd.model.TasbehCount;
import uz.ems.testcicd.model.User;
import uz.ems.testcicd.model.repo.TasbehRepository;
import uz.ems.testcicd.model.repo.UserRepository;

@Component
public class Runner implements CommandLineRunner {
    private final UserRepository userRepository;
    private final TasbehRepository tasbehRepository;

    public Runner(UserRepository userRepository, TasbehRepository tasbehRepository) {
        this.userRepository = userRepository;
        this.tasbehRepository = tasbehRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findAll().isEmpty()) {
            User me = new User();
            me.setId(1L);
            me.setUsername("QALANDAR");
            me.setPassword("2201");
            User her = new User();
            her.setId(2L);
            her.setUsername("NIGINA");
            her.setPassword("0526");
            userRepository.save(her);
            userRepository.save(me);
        }
        if (tasbehRepository.findAll().isEmpty()) {
            TasbehCount tasbehCount = new TasbehCount(1L,userRepository.findById(1L).get(),0L);
            TasbehCount tasbehCount2 = new TasbehCount(2L,userRepository.findById(2L).get(),0L);
            tasbehRepository.save(tasbehCount);
            tasbehRepository.save(tasbehCount2);
        }
    }
}
