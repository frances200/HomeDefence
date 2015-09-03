package com.FrobPlugins.TowerDefence;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Main extends Game {
	public SpriteBatch batch;
	public static Assets assets;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		
		loadAssets();
		
		setScreen(new GameScreen(this));
	}
	
	public void loadAssets(){
		assets = new Assets();
		assets.load();
	}
}
