package crash;

import com.badlogic.gdx.math.Vector2;

public class World1 implements World {

	private Square player;

	private Vector2 friction;

	public World1() {
		player = new Square1(1);

		friction = new Vector2(.1f, .1f);
	}

	@Override
	public Square getPlayer() {
		return player;
	}

	@Override
	public void update(float delta) {
		// Vector2 v = player.getV();
		// v.sub(friction);

		player.update(delta);

		System.out.println(player);

	}

}
