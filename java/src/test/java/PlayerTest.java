import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    @Test
    public void getNameShouldReturnPlayerName(){
        Player player = new Player("Martin");
        String actual = player.getName();
        assertEquals("Martin", actual);
    }
}
