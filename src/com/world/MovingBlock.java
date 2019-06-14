package com.world;

import com.Game;
import com.Player;

public class MovingBlock extends ActiveBlock {

	private float centerX, centerY;
	
	private long timer = 0;
	
	private static final float MOVE_RADIUS = 450;
	
	public MovingBlock(float x, float y) {
		super(x, y);
		centerX = x;
		centerY = y;
	}

	@Override
	public void tick() {
		timer++;
		y = (float) (centerY + Math.sin(timer/30F) * MOVE_RADIUS);
	}
	
	@Override
	public void touch(Player player, CollisionDirection d) {
		Game.g.death();
	}
	
}
