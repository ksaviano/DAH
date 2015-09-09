package com.rationalresolution.dah.mech;

import com.rationalresolution.dah.cards.*;

public class UtilReadAloud {

	//	Utility Methods - WhiteCard
	public static void setReadAloud(WhiteCard wc) {						//	if no parameter, use default method to make sound file
		String text = wc.getCardText();
		setReadAloud(defTextToVoice(text));
	}
	
	public static void setReadAloud(String t) {							//	play sound file
		//	play sounds file t
	}
	
	public static String defTextToVoice(String text) {						//	use website to generate sound file
		// api to text-to-voice service
		return "DEFAULT";
	}
	
	public static void doReadAloud(String[] t) {
		for (String string : t) {
			//	play sound file
		}
	}
}
