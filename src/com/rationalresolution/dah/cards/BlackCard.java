package com.rationalresolution.dah.cards;

import javax.persistence.*;

@Entity
@Table(name = "CARDBLACKCARD")
public class BlackCard extends Card {
	//	Fields
	
	@Column(name = "bcPKey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bcPKey;
	
	@Column(name = "CARDID")
	@JoinColumn(name = "cbPKey")
	private int bccbFKey								= getCardID();
	
	@Column(name = "bcBlanks")
	private int blanks 									= 0;
	
	
	private String[] qStructure;
	
	@Column(name = "bcQStructSwitch")
	private char qStructSwitch 							= 'z';															//	a = [blank / text], b = [text / blank], c = [text / blank /text], d = [text?]

	public static final String blank 					= "______________";

	//	Constructor
	public BlackCard() {																		//	Default Constructor (for beans, but should not be used)
		
	}
	
	public BlackCard(int id, String text) {
		super(id, text);
		parseQuestion(text);
		for (String string : qStructure) {
			setReadAloud(defTextToVoice(string));
		}
	}
	
	//	Accessor Methods
	public int getBcPKey()					{ return bcPKey;		}
	public int getBlanks()					{ return blanks;		}
	public String[] getQStructure()			{ return qStructure;	}
	
	public void setBlanks()					{ blanks++;				}
	@Override
	public void setCardText(String text) {														//	Need QA and Database work on card text
		//	ensure no duplicates in DB
		parseQuestion(text);
		for (String string : qStructure) {
			setReadAloud(defTextToVoice(string));
		}
	}
	
	//	Methods
	public void parseQuestion(String text) {
		if(text.contains("[BLANK]")) {
			blanks = 1;
			if(text.startsWith("[BLANK]")) {
				setBlanks();
				qStructure = new String[1];
				qStructure[0] = text.substring(6);
				qStructSwitch = 'a';						//	[Blank / Text]
			}
			else if(text.endsWith("[BLANK].") || text.endsWith("[BLANK]?") || text.endsWith("[BLANK]!")) {
				setBlanks();
				qStructure = new String[2];
				qStructure[1] = text.substring(text.length()-1, text.length());
				qStructure[0] = text.replace("[BLANK]", "");
				qStructSwitch = 'b';						//	[Text / Blank]
			}
			else {
				setBlanks();
				qStructure = text.split("[BLANK]", 2);
				qStructSwitch = 'c';						//	[Text / Blank / Text]
			}
		}
		else { 
			qStructure = new String[1];
			qStructure[0] = text;
			qStructSwitch = 'd'; 							//	[Text]
		}
	}
	
	public String displayQuestion(String[] qStruct, char qStructSwitch) {
		switch(qStructSwitch) {
		case 'a':	return (blank + qStructure[0]);
		case 'b':	return (qStructure[0] + " " + blank + qStructure[1]);
		case 'c':	return (qStructure[0] + " " + blank + " " + qStructure[2]);
		case 'd':	return (qStructure[0]);
		default:	return "Error in qStrucutre of black card";
		}
	}
	
	public void setReadAloud() {							//	if no parameter, use default method to make sound file
		for (String text : qStructure) {
			setReadAloud(defTextToVoice(text));
		}
		
	}
	
	public String defTextToVoice(String text) {
		// api to text-to-voice service
		return "DEFAULT";
	}
}
