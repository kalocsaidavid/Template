package com.example.demo.template;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class TemplateHandlerImpl implements TemplateHandler {
	private String fileName;
	private VelocityContext context;
	
	@Override
	public void setTemplateFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void setTemplateContext(VelocityContext context) {
		this.context = context;
	}
	
	@Override
	public String convertTemplate() {
		final VelocityEngine ve = new VelocityEngine();
		ve.init();

		Template t = ve.getTemplate(this.fileName);
		StringWriter writer = new StringWriter();
		t.merge(context, writer);

		return writer.toString();
	}
}
