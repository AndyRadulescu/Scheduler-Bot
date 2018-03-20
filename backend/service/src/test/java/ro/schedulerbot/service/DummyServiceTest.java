package ro.schedulerbot.service;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ro.schedulerbot.service.config.ServiceBeanConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServiceBeanConfig.class})
@TestPropertySource("classpath:application.properties")
public class DummyServiceTest {

	@Autowired
	DummyService dummy;
	
	@Test
	public void testSaveDummySubscriber() throws ParseException{
		dummy.saveDummySubscriber();
	}

}
