package com.vehicles;

import java.awt.Color;

import com.Game;
import com.GravityState;
import com.Player;
import com.Vehicle;

public class Helicopter extends Vehicle {


	@Override
	public void click(Player p) {
		GravityState newState = GravityState.inverse(Game.getGravityState());
		Game.setGravityState(newState);
	}

	@Override
	public void tick(Player p) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Color getColor() {
		return Color.PINK;
	}
	
}
