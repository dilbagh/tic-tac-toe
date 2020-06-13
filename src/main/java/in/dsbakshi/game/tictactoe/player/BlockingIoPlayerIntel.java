package in.dsbakshi.game.tictactoe.player;

import in.dsbakshi.game.tictactoe.grid.GridView;
import in.dsbakshi.game.tictactoe.grid.Position;
import in.dsbakshi.game.tictactoe.io.BlockingIO;

/**
 * Player Intelligence that asks from input from a blocking I/O.
 *
 * @author Dilbagh Singh Bakshi
 */
public class BlockingIoPlayerIntel implements PlayerIntelligence {

    private final BlockingIO io;

    public BlockingIoPlayerIntel(BlockingIO io) {
        this.io = io;
    }

    @Override
    public Position provideMove(GridView view) {
        return io.askForMove();
    }
}
