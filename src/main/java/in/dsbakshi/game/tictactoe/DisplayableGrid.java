package in.dsbakshi.game.tictactoe;

import in.dsbakshi.game.io.Displayable;

/**
 * A grid that can be displayed in text.
 */
public class DisplayableGrid extends Grid implements Displayable {

    @Override
    public String displayText() {
        Mark[] gridState = getCurrentState();
        return String.join("",
                "\n ", displayText(gridState[0]), " | ", displayText(gridState[1]), " | ", displayText(gridState[2]),
                "    1\n",
                "---|---|---\n",
                " ", displayText(gridState[3]), " | ", displayText(gridState[4]), " | ", displayText(gridState[5]),
                "    2\n",
                "---|---|---\n",
                " ", displayText(gridState[6]), " | ", displayText(gridState[7]), " | ", displayText(gridState[8]),
                "    3\n",
                " 1   2   3  x y");
    }

    private String displayText(Mark mark) {
        if (mark == null) {
            return " ";
        }
        return mark.displayText();
    }
}
