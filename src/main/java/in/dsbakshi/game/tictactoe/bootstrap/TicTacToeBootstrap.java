package in.dsbakshi.game.tictactoe.bootstrap;

import in.dsbakshi.game.tictactoe.gameplay.Game;
import in.dsbakshi.game.tictactoe.gameplay.ThreeByThreeWinnerCheck;
import in.dsbakshi.game.tictactoe.grid.Mark;
import in.dsbakshi.game.tictactoe.grid.SquareGrid;
import in.dsbakshi.game.tictactoe.io.ConsoleIO;
import in.dsbakshi.game.tictactoe.player.BlockingIoPlayerIntel;
import in.dsbakshi.game.tictactoe.player.DefaultPlayer;
import in.dsbakshi.game.tictactoe.player.DumbAutomatedPlayerIntel;

/**
 * Bootstrap the Tic Tac Toe game on console.
 *
 * @author Dilbagh Singh Bakshi
 */
public class TicTacToeBootstrap {

    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();

        Game game = null;
        while (game == null) {
            try {
                int choice = askChoice(io);
                game = createGame(choice, io);
            } catch (Exception exception) {
                io.display("Invalid Choice!");
            }
        }

        game.play();
    }

    private static int askChoice(ConsoleIO io) {
        io.display("How do you want to play?");
        io.display("========================");
        io.display("1. Player vs Dumb AI");
        io.display("2. Player vs Player");
        return Integer.parseInt(io.read("Please choose : "));
    }

    private static Game createGame(int choice, ConsoleIO io) {
        BlockingIoPlayerIntel blockingIoPlayerIntel = new BlockingIoPlayerIntel(io);
        switch (choice) {
            case 1:
                return baseGameBuilder(io, blockingIoPlayerIntel)
                        .withSecondPlayer(new DefaultPlayer("Dumb AI",
                                Mark.O,
                                new DumbAutomatedPlayerIntel()))
                        .build();
            case 2:
                return baseGameBuilder(io, blockingIoPlayerIntel)
                        .withSecondPlayer(new DefaultPlayer(askName(io, "Player2"),
                                Mark.O,
                                blockingIoPlayerIntel))
                        .build();
        }
        throw new IllegalArgumentException("Invalid choice");
    }

    private static BlockingIoGameBuilder baseGameBuilder(ConsoleIO io, BlockingIoPlayerIntel blockingIoPlayerIntel) {
        return new BlockingIoGameBuilder()
                .withFirstPlayer(new DefaultPlayer(askName(io, "Player1"),
                        Mark.X,
                        blockingIoPlayerIntel))
                .withGrid(new SquareGrid(3,
                        new ThreeByThreeWinnerCheck()))
                .withIo(io);
    }

    private static String askName(ConsoleIO io, String defaultName) {
        return io.read(defaultName + ", Enter your name : ", defaultName);
    }

}
