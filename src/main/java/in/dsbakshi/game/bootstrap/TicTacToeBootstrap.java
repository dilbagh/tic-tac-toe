package in.dsbakshi.game.bootstrap;

import in.dsbakshi.game.io.ConsoleIO;
import in.dsbakshi.game.tictactoe.*;

public class TicTacToeBootstrap {

    public static void main(String[] args) {
        ConsoleIO io = new ConsoleIO();
        Game game = createGame(io);
        Result result = game.play();
        io.display(result);
    }

    private static Game createGame(ConsoleIO io) {
        return new GameBuilder()
                .withGrid(new DisplayableGrid())
                .withConfig(createGameConfig(io))
                .withWinnerCheck(new WinnerCheck())
                .withIo(io)
                .build();
    }

    private static GameConfig createGameConfig(ConsoleIO io) {
        Player p1 = new Player(io.read("Player1, Enter your name :", "Player1"));
        Player p2 = new Player(io.read("Player2, Enter your name :", "Player2"));
        return new GameConfig(p1, p2);
    }

}
