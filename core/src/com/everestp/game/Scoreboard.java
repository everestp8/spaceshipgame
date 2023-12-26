
package com.everestp.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Scoreboard extends Actor {
	private Text txt;
	private BitmapFont txtbitmap;

	public Scoreboard() {
		txt = new Text();
		txt.parameter.color = Color.RED;
		txt.parameter.size = 60;
		txtbitmap = txt.getBitmap();
	}

	@Override
	public void act(float delta) {
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		/*for (int i=1; i<=hp; i++) {
			spr.setPosition(Gdx.graphics.getWidth()-i*50, Gdx.graphics.getHeight()-52);
			spr.draw(batch);
		}*/
		txtbitmap.draw(batch, "Game Over", Gdx.graphics.getWidth()/2-140, Gdx.graphics.getHeight()/2-txtbitmap.getCapHeight()/2);
	}
}

