package com.vehicles;

import java.awt.Color;

import com.Game;
import com.Player;
import com.Vehicle;

public class Ship extends Vehicle {
	
	@Override
	public void click(Player p) {}

	@Override
	public void tick(Player p) {
		if (Game.g.mousePressed && Game.g.mouseButton == Game.g.LEFT) {
			p.setyVelocity(p.getyVelocity() + 2 * Game.GRAVITY * Game.getGravityConstant());
		}
	}

	@Override
	public Color getColor() {
		return Color.CYAN;
	}

}
