package com.FrobPlugins.TowerDefence.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.FrobPlugins.TowerDefence.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Main(), config);
		config.resizable = false;
		config.width = 1280;
		config.height = 720;
		config.title = "TowerDefence";
	}
}
