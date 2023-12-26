package com.everestp.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Group;

public class GameScene extends Stage {
	private Nave nave;
	private EnemySpawner eSpawner;
	public static Group bullets;
	public static Group enemies;
	private Background bg1;
	private Background bg2;
	private GUI ui;
	
	public GameScene() {
		ui = new GUI();
		nave = new Nave();
		eSpawner = new EnemySpawner();
		bullets = new Group();
		enemies = new Group();
		bg1 = new Background(0);
		bg2 = new Background(Gdx.graphics.getWidth());
		addActor(bg1);
		addActor(bg2);
		addActor(eSpawner);
		addActor(enemies);
		addActor(bullets);
		addActor(nave);
		addActor(ui);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		eSpawner.target.set(nave.getX(), nave.getY());
	}
	
	public static void addBullet(Missile bullet) {
		bullets.addActor(bullet);
	}
}

