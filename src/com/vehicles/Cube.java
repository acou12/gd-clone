package com.vehicles;

import com.Player;
import com.Vehicle;

public class Cube extends Vehicle {

	public static final float JUMP_HEIGHT = 10;
		
	@Override
	public void click(Player p) {
		if (p.isGrounded()) {
			p.setyVelocity(-JUMP_HEIGHT);
			p.setGrounded(false);
		}
	}

	@Override
	public void tick(Player p) {
		// TODO Auto-generated method stub
		
	}

}
