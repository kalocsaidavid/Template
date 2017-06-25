package com.example.demo.template;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class TemplateHandlerImplTest {
	
	@InjectMocks
	TemplateHandlerImpl templateHandler;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testingTemplate() {
		Map<String, String> map = new HashMap<>();
		Map<String, String> map2 = new HashMap<>();
		Map<String, String> map3 = new HashMap<>();

		map.put("name", "Cow");
		map.put("price", "$100.00");
		
		map2.put("name", "Eagle");
		map2.put("price", "$59.99");
		
		map3.put("name", "Shark");
		map3.put("price", "$3.99");
		
		VelocityContext context = new TemplateContextBuilderImpl()
				.addNamedList("petList", map)
				.addNamedList("petList", map2)
				.addNamedList("petList", map3)
				.getTemplateContext();
		
		this.templateHandler.setTemplateFileName("./src/main/resources/template.txt");
		this.templateHandler.setTemplateContext(context);
		String result = this.templateHandler.convertTemplate();
		System.out.println(result);
	}
}	
