package in.dsbakshi.game.tictactoe.gameplay;

import in.dsbakshi.game.tictactoe.grid.GridView;
import in.dsbakshi.game.tictactoe.grid.Mark;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A winning check function for a three by three grid.
 *
 * @author Dilbagh Singh Bakshi
 */
public class ThreeByThreeWinnerCheck implements Function<GridView, Boolean> {

    @Override
    public Boolean apply(GridView gridView) {
        Mark[][] state = gridView.getCurrentState();
        return IntStream.range(0, 3).anyMatch(y -> checkRow(state, y)) ||
                IntStream.range(0, 3).anyMatch(x -> checkColumn(state, x)) ||
                checkDiagonals(state);

    }

    private boolean checkRow(Mark[][] state, int y) {
        return checkForWin(IntStream.range(0, 3)
                .mapToObj(x -> state[x][y])
                .collect(Collectors.toSet()));
    }

    private boolean checkColumn(Mark[][] state, int x) {
        return checkForWin(Arrays.stream(state[x])
                .collect(Collectors.toSet()));
    }

    private boolean checkDiagonals(Mark[][] state) {
        return checkForWin(IntStream.range(0, 3)
                .mapToObj(i -> state[i][i])
                .collect(Collectors.toSet())) ||
                checkForWin(IntStream.range(0, 3)
                        .mapToObj(i -> state[i][2 - i])
                        .collect(Collectors.toSet()));
    }

    private boolean checkForWin(Set<Mark> marks) {
        return !marks.contains(null) && marks.size() == 1;
    }
}
