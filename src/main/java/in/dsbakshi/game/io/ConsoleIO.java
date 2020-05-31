package in.dsbakshi.game.io;

import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * All IO operations through console.
 *
 * @author Dilbagh Singh Bakshi
 */
public class ConsoleIO {

    private static final Scanner IN = new Scanner(System.in);

    /**
     * Display on console.
     *
     * @param text text to display
     */
    public void display(String text) {
        System.out.println(text);
    }

    /**
     * Display on console using a {@link Displayable} instance.
     *
     * @param displayable instance to display text from
     */
    public void display(Displayable displayable) {
        display(getText(displayable));
    }

    /**
     * Display on console using any instance.
     *
     * @param object instance to display text from
     */
    public void display(Object object) {
        display(getText(object));
    }

    /**
     * Display concatenated text from multiple objects.
     *
     * @param objects instances to display text from
     */
    public void display(Object... objects) {
        display(Arrays.stream(objects)
                .map(this::getText)
                .collect(Collectors.joining()));
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

    private String getText(Displayable displayable) {
        return displayable.displayText();
    }

    private String getText(Object object) {
        if (object == null) {
            return "";
        }
        if (object instanceof Displayable) {
            return getText((Displayable) object);
        }
        return object.toString();
    }

}
