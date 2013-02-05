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

	private final float A = 5;

	@Override
	public void show() {
		world = new World1();
		player = world.getPlayer();
		render = new Render(world);

		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

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
			a.x = -A;
		else if (keycode == Keys.RIGHT)
			a.x = A;
		else if (keycode == Keys.DOWN)
			a.y = -A;
		else if (keycode == Keys.UP)
			a.y = A;

		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		Vector2 a = player.getA();
		if (keycode == Keys.LEFT && a.x == -A)
			a.x = 0;
		else if (keycode == Keys.RIGHT && a.x == A)
			a.x = 0;
		else if (keycode == Keys.DOWN && a.y == -A)
			a.y = 0;
		else if (keycode == Keys.UP && a.y == A)
			a.y = 0;

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
