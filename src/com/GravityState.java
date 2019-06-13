package com;

public enum GravityState {
	DOWN, UP;
	
	public static GravityState inverse(GravityState g) {
		return (g == DOWN) ? UP : DOWN;
	}
}
