package com.rationalresolution.dah.players;

import com.rationalresolution.dah.cards.*;
import javax.persistence.*;


@Table(name = "GhostPlayer")
public class GhostPlayer extends Player {
	//	Fields
	
	@Column(name = "gpPKey")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int gpPKey;
	
	@Column(name = "gpplFKey")
	@OneToOne
	@JoinColumn(name = "plPKey")
	private int gpplFKey						= getPlayerID();
	
	//	Accessor Methods
	public int getGpPKey()	{ return gpPKey;	}
	public void setGpPkey()	{}						//	NEED PROCESS FOR AUTOMATED ID
	
	//	Methods
	@Override
	public int decideCard() {					//	ROUND OF PLAY STEP 2
		//	decide which card in hand is best... for now, choose one at random		
		int x = (int) (Math.random() * 7);
		return x;
	}

}
