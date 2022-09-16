class Player(val name: String) {

    companion object {
        private const val INITAL_SCORE = 0
        private const val INITIAL_RESULT = ""
    }

    var score: Int = INITAL_SCORE
    var scoreResult: String = INITIAL_RESULT

    fun computeWinPlayer(): String {
        return "Win for $name"
    }

    fun computeAdvantagePlayer(): String {
        return "Advantage $name"
    }
}
