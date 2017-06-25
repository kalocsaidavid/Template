package com.example.demo.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.VelocityContext;

public class TemplateContextBuilderImpl implements TemplateContextBuilder{
	private static final String DEFAULT_OBJECT_NAME = "data";
	private static final String DEFAULT_LIST_NAME = "list";
	
	private Map<String, Map<String,String>> objects = new HashMap<>();
	private Map<String, ArrayList<Map<String, String>>> lists = new HashMap<>();
	
	@Override
	public TemplateContextBuilderImpl addProperty (String propertyName, String propertyValue) {
		return this.addNamedProperty(DEFAULT_OBJECT_NAME, propertyName, propertyValue);
	}
	
	@Override
	public TemplateContextBuilderImpl addList (Map<String, String> map) {
		return this.addNamedList(DEFAULT_LIST_NAME, map);
	}
	
	@Override
	public TemplateContextBuilderImpl addNamedProperty (String objectName, String propertyName, String propertyValue) {
		Map<String,String> selectedMap;
		if (!objects.containsKey(objectName)) {
			selectedMap = new HashMap<>();
			selectedMap.put(propertyName, propertyValue);
			objects.put(objectName, selectedMap);
		} else {
			selectedMap = objects.get(objectName);
			selectedMap.put(propertyName, propertyValue);
		}
		return this;
	}
	
	@Override
	public TemplateContextBuilderImpl addNamedList (String listName, Map<String, String> map) {
		ArrayList<Map<String, String>> selectedList;
		
		if (!lists.containsKey(listName)) {
			selectedList = new ArrayList<Map<String, String>>();
			selectedList.add(map);
			lists.put(listName, selectedList);
		} else {
			selectedList = lists.get(listName);
			selectedList.add(map);
		}
		return this;
	}
	
	@Override
	public VelocityContext getTemplateContext() {
		VelocityContext context = new VelocityContext();
		this.packObjectsIntoContext(context);
		this.packListsIntoContext(context);
		return context;
	}
	
	private void packObjectsIntoContext(final VelocityContext context) {
		for (Map.Entry<String, Map<String, String>> object : objects.entrySet()) {
		    context.put(object.getKey(), object.getValue());
		}
	}
	
	private void packListsIntoContext(final VelocityContext context) {
		for (Map.Entry<String, ArrayList<Map<String, String>>> list : lists.entrySet()) {
		    context.put(list.getKey(), list.getValue());
		}
	}
	
	@Override
	public String toString() {
		StringBuilder details = new StringBuilder();
		for (Map.Entry<String, Map<String, String>> object : objects.entrySet()) {
			String objectName = "[Object name is " + object.getKey() + " : \n";
		    details.append(objectName + object.getValue().toString());
		    details.append("]\n");
		}
		for (Map.Entry<String, ArrayList<Map<String, String>>> list : lists.entrySet()) {
			String objectName = "[List name is " + list.getKey()  + " : \n";
		    details.append(objectName + list.getValue().toString());
		    details.append("]\n");
		}
		return details.toString();
	}	
}
