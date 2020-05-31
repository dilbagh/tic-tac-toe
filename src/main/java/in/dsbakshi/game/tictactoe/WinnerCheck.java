package in.dsbakshi.game.tictactoe;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Checks winning condition on a Grid.
 *
 * @author Dilbagh Singh Bakshi
 */
public class WinnerCheck {

    private static final int[][] WIN_COMBOS = {
            { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },
            { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
            { 0, 4, 8 }, { 2, 4, 6 } };

    /**
     * Check if anyone is winning in the provided grid state.
     *
     * @param gridState state of the Grid
     * @return Optional of winning Mark
     */
    public Optional<Mark> checkForWinner(Mark[] gridState) {
        return Arrays.stream(WIN_COMBOS)
                .map(combo -> checkComboForWinner(combo, gridState))
                .filter(Objects::nonNull)
                .findFirst();
    }

    private Mark checkComboForWinner(int[] combo, Mark[] gridState) {
        Set<Mark> marksInCombo = Arrays.stream(combo)
                .mapToObj(index -> gridState[index])
                .collect(Collectors.toSet());
        if (marksInCombo.contains(null) || marksInCombo.size() > 1) {
            return null;
        }
        return marksInCombo.iterator().next();
    }

}
