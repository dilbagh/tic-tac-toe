package in.dsbakshi.game.tictactoe.grid;

import com.google.common.base.Preconditions;

/**
 * An abstract tic tac toe grid, that can validate the moves.
 *
 * @author Dilbagh Singh Bakshi
 */
public abstract class AbstractGrid implements Grid {

    @Override
    public void mark(Position position, Mark mark) {
        validate(position);
        markOnGrid(position, mark);
    }

    protected abstract int getSide();

    protected abstract void markOnGrid(Position position, Mark mark);

    private void validate(Position position) {
        Preconditions.checkArgument(isWithinSize(position), "Invalid co-ordinates.");
        Preconditions.checkArgument(getView().isValidMove(position), "Already marked.");
    }

    private boolean isWithinSize(Position position) {
        int x = position.getX();
        int y = position.getY();
        int side = getSide();
        return x >= 0 && x < side && y >= 0 && y < side;
    }
}
