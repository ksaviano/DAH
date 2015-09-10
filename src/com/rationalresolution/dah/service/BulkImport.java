package com.rationalresolution.dah.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BulkImport {
	public static ArrayList<String> parseWhiteCardtoSQL(String datafile) {
		String sInput;
		ArrayList<String> incArray = new ArrayList<>();

		try(FileReader     fReader    = new FileReader(datafile); 			//	with ArrayList, just read in file
			BufferedReader inFromFile = new BufferedReader(fReader)) {		//	1 line at a time, return incArray
				while((sInput = inFromFile.readLine()) != null) {
					sInput = sInput.replace("'", "''");
					incArray.add("INSERT INTO APP.CARDWHITECARD (\"wcCardText\") VALUES ('" + sInput + "');\n");
				}
		}
		catch(Exception e) {
			System.out.println("parseWhiteCardtoSQL:\n" + e);
		}
		return incArray;
	}
	
	public static ArrayList<String> parseWhiteCardtoJava(String datafile) {
		String sInput;
		ArrayList<String> incArray = new ArrayList<>();

		try(FileReader     fReader    = new FileReader(datafile); 			//	with ArrayList, just read in file
			BufferedReader inFromFile = new BufferedReader(fReader)) {		//	1 line at a time, return incArray
				while((sInput = inFromFile.readLine()) != null) {
					sInput = sInput.replace("'", "''");
					incArray.add(sInput);
				}
		}
		catch(Exception e) {
			System.out.println("parseWhiteCardtoJava:\n" + e);
		}
		return incArray;
	}
	
	public static void createWhiteSQLFile(ArrayList<String> incArray) {
		String filename = "WhiteCardSQL.sql";
		
		try(FileWriter 		fWriter		= new FileWriter(filename);
			BufferedWriter  inFromFile  = new BufferedWriter(fWriter)) {
			for (String string : incArray) {
				fWriter.write(string);
			}
		}
		catch(Exception e) {
			System.out.println("createWhiteSQLFile:\n" + e);
		}
	}
	
	public static ArrayList<String> parseBlackCardtoSQL(String datafile) {
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
					incArray.add("INSERT INTO APP.CARDBLACKCARD (\"bcQuestionText\") VALUES ('" + sInput + "');\n");
				}
			}
		}
		catch(Exception e) {
			System.out.println("parseBlackCardtoSQL:\n" + e);
		}
		return incArray;
	}

	public static ArrayList<String> parseBlackCardtoJava(String datafile) {
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
					incArray.add(sInput);
				}
			}
		}
		catch(Exception e) {
			System.out.println("parseBlackCardtoJava:\n" + e);
		}
		return incArray;
	}
	public static void constructWhiteCards(ArrayList<String> incArray) {
		
	}
	
	
	public static void createBlackSQLFile(ArrayList<String> incArray) {
		String filename = "BlackCardSQL.sql";
		
		try(FileWriter		fWriter		= new FileWriter(filename);
			BufferedWriter	inFromFile	= new BufferedWriter(fWriter)) {
			for(String string : incArray) {
				fWriter.write(string);
			}
		}
		catch(Exception e) {
			System.out.println("createBlackSQLFile:\n" + e);
		}
	}
	
	public static void main(String[] args) {
		createWhiteSQLFile(parseWhiteCard("/Users/KSaviano/Documents/answers.txt"));
		createBlackSQLFile(parseBlackCard("/Users/KSaviano/Documents/questions.txt"));
	}
}



