package com;
import processing.core.PApplet;

public class Game extends PApplet {
	
	// constants

	private static final int LENGTH = 1920;
	private static final int HEIGHT = 1080;
	
	private static final float GRAVITY = 0.6F;
	private static final int GROUND_HEIGHT = HEIGHT - 300;
	private static final float MOVE_SPEED = 4;


	public static void main(String... args) {
		Game g = new Game();
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
		player.setyVelocity(player.getyVelocity() + GRAVITY);
		if (player.getY() > (GROUND_HEIGHT)) {
			player.setY(GROUND_HEIGHT);
			player.setyVelocity(0);
			player.setGrounded(true);
		}
		fill(255);
		rect(player.getX(), player.getY() - 30, 30, 30);
	}
	
	@Override
	public void mousePressed() {
		player.getV().click(player);
	}
}
