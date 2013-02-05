package crash;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Render {

	private static final float CAMERA_WIDTH = 24;

	private static final float CAMERA_HEIGHT = 42.7f;

	private World world;
	private Square player;

	private OrthographicCamera cam;

	ShapeRenderer renderer = new ShapeRenderer();

	public Render(World world) {
		this.world = world;
		this.player = world.getPlayer();

		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		renderer.setProjectionMatrix(cam.combined);
	}

	public void render() {
		Square player = world.getPlayer();
		renderer.begin(ShapeType.Rectangle);
		renderer.setColor(Color.RED);

		renderer.rect(player.getPos().x, player.getPos().y, player.getW(),
				player.getW());

		renderer.end();

	}

}
