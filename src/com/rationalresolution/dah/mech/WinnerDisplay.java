package com.rationalresolution.dah.mech;

import com.rationalresolution.dah.cards.WhiteCard;

public class WinnerDisplay {
	//	Fields
	String winneravatar;
	WhiteCard winningcard;
	int x;
	int totalRndNum;
	
	//	Constructor
	public WinnerDisplay(String a, WhiteCard wc, int x) {
		setWinneravatar(a);
		setWinningcard(wc);
		setX(x);
		setTotalRndNum();

	}
	
	//	Accessor Methods
	public String getWinneravatar()		{ return winneravatar;	}
	public WhiteCard getWinningcard()	{ return winningcard;	}
	public int getX()					{ return x;				}
	public int getTotalRndNum()			{ return totalRndNum; }
	
	public void setWinneravatar(String a)		{ winneravatar = a;	}
	public void setWinningcard(WhiteCard wc)	{ winningcard = wc;	}
	public void setX(int x)						{ this.x = x; 		}
	public void setTotalRndNum()				{ totalRndNum = GameDeck.getTotalRounds(); }

}
