package com.FrobPlugins.TowerDefence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Inventory {
	
	Cell[][] cell;
	int inventoryWidth = 5;
	int inventoryHeight = 5;
	boolean isOpen = false;
	int pointX;
	int pointY;
	boolean selected = false;
	boolean holdTower1 = false;
	boolean holdTower2 = false;
	
	public Inventory(){
		cell = new Cell[inventoryWidth][inventoryHeight];
	}
	
	public void update(){
		pointX = Gdx.input.getX();
		pointY = Gdx.input.getY();
		for(int x=0;x<cell.length;x++){
			for(int y=0;y<cell[0].length;y++){
				cell[x][y] = new Cell((GameScreen.ScreenWidth-((x * GameScreen.blockSize)+80)),y * GameScreen.blockSize, GameScreen.blockSize, GameScreen.blockSize, Tile.airID);
			}
		}
		if(isOpen){
			if(Gdx.input.justTouched()){
				if(Gdx.input.getX() >= 0 && Gdx.input.getX() < 0 + 80
						&& Gdx.input.getY() <= 720 && Gdx.input.getY() >= 720-80){
					isOpen = false;
				}
			}
			if(pointY == 0) {pointY -= 1;}
			if(pointY == 80) {pointY -= 1;}
			if(pointY == 160) {pointY -= 1;}
			if(pointY == 240) {pointY -= 1;}
			if(pointY == 320) {pointY -= 1;}
			if(pointY == 400) {pointY -= 1;}
			if(pointY == 480) {pointY -= 1;}
			if(pointY == 560) {pointY -= 1;}
			if(pointY == 640) {pointY -= 1;}
			if(pointY == 720) {pointY -= 1;}
			if(pointX == 0) {pointX -= 1;}
			if(pointX == 80) {pointX -= 1;}
			if(pointX == 160) {pointX -= 1;}
			if(pointX == 240) {pointX -= 1;}
			if(pointX == 320) {pointX -= 1;}
			if(pointX == 400) {pointX -= 1;}
			if(pointX == 480) {pointX -= 1;}
			if(pointX == 560) {pointX -= 1;}
			if(pointX == 640) {pointX -= 1;}
			if(pointX == 720) {pointX -= 1;}
			if(pointX == 800) {pointX -= 1;}
			if(pointX == 880) {pointX -= 1;}
			if(pointX == 960) {pointX -= 1;}
			if(pointX == 1040) {pointX -= 1;}
			if(pointX == 1120) {pointX -= 1;}
			if(pointX == 1200) {pointX -= 1;}
			if(pointX == 1280) {pointX -= 1;}
			if(Gdx.input.justTouched()){
				for(int x=0;x<cell.length;x++){
					for(int y=0;y<cell[0].length;y++){
							if(cell[4][4].contains(pointX, pointY)){
								holdTower1 = true;
								isOpen = false;
							}
							if(cell[3][4].contains(pointX, pointY)){
								holdTower2 = true;
								isOpen = false;
							}
							if(holdTower1){
								if(!cell[4][4].contains(pointX, pointY) && pointX >= cell[4][4].x && pointX <= cell[0][4].x+80
										&& pointY >= cell[4][4].y){
									holdTower1 = false;
								}
							}
							if(holdTower2){
								if(!cell[3][4].contains(pointX, pointY) && pointX >= cell[4][4].x && pointX <= cell[0][4].x+80
										&& pointY >= cell[4][4].y){
									holdTower2 = false;
								}
							}
						}
					}
				}
		}else if(Gdx.input.justTouched()){
			if(Gdx.input.getX() >= 0 && Gdx.input.getX() < 0 + 80
					&& Gdx.input.getY() <= 720 && Gdx.input.getY() >= 720-80){
				isOpen = true;
			}
		}
		if(holdTower1){
			if(isOpen){
				holdTower1 = false;
			}
		}
		if(holdTower2){
			if(isOpen){
				holdTower2 = false;
			}
		}
	}
	
	public void draw(SpriteBatch batch){
		if(holdTower1){
			for(int x=0;x<GameScreen.block.length;x++){
				for(int y=0;y<GameScreen.block[0].length;y++){
					if(GameScreen.block[x][y].ID == Tile.airID){
						batch.draw(Assets.sprite_freeSpace, GameScreen.block[x][y].x, GameScreen.block[x][y].y);
					}
					if(GameScreen.block[x][y].ID != Tile.airID){
						batch.draw(Assets.sprite_noFreeSpace, GameScreen.block[x][y].x, GameScreen.block[x][y].y);
					}
				}
			}
			batch.draw(Assets.sprite_tower, Gdx.input.getX()-40,680-Gdx.input.getY());
		}
		if(holdTower2){
			for(int x=0;x<GameScreen.block.length;x++){
				for(int y=0;y<GameScreen.block[0].length;y++){
					if(GameScreen.block[x][y].ID == Tile.airID){
						batch.draw(Assets.sprite_freeSpace, GameScreen.block[x][y].x, GameScreen.block[x][y].y);
					}
					if(GameScreen.block[x][y].ID != Tile.airID){
						batch.draw(Assets.sprite_noFreeSpace, GameScreen.block[x][y].x, GameScreen.block[x][y].y);
					}
				}
			}
			batch.draw(Assets.sprite_itemHose, Gdx.input.getX()-40,680-Gdx.input.getY());
		}
		if(isOpen){
			for(int x=0;x<cell.length;x++){
				for(int y=0;y<cell[0].length;y++){
					batch.draw(Assets.sprite_cell, cell[x][y].x, cell[x][y].y);
					batch.draw(Assets.sprite_tower, cell[4][4].x, cell[4][4].y);
					batch.draw(Assets.sprite_itemHose, cell[3][4].x, cell[3][4].y);
						if(cell[x][y].contains(pointX,720 - pointY)){
							batch.draw(Assets.sprite_cellSelected, cell[x][y].x, cell[x][y].y);
					}
				}
			}
		}	
	}
}