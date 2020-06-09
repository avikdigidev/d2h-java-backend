package com.techv.prakash.utils;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class InputAsker {
	private  Scanner scanner;
	private  PrintStream out;
	
	 public InputAsker(InputStream in, PrintStream out) {
	        scanner = new Scanner(in);
	        this.out = out;
	    }

//	    public int ask(String message) {
//	        out.println(message);
//	        return scanner.nextInt();
//	    }
	    
		public String askStringValue(String message) {
	    	out.println(message);
	    	scanner = new Scanner(System.in);
	    	return scanner.nextLine();
	    }
}
