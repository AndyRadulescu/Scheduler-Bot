package ro.schedulerbot.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class DummyServiceTest {

	@Autowired
	DummyService dummy;
	
	@Ignore
	@Test
	public void testSaveDummySubscriber(){
		dummy.saveDummySubscriber();
	}

}
