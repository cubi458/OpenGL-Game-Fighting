package main.game.world.sprites.fighters.impl;

import com.jogamp.newt.event.KeyEvent;
import main.game.engine.GameLoop;
import main.game.graphics.Graphics;
import main.game.graphics.Renderer;
import main.game.inputs.KeyEventListener;
import main.game.resources.ImageResource;
import main.game.world.World;
import main.game.world.sprites.fighters.AbstractFighter;
import main.game.world.sprites.fighters.power.impl.PowerupKree;


/**
 * @author oshan
 */
public class FighterKree extends AbstractFighter {

    public FighterKree(float x, float y, int width, int height) {
        this(x,y,width,height,0,0);
    }

    /**
     * @param x         horizontal index position (in game units)
     * @param y         vertical index position (in game units)
     * @param width     width of the sprite
     * @param height    height of the sprite
     * @param offsetX   will be reduced from the width of the sprite (if the sprite has blank surrounding space)
     * @param offsetY   will be reduced from the height of the sprite (if the sprite has blank surrounding space)
     */
    public FighterKree(float x, float y, int width, int height, int offsetX, int offsetY) {
        super(x, y, width, height, "kree", offsetX, offsetY);
        powerTexture = new ImageResource().setImage("/images/powers/kree_power.png").getTexture();
        powerHitTexture = new ImageResource().setImage("/images/powers/kree_hit_power.png").getTexture();
    }

    /**
     * Checks all the keyEvents happened for character movements
     */
    @Override
    public void update() {
        float yIn = 0;
        //testing code
        if(KeyEventListener.isRegisteredKey(KeyEvent.VK_D)) {
            move(true);
        }

        if (KeyEventListener.isRegisteredKey(KeyEvent.VK_A)) {
            move(false);
        }

        if (KeyEventListener.isRegisteredKey(KeyEvent.VK_W)) {

            y += ++yIn * movementSpeed * GameLoop.getDelta();

            if(y>Renderer.tileSize / 2 - 0.5f) {
                y = Renderer.tileSize / 2 - 0.5f;
            } else if(y<-Renderer.tileSize / 2 + 0.5f) {
                y = -Renderer.tileSize / 2 + 0.5f;
            }
        }

        if (KeyEventListener.isRegisteredKey(KeyEvent.VK_S)) {
            y += --yIn * movementSpeed * GameLoop.getDelta();

            if(y>Renderer.tileSize / 2 - 0.5f) {
                y = Renderer.tileSize / 2 - 0.5f;
            } else if(y<-Renderer.tileSize / 2 + 0.5f) {
                y = -Renderer.tileSize / 2 + 0.5f;
            }
        }

        if(KeyEventListener.isRegisteredKey(KeyEvent.VK_F)) {
            long currentTime = System.nanoTime();

            if(currentTime - lastPowerTime > 500000000) {
                currentAnimation = animations.get("shoot");
                PowerupKree power = new PowerupKree(x+1f,y,16,16, powerTexture);
                power.setOwner(this);
                power.setEnemy((AbstractFighter) World.getPlayerTwo()); //set enemy to Bee
                World.addGameObject(power);

                lastPowerTime = currentTime;
            }
        }

    }

    /**
     * Render the updates to the screen
     */
    @Override
    public void render() {
        currentAnimation.play();
        Graphics.createObjectTexture(currentAnimation.getCurrentImage(),x,y,charWidth,charHeight,0);
    }


    @Override
    public void lowPunch() {

    }

    @Override
    public void lowKick() {

    }

    @Override
    public void highKick() {

    }

    @Override
    public void highPunch() {

    }

    @Override
    public void block() {

    }

    @Override
    public void jump() {

    }

    @Override
    public void crouch() {

    }

    @Override
    public String toString() {
        return "FighterKree";
    }
}
