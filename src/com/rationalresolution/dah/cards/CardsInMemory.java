package com.rationalresolution.dah.cards;

import java.util.ArrayList;
import java.util.List;


public class CardsInMemory {
	//	Fields
	private List<BlackCard> blackcards = new ArrayList<>();
	private List<WhiteCard> whitecards = new ArrayList<>();
	private String name = "Black Cards";
	
	private void loadBlackCards() {
		blackcards.add(new BlackCard(1, "What killed my boner?"));
		blackcards.add(new BlackCard(2, "What did I bring back from Mexico?"));
		blackcards.add(new BlackCard(3, "[BLANK]. It's a trap!"));
		blackcards.add(new BlackCard(4, "Next on ESPN8, the World Series of [BLANK]."));
		blackcards.add(new BlackCard(5, "After the earthquake, Sean Penn brought [BLANK] to the people of Haiti"));
		blackcards.add(new BlackCard(6, "But before I kill you, Mr. Bond, I must show you [BLANK]."));
		blackcards.add(new BlackCard(7, "I'm not going to lie. I despise [BLANK]. There, I said it."));
		blackcards.add(new BlackCard(8, "A wise man said, 'Everything is about sex. Except sex. Sex is about [BLANK]."));
		blackcards.add(new BlackCard(9, "Cancel all my meetings. We've got a situation with [BLANK] that requires my immediate attention."));
		blackcards.add(new BlackCard(10, "How am I maintaining my relationship status?"));
	}
	
	private void loadWhiteCards() {
		whitecards.add(new WhiteCard(1, "Racially-biased SAT questions."));
		whitecards.add(new WhiteCard(2, "Centaurs."));
		whitecards.add(new WhiteCard(3, "A salty surprise."));
		whitecards.add(new WhiteCard(4, "Embryonic stem cells."));
		whitecards.add(new WhiteCard(5, "Stormtroopers."));
		whitecards.add(new WhiteCard(6, "The profoundly handicapped."));
		whitecards.add(new WhiteCard(7, "Not wearing pants."));
		whitecards.add(new WhiteCard(8, "Date rape."));
		whitecards.add(new WhiteCard(9, "A bucket of fish heads."));
		whitecards.add(new WhiteCard(10, "72 virgins."));	
	}
	
}
