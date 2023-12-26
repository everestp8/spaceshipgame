package com.everestp.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Background extends Actor {
	private Sprite spr;
	private Vector2 position;
	private Vector2 size;
	private float speed = 1f;
	private float rotation = 0f;

	public Background(float startPointX) {
		this.spr = new Sprite(new Texture("bg.png"));
		this.position = new Vector2(startPointX, 0f);
		this.size = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		this.spr.setSize(this.size.x, this.size.y);
	}

	@Override
	public void act(float delta) {
		this.position.x -= this.speed;
		if (this.position.x <= -this.size.x) {
			this.position.x = Gdx.graphics.getWidth();
			this.size.x = Gdx.graphics.getWidth(); 
			this.size.y = Gdx.graphics.getHeight();
			this.spr.setSize(this.size.x, this.size.y);
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		spr.setPosition(this.position.x, this.position.y);
		spr.setRotation(-this.rotation);
		spr.draw(batch);
	}
}

