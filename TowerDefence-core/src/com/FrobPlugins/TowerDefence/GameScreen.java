package com.FrobPlugins.TowerDefence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen implements Screen {
	
	Main main;
	public OrthographicCamera camera;
	
	int buildButtonX = 0;
	int buildButtonY = 0;
	public static int blockSize = 80;
	public boolean ButtonClicked;
	boolean disabled = false;
	static int mapWidth = 15;
	static int mapHeight = 8;
	static int ScreenWidth = 1280;
	static int ScreenHeight = 720;
	public static Block[][] block;
	Enemy[] maxEnemies = new Enemy[100];
	Inventory inventory;
	
	public GameScreen(Main main){
		this.main = main;
	}
	
	@Override
	public void show() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, ScreenWidth, ScreenHeight);
		camera.update();
		inventory = new Inventory();
		block = new Block[mapWidth][mapHeight];
		createLevel1();
		for(int i=0;i<maxEnemies.length;i++){
			maxEnemies[i] = new Enemy();
		}
	}

	@Override
	public void render(float delta) {
		Gdx.gl20.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		main.batch.setProjectionMatrix(camera.combined);
		
		//Listener Methods
		clickListener();
		
		for(int x=0;x<block.length;x++){
			for(int y=0;y<block[0].length;y++){
				block[x][y] = new Block((ScreenWidth/2) - ((mapWidth*blockSize)/2) + x * blockSize,(ScreenHeight/2) - ((mapHeight*blockSize)/2) + y * blockSize, blockSize, blockSize, Tile.airID);
			}
		}
		for(int x=0;x<block.length;x++){
			for(int y=0;y<block[0].length;y++){
				if(block[0][5].ID == Tile.airID){
					block[0][4].ID = Tile.horizontalID;
					block[1][4].ID = Tile.RightUpCornerID;
					block[1][3].ID = Tile.LeftDownCorner;
					block[2][3].ID = Tile.horizontalID;
					block[3][3].ID = Tile.horizontalID;
					block[4][3].ID = Tile.RightDownCorner;
					block[4][4].ID = Tile.verticalID;
					block[4][5].ID = Tile.verticalID;
					block[4][6].ID = Tile.leftUpCornerID;
					block[5][6].ID = Tile.horizontalID;
					block[6][6].ID = Tile.horizontalID;
					block[7][6].ID = Tile.horizontalID;
					block[8][6].ID = Tile.RightUpCornerID;
					block[8][5].ID = Tile.verticalID;
					block[8][4].ID = Tile.verticalID;
					block[8][3].ID = Tile.verticalID;
					block[8][2].ID = Tile.LeftDownCorner;
					block[9][2].ID = Tile.horizontalID;
					block[10][2].ID = Tile.horizontalID;
					block[11][2].ID = Tile.horizontalID;
					block[12][2].ID = Tile.horizontalID;
					block[13][2].ID = Tile.horizontalID;
					block[14][2].ID = Tile.horizontalID;
				}
			}
		}
		for(int i=0;i<maxEnemies.length;i++){
			maxEnemies[i].update();
		}
		inventory.update();
		spawnEnemy();
		draw();
	}
	
	public void draw(){
		main.batch.begin();
		for(int x=0;x<block.length;x++){
			for(int y=0;y<block[0].length;y++){
				block[x][y].draw(main.batch);
			}
		}
		for(int i=0;i<maxEnemies.length;i++){
			if(maxEnemies[i].inGame){
				maxEnemies[i].draw(main.batch);
			}
		}
		main.batch.draw(Assets.sprite_build, 0, 0);
		inventory.draw(main.batch);
		main.batch.end();
	}
	//100 = 1 second;
	public int spawnTime = 75, spawnFrame = 0;
	public void spawnEnemy(){
		if(spawnFrame >= spawnTime){
			for(int i=0;i<maxEnemies.length;i++){
				if(!maxEnemies[i].inGame){
					maxEnemies[i].spawnEnemy();
					break;
				}
			}
			
			spawnFrame = 0;
		}else{
			spawnFrame += 1;
		}
	}
	
	public void createLevel1(){
		
	}
	
	public void clickListener(){
		
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {
		
	}

	@Override
	public void dispose() {

	}
}