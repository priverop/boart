package es.boart.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import es.boart.services.PublicationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class smokeTest {

	@Autowired
	private PublicationService ps;
	
	@Test
	public void smokeWeedEveryday() throws Exception{
		assertThat(ps).isNotNull();
	}
	
}
