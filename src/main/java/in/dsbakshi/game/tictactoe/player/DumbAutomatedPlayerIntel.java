package in.dsbakshi.game.tictactoe.player;

import in.dsbakshi.game.tictactoe.grid.GridView;
import in.dsbakshi.game.tictactoe.grid.Position;

import java.util.List;

/**
 * Player Intelligence that randomly chooses any available move on the grid.
 *
 * @author Dilbagh Singh Bakshi
 */
public class DumbAutomatedPlayerIntel implements PlayerIntelligence {

    @Override
    public Position provideMove(GridView view) {
        List<Position> availableMoves = view.getAvailableMoves();
        if (availableMoves.isEmpty()) {
            throw new IllegalStateException("No moves available.");
        }
        int randomMove = (int) (Math.random() * availableMoves.size());
        return availableMoves.get(randomMove);
    }
}
