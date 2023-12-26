package com.everestp.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Enemy extends Actor {
	private Sprite spr;
	private Vector2 position;
	private Vector2 size;
	private Vector2 center = new Vector2();
	private Vector2 dir = new Vector2();
	private Vector2 target = new Vector2();
	public float speed;
	private float rotation = 0f;
	private float timer, timerLimit = 12f;

	public Enemy(Vector2 position, Vector2 target) {
		this.spr = new Sprite(new Texture("enemy.png"));
		this.position = new Vector2(position.x, position.y);
		this.size = new Vector2(this.spr.getWidth(), this.spr.getHeight());
		this.target = target;
		center.x = this.position.x + this.size.x/2;
		center.y = this.position.y + this.size.y/2;
		dir.set(target.sub(center).nor());
		this.rotation = MathUtils.atan2(dir.x, dir.y) * MathUtils.radiansToDegrees;
		this.setSize(size.x, size.y);
		speed = 128f;
	}

	@Override
	public void act(float delta) {
		this.position.x += this.speed*MathUtils.sin(rotation*(MathUtils.PI/180)) * delta;
		this.position.y += this.speed*MathUtils.cos(rotation*(MathUtils.PI/180)) * delta;
		center.x = this.position.x + this.size.x/2;
		center.y = this.position.y + this.size.y/2;
		this.setPosition(position.x, position.y);
		this.timer += 1*delta;
		if (this.timer >= this.timerLimit) this.remove();
	}

	public static void hitted(Actor enemy) {
		GUI.incrementScore();
		enemy.remove();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		spr.setPosition(this.position.x, this.position.y);
		spr.setSize(this.size.x/2, this.size.y/2);
		spr.setRotation(-this.rotation - 90);

		spr.draw(batch);
	}
}

