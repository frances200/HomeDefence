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
			if(GameScreen.block[0][y].ID == Tile.groundID){
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
				x += 2;
				hasRight = true;
			}
			if(direction == down){
				y -= 2;
				hasDown = true;
			}
			if(direction == up){
				y += 2;
				hasUp = true;
			}
			if(direction == left){
				x -= 2;
				hasLeft = true;
			}
			mobWalk += 2;
			System.out.println(xC);
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
						if(GameScreen.block[xC][yC-1].ID == Tile.groundID){
							direction = down;
						}
					}catch(Exception e){
						
					}
				}
				if(!hasLeft){
					try{
						if(GameScreen.block[xC+1][yC].ID == Tile.groundID){
							direction = right;
						}
					}catch(Exception e){
						
					}
				}
				if(!hasDown){
					try{
						if(GameScreen.block[xC][yC+1].ID == Tile.groundID){
							direction = up;
						}
					}catch(Exception e){
						
					}
				}
				if(!hasRight){
					try{
						if(GameScreen.block[xC-1][yC].ID == Tile.groundID){
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
			System.out.println(mobWalk);
		}
	}
	
	public void draw(SpriteBatch batch){
		batch.draw(Assets.sprite_enemy, x, y);
	}
}
