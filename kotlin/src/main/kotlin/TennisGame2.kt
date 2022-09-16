class TennisGame2(private val player1Name: String, private val player2Name: String) : TennisGame {

    companion object {
        private const val LOVE = 0
        private const val THIRTY = 2
        private const val FORTY = 3
        private const val OVER_FORTY = 4
    }

    private val player1 = Player(player1Name)
    private val player2 = Player(player2Name)

    var P1res: String = ""
    var P2res: String = ""

    override fun getScore(): String {
        var score = ""
        if (player1.score == player2.score && player1.score < OVER_FORTY) {
            score = computeEqualScore(score)
        }

        if (player1.score == player2.score && player1.score >= FORTY) {
            score = computeDeuceScore(score)
        }

        if (player1.score > LOVE && player2.score == LOVE) {
            score = computePlayer1Score(score)
        }
        if (player2.score > LOVE && player1.score == LOVE) {
            score = computePlayer2Score(score)
        }

        if (player1.score > player2.score && player1.score < OVER_FORTY) {
            score = computePlayer1IsLeadingScore(score)
        }
        if (player2.score > player1.score && player2.score < OVER_FORTY) {
            score = computePlayer2IsLeadingScore(score)
        }

        if (player1.score > player2.score && player2.score >= FORTY) {
            score = computeAdvantagePlayer1(score)
        }

        if (player2.score > player1.score && player1.score >= FORTY) {
            score = computeAdvantagePlayer2(score)
        }

        if (player1.score >= OVER_FORTY && player2.score >= LOVE && player1.score - player2.score >= THIRTY) {
            score = computeWinPlayer1(score)
        }
        if (player2.score >= OVER_FORTY && player1.score >= LOVE && player2.score - player1.score >= THIRTY) {
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

        score1 = "Win for ${player1.name}"
        return score1
    }

    private fun computeAdvantagePlayer2(score: String): String {
        var score1 = score
        score1 = "Advantage ${player2.name}"
        return score1
    }

    private fun computeAdvantagePlayer1(score: String): String {
        var score1 = score
        score1 = "Advantage player1"
        return score1
    }

    private fun computePlayer2IsLeadingScore(score: String): String {
        var score1 = score
        if (player2.score == 2)
            P2res = "Thirty"
        if (player2.score == 3)
            P2res = "Forty"
        if (player1.score == 1)
            P1res = "Fifteen"
        if (player1.score == 2)
            P1res = "Thirty"
        score1 = "$P1res-$P2res"
        return score1
    }

    private fun computePlayer1IsLeadingScore(score: String): String {
        var score1 = score
        if (player1.score == 2)
            P1res = "Thirty"
        if (player1.score == 3)
            P1res = "Forty"
        if (player2.score == 1)
            P2res = "Fifteen"
        if (player2.score == 2)
            P2res = "Thirty"
        score1 = "$P1res-$P2res"
        return score1
    }

    private fun computePlayer2Score(score: String): String {
        var score1 = score
        if (player2.score == 1)
            P2res = "Fifteen"
        if (player2.score == 2)
            P2res = "Thirty"
        if (player2.score == 3)
            P2res = "Forty"

        P1res = "Love"
        score1 = "$P1res-$P2res"
        return score1
    }

    private fun computePlayer1Score(score: String): String {
        var score1 = score
        if (player1.score == 1)
            P1res = "Fifteen"
        if (player1.score == 2)
            P1res = "Thirty"
        if (player1.score == 3)
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
        if (player1.score == LOVE)
            score1 = "Love"
        if (player1.score == 1)
            score1 = "Fifteen"
        if (player1.score == 2)
            score1 = "Thirty"
        score1 += "-All"
        return score1
    }

    fun P1Score() {
        player1.score++
    }

    fun P2Score() {
        player2.score++
    }

    override fun wonPoint(player: String) {
        if (player === "player1")
            P1Score()
        else
            P2Score()
    }
}