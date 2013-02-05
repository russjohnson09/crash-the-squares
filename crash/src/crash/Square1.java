package crash;

import com.badlogic.gdx.math.Vector2;

public class Square1 implements Square {

	/* pos bottom left hand corner */
	Vector2 pos;
	Vector2 v;
	Vector2 a;

	/* width */
	private float w;

	public Square1(float w) {
		this.w = w;
		this.pos = new Vector2(0, 0);
		this.v = new Vector2(.1f, .1f);
		this.a = new Vector2(0, 0);
	}

	@Override
	public void update(float delta) {
		pos.x += v.x * delta;
		pos.y += v.y * delta;
		v.x += a.x * delta;
		v.y += a.y * delta;
	}

	@Override
	public Vector2 getV() {
		return v;
	}

	@Override
	public Vector2 getA() {
		return a;
	}

	@Override
	public Vector2 getPos() {
		return pos;
	}

	@Override
	public float getW() {
		return w;
	}

	@Override
	public String toString() {
		// return pos.toString();
		return v.toString();
	}

}
