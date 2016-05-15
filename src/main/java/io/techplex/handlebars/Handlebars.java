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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 *
 * @author techplex
 */
public class Handlebars {
	
	//Handlebars should share the script engine...
	private static ScriptEngine engine;
	
	
	public Handlebars() {
		if (engine == null) {
			engine = new ScriptEngineManager().getEngineByName("nashorn");
			InputStream is = this.getClass().getResourceAsStream("/handlebars-v4.0.5.js");
			System.out.println(is);
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String readLine;
			
			try {
				while (((readLine = br.readLine()) != null)) {
					System.out.println(readLine);
				}
			} catch (IOException ex) {
				Logger.getLogger(Handlebars.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	Template compile(String string) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	

	
}
