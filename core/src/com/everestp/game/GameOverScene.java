package com.everestp.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameOverScene extends Stage {
	private Background bg1;
	private Background bg2;
	private Scoreboard scoreboard;
	
	public GameOverScene() {
		bg1 = new Background(0);
		bg2 = new Background(Gdx.graphics.getWidth());
		scoreboard = new Scoreboard();
		addActor(bg1);
		addActor(bg2);
		addActor(scoreboard);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		if (Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			SpaceShip.newGame();
		}
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
			Gdx.app.exit();
		}
	}
}

