package in.dsbakshi.game.tictactoe.grid;

import java.util.List;

/**
 * Read only view of the Grid that can be used to draw the grid or make decisions on.
 *
 * @author Dilbagh Singh Bakshi
 */
public interface GridView {

    boolean isValidMove(Position position);

    boolean hasMoreMoves();

    boolean hasWinningCombination();

    Mark[][] getCurrentState();

    int getSizeX();

    int getSizeY();

    List<Position> getAvailableMoves();

}
