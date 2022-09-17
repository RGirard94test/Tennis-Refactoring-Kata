import TennisScore.scoreToTennisScore

class TennisGame3() {

    fun getScore(firstPlayer: Player, secondPlayer: Player): String {
        val s: String
        if (firstPlayer.score < 4 && secondPlayer.score < 4) {
            if (firstPlayer.score + secondPlayer.score != 6) {
                s = scoreToTennisScore(firstPlayer.score)
                if (firstPlayer.score == secondPlayer.score)
                    return "$s-All"
                else
                    return "$s-${scoreToTennisScore(secondPlayer.score)}"
            } else {
                return deuce(firstPlayer, secondPlayer)
            }
        } else {
            return deuce(firstPlayer, secondPlayer)
        }
    }

    fun deuce(firstPlayer: Player, secondPlayer: Player): String {
        if (firstPlayer.score == secondPlayer.score)
            return "Deuce"

        return isOverForty(firstPlayer, secondPlayer)
    }

    private fun isOverForty(firstPlayer: Player, secondPlayer: Player): String {
        var s1 = ""
        s1 = if (firstPlayer.score > secondPlayer.score) firstPlayer.name else secondPlayer.name
        return if ((firstPlayer.score - secondPlayer.score) * (firstPlayer.score - secondPlayer.score) == 1) "Advantage $s1" else "Win for $s1"
    }

    fun wonPoint(winnerName: String, firstPlayer: Player, secondPlayer: Player) {
        if (winnerName === firstPlayer.name)
            firstPlayer.score += 1
        else
            secondPlayer.score += 1
    }

}
