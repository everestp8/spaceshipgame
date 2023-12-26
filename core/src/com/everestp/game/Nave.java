package com.everestp.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.math.Rectangle;

public class Nave extends Actor {
	private Sprite spr;
	private Vector2 position;
	private Vector2 size;
	private float speed = 512f;
	private float rotation = 0f;
	private Vector2 touch = new Vector2();
	private Vector2 center = new Vector2() ;
	private Vector2 dir = new Vector2(); 
	private Rectangle bounds;
	private float timer, timerLimit = 0.7f;

	public Nave() {
		this.spr = new Sprite(new Texture("spaceship.png"));
		this.position = new Vector2(50f, 50f);
		this.size = new Vector2(this.spr.getWidth(), this.spr.getHeight());
		this.bounds = new Rectangle(position.x, position.y, size.x, size.y);
	}

	private void testCollision() {
		for (Actor enemy: GameScene.enemies.getChildren()) {
			Rectangle enemyBounds = new Rectangle((int)enemy.getX(), (int)enemy.getY(), (int)enemy.getWidth(), (int)enemy.getHeight());
			if(enemyBounds.overlaps(this.bounds) && timer <= 0) {
				handleCollision();
				this.timer = timerLimit;
			}
		}
	}

	private void handleCollision() {
		GUI.decrementHP();
	}

	@Override
	public void act(float delta) {
		testCollision();
		if (this.timer >= 0) timer -= 1*delta;
		center.x = this.position.x + this.size.x/2;
		center.y = this.position.y + this.size.y/2;
		setPosition(center.x, center.y);
		dir.set(touch.sub(center).nor());
		this.bounds.x = position.x;
		this.bounds.y = position.y;
		rotation = MathUtils.atan2(dir.x, dir.y) * MathUtils.radiansToDegrees;

		this.touch.set(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY()); 
		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			this.position.x += this.speed * delta;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			this.position.x -= this.speed * delta;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			this.position.y += this.speed * delta;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			this.position.y -= this.speed * delta;
		}
		if (Gdx.input.justTouched()) {
			GameScene.addBullet(new Missile(this.center, this.rotation));
		}
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		spr.setPosition(this.position.x, this.position.y);
		spr.setRotation(-this.rotation + 90);
		spr.draw(batch);
	}
}
