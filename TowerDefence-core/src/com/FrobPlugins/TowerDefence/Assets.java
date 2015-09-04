package com.FrobPlugins.TowerDefence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {
	
	public Texture grass;
	public static Sprite sprite_grass;
	public Texture build;
	public static Sprite sprite_build;
	public Texture cell;
	public static Sprite sprite_cell;
	public Texture cell_selected;
	public static Sprite sprite_cellSelected;
	public Texture vertical_path;
	public static Sprite sprite_vertical_path;
	public Texture horizontal_path;
	public static Sprite sprite_horizontal_path;
	public Texture LeftUpperCorner_path;
	public static Sprite sprite_LeftUpperCorner_path;
	public Texture RightUpperCorner_path;
	public static Sprite sprite_RightUpperCorner_path;
	public Texture LeftDownCorner_path;
	public static Sprite sprite_LeftDownCorner_path;
	public Texture RightDownCorner_path;
	public static Sprite sprite_RightDownCorner_path;
	public Texture enemy;
	public static Sprite sprite_enemy;
	public Texture tower;
	public static Sprite sprite_tower;
	
	public void load(){
		//Load textures
		grass = new Texture(Gdx.files.internal("Textures/grass.png"));
		build = new Texture(Gdx.files.internal("Textures/BuildButton.png"));
		cell = new Texture(Gdx.files.internal("Textures/Cell.png"));
		cell_selected = new Texture(Gdx.files.internal("Textures/cell_selected.png"));
		enemy = new Texture(Gdx.files.internal("Textures/Enemy.png"));
		LeftUpperCorner_path = new Texture(Gdx.files.internal("Textures/LeftUpCorner.png"));
		RightUpperCorner_path = new Texture(Gdx.files.internal("Textures/RightUpCorner.png"));
		LeftDownCorner_path = new Texture(Gdx.files.internal("Textures/LeftDownCorner.png"));
		RightDownCorner_path = new Texture(Gdx.files.internal("Textures/RightDownCorner.png"));
		vertical_path = new Texture(Gdx.files.internal("Textures/Vertical.png"));
		horizontal_path = new Texture(Gdx.files.internal("Textures/Horizontal.png"));
		tower = new Texture(Gdx.files.internal("Textures/tower.png"));
	
		
		//Load Sprites
		sprite_grass = new Sprite(grass);
		sprite_build = new Sprite(build);
		sprite_cell = new Sprite(cell);
		sprite_cellSelected = new Sprite(cell_selected);
		sprite_enemy = new Sprite(enemy);
		sprite_LeftUpperCorner_path = new Sprite(LeftUpperCorner_path);
		sprite_LeftDownCorner_path = new Sprite(LeftDownCorner_path);
		sprite_RightUpperCorner_path = new Sprite(RightUpperCorner_path);
		sprite_RightDownCorner_path = new Sprite(RightDownCorner_path);
		sprite_vertical_path = new Sprite(vertical_path);
		sprite_horizontal_path = new Sprite(horizontal_path);
		sprite_tower = new Sprite(tower);
	}
}