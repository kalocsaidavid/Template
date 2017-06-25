package com.example.demo.template;

import org.apache.velocity.VelocityContext;

public interface TemplateHandler {
	
	void setTemplateContext(VelocityContext context);
	
	void setTemplateFileName(String fileName);
	
	String convertTemplate();	
}
