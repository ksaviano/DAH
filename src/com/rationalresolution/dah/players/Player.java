package com.rationalresolution.dah.players;

import javax.servlet.http.HttpSession;

import com.rationalresolution.dah.cards.WhiteCard;

public interface Player {
	public void setHand(WhiteCard wc, int a);
	public int decideCard(int bc, HttpSession session);
	public WhiteCard playCard(int x);
	public WhiteCard[] getHand();
	public void discard(int x);
	public String getUsername();
	public WhiteCard getRoundpick();
	public void setRoundpick(WhiteCard wc);
}
