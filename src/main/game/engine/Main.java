package main.game.engine;

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
