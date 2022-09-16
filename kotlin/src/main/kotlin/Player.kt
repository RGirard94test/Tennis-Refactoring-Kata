class Player(val name: String) {
    companion object {
        private const val INITAL_SCORE = 0
    }

    var score: Int = INITAL_SCORE
}
