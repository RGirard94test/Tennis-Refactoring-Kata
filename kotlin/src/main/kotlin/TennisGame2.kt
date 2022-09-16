class TennisGame2(private val player1Name: String, private val player2Name: String) : TennisGame {

    companion object {
        private const val LOVE = 0
        private const val THIRTY = 2
        private const val FORTY = 3
        private const val OVER_FORTY = 4
    }

    var P1point: Int = 0
    var P2point: Int = 0

    var P1res: String = ""
    var P2res: String = ""

    override fun getScore(): String {
        var score = ""
        if (P1point == P2point && P1point < OVER_FORTY) {
            score = computeEqualScore(score)
        }
        if (P1point == P2point && P1point >= FORTY) {

            score = computeDeuceScore(score)
        }

        if (P1point > LOVE && P2point == LOVE) {
            score = computePlayer1Score(score)
        }
        if (P2point > LOVE && P1point == LOVE) {
            score = computePlayer2Score(score)
        }

        if (P1point > P2point && P1point < OVER_FORTY) {
            score = computePlayer1IsLeadingScore(score)
        }
        if (P2point > P1point && P2point < OVER_FORTY) {
            score = computePlayer2IsLeadingScore(score)
        }

        if (P1point > P2point && P2point >= FORTY) {
            score = computeAdvantagePlayer1(score)
        }

        if (P2point > P1point && P1point >= FORTY) {
            score = computeAdvantagePlayer2(score)
        }

        if (P1point >= OVER_FORTY && P2point >= LOVE && P1point - P2point >= THIRTY) {
            score = computeWinPlayer1(score)
        }
        if (P2point >= OVER_FORTY && P1point >= LOVE && P2point - P1point >= THIRTY) {
            score = computeWinPlayer2(score)
        }
        return score
    }

    private fun computeWinPlayer2(score: String): String {
        var score1 = score
        score1 = "Win for player2"
        return score1
    }

    private fun computeWinPlayer1(score: String): String {
        var score1 = score
        score1 = "Win for player1"
        return score1
    }

    private fun computeAdvantagePlayer2(score: String): String {
        var score1 = score
        score1 = "Advantage player2"
        return score1
    }

    private fun computeAdvantagePlayer1(score: String): String {
        var score1 = score
        score1 = "Advantage player1"
        return score1
    }

    private fun computePlayer2IsLeadingScore(score: String): String {
        var score1 = score
        if (P2point == 2)
            P2res = "Thirty"
        if (P2point == 3)
            P2res = "Forty"
        if (P1point == 1)
            P1res = "Fifteen"
        if (P1point == 2)
            P1res = "Thirty"
        score1 = "$P1res-$P2res"
        return score1
    }

    private fun computePlayer1IsLeadingScore(score: String): String {
        var score1 = score
        if (P1point == 2)
            P1res = "Thirty"
        if (P1point == 3)
            P1res = "Forty"
        if (P2point == 1)
            P2res = "Fifteen"
        if (P2point == 2)
            P2res = "Thirty"
        score1 = "$P1res-$P2res"
        return score1
    }

    private fun computePlayer2Score(score: String): String {
        var score1 = score
        if (P2point == 1)
            P2res = "Fifteen"
        if (P2point == 2)
            P2res = "Thirty"
        if (P2point == 3)
            P2res = "Forty"

        P1res = "Love"
        score1 = "$P1res-$P2res"
        return score1
    }

    private fun computePlayer1Score(score: String): String {
        var score1 = score
        if (P1point == 1)
            P1res = "Fifteen"
        if (P1point == 2)
            P1res = "Thirty"
        if (P1point == 3)
            P1res = "Forty"

        P2res = "Love"
        score1 = "$P1res-$P2res"
        return score1
    }

    private fun computeDeuceScore(score: String): String {
        var score1 = score
        score1 = "Deuce"
        return score1
    }

    private fun computeEqualScore(score: String): String {
        var score1 = score
        if (P1point == LOVE)
            score1 = "Love"
        if (P1point == 1)
            score1 = "Fifteen"
        if (P1point == 2)
            score1 = "Thirty"
        score1 += "-All"
        return score1
    }

    fun SetP1Score(number: Int) {

        for (i in 0 until number) {
            P1Score()
        }
    }

    fun SetP2Score(number: Int) {

        for (i in 0 until number) {
            P2Score()
        }
    }

    fun P1Score() {
        P1point++
    }

    fun P2Score() {
        P2point++
    }

    override fun wonPoint(player: String) {
        if (player === "player1")
            P1Score()
        else
            P2Score()
    }
}