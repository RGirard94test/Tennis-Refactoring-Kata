class TennisGame3(private val player1Name: String, private val player2Name: String) {

    companion object {
        private val TENNIS_SCORE = arrayOf("Love", "Fifteen", "Thirty", "Forty")
    }

    private val player1: Player = Player((player1Name))
    private val player2: Player = Player((player2Name))

    fun getScore(): String {
        val s: String
        if (player1.score < 4 && player2.score < 4) {
            if (player1.score + player2.score != 6) {
                s = TENNIS_SCORE[player1.score]
                return if (player1.score == player2.score) "$s-All" else "$s-${TENNIS_SCORE[player2.score]}"
            } else {
                return deuce()
            }
        } else {
            return deuce()
        }
    }

    private fun deuce(): String {
        var s1 = ""
        if (player1.score == player2.score)
            return "Deuce"
        s1 = if (player1.score > player2.score) player1.name else player2.name
        return if ((player1.score - player2.score) * (player1.score - player2.score) == 1) "Advantage $s1" else "Win for $s1"
    }

    fun wonPoint(playerName: String) {
        if (playerName === player1.name)
            this.player1.score += 1
        else
            this.player2.score += 1
    }

}
