package com.world;

public abstract class ActiveBlock extends Block {

	public ActiveBlock(float x, float y) {
		super(x, y);
	}
	
	public abstract void tick();
}
