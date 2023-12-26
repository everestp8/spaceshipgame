package com.everestp.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class EnemySpawner extends Actor {
	private static float spawnCooldown;
	private float spawnTimer;
	public Vector2 target;
	private static float enemySpeed;
	private static float speedDifucult = 1.01f;

	public EnemySpawner() {
		spawnCooldown = 1f;
		enemySpeed = 128f;
		this.spawnTimer = spawnCooldown;
		this.target = new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
	}

	private float randRange(float min, float max) {
 		return (float)Math.floor(Math.random() * (max - min + 1) + min);
	}

	private Vector2 randomPos() {
		Vector2 screensz = new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		float randY;
		if (randRange(0, 1) == 0) {
			randY = screensz.y+128;
		} else {
			randY = -128f;
		}
		return new Vector2(randRange(0, screensz.x), randY);
	}

	public static void upSpeed() {
		enemySpeed *= speedDifucult;
		spawnCooldown -= 0.02;
	}

	@Override
	public void act(float delta) {
		this.spawnTimer -= 1*delta;
		if (this.spawnTimer <= 0) {
			Enemy enemy = new Enemy(this.randomPos(), this.target);
			enemy.speed = this.enemySpeed;
			GameScene.enemies.addActor(enemy);
			this.spawnTimer = spawnCooldown;
		}
	}
}

