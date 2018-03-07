package ro.schedulerbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.schedulerbot.persistence.model.Subscriber;
import ro.schedulerbot.persistence.repo.SubscriberRepo;

@Service
public class DummyService {
	
	@Autowired
	SubscriberRepo subscriberRepo;

	public void saveDummySubscriber(){
		Subscriber subscriber = new Subscriber();
		subscriber.setId(Long.valueOf(1));
		subscriber.setName("Aaaaa");
	}
	
}
