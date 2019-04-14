package br.com.bravi.api.resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PessoaResourceTests {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mock;
	
	@Before
	public void setUp() {
		mock = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void getPessoaTest() throws Exception {
		String uriPessa = "/pessoas/2"; 
		System.out.println(mock.perform(get(uriPessa)).andDo(print()));
		mock.perform(get(uriPessa))
			.andExpect(status().isOk());
	}
	
	@Test
	public void postPessoaTest() throws Exception {
		String uriPessa = "/pessoas"; 
		mock.perform(
				MockMvcRequestBuilders
					.post(uriPessa)
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content("{\r\n" + 
							"    \"nome\": \"teste 1234\",\r\n" + 
							"    \"contato\": [\r\n" + 
							"        {\r\n" + 
							"            \"email\": \"teste@bravi.com 20\",\r\n" + 
							"            \"watsapp\": \"watsapp 1 123456\"\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"            \"email\": \"teste@bravi.com 20\",\r\n" + 
							"            \"watsapp\": \"watsapp 2 321654\"\r\n" + 
							"        }\r\n" + 
							"    ]\r\n" + 
							"}")
				).andExpect(status().isCreated());
			
	}
	
	@Test
	public void putPessoaTest() throws Exception {
		String uriPessa = "/pessoas/15"; 
		mock.perform(
				MockMvcRequestBuilders
					.put(uriPessa)
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.content("{\r\n" + 
							"    \"nome\": \"teste 1234\",\r\n" + 
							"    \"contato\": [\r\n" + 
							"        {\r\n" + 
							"            \"email\": \"teste@bravi.com 20\",\r\n" + 
							"            \"watsapp\": \"watsapp 1 123456\"\r\n" + 
							"        },\r\n" + 
							"        {\r\n" + 
							"            \"email\": \"teste@bravi.com 20\",\r\n" + 
							"            \"watsapp\": \"watsapp 2 321654\"\r\n" + 
							"        }\r\n" + 
							"    ]\r\n" + 
							"}")
				).andExpect(status().isCreated());
			
	}
	
	@Test
	public void deletePessoaTest() throws Exception {
		String uriPessa = "/pessoas/15"; 
		mock.perform(MockMvcRequestBuilders.delete(uriPessa)).andExpect(status().isOk());
			
	}
	
}
