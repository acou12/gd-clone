package com.vehicles;

import java.awt.Color;

import com.Game;
import com.Player;
import com.Vehicle;

public class Cube extends Vehicle {

	public static final float JUMP_HEIGHT = 10;
		
	@Override
	public void click(Player p) {
		
	}

	@Override
	public void tick(Player p) {
		if (Game.g.mousePressed && Game.g.mouseButton == Game.g.LEFT && p.isGrounded()) {
			p.setyVelocity(JUMP_HEIGHT * Game.getGravityConstant());
			p.setGrounded(false);
		}
	}

	@Override
	public Color getColor() {
		return Color.GREEN;
	}
	
}
