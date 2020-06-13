package in.dsbakshi.game.tictactoe.grid;

/**
 * Represents a coordinate of a box on any grid.
 *
 * @author Dilbagh Singh Bakshi
 */
public class Position {

    private final int x;

    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
