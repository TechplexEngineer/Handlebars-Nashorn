/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.techplex.handlebars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author techplex
 */
public class Handlebars {
	
	//Handlebars should share the script engine
	private ScriptEngine engine;
	
	private List<Template> templates;
	
	
	public Handlebars() {
		engine = new ScriptEngineManager().getEngineByName("nashorn");
		InputStream is = this.getClass().getResourceAsStream("/handlebars-v4.0.5.js");
		try {
			engine.eval(new InputStreamReader(is));
		} catch (ScriptException ex) {
			Logger.getLogger(Handlebars.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	Template compile(String tplstr) {
		Invocable inv = (Invocable) this.engine;
		try {
			String jstpl = (String)inv.invokeFunction("Handlebars.compile", tplstr);
			Template tpl = new Template(this, jstpl);
			return tpl;
		} catch (ScriptException | NoSuchMethodException ex) {
			Logger.getLogger(Handlebars.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	String render(Template tpl) {
		String jstpl = tpl.getCompiledTemplate();
		
		
	}
	
}
