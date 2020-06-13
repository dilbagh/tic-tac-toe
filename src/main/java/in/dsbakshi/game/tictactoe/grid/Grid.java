package in.dsbakshi.game.tictactoe.grid;

/**
 * A tic tac toe grid.
 *
 * @author Dilbagh Singh Bakshi
 */
public interface Grid {

    void mark(Position position, Mark mark);

    GridView getView();

}
