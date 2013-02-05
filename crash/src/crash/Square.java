package crash;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public interface Square {

	/**
	 * update its position
	 * 
	 * @param delta
	 */
	void update(float delta);

	/**
	 * 
	 * @return velocity vector
	 */
	Vector2 getV();

	/**
	 * 
	 * @return acceleration vector
	 */
	Vector2 getA();

	Vector2 getPos();

	float getM();

	/**
	 * 
	 * @return width of square;
	 */
	float getW();

	Rectangle getRect();

}
