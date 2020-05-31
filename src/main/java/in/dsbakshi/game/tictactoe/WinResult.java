package in.dsbakshi.game.tictactoe;

/**
 * Result with a winner.
 *
 * @author Dilbagh Singh Bakshi
 */
public class WinResult implements Result {

    private final Player winner;

    /**
     * @param winner player who won
     */
    public WinResult(Player winner) {
        this.winner = winner;
    }

    @Override
    public String displayText() {
        return winner.displayText() + " wins!";
    }
}
