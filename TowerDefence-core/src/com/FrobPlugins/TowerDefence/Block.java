package com.FrobPlugins.TowerDefence;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Block extends Rectangle{
	int ID;
	int blockSize = 80;
	
	public Block(int x, int y, int width, int height, int ID){
		set(x, y, width, height);
		this.ID = ID;
	}
	
	public void draw(SpriteBatch batch){
		if(ID == Tile.groundID){
			batch.draw(Assets.sprite_path, x, y);
		}
		if(ID == Tile.airID){
			batch.draw(Assets.sprite_grass, x, y);
		}
	}
}
