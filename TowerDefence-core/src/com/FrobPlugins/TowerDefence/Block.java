package com.FrobPlugins.TowerDefence;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Block extends Rectangle{
	int ID;
	
	public Block(int x, int y, int width, int height, int ID){
		set(x, y, width, height);
		this.ID = ID;
	}
	
	public void draw(SpriteBatch batch){
		if(ID == Tile.horizontalID){
			batch.draw(Assets.sprite_horizontal_path, x, y);
		}
		if(ID == Tile.verticalID){
			batch.draw(Assets.sprite_vertical_path, x, y);
		}
		if(ID == Tile.leftUpCornerID){
			batch.draw(Assets.sprite_LeftUpperCorner_path, x, y);
		}
		if(ID == Tile.LeftDownCorner){
			batch.draw(Assets.sprite_LeftDownCorner_path, x, y);
		}
		if(ID == Tile.RightUpCornerID){
			batch.draw(Assets.sprite_RightUpperCorner_path, x, y);
		}
		if(ID == Tile.RightDownCorner){
			batch.draw(Assets.sprite_RightDownCorner_path, x, y);
		}
		if(ID == Tile.airID){
			batch.draw(Assets.sprite_grass, x, y);
		}
	}
}
