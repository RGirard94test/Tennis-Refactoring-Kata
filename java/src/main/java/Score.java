public class Score {

    public Score(int firstPlayerScore, int secondPlayerScore) {
        this.firstPlayerScore = firstPlayerScore;
        this.secondPlayerScore = secondPlayerScore;
    }

    public int firstPlayerScore;
    public int secondPlayerScore;

    public String getScore(Score matchScore, String player1, String player2) {
        String score = "";
        if (matchScore.firstPlayerScore==matchScore.secondPlayerScore)
            score = computeScoreWhenDraw(matchScore);
        else if (matchScore.firstPlayerScore>=4 || matchScore.secondPlayerScore>=4)
            score = computeScoreWhenOverForty(matchScore, player1, player2);
        else
            score = computeScoreRegularPlay(matchScore);
        return score;
    }

    private String computeScoreRegularPlay(Score matchScore) {
        String score = "";
        int tempScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) tempScore = matchScore.firstPlayerScore;
            else { score +="-"; tempScore = matchScore.secondPlayerScore;}
            switch(tempScore)
            {
                case 0:
                    score +="Love";
                    break;
                case 1:
                    score +="Fifteen";
                    break;
                case 2:
                    score +="Thirty";
                    break;
                case 3:
                    score +="Forty";
                    break;
            }
        }
        return score;
    }

    private String computeScoreWhenOverForty(Score matchScore, String player1, String player2) {
        String score;
        int minusResult = matchScore.firstPlayerScore-matchScore.secondPlayerScore;
        score = computeAdvantages(minusResult, player1, player2);
        return score;
    }

    private String computeAdvantages(int minusResult, String player1, String player2) {
        String score;
        if (minusResult ==1) score ="Advantage "+ player1;
        else if (minusResult ==-1) score ="Advantage " + player2;
        else if (minusResult >=2) score = "Win for "+ player1;
        else score ="Win for " + player2;
        return score;
    }

    private String computeScoreWhenDraw(Score matchScore) {
        String score;
        switch (matchScore.firstPlayerScore)
        {
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
