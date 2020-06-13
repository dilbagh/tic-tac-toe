package in.dsbakshi.game.tictactoe.player;

import in.dsbakshi.game.tictactoe.grid.GridView;
import in.dsbakshi.game.tictactoe.grid.Position;

/**
 * Intelligence of a tic tac toe player.
 *
 * @author Dilbagh Singh Bakshi
 */
public interface PlayerIntelligence {

    /**
     * Provide the next move to be played on the grid using the existing view of the grid.
     */
    Position provideMove(GridView view);

}
