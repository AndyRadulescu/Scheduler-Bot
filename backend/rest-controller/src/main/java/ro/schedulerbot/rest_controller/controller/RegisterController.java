package ro.schedulerbot.rest_controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.schedulerbot.persistence.model.Subscriber;
import ro.schedulerbot.persistence.repo.SubscriberRepo;

@RestController
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    SubscriberRepo subscriberRepo;

    @PostMapping(value = "/register")
    public void register(@RequestBody Subscriber subscriber) {
        subscriberRepo.save(subscriber);
    }
}
