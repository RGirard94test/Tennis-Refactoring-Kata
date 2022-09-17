class TennisGame3(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var player2Score: Int = 0
    private var player1Score: Int = 0

    private val player1: Player = Player((player1Name))
    private val player2: Player = Player((player2Name))

    override fun getScore(): String {
        val s: String
        if (player1Score < 4 && player2Score < 4) {
            if (player1Score + player2Score != 6) {
                val p = arrayOf("Love", "Fifteen", "Thirty", "Forty")
                s = p[player1Score]
                return if (player1Score == player2Score) "$s-All" else "$s-${p[player2Score]}"
            } else {
                if (player1Score == player2Score)
                    return "Deuce"
                s = if (player1Score > player2Score) player1.name else player2.name
                return if ((player1Score - player2Score) * (player1Score - player2Score) == 1) "Advantage $s" else "Win for $s"
            }
        } else {
            if (player1Score == player2Score)
                return "Deuce"
            s = if (player1Score > player2Score) player1.name else player2.name
            return if ((player1Score - player2Score) * (player1Score - player2Score) == 1) "Advantage $s" else "Win for $s"
        }
    }

    override fun wonPoint(playerName: String) {
        if (playerName === player1.name)
            this.player1Score += 1
        else
            this.player2Score += 1

    }

}
