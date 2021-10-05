package nl.novi.dpcc.observerpattern.observer;

import nl.novi.dpcc.observerpattern.domain.MatchStatistics;
import nl.novi.dpcc.observerpattern.domain.Message;
import java.util.LinkedHashMap;
import java.util.Map;

import static nl.novi.dpcc.observerpattern.domain.MatchEventType.END;

public class BoardObserver implements Observer {

    private final Map<String, MatchStatistics> teams = new LinkedHashMap<>();



    public void update(Message message) {
        String clubname = message.getClubName();
        checkTeam(clubname);

        switch (message.getMatchEventType()) {
            case GOAL:
                addScore(clubname);
                break;
            case YELLOW_CARD:
                addYellowCard(clubname);
                break;
            case RED_CARD:
                addRedCard(clubname);
                break;
            case END:
                printScoreBoard();
                break;
            default:
        }
    }

    private void checkTeam(String clubName) {
        if (!teams.containsKey(clubName)) {
            teams.put(clubName, new MatchStatistics());
        }
    }

    private void addScore(String clubName) {
        teams.get(clubName).addScore();
    }

    private void addYellowCard(String clubName) {
        teams.get(clubName).addYellowCard();
    }

    private void addRedCard(String clubName) {
        teams.get(clubName).addRedCard();
    }

    private void printScoreBoard() {

        if (!isMapValid()) {
            throw new RuntimeException("It's not about the scores or who won, it's about playing the game")
        }

        String numberOne = teams.keySet().toArray()[0].toString();
        MatchStatistics numberOneStats = (MatchStatistics) teams.values().toArray()[0];
        String numberTwo = teams.keySet().toArray()[1].toString();
        MatchStatistics numberTwoStats = (MatchStatistics) teams.values().toArray()[1];

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(numberOne).append(" - ").append(numberTwo).append(" (").append(numberOneStats.getScore()).append("-").append(numberTwoStats.getScore()).append(")").append("\n\r");

        stringBuilder.append("Yellow cards: ").append(numberOne).append(" (").append(numberOneStats.getAmountYellowCards()).append(") ").append(numberTwo).append(" (").append(numberTwoStats.getAmountYellowCards()).append(") ").append("\r\n");

        stringBuilder.append("Red cards: ").append(numberOne).append(" (").append(numberOneStats.getAmountRedCards()).append(") ").append(numberTwo).append(" (").append(numberTwoStats.getAmountRedCards()).append(") ");

        System.out.println(stringBuilder.toString());
    }

    private boolean isMapValid() {
        return teams.keySet().toArray()[0] != null && teams.keySet().toArray()[1] != null;
    }
}