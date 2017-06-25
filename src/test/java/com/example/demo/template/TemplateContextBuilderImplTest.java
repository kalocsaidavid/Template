package com.example.demo.template;

import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class TemplateContextBuilderImplTest {

	@InjectMocks
	TemplateContextBuilderImpl templatecontextBuilder;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void objectsShouldContainTwoObjectsWhenAddedTwoObjects() {
		templatecontextBuilder.addNamedProperty("Person", "Age", "23")
							  .addNamedProperty("Person","Hair", "Blond")
							  .addNamedProperty("Animal","Age", "45")
							  .addNamedProperty("Animal","Nose", "big");
		
		System.out.println(templatecontextBuilder.toString());
	}
	
	@Test
	public void objectsShouldContainTwoListsWhenAddedTwoLists() {
		Map<String, String> location = new HashedMap();
		location.put("Country", "Hungary");
		location.put("City", "Budapest");
		Map<String, String> location2 = new HashedMap();
		location2.put("Country", "Austria");
		location2.put("City", "Vienna");
		
		Map<String, String> animals = new HashedMap();
		animals.put("Type", "Dog");
		animals.put("Name", "Bob");
		Map<String, String> animals2 = new HashedMap();
		animals2.put("Type", "Cat");
		animals2.put("Name", "Suzy");
		
		
		templatecontextBuilder.addNamedList("location",location)
							  .addNamedList("location",location2)
							  .addNamedList("animals",animals)
							  .addNamedList("animals",animals2);
		
		System.out.println(templatecontextBuilder.toString());
	}
}