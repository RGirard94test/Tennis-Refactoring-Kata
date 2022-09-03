
public class TennisGame1 implements TennisGame {

    private Score gameScore = new Score(0,0);
    private Player player1;
    private Player player2;

    public TennisGame1(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1.name)
            gameScore.firstPlayerScore += 1;
        else
            gameScore.secondPlayerScore += 1;
    }

    @Override
    public String getScore(Score matchScore) {
       return matchScore.getScore(gameScore, player1.name, player2.name);
    }
}
