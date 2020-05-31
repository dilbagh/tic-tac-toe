package in.dsbakshi.game.bootstrap;

import in.dsbakshi.game.io.ConsoleIO;
import in.dsbakshi.game.tictactoe.*;

/**
 * Builder for {@link Game}.
 *
 * @author Dilbagh Singh Bakshi
 */
public class GameBuilder {

    private Grid grid;

    private GameConfig config;

    private WinnerCheck winnerCheck;

    private ConsoleIO io;

    public GameBuilder withGrid(Grid grid) {
        this.grid = grid;
        return this;
    }

    public GameBuilder withConfig(GameConfig config) {
        this.config = config;
        return this;
    }

    public GameBuilder withWinnerCheck(WinnerCheck winnerCheck) {
        this.winnerCheck = winnerCheck;
        return this;
    }

    public GameBuilder withIo(ConsoleIO io) {
        this.io = io;
        return this;
    }

    public Game build() {
        return new Game(grid, config, winnerCheck, io);
    }

}
