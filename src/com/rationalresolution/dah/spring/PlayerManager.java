package com.rationalresolution.dah.spring;

import com.rationalresolution.dah.players.LocalPlayer;

public class PlayerManager implements UserDAO {

	
	
	//	Methods
	public LocalPlayer getPlayer(LocalPlayer p) {
		LocalPlayer onlyPlayer = new LocalPlayer("player1", "password");
		
		if(p.getUsername().equals(onlyPlayer.getUsername()) && p.getPassword().equals(onlyPlayer.getPassword())) {
			return onlyPlayer;
		}
		return null;
	}
	
	public boolean playerExists(String username) {
		return false;
	}
}
