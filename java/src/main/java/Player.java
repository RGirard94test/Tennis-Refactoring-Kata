public class Player implements IPlayer {
    public String playerName;
    public int score = 0;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void wonPoint() {
        this.score += 1;
    }
}
