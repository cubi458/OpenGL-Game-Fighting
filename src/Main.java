

import main.game.engine.GameLoop;
import main.game.graphics.Renderer;

/**
 * @author oshan
 */
public class Main {
    public static void main(String[] args) {
        Renderer.init();
        GameLoop.getInstance().start();
    }
}
