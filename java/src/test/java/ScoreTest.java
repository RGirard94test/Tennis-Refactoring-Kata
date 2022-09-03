import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class ScoreTest {

    @Test
    public void whenWeCallGetScoreItShouldReturnTheCurrentScoreForTheGame() {
        //GIVEN
        Score score = new Score(1,0);
        String expected = "Fifteen-Love";
        //WHEN
        String actual = score.getScore(score,"L'éliance", "le giro");
        //THEN
        Assert.assertEquals(actual, expected);
    }

    //COMME LE DIRAIT UN TL : PASSER LES METHODES DU SCORE EN PUBLIC ET LES TESTER ^^
}