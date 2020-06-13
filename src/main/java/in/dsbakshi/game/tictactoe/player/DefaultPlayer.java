package in.dsbakshi.game.tictactoe.player;

import in.dsbakshi.game.tictactoe.grid.Grid;
import in.dsbakshi.game.tictactoe.grid.Mark;
import in.dsbakshi.game.tictactoe.grid.Position;

/**
 * A tic tac toe player that can play on any grid using a configurable intelligence.
 *
 * @author Dilbagh Singh Bakshi
 */
public class DefaultPlayer implements Player {

    private final String name;

    private final Mark mark;

    private final PlayerIntelligence playerIntelligence;

    public DefaultPlayer(String name, Mark mark, PlayerIntelligence playerIntelligence) {
        this.name = name;
        this.mark = mark;
        this.playerIntelligence = playerIntelligence;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Mark getMark() {
        return mark;
    }

    @Override
    public final void makeMove(Grid grid) {
        Position position = playerIntelligence.provideMove(grid.getView());
        grid.mark(position, mark);
    }

    @Override
    public String toString() {
        return String.join("/", name, mark.toString());
    }
}
