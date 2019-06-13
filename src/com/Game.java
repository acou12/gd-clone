package com;
import java.awt.Color;

import com.vehicles.Cube;
import com.vehicles.Helicopter;
import com.vehicles.Ufo;
import com.vehicles.Wave;

import processing.core.PApplet;

public class Game extends PApplet {
	
	// constants

	private static final int LENGTH = 1920;
	private static final int HEIGHT = 1080;
	
	private static final float GRAVITY = 0.6F;
	private static final int GROUND_HEIGHT = HEIGHT - 300;
	private static final float MOVE_SPEED = 8;

	private static GravityState gravityState = GravityState.DOWN;
	
	public static Game g = new Game();
	
	public static void main(String... args) {
		PApplet.runSketch(new String[]{"Geometry Dash"}, g);
	}
	
	Player player = new Player();
	
	@Override
	public void settings() {
		size(LENGTH, HEIGHT);
	}
	
	@Override
	public void setup() {
		
	}
	
	@Override
	public void draw() {
		background(0);
		stroke(255);
		line(0, GROUND_HEIGHT, LENGTH, GROUND_HEIGHT);
		player.getV().tick(player);
		player.setX(player.getX() + MOVE_SPEED);
		player.setY(player.getY() + player.getyVelocity());
		player.setyVelocity(player.getyVelocity() + 
				GRAVITY * (gravityState == GravityState.UP ? -1 : 1)
				);
		if (player.getY() > (GROUND_HEIGHT)) {
			player.setY(GROUND_HEIGHT);
			player.setyVelocity(0);
			player.setGrounded(true);
		}
		if (player.getX() > LENGTH) {
			player.setX(0);
		}
		Color c = player.getV().getColor();
		fill(c.getRed(), c.getGreen(), c.getBlue());
		rect(player.getX(), player.getY() - 30, 30, 30);
	}
	
	@Override
	public void mousePressed() {
		player.getV().click(player);
	}
	
	@Override
	public void keyPressed() {
		if (key == 'u') {
			player.setV(new Ufo());
		}if (key == 'c') {
			player.setV(new Cube());
		}  if (key == 'm') {
			player.setV(new Helicopter());
		}  if (key == 'w') {
			player.setV(new Wave());
		}
	}

	public static GravityState getGravityState() {
		return gravityState;
	}

	public static void setGravityState(GravityState gravityState) {
		Game.gravityState = gravityState;
	}
}
