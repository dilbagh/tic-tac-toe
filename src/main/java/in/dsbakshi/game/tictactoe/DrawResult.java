package in.dsbakshi.game.tictactoe;

/**
 * Result with no winner.
 *
 * @author Dilbagh Singh Bakshi
 */
public class DrawResult implements Result {

    @Override
    public String displayText() {
        return "It's a draw!";
    }
}
