package in.dsbakshi.game.tictactoe;

import java.util.EnumMap;
import java.util.Map;

/**
 * Configuration of the game.
 *
 * @author Dilbagh Singh Bakshi
 */
public class GameConfig {

    private final Map<Mark, Player> playerMap;

    /**
     * @param player1 first player
     * @param player2 second player
     */
    public GameConfig(Player player1, Player player2) {
        playerMap = new EnumMap<>(Mark.class);
        playerMap.put(Mark.CROSS, player1);
        playerMap.put(Mark.NOUGHT, player2);
    }

    /**
     * Get player with given mark.
     *
     * @param mark mark
     * @return player with the marlk
     */
    public Player getPlayer(Mark mark) {
        return playerMap.get(mark);
    }

}
