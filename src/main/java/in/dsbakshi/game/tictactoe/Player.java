package in.dsbakshi.game.tictactoe;

import in.dsbakshi.game.io.Displayable;

/**
 * Holds information about a player.
 */
public class Player implements Displayable {

    private final String name;

    /**
     * @param name name of the player
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Get the name of the player.
     *
     * @return name of the player
     */
    public String getName() {
        return name;
    }

    @Override
    public String displayText() {
        return getName();
    }
}
