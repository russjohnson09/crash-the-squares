package crash;

import com.badlogic.gdx.utils.Array;

public interface World {

	Square getPlayer();

	void update(float delta);

	Array<Square> getSquares();

}
