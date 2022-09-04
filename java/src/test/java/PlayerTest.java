import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void itShouldInitializeAPlayerWithScore0() {
        // GIVEN
        String playerName = "playerName";

        // WHEN
        Player player = new Player(playerName);

        // THEN
        assertEquals(player.score, 0);
        assertEquals(player.playerName, playerName);
    }

    @Test
    public void itShouldIncrementPlayerScoreByOne() {
        //GIVEN
        Player player = new Player("player1");

        //WHEN
        player.wonPoint();

        //THEN
        assertEquals(player.score, 1);
    }

}
