package in.dsbakshi.game.tictactoe.grid;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A square grid of configurable size.
 *
 * @author Dilbagh Singh Bakshi
 */
public class SquareGrid extends AbstractGrid {

    private final int side;

    private final Mark[] state;

    private final Function<GridView, Boolean> winnerCheck;

    public SquareGrid(int side, Function<GridView, Boolean> winnerCheck) {
        this.side = side;
        state = new Mark[side * side];
        this.winnerCheck = winnerCheck;
    }

    @Override
    public GridView getView() {
        return new ReadOnlyView();
    }

    @Override
    protected int getSide() {
        return side;
    }

    @Override
    protected void markOnGrid(Position position, Mark mark) {
        state[getIndex(position)] = mark;
    }

    private int getIndex(Position position) {
        return position.getX() + side * position.getY();
    }

    private class ReadOnlyView implements GridView {

        @Override
        public boolean isValidMove(Position position) {
            return state[getIndex(position)] == null;
        }

        @Override
        public boolean hasMoreMoves() {
            return Arrays.stream(state)
                    .anyMatch(Objects::isNull);
        }

        @Override
        public boolean hasWinningCombination() {
            return winnerCheck.apply(this);
        }

        @Override
        public Mark[][] getCurrentState() {
            Mark[][] currentState = new Mark[side][side];
            IntStream.range(0, state.length)
                    .forEach(index -> {
                        Position position = getPosition(index);
                        currentState[position.getX()][position.getY()] = state[index];
                    });
            return currentState;
        }

        @Override
        public int getSizeX() {
            return side;
        }

        @Override
        public int getSizeY() {
            return side;
        }

        @Override
        public List<Position> getAvailableMoves() {
            return IntStream.range(0, state.length)
                    .filter(index -> state[index] == null)
                    .mapToObj(this::getPosition)
                    .collect(Collectors.toList());
        }

        private Position getPosition(int index) {
            return new Position(index % side,
                    index / side);
        }
    }

}
