
public class TennisGame1 implements TennisGame {
    private Player player1;
    private Player player2;
    private Score score;

    public TennisGame1(Player player1, Player player2, Score score) {
        this.player1 = player1;
        this.player2 = player2;
        this.score = score;
    }

    public String getScore() {
        String score = "";
        if (player1.score == player2.score) {
            score = getScoreWhenisEqualBetweenPlayers();
        } else if (player1.score >= 4 || player2.score >= 4) {
            score = getScoreAboveDeuce();
        } else {
            score = getNormalScore(score);
        }
        return score;
    }

    private String getNormalScore(String score) {
        for (int i = 1; i < 3; i++) {
            int tempScore = 0;
            if (i == 1) tempScore = player1.score;
            else {
                score += "-";
                tempScore = player2.score;
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }
        return score;
    }

    private String getScoreAboveDeuce() {
        String score;
        int minusResult = player1.score - player2.score;
        if (minusResult == 1) score = "Advantage " + player1.playerName;
        else if (minusResult == -1) score = "Advantage " + player2.playerName;
        else if (minusResult >= 2) score = "Win for " + player1.playerName;
        else score = "Win for " + player2.playerName;
        return score;
    }

    private String getScoreWhenisEqualBetweenPlayers() {
        String score;
        switch (player1.score) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;
        }
        return score;
    }
}
