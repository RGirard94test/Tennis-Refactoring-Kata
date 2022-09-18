
public class TennisGame2 implements TennisGame
{
    public static final int ADVANTAGE = 4;
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;
    public static final String PLAYER_2 = "player2";
    public static final String PLAYER_1 = "player1";
    public int P1point = LOVE;
    public int P2point = LOVE;

    public Player player1;
    public Player player2;

    public String P1res = "";
    public String P2res = "";

    public TennisGame2(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore(){
        String score = "";
        if (P1point == P2point && P1point < ADVANTAGE)
        {
            if (P1point== LOVE)
                score = "Love";
            if (P1point== FIFTEEN)
                score = "Fifteen";
            if (P1point== THIRTY)
                score = "Thirty";
            score += "-All";
        }
        if (P1point==P2point && P1point>= FORTY)
            score = "Deuce";

        if (P1point > LOVE && P2point== LOVE)
        {
            if (P1point== FIFTEEN)
                P1res = "Fifteen";
            if (P1point== THIRTY)
                P1res = "Thirty";
            if (P1point== FORTY)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if (P2point > LOVE && P1point== LOVE)
        {
            if (P2point== FIFTEEN)
                P2res = "Fifteen";
            if (P2point== THIRTY)
                P2res = "Thirty";
            if (P2point== FORTY)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (P1point>P2point && P1point < ADVANTAGE)
        {
            if (P2point== FIFTEEN)
                P2res="Fifteen";
            if (P1point== THIRTY)
                P1res="Thirty";
            if (P1point== FORTY)
                P1res="Forty";
            if (P2point== THIRTY)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
        if (P2point>P1point && P2point < ADVANTAGE)
        {
            if (P2point== THIRTY)
                P2res="Thirty";
            if (P2point== FORTY)
                P2res="Forty";
            if (P1point== FIFTEEN)
                P1res="Fifteen";
            if (P1point== THIRTY)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }

        if (P1point > P2point && P2point >= FORTY)
        {
            score = "Advantage " + PLAYER_1;
        }

        if (P2point > P1point && P1point >= FORTY)
        {
            score = "Advantage " + PLAYER_2;
        }

        if (P1point>=ADVANTAGE && P2point>= LOVE && (P1point-P2point)>= THIRTY)
        {
            score = "Win for " + PLAYER_1;
        }
        if (P2point>=ADVANTAGE && P1point>= LOVE && (P2point-P1point)>= THIRTY)
        {
            score = "Win for " + PLAYER_2;
        }
        return score;
    }

    public void SetP1Score(int number){

        for (int i = LOVE; i < number; i++)
        {
            P1Score();
        }

    }

    public void SetP2Score(int number){

        for (int i = LOVE; i < number; i++)
        {
            P2Score();
        }

    }

    public void P1Score(){
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == PLAYER_1)
            P1Score();
        else
            P2Score();
    }
}
