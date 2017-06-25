package com.example.demo.template;

import java.util.Map;

import org.apache.velocity.VelocityContext;

public interface TemplateContextBuilder {
	
	TemplateContextBuilderImpl addProperty (String propertyName, String propertyValue);
	
	TemplateContextBuilderImpl addList (Map<String, String> map);
	
	TemplateContextBuilderImpl addNamedProperty (String objectName, String propertyName, String propertyValue);
	
	TemplateContextBuilderImpl addNamedList (String listName, Map<String, String> map);
	
	VelocityContext getTemplateContext();
}
