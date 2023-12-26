package com.everestp.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Missile extends Actor {
	private Sprite spr;
	private Vector2 position;
	private Vector2 size;
	private Rectangle bounds;
	private float speed = 768f;
	private float rotation = 0f;
	private float timer = 0;
	private float timerLimit = 2f;

	public Missile(Vector2 position, float rotation) {
		this.spr = new Sprite(new Texture("missile.png"));
		this.position = new Vector2(50f, 50f);
		this.position = new Vector2(position.x, position.y);
		this.rotation = rotation;
		this.size = new Vector2(this.spr.getWidth(), this.spr.getHeight());
		this.bounds = new Rectangle(position.x, position.y, size.x, size.y);
	}

	private void testCollision() {
		for (Actor enemy: GameScene.enemies.getChildren()) {
			Rectangle enemyBounds = new Rectangle((int)enemy.getX(), (int)enemy.getY(), (int)enemy.getWidth(), (int)enemy.getHeight());
			if (enemyBounds.overlaps(this.bounds)) {
				Enemy.hitted(enemy);
				this.remove();
			}
		}
	}

	@Override
	public void act(float delta) {
		this.timer += 1*delta;
		this.testCollision();
		this.position.x += this.speed*MathUtils.sin(rotation*(MathUtils.PI/180)) * delta;
		this.position.y += this.speed*MathUtils.cos(rotation*(MathUtils.PI/180)) * delta;
		this.bounds.x = position.x;
		this.bounds.y = position.y;
		if (this.timer >= this.timerLimit) this.remove();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		spr.setPosition(this.position.x, this.position.y);
		spr.setRotation(-this.rotation + 90);
		spr.draw(batch);
	}
}

