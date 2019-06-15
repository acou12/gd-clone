package com;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.vehicles.Ball;
import com.vehicles.Cube;
import com.vehicles.Helicopter;
import com.vehicles.Ship;
import com.vehicles.Ufo;
import com.vehicles.Wave;
import com.world.ActiveBlock;
import com.world.Block;
import com.world.Block.CollisionDirection;
import com.world.Invisiblock;
import com.world.MovingBlock;
import com.world.Redblock;

import processing.core.PApplet;

public class Game extends PApplet {
	
	// constants

	private static final int LENGTH = 1920;
	private static final int HEIGHT = 1080;
	public static final float PLAYER_SIZE = 30;
	
	public static final float GRAVITY = 0.6F;
	public static final int GROUND_HEIGHT = HEIGHT - 300;
	private static final float MOVE_SPEED = 8;
	
	private static boolean shiftPressed = false;
	private static boolean controlPressed = false;
	

	private static GravityState gravityState = GravityState.DOWN;
	
	public static List<Block> blocks = new ArrayList<Block>();

	public static Game g = new Game();
	
	public static void main(String... args) {
		PApplet.runSketch(new String[]{"Geometry Dash"}, g);
	}
	
	static Player player = new Player();
	
	@Override
	public void settings() {
		size(LENGTH, HEIGHT);
	}
	
	@Override
	public void setup() {
		
	}
	
	public static void death() {
		player.setY(Game.g.GROUND_HEIGHT);
		player.setX(0);
	}
	
	@Override
	public void draw() {
		background(0);
		stroke(255);
		line(0, GROUND_HEIGHT, LENGTH, GROUND_HEIGHT);
		float oldX = player.getX();
		float oldY = player.getY();
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
		gameTick();
		for (float xo = 0; xo < PLAYER_SIZE; xo += PLAYER_SIZE - 1)
		for (float yo = 0; yo < PLAYER_SIZE; yo += PLAYER_SIZE - 1)
		for (Block b : blocks) {
			if (b.isInside(player.getX() + xo, player.getY() + yo - PLAYER_SIZE)) {
				CollisionDirection d = b.getDirection(oldX + xo, oldY + yo - PLAYER_SIZE);
				b.touch(player, d);
				break;
			}
		}
		for (Block b : blocks) {
			if (b instanceof Redblock) {
				fill(255, 0, 0);
			} else if (b instanceof ActiveBlock) {
				if (b instanceof Invisiblock) {
					noStroke();
					fill(255, 0, 255, ((Invisiblock) b).getAlpha());
				}
				else fill(0, 255, 0);
			} else {
				fill(255, 255, 255);
			}
			rect(b.getX(), b.getY(), b.getSizeX(), b.getSizeY());
			if (b instanceof ActiveBlock) {
				((ActiveBlock) b).tick();
			}
		}
		Color c = player.getV().getColor();
		fill(c.getRed(), c.getGreen(), c.getBlue());
		rect(player.getX(), player.getY() - PLAYER_SIZE, PLAYER_SIZE, PLAYER_SIZE);
	}
	
	@Override
	public void mousePressed() {
		if (mouseButton == LEFT) player.getV().click(player);
	}
	
	public void gameTick() {
		if (mousePressed && mouseButton == RIGHT) {
			Block b;
			if (shiftPressed) {
				b = new Redblock(mouseX, mouseY);
			} else if (controlPressed) {
				b = new Invisiblock(mouseX, mouseY);
			} else {
				b = new Block(mouseX, mouseY);
			}
			blocks.add(b);
		}
	}
	
	@Override
	public void keyPressed() {
		if (key == 'u') {
			player.setV(new Ufo());
		} if (key == 'c') {;
			player.setV(new Cube());
		} if (key == 'm') {
			player.setV(new Helicopter());
		} if (key == 'w') {
			player.setV(new Wave());
		} if (key == 's') {
			player.setV(new Ship());
		} if (keyCode == SHIFT) {
			shiftPressed = true;
		} if (key == 'r') {
			blocks.clear();
			player.setX(0);
			player.setY(GROUND_HEIGHT);
			player.setyVelocity(0);
		} if (key == 'b') {
			player.setV(new Ball());
		} if (keyCode == CONTROL) {
			controlPressed = true;
		}
	}

	@Override
	public void keyReleased() {
		if (keyCode == SHIFT) {
			shiftPressed = false;
		} if (keyCode == CONTROL) {
			controlPressed = false;
		}
	}
	
	public static GravityState getGravityState() {
		return gravityState;
	}

	public static void setGravityState(GravityState gravityState) {
		Game.gravityState = gravityState;
	}
	
	public static int getGravityConstant() {
		return (gravityState == GravityState.DOWN) ? -1 : 1;
	}
}
