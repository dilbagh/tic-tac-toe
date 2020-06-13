package in.dsbakshi.game.tictactoe.io;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import in.dsbakshi.game.tictactoe.grid.GridView;
import in.dsbakshi.game.tictactoe.grid.Mark;
import in.dsbakshi.game.tictactoe.grid.Position;
import in.dsbakshi.game.tictactoe.player.Player;

import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Game operations using standard input/output.
 *
 * @author Dilbagh Singh Bakshi
 */
public class ConsoleIO implements BlockingIO {

    private static final Scanner IN = new Scanner(System.in);

    @Override
    public void updateCurrentPlayerDisplay(Player player) {
        display(String.join("",
                player.getName(), ", your chance! Your mark:", player.getMark().toString()));
    }

    @Override
    public void updateGridDisplay(GridView gridView) {
        Mark[][] gridState = gridView.getCurrentState();

        display("");
        display(IntStream.range(0, gridView.getSizeY())
                .mapToObj(y -> gridLine(gridState, gridView.getSizeX(), y))
                .collect(Collectors.joining(gridLineSeparator(gridView.getSizeX()))));
        display(IntStream.range(0, gridView.getSizeX())
                .mapToObj(x -> String.format(" %d  ", x))
                .collect(Collectors.joining()) + " x y");
    }

    private String gridLineSeparator(int sizeX) {
        return String.join("", "\n-", IntStream.range(0, sizeX)
                .mapToObj(x -> "-")
                .collect(Collectors.joining("-|-")), "-\n");
    }

    private String gridLine(Mark[][] gridState, int sizeX, int y) {
        return String.join("", IntStream.range(0, sizeX)
                .mapToObj(x -> Optional.ofNullable(gridState[x][y]).map(Mark::toString)
                        .map(str -> Strings.padStart(str, 2, ' '))
                        .map(str -> Strings.padEnd(str, 3, ' '))
                        .orElse("   "))
                .collect(Collectors.joining("|")), "    ", String.valueOf(y));
    }

    @Override
    public void declareWinner(Player player) {
        display(player.getName() + " wins!");
    }

    @Override
    public void declareDraw() {
        display("It's a draw!");
    }

    @Override
    public void displayError(Exception exception) {
        display("Error! " + exception.getMessage());
    }

    @Override
    public Position askForMove() {
        String input = read("Where do you want to mark? Enter x,y: ");
        return parse(input);
    }

    /**
     * Display on console.
     *
     * @param text text to display
     */
    public void display(String text) {
        System.out.println(text);
    }

    /**
     * Read from standard input.
     *
     * @param prompt text to prompt
     * @return input by user
     */
    public String read(String prompt) {
        return read(prompt, "");
    }

    /**
     * Read from standard input.
     *
     * @param prompt       text to prompt
     * @param defaultValue default value if user skips input
     * @return input by user
     */
    public String read(String prompt, String defaultValue) {
        System.out.print(prompt);
        String input = IN.nextLine();
        if (Strings.isNullOrEmpty(input)) {
            return defaultValue;
        }
        return input;
    }

    private Position parse(String input) {
        Iterable<String> splitInput = Splitter.on(",")
                .omitEmptyStrings()
                .trimResults()
                .split(input);
        Iterator<String> inputIterator = splitInput.iterator();
        int x = parseInteger(inputIterator.next());
        int y = parseInteger(inputIterator.next());
        return new Position(x, y);
    }

    private int parseInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Not a valid integer \"" + str + "\"", ex);
        }
    }
}
