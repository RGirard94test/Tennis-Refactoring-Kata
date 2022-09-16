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

    @Test
    fun itShouldComputePlayerWinScore() {
        //GIVEN
        val player = Player("jean-marc")
        //WHEN
        val actual = player.computeWinPlayer()

        //THEN
        assertEquals(actual, "Win for jean-marc")
    }

    @Test
    fun itShouldComputePlayerAdvantageScore() {
        //GIVEN
        val player = Player("jean-marc")
        //WHEN
        val actual = player.computeAdvantagePlayer()

        //THEN
        assertEquals(actual, "Advantage jean-marc")
    }
}