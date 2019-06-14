package com.world;

public class Block {
	private float x, y;
	private float sizeX, sizeY;
	
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
}
