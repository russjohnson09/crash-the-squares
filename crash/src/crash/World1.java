package crash;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World1 implements World {

	private Square player;

	private Array<Square> squares = new Array<Square>();

	private float friction;

	private Square s;

	public World1() {
		player = new Square1(1);

		s = new Square1(1, new Vector2(5, 5));
		squares.add(player);
		squares.add(s);

		friction = .5f;
	}

	@Override
	public Square getPlayer() {
		return player;
	}

	@Override
	public void update(float delta) {

		applyFriction(delta);

		sideCollision();
		collision();

		player.update(delta);
		s.update(delta);

		System.out.println(player);

	}

	private void applyFriction(float delta) {
		Vector2 a;
		Vector2 v;
		for (Square s : squares) {
			a = s.getA();
			v = s.getV();

			if (v.x > 0)
				v.x -= friction * delta;
			else
				v.x += friction * delta;
			if (v.y > 0)
				v.y -= friction * delta;
			else
				v.y += friction * delta;
		}

	}

	private void sideCollision() {
		Vector2 pos;
		Vector2 v;
		for (Square s : squares) {
			pos = s.getPos();
			v = s.getV();

			if (pos.x < 0 || pos.x > Render.CAMERA_WIDTH - s.getW())
				v.x = -v.x;

			if (pos.y < 0 || pos.y > Render.CAMERA_HEIGHT - s.getW())
				v.y = -v.y;
		}

	}

	private void collision() {
		if (Intersector.overlapRectangles(player.getRect(), s.getRect())) {

			Vector2 v1 = player.getV();
			Vector2 v2 = s.getV();
			Vector2 tmp = v1.tmp();
			v1.x = v2.x;
			v1.y = v2.y;
			v2.x = tmp.x;
			v2.y = tmp.y;
		}

	}

	@Override
	public Array<Square> getSquares() {
		return squares;
	}
}
