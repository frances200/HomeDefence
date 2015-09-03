package com.FrobPlugins.TowerDefence;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Enemy extends Rectangle {
	
	public int enemySize = 80;
	public boolean inGame = false;
	public int mobWalk = 0;
	public int up = 0, down = 1, right = 2, left = 3;
	public int xC, yC;
	public int direction = right;
	public boolean hasUp = false, hasDown = false, hasLeft = false, hasRight = false;
	
	public Enemy(){
		
	}
	
	public void spawnEnemy(){
		for(int y=0;y<GameScreen.block[0].length;y++){
			if(GameScreen.block[0][y].ID == Tile.horizontalID || GameScreen.block[0][y].ID == Tile.verticalID
					|| GameScreen.block[0][y].ID == Tile.leftUpCornerID || GameScreen.block[0][y].ID == Tile.LeftDownCorner
					|| GameScreen.block[0][y].ID == Tile.RightUpCornerID || GameScreen.block[0][y].ID == Tile.RightDownCorner){
				set(GameScreen.block[0][y].x, GameScreen.block[0][y].y, GameScreen.blockSize, GameScreen.blockSize);
				xC = 0;
				yC = y;
			}
		}
		
		inGame = true;
	}
	
	public int walkSpeed = 1;
	public void update(){
		if(inGame){
			if(direction == right){
				x += 1;
				hasRight = true;
			}
			if(direction == down){
				y -= 1;
				hasDown = true;
			}
			if(direction == up){
				y += 1;
				hasUp = true;
			}
			if(direction == left){
				x -= 1;
				hasLeft = true;
			}
			mobWalk += 1;
			System.out.println(direction);
			if(mobWalk == 80){
				if(direction == right){
					xC += 1;
				}
				if(direction == up){
					yC += 1;
				}
				if(direction == down){
					yC -= 1;
				}
				if(!hasUp){
					try{
						if(GameScreen.block[xC][yC-1].ID == Tile.horizontalID || GameScreen.block[xC][yC-1].ID == Tile.verticalID
								|| GameScreen.block[xC][yC-1].ID == Tile.leftUpCornerID || GameScreen.block[xC][yC-1].ID == Tile.LeftDownCorner
								|| GameScreen.block[xC][yC-1].ID == Tile.RightUpCornerID || GameScreen.block[xC][yC-1].ID == Tile.RightDownCorner){
							direction = down;
						}
					}catch(Exception e){
						
					}
				}
				if(!hasLeft){
					try{
						if(GameScreen.block[xC][yC-1].ID == Tile.horizontalID || GameScreen.block[xC][yC-1].ID == Tile.verticalID
								|| GameScreen.block[xC][yC-1].ID == Tile.leftUpCornerID || GameScreen.block[xC][yC-1].ID == Tile.LeftDownCorner
								|| GameScreen.block[xC][yC-1].ID == Tile.RightUpCornerID || GameScreen.block[xC][yC-1].ID == Tile.RightDownCorner){
							direction = right;
						}
					}catch(Exception e){
						
					}
				}
				if(!hasDown){
					try{
						if(GameScreen.block[xC][yC+1].ID == Tile.horizontalID || GameScreen.block[xC][yC+1].ID == Tile.verticalID
								|| GameScreen.block[xC][yC+1].ID == Tile.leftUpCornerID || GameScreen.block[xC][yC+1].ID == Tile.LeftDownCorner
								|| GameScreen.block[xC][yC+1].ID == Tile.RightUpCornerID || GameScreen.block[xC][yC+1].ID == Tile.RightDownCorner){
							direction = up;
						}
					}catch(Exception e){
						
					}
				}
				if(!hasRight){
					try{
						if(GameScreen.block[xC-1][yC].ID == Tile.horizontalID || GameScreen.block[xC-1][yC].ID == Tile.verticalID
								|| GameScreen.block[xC-1][yC].ID == Tile.leftUpCornerID || GameScreen.block[xC-1][yC].ID == Tile.LeftDownCorner
								|| GameScreen.block[xC-1][yC].ID == Tile.RightUpCornerID || GameScreen.block[xC-1][yC].ID == Tile.RightDownCorner){
							direction = left;
						}
					}catch(Exception e){
						
					}
				}
				mobWalk = 0;
			}
			hasUp = false;
			hasDown = false;
			hasLeft = false;
			hasRight = false;
		}
	}
	
	public void draw(SpriteBatch batch){
		batch.draw(Assets.sprite_enemy, x, y);
	}
}
