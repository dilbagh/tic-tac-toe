package in.dsbakshi.game.tictactoe.bootstrap;

import in.dsbakshi.game.tictactoe.gameplay.BlockingIoGame;
import in.dsbakshi.game.tictactoe.grid.Grid;
import in.dsbakshi.game.tictactoe.io.BlockingIO;
import in.dsbakshi.game.tictactoe.player.Player;

/**
 * Builder for {@link BlockingIoGame}.
 *
 * @author Dilbagh Singh Bakshi
 */
public class BlockingIoGameBuilder {

    private Player player1;

    private Player player2;

    private Grid grid;

    private BlockingIO io;

    public BlockingIoGameBuilder withFirstPlayer(Player player) {
        player1 = player;
        return this;
    }

    public BlockingIoGameBuilder withSecondPlayer(Player player) {
        player2 = player;
        return this;
    }

    public BlockingIoGameBuilder withGrid(Grid grid) {
        this.grid = grid;
        return this;
    }

    public BlockingIoGameBuilder withIo(BlockingIO io) {
        this.io = io;
        return this;
    }

    public BlockingIoGame build() {
        return new BlockingIoGame(player1, player2, grid, io);
    }
}
