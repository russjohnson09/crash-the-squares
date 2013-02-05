package crash;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements Screen, InputProcessor {

	private World world;
	private Square player;

	private Render render;

	private enum K {
		L, R, U, D
	};

	private static Set<K> key = new HashSet<K>();

	static {
		key.add(K.L);
		key.add(K.R);
		key.add(K.U);
		key.add(K.D);
	};

	@Override
	public void show() {
		world = new World1();
		player = world.getPlayer();
		render = new Render(world);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		Vector2 a = player.getA();
		//
		// if (key.contains(K.L))
		// if (key.contains(K.R))
		// a.x = 0;
		// else
		// a.x = -1;
		// else if (key.contains(K.R))
		// a.x = 1;
		// else
		// a.x = 0;
		//
		// if (key.contains(K.D))
		// if (key.contains(K.U))
		// a.y = 0;
		// else
		// a.y = -1;
		// else if (key.contains(K.U))
		// a.y = 1;
		// else
		// a.y = 0;

		world.update(delta);

		render.render();
	}

	/**
	 * Update the player's acceleration based on key press.
	 */
	@Override
	public boolean keyDown(int keycode) {
		Vector2 a = player.getA();
		if (keycode == Keys.LEFT)
			a.y = 1;

		if (keycode == Keys.LEFT)
			key.add(K.L);
		else if (keycode == Keys.RIGHT)
			key.add(K.R);
		else if (keycode == Keys.DOWN)
			key.add(K.D);
		else if (keycode == Keys.UP)
			key.add(K.U);
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT)
			key.remove(K.L);
		else if (keycode == Keys.RIGHT)
			key.remove(K.R);
		else if (keycode == Keys.DOWN)
			key.remove(K.D);
		else if (keycode == Keys.UP)
			key.remove(K.U);
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
