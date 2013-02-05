package crash;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Render {

	public static final float CAMERA_WIDTH = 24;

	public static final float CAMERA_HEIGHT = 42.7f;

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
		renderer.begin(ShapeType.Rectangle);
		renderer.setColor(Color.RED);

		for (Square s : world.getSquares())
			renderer.rect(s.getPos().x, s.getPos().y, s.getW(), s.getW());

		renderer.end();

	}

}
