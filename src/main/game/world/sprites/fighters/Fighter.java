package main.game.world.sprites.fighters;

/**
 * @author oshan
 */
public interface Fighter {
    void lowPunch();
    void lowKick();
    void highKick();
    void highPunch();
    void block();

    void jump();
    void crouch();
    void move(boolean isMovingRight);

    int getHealth();

}
