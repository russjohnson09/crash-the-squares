package crash;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public class World1 implements World {

	private Square player;

	private float friction;

	private float grav;

	private Square s;

	public World1() {
		player = new Square1(1);

		s = new Square1(1, new Vector2(5, 5));

		friction = .5f;
		grav = 10;
	}

	@Override
	public Square getPlayer() {
		return player;
	}

	@Override
	public void update(float delta) {
		Vector2 a = player.getA();
		Vector2 v = player.getV();

		if (v.x > 0)
			v.x -= friction * delta;
		else
			v.x += friction * delta;
		if (v.y > 0)
			v.y -= friction * delta;
		else
			v.y += friction * delta;

		player.update(delta);

		System.out.println(player);

	}

	private void collision() {
		if (Intersector.overlapRectangles(player.getRect(), s.getRect())) {

		}

	}

	// private boolean isCollision(Square s1, Square s2) {
	// Vector2 p = s1.getPos();
	// Vector2 p2 = s2.getPos();
	// float x1 = p.x;
	// float x2 = x1 + s1.getW();
	// float y1 = p.y;
	// float y2 = y1 + s1.getW();
	//
	// float x3 = p2.x;
	// float x4 = x3 + s2.getW();
	// float y3 = p.x;
	// float y4 = y3 + s2.getW();
	//
	// x3 < x1 < x4
	// }
}
