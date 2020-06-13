package in.dsbakshi.game.tictactoe.gameplay;

import in.dsbakshi.game.tictactoe.grid.Grid;
import in.dsbakshi.game.tictactoe.grid.GridView;
import in.dsbakshi.game.tictactoe.io.BlockingIO;
import in.dsbakshi.game.tictactoe.player.Player;

/**
 * Tic tac toe Gameplay using a blocking I/O.
 *
 * @author Dilbagh Singh Bakshi
 */
public class BlockingIoGame implements Game {

    private final ChanceProvider chanceProvider;

    private final Grid grid;

    private final BlockingIO io;

    public BlockingIoGame(Player player1, Player player2, Grid grid, BlockingIO io) {
        chanceProvider = new ChanceProvider(player1, player2);
        this.grid = grid;
        this.io = io;
    }

    @Override
    public void play() {
        GridView view = grid.getView();
        while (view.hasMoreMoves()) {
            io.updateGridDisplay(view);
            Player player = chanceProvider.nextChance();
            io.updateCurrentPlayerDisplay(player);
            makeMove(player);
            if (view.hasWinningCombination()) {
                io.updateGridDisplay(view);
                io.declareWinner(player);
                return;
            }
        }
        io.updateGridDisplay(view);
        io.declareDraw();
    }

    private void makeMove(Player player) {
        try {
            player.makeMove(grid);
        } catch (Exception ex) {
            chanceProvider.chanceFailure();
            io.displayError(ex);
        }
    }

    private static class ChanceProvider {

        private final Player[] players = new Player[2];

        private int turn;

        public ChanceProvider(Player player1, Player player2) {
            players[0] = player1;
            players[1] = player2;
        }

        public Player nextChance() {
            return players[turn++ % players.length];
        }

        public void chanceFailure() {
            turn--;
        }
    }
}
