package com.rationalresolution.dah.players;

import javax.persistence.*;

@Entity
@Table(name = "LOCALPLAYER")
public class LocalPlayer extends Player {
	//	Fields
	
	@Column(name = "lpPKey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lpPKey;
	

	private int lpplFKey					= getPlayerID();
	
	@Column(name = "lpPassword")
	private String password;
	
	//	Constructor
	public LocalPlayer() {
		
	}
	
	public LocalPlayer(String u, String p) {
		super(u);
		setPassword(p);
	}
	
	//	Accessor Methods
	public String getPassword()			{ return password;			}
	public void setPassword(String p)	{ password = p; }					//	I think there is some password automation avail
	
	
	//	Methods
	@Override
	public int decideCard() {						//	ROUND OF PLAY STEP 2
		//	Have player select the card they want to play
		int x = 0;	// this will be return from ChooseCard.jsp
		return x;
	}
	

}
