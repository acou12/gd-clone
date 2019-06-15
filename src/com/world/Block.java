package com.world;

import com.Game;
import com.Player;
import com.world.Block.CollisionDirection;

public class Block {
	protected float x;
	protected float y;
	protected float sizeX, sizeY;
	
	private static float DEFAULT_BLOCK_SIZE = 60;
	
	public Block(float x, float y) {
		this.x = x;
		this.y = y;
		sizeX = sizeY = DEFAULT_BLOCK_SIZE;
	}
	
	public Block(float x1, float y1, float x2, float y2) {
		
		if (x1 < x2) {
			this.x = x1;
			this.sizeX = x2 - x1;
		} else if (x2 < x1) {
			this.x = x2;
			this.sizeX = x1 - x2;
		} else {
			this.x = this.sizeX = 0;
		}
		
		if (y1 < y2) {
			this.y = y1;
			this.sizeY = y2 - y1;
		} else if (y2 < y1) {
			this.y = y2;
			this.sizeY = y1 - y2;
		} else {
			this.y = this.sizeY = 0;
		}
		
		
	}

	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public float getSizeX() {
		return sizeX;
	}
	
	public float getSizeY() {
		return sizeY;
	}
	
	public boolean isInside(float x, float y) {
		return (this.x <= x && x <= this.x + this.sizeX) &&
			   (this.y <= y && y <= this.y + this.sizeY);
	}
	
	public CollisionDirection getDirection(float oldX, float oldY) {
		if (oldY < this.y) {
			return CollisionDirection.TOP;
		} else if (this.y + this.sizeY - 1 < oldY) {
			return CollisionDirection.BOTTOM;
		} else if (oldX < this.x) {
			return CollisionDirection.LEFT;
		} else if (this.x + this.sizeX - 1 < oldX) {
			return CollisionDirection.RIGHT;
		}
		return null;
	}
	
	public enum CollisionDirection {
		LEFT, RIGHT, TOP, BOTTOM;
	}
	
	public void touch(Player player, CollisionDirection d) {
		if (d == CollisionDirection.TOP) {
			player.setY(getY() - 1);
			player.setyVelocity(0);
			if (Game.getGravityConstant() == -1) player.setGrounded(true);
		} else if (d == CollisionDirection.BOTTOM) {
			player.setY(getY() + getSizeY() + Game.PLAYER_SIZE + 1);
			player.setyVelocity(0);
			if (Game.getGravityConstant() == 1) player.setGrounded(true);
		} else if (d == CollisionDirection.LEFT) {
			Game.death();
		}
	}
}
