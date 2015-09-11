package com.rationalresolution.dah.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rationalresolution.dah.cards.*;

public class BulkImport {	
	public static ArrayList<String> parseCardtoSQL(String datafile, String cardtype) {
		String fieldname = "";
		String tablename = "";
		if(cardtype.equals("BlackCard")) {									//	parse BlackCard
			fieldname = "bcQuestionText";									
			tablename = "APP.CARDBLACKCARD";								
		}
		else if(cardtype.equals("WhiteCard")) {								//  parse WhiteCard
			fieldname = "wcCardText";										
			tablename = "APP.CARDWHITECARD";								
		}
		else {
			System.out.println("Error - illegal cardtype (BlackCard/WhiteCard)");
			return new ArrayList<String>();
		}
		
		String sInput;
		ArrayList<String> incArray = new ArrayList<>();
		String sourceBlank = "_";
		String targetBlank = "[BLANK]";
		Pattern p = Pattern.compile(sourceBlank);
		Matcher m;
		
		try(FileReader		fReader		= new FileReader(datafile);
			BufferedReader	inFromFile	= new BufferedReader(fReader)) {
			while((sInput = inFromFile.readLine()) != null) {
				m = p.matcher(sInput);
				int count = 0;
				while (m.find()) {
					count++;
				}
				if(count < 2) {						
					sInput = sInput.replace(sourceBlank, targetBlank);
					sInput = sInput.replace("'", "''");
					sInput = sInput.replace("&#34;", "\"");
					incArray.add("INSERT INTO " + tablename + "(\"" + fieldname + "\") VALUES ('" + sInput + "');\n");
				}
			}
		}
		catch(Exception e) {
			System.out.println("parseCardtoSQL:\n" + e);
		}
		return incArray;
	}

	public static void createSQLFile(ArrayList<String> incArray, String cardtype) {
		String filename = "";
		if(cardtype.equals("BlackCard")) {
			filename = "BlackCardSQL.sql";
		}
		else if(cardtype.equals("WhiteCard")) {
			filename = "WhiteCardSQL.sql";
		}
		else {
			System.out.println("Error - illegal cardtype (BlackCard/WhiteCard)");
			return;
		}
		
		try(FileWriter 		fWriter		= new FileWriter(filename);
			BufferedWriter  inFromFile  = new BufferedWriter(fWriter)) {
			for (String string : incArray) {
				fWriter.write(string);
			}
		}
		catch(Exception e) {
			System.out.println("createSQLFile:\n" + e);
		}
	}
	public static int parseCardtoJava(String datafile, String cardtype) {		
		String sInput = "";
		ArrayList<String> incArray = new ArrayList<>();
		String sourceBlank = "_";
		String targetBlank = "[BLANK]";
		Pattern p = Pattern.compile(sourceBlank);
		Matcher m;
		int cardcount = 0;
		int indexcount = 0;
		int lastIndex = 0;
		
		EntityManagerFactory emf = null;
		EntityManager em = null;
		emf = Persistence.createEntityManagerFactory("DAH");
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try(FileReader		fReader		= new FileReader(datafile);
			BufferedReader	inFromFile	= new BufferedReader(fReader)) {
			while((sInput = inFromFile.readLine()) != null) {
				m = p.matcher(sInput);
				if(cardtype.equals("BlackCard")) {
					m.find();					
					sInput = sInput.replace(sourceBlank, targetBlank);
					sInput = sInput.replace("'", "''");
					sInput = sInput.replace("&#34;", "\"");
					while(lastIndex != -1){
					    lastIndex = sInput.indexOf(targetBlank,lastIndex);
					    if(lastIndex != -1) {
					        indexcount++;
					        lastIndex += targetBlank.length();
					    }
					}
					    et.begin();
					    	em.persist(new BlackCard(sInput, indexcount));
					    	indexcount = 0;
					    	lastIndex = 0;
					    et.commit();
				}
				else if (cardtype.equals("WhiteCard")) {
					et.begin();
					em.persist(new WhiteCard(sInput));
					et.commit();
				}
				else {
					System.out.println("Error - illegal cardtype (BlackCard/WhiteCard)");
				}
			}	
		}
		catch(Exception e) {
			System.out.println("Error when parsing file:\n" + e);
		}
		return cardcount;
	}
	
	public static void main(String[] args) {

		try {
//			et.begin();
			int x = parseCardtoJava("answers.txt", "WhiteCard");
			System.out.println("White Cards added: " + x);
			int y = parseCardtoJava("questions.txt", "BlackCard");
			System.out.println("Black Cards added: " + y);
//			et.commit();
		}
		catch(Exception e) {
			System.out.println("Error in Bulk Upload\n" + e);
		}
	}
}



