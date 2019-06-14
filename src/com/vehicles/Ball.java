package com.vehicles;

import java.awt.Color;

import com.Game;
import com.GravityState;
import com.Player;
import com.Vehicle;

public class Ball extends Vehicle {

	@Override
	public void click(Player p) {
		if (p.isGrounded()) {
			Game.setGravityState(GravityState.inverse(Game.getGravityState()));
			p.setGrounded(false);
		}
	}

	@Override
	public void tick(Player p) {
	}

	@Override
	public Color getColor() {
		return Color.YELLOW;
	}

}
