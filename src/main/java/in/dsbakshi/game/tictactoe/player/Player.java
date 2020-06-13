package in.dsbakshi.game.tictactoe.player;

import in.dsbakshi.game.tictactoe.grid.Grid;
import in.dsbakshi.game.tictactoe.grid.Mark;

/**
 * A tic tac toe player that can play on any grid.
 */
public interface Player {

    String getName();

    Mark getMark();

    void makeMove(Grid grid);

}
