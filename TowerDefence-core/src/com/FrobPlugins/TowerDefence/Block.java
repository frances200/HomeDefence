package com.FrobPlugins.TowerDefence;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Block extends Rectangle{
	int ID;
	Rectangle towerSquare;
	int towerSquareSize = 130;
	boolean shooting = false;
	public int shotMob = 0;
	public Block(int x, int y, int width, int height, int ID){
		set(x, y, width, height);
		towerSquare = new Rectangle(x - (towerSquareSize/2), y - (towerSquareSize/2), width + (towerSquareSize), height + (towerSquareSize));
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
		if(ID == Tile.treeTower){
			batch.draw(Assets.sprite_towerTreeGround, x, y);
		}
		if(ID == Tile.hoseTower){
			batch.draw(Assets.sprite_groundHose, x, y);
		}
	}
	
	public void update(){
		shooting = false;
		if(ID == Tile.treeTower){
			for(int i=0;i<GameScreen.maxEnemies.length;i++){
				if(GameScreen.maxEnemies[i].inGame){
					if(GameScreen.maxEnemies[i].overlaps(towerSquare)){
						shooting = true;
						shotMob = i;
					}
				}
			}
		}
		if(shooting){
			GameScreen.maxEnemies[shotMob].health -= 2;
		}
	}
}
