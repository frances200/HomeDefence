package com.FrobPlugins.TowerDefence;

import com.badlogic.gdx.math.Rectangle;

public class Cell extends Rectangle{
	
	int ID;
	
	public Cell(int x, int y, int width, int height, int ID){
		set(x, y, width, height);
		this.ID = ID;
	}
}