package nl.novi.dpcc.observerpattern.domain;

public class MatchStatistics {

    private int score;
    private int amountYellowCards;
    private int amountRedCards;

    public void MatchStatistics() {
        this.score = 0;
        this.amountYellowCards = 0;
        this.amountRedCards = 0;
    }

    public void addScore() {
        this.score += 1;
    }

    public void addYellowCard() {
        this.amountYellowCards += 1;
    }

    public void addRedCard() {
        this.amountRedCards += 1;
    }

    public int getScore() {
        return score;
    }

    public int getAmountYellowCards() {
        return amountYellowCards;
    }

    public int getAmountRedCards() {
        return amountRedCards;
    }


}
