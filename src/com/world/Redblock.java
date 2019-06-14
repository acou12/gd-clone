package com.world;

import com.Game;
import com.Player;

public class Redblock extends Block {

	public Redblock(float x, float y) {
		super(x, y);
	}
	
	@Override
	public void touch(Player player, CollisionDirection d) {
		Game.death();
	}
	
}
