package com;

import java.awt.Color;

public abstract class Vehicle {
		
	public abstract void click(Player p);
	public abstract void tick(Player p);
	public abstract Color getColor();
}
