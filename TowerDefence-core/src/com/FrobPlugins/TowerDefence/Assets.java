package com.FrobPlugins.TowerDefence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {
	
	public Texture grass;
	public static Sprite sprite_grass;
	public Texture build;
	public static Sprite sprite_build;
	public Texture path;
	public static Sprite sprite_path;
	public Texture cell;
	public static Sprite sprite_cell;
	public Texture enemy;
	public static Sprite sprite_enemy;
	
	public void load(){
		//Load textures
		grass = new Texture(Gdx.files.internal("Textures/grass.png"));
		build = new Texture(Gdx.files.internal("Textures/BuildButton.png"));
		path = new Texture(Gdx.files.internal("Textures/Path.png"));
		cell = new Texture(Gdx.files.internal("Textures/Cell.png"));
		enemy = new Texture(Gdx.files.internal("Textures/Enemy.png"));
	
		
		//Load Sprites
		sprite_grass = new Sprite(grass);
		sprite_build = new Sprite(build);
		sprite_path = new Sprite(path);
		sprite_cell = new Sprite(cell);
		sprite_enemy = new Sprite(enemy);
	}
}