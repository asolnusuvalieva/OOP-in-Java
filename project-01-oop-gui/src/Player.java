public class Player{
    private boolean lost = false;
    private boolean won;
    public int totalCellsToUncover;

    /* Getters */
    public boolean isLost() {
        return lost;
    }

    public boolean isWon() {
        return won;
    }


    /* Setters */
    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public Player(GameLevel gameLevel){
        totalCellsToUncover = gameLevel.getFIELD_HEIGHT() * gameLevel.getFIELD_WIDTH() - gameLevel.getMINES();
        won = totalCellsToUncover == 0;
    }
}
