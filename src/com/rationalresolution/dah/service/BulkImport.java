package com.rationalresolution.dah.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public static void parseCardtoJava(String datafile, String cardtype) {		
		String sInput = "";
		ArrayList<String> incArray = new ArrayList<>();
		String sourceBlank = "_";
		String targetBlank = "[BLANK]";
		Pattern p = Pattern.compile(sourceBlank);
		Matcher m;
		
		for (String string : incArray) {
			m = p.matcher(sInput);
			int count = 0;
			while (m.find()) {
				count++;
			}
			if(count < 2) {						
				sInput = sInput.replace(sourceBlank, targetBlank);
				sInput = sInput.replace("'", "''");
				sInput = sInput.replace("&#34;", "\"");
				if(cardtype.equals("BlackCard")) {
					new BlackCard(sInput, count);
				}
				else if (cardtype.equals("WhiteCard")) {
					new WhiteCard(sInput);
				}
				else {
					System.out.println("Error - illegal cardtype (BlackCard/WhiteCard)");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		parseCardtoJava("answers.txt", "WhiteCard");
	}
}



