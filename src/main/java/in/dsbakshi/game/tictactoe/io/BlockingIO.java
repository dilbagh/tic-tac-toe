package in.dsbakshi.game.tictactoe.io;

import in.dsbakshi.game.tictactoe.grid.GridView;
import in.dsbakshi.game.tictactoe.grid.Position;
import in.dsbakshi.game.tictactoe.player.Player;

/**
 * All game I/O operations using a Blocking I/O.
 *
 * @author Dilbagh Singh Bakshi
 */
public interface BlockingIO {

    void updateCurrentPlayerDisplay(Player player);

    void updateGridDisplay(GridView gridView);

    void declareWinner(Player player);

    void declareDraw();

    void displayError(Exception exception);

    Position askForMove();
}
