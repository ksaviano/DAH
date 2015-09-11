package com.rationalresolution.dah.players;

import com.rationalresolution.dah.cards.WhiteCard;

public interface Player {
	public void setHand(WhiteCard wc, int a);
	public int decideCard();
	public WhiteCard playCard(int x);
	public WhiteCard[] getHand();
	public void discard(int x);
}
