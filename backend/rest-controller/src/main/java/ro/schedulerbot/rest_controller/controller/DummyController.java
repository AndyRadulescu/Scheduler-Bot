package ro.schedulerbot.rest_controller.controller;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ro.schedulerbot.service.DummyService;

@RestController
@RequestMapping("/api")
public class DummyController {

	@Autowired
	DummyService dummyService;
	
	@RequestMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public String saveSubscriber() throws ParseException {
		dummyService.saveDummySubscriber();
		return "ok";
	}
	
	@RequestMapping(value = "/ex/foos", method = RequestMethod.GET)
	@ResponseBody
	public String getFoosBySimplePath() {
	    return "Get some Foos";
	}
}
