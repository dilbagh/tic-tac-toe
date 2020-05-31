package in.dsbakshi.game.tictactoe;

import com.google.common.base.Splitter;
import in.dsbakshi.game.io.ConsoleIO;

import java.util.Iterator;
import java.util.Optional;

/**
 * Orchestrates the game.
 *
 * @author Dilbagh Singh Bakshi
 */
public class Game {

    private final Grid grid;

    private final GameConfig config;

    private final WinnerCheck winnerCheck;

    private final ConsoleIO io;

    /**
     * @param grid        instance of {@link Grid}
     * @param config      instance of {@link GameConfig}
     * @param winnerCheck instance of {@link WinnerCheck}
     * @param io          instance of {@link ConsoleIO}
     */
    public Game(Grid grid, GameConfig config, WinnerCheck winnerCheck, ConsoleIO io) {
        this.grid = grid;
        this.config = config;
        this.winnerCheck = winnerCheck;
        this.io = io;
    }

    /**
     * Start orchestration of the gameplay.
     *
     * @return result of the game
     */
    public Result play() {
        while (grid.isNotFull()) {
            io.display(grid);
            int[] pos = readPosition();
            grid.markBox(pos[0], pos[1]);
            Optional<Result> result = checkWinner();
            if (result.isPresent()) {
                io.display(grid);
                return result.get();
            }
        }
        io.display(grid);
        return new DrawResult();
    }

    private int[] readPosition() {
        Mark currentMark = grid.getCurrentMark();
        io.display(config.getPlayer(currentMark), ", your turn. Your mark: ", currentMark);
        try {
            return parseInput(io.read("Where do you want to mark? Enter x,y:"));
        } catch (Exception ex) {
            return new int[] { 0, 0 };
        }
    }

    private int[] parseInput(String input) {
        Iterable<String> splitInput = Splitter.on(',')
                .omitEmptyStrings()
                .trimResults()
                .split(input);
        int[] pos = new int[2];
        Iterator<String> iterator = splitInput.iterator();
        pos[0] = Integer.parseInt(iterator.next());
        pos[1] = Integer.parseInt(iterator.next());
        return pos;
    }

    private Optional<Result> checkWinner() {
        return winnerCheck.checkForWinner(grid.getCurrentState())
                .map(config::getPlayer)
                .map(WinResult::new);
    }
}
