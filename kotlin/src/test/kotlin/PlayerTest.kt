import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PlayerTest {
    @Test
    fun whenWeCreateAPlayerHisInitialScoreShouldBeZero() {
        //GIVEN
        val player = Player("Jean-Jacques")
        //WHEN
        val actual = player.score

        //THEN
        assertEquals(actual, 0)
    }
}