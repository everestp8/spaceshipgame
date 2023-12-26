package com.everestp.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
// import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.scenes.scene2d.Stage;
// import com.badlogic.gdx.scenes.scene2d.Group;

public class SpaceShip extends ApplicationAdapter {
	private static Stage curretScene;
	private static boolean gameover;
	
	@Override
	public void create () {
		Graphics.DisplayMode displayMode = Gdx.graphics.getDisplayMode();
		Gdx.graphics.setWindowedMode(displayMode.width, displayMode.height);
		curretScene = new GameScene();
	}
	
	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		if (gameover) {
			curretScene = new GameOverScene();
			gameover = false;
		}

		curretScene.act(Gdx.graphics.getDeltaTime());
		curretScene.draw();
	}

	public static void setGameOver() {
		gameover = true;
	}

	public static void newGame() {
		curretScene = new GameScene();
	}
}
