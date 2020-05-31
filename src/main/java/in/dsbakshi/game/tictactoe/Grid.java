package in.dsbakshi.game.tictactoe;

import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.Objects;

/**
 * Holds the state of the Grid.
 *
 * @author Dilbagh Singh Bakshi
 */
public class Grid {

    private static final int SIDE = 3;

    private static final int SIZE = SIDE * SIDE;

    private final Mark[] state = new Mark[SIZE];

    private final DimensionTranslator dimensionTranslator;

    private Mark lastMark;

    /**
     * Default constructor.
     */
    public Grid() {
        dimensionTranslator = new DimensionTranslator();
    }

    /**
     * If all boxes on the grid have marks on them.
     *
     * @return grid full or not
     */
    public boolean isNotFull() {
        return Arrays.stream(state).anyMatch(Objects::isNull);
    }

    /**
     * Mark which will be used for current chance.
     *
     * @return mark instance
     */
    public Mark getCurrentMark() {
        if (lastMark == null || lastMark == Mark.NOUGHT) {
            return Mark.CROSS;
        }
        return Mark.NOUGHT;
    }

    /**
     * Put mark on the provided co-ordinates.
     *
     * @param x the X co-ordinate
     * @param y the Y co-ordinate
     */
    public void markBox(int x, int y) {
        try {
            updateMark(dimensionTranslator.toIndex(x, y));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * The current state of the grid.
     *
     * @return single dimensional array of current state
     */
    public Mark[] getCurrentState() {
        return Arrays.copyOf(state, state.length);
    }

    private void updateMark(int index) {
        Preconditions.checkArgument(state[index] == null, "Position already filled");
        Mark currentMark = getCurrentMark();
        state[index] = currentMark;
        lastMark = currentMark;
    }

    /**
     * Translates 2D input to 1D state.
     */
    static class DimensionTranslator {

        /**
         * Convert 2D co-ordinates to 1D index.
         *
         * @param x the X co-ordinate
         * @param y the Y co-ordinate
         * @return 1D index
         */
        public int toIndex(int x, int y) {
            Preconditions.checkArgument(x <= SIDE && x > 0, "Invalid co-ordinates");
            Preconditions.checkArgument(y <= SIDE && y > 0, "Invalid co-ordinates");
            return 3 * y + x - 4;
        }
    }
}
