package es.boart.rest;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import es.boart.services.PublicationService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PublicationTest {

	private final String API_PUBLICATION		= "/api/publication/";
	private final int ALL_PUBLICATIONS 			= 9; 
	private final String MOST_LIKED_PUBLICATION = "NORWAY"; 
	private final int ID_PUBLICATION = 41;
	
	@Autowired
	private PublicationService ps;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Resource
    private FilterChainProxy springSecurityFilterChain;
 
    @Resource
    private WebApplicationContext webApplicationContext;
    
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilter(springSecurityFilterChain)
                .build();
    }

	@Test
	public void findAllPublication() throws Exception{
		this.mockMvc.perform(get(API_PUBLICATION+"list")).andExpect(status().isBadRequest());
	}
	
	@Test
	public void findLikesPublication() throws Exception{
		this.mockMvc.perform(post(API_PUBLICATION+"list")
		.param("filter", "likes"))
		.andDo(print()).andExpect(status().isUnauthorized());
	}
	
	@Test
	public void findPublication() throws Exception{
		this.mockMvc.perform(get(API_PUBLICATION+ID_PUBLICATION))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString(MOST_LIKED_PUBLICATION)));
	}
	
	@Test
	public void publicationDoesntExists() throws Exception{
		this.mockMvc.perform(get(API_PUBLICATION+999999))
		.andDo(print()).andExpect(status().isNotFound());
	}
	
}
