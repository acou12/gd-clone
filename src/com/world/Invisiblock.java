package com.world;

import com.Game;
import com.Player;

public class Invisiblock extends ActiveBlock {

	private static final long INVISIBLE_TIME = 100;
	
	private long timer = 0;
	
	private int alpha = 255;
	
	public Invisiblock(float x, float y) {
		super(x, y);
	}

	@Override
	public void tick() {
		timer++;
		alpha = (int) (Math.cos(timer/30.0) * 255);
	}
	
	public int getAlpha() {
		return alpha;
	}
	
	@Override
	public void touch(Player player, CollisionDirection d) {
		if (alpha > 100) {
			Game.death();
		}
	}
	
	
}
