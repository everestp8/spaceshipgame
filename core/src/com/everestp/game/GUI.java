package com.everestp.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GUI extends Actor {
	private Sprite spr;
	private static int score;
	private static int hp;
	private Text txt;
	private BitmapFont txtbitmap;

	public GUI() {
		spr = new Sprite(new Texture("hearth.png"));
		score = 0;
		hp = 7;
		txt = new Text();
		txtbitmap = txt.getBitmap();
	}

	public static void incrementScore() {
		score++;
		if (score != 0 && score%5 == 0) {
			EnemySpawner.upSpeed();
		}
	}

	public static void decrementHP() {
		hp--;
		if (hp <= 0) {
			SpaceShip.setGameOver();
		}
	}

	@Override
	public void act(float delta) {
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		for (int i=1; i<=hp; i++) {
			spr.setPosition(Gdx.graphics.getWidth()-i*50, Gdx.graphics.getHeight()-52);
			spr.draw(batch);
		}
		txtbitmap.draw(batch, "Score: " + this.score, 20, Gdx.graphics.getHeight() - 20);
	}
}

