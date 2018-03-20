package ro.schedulerbot.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.schedulerbot.persistence.model.Subscriber;
import ro.schedulerbot.persistence.repo.SubscriberRepo;

@Service
public class DummyService {
	
	@Autowired
	SubscriberRepo subscriberRepo;

	public void saveDummySubscriber() throws ParseException{
		Subscriber subscriber = new Subscriber();
		subscriber.setId(Long.valueOf(1));
		subscriber.setName("Aaaaa");
		subscriber.setEmail("blabla");
		String s = "{\"conn\":\"blabla\"}";
		JSONParser parser = new JSONParser();
		subscriber.setFacebookConn(new JSONObject((JSONObject)parser.parse(s)));
		subscriber.setGoogleCalendarConn(new JSONObject((JSONObject)parser.parse(s)));
		subscriberRepo.save(subscriber);
	}
	
}
