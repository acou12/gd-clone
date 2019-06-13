package com.vehicles;

import java.awt.Color;

import com.Player;
import com.Vehicle;

public class Ufo extends Vehicle {

	public static final float JUMP_HEIGHT = 10;
		

	@Override
	public void click(Player p) {
		p.setyVelocity(-JUMP_HEIGHT);
		p.setGrounded(false);
	}

	@Override
	public void tick(Player p) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Color getColor() {
		return Color.ORANGE;
	}

}
