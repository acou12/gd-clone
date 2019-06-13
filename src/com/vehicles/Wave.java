package com.vehicles;

import java.awt.Color;

import com.Game;
import com.Player;
import com.Vehicle;

public class Wave extends Vehicle {
	
	private static float WAVE_STEEPNESS = 8;

	@Override
	public void click(Player p) {
		
	}

	@Override
	public void tick(Player p) {
		if (Game.g.mousePressed) {
			p.setyVelocity(-WAVE_STEEPNESS);
		} else {
			p.setyVelocity(WAVE_STEEPNESS);	
		}
	}
	
	@Override
	public Color getColor() {
		return Color.BLUE;
	}
}
