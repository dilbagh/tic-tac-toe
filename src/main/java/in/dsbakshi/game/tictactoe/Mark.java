package in.dsbakshi.game.tictactoe;

import in.dsbakshi.game.io.Displayable;

/**
 * Marks allowed on the Grid.
 *
 * @author Dilbagh Singh Bakshi
 */
public enum Mark implements Displayable {
    CROSS("X"),
    NOUGHT("O");

    private final String value;

    /**
     * @param value value of the Mark
     */
    Mark(String value) {
        this.value = value;
    }

    /**
     * Get the value of the mark.
     *
     * @return value of the mark
     */
    public String getValue() {
        return value;
    }

    @Override
    public String displayText() {
        return getValue();
    }
}
