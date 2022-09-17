import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PlayerTest {
    @Test
    @DisplayName("when a player is created his score should be zero")
    fun whenAPlayerIsCreatedHisScoreShouldBeZero() {
        //GIVEN
        val player = Player("jean-philippe")
        //WHEN //THEN
        assertEquals(player.score, 0)
    }
}