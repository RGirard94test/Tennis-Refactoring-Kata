class TennisGame2(private val player1Name: String, private val player2Name: String) : TennisGame {

    companion object {
        private const val LOVE = 0
        private const val FIFTEEN = 1
        private const val THIRTY = 2
        private const val FORTY = 3
        private const val OVER_FORTY = 4
    }

    private val player1 = Player(player1Name)
    private val player2 = Player(player2Name)

    override fun getScore(): String {
        var score = ""
        if (player1.score == player2.score && player1.score < OVER_FORTY) {
            score = computeEqualScore(score)
        }

        if (player1.score == player2.score && player1.score >= FORTY) {
            score = computeDeuceScore()
        }

        if (player1.score > LOVE && player2.score == LOVE) {
            score = computePlayer1Score()
        }
        if (player2.score > LOVE && player1.score == LOVE) {
            score = computePlayerScore()
        }

        if (player1.score > player2.score && player1.score < OVER_FORTY) {
            score = computePlayer1IsLeadingScore()
        }
        if (player2.score > player1.score && player2.score < OVER_FORTY) {
            score = computePlayer2IsLeadingScore()
        }

        if (player1.score > player2.score && player2.score >= FORTY) {
            score = player1.computeAdvantagePlayer()
        }

        if (player2.score > player1.score && player1.score >= FORTY) {
            score = player2.computeAdvantagePlayer()
        }

        if (player1.score >= OVER_FORTY && player2.score >= LOVE && player1.score - player2.score >= THIRTY) {
            score = player1.computeWinPlayer()
        }
        if (player2.score >= OVER_FORTY && player1.score >= LOVE && player2.score - player1.score >= THIRTY) {
            score = player2.computeWinPlayer()
        }
        return score
    }

    private fun computePlayer2IsLeadingScore(): String {
        if (player2.score == THIRTY)
            player2.scoreResult = "Thirty"
        if (player2.score == FORTY)
            player2.scoreResult = "Forty"
        if (player1.score == FIFTEEN)
            player1.scoreResult = "Fifteen"
        if (player1.score == THIRTY)
            player1.scoreResult = "Thirty"
        return "${player1.scoreResult}-${player2.scoreResult}"
    }

    private fun computePlayer1IsLeadingScore(): String {
        if (player1.score == THIRTY)
            player1.scoreResult = "Thirty"
        if (player1.score == FORTY)
            player1.scoreResult = "Forty"
        if (player2.score == FIFTEEN)
            player2.scoreResult = "Fifteen"
        if (player2.score == THIRTY)
            player2.scoreResult = "Thirty"
        return "${player1.scoreResult}-${player2.scoreResult}"
    }

    private fun computePlayerScore(): String {
        if (player2.score == FIFTEEN)
            player2.scoreResult = "Fifteen"
        if (player2.score == THIRTY)
            player2.scoreResult = "Thirty"
        if (player2.score == FORTY)
            player2.scoreResult = "Forty"

        player1.scoreResult = "Love"
        return "${player1.scoreResult}-${player2.scoreResult}"
    }

    private fun computePlayer1Score(): String {
        if (player1.score == FIFTEEN)
            player1.scoreResult = "Fifteen"
        if (player1.score == THIRTY)
            player1.scoreResult = "Thirty"
        if (player1.score == FORTY)
            player1.scoreResult = "Forty"

        player2.scoreResult = "Love"
        return "${player1.scoreResult}-${player2.scoreResult}"
    }

    private fun computeDeuceScore(): String {
        return "Deuce"
    }

    private fun computeEqualScore(score: String): String {
        var score1 = score
        if (player1.score == LOVE)
            score1 = "Love"
        if (player1.score == FIFTEEN)
            score1 = "Fifteen"
        if (player1.score == THIRTY)
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