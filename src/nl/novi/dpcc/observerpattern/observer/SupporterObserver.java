package nl.novi.dpcc.observerpattern.observer;

import nl.novi.dpcc.observerpattern.domain.MatchEventType;
import nl.novi.dpcc.observerpattern.domain.Message;

public  class SupporterObserver implements Observer {

    private final String favouriteClub;

    public SupporterObserver(String favouriteClub) {
        this.favouriteClub = favouriteClub;
    }

    public void update(Message message) {
        String clubname = message.getClubName();
        MatchEventType eventType = message.getMatchEventType();

        StringBuilder sb = new StringBuilder("The ").append(favouriteClub).append("-crowd ");
        StringBuilder sb2 = new StringBuilder("The ").append(favouriteClub).append("-hooligans ");

        if(favouriteClub.equalsIgnoreCase(clubname)) {
            sb.append(crowdReactionOwnTeam(eventType));
            sb2.append(hooliganReactionOwnTeam(eventType));
        } else {
            sb.append(crowdReactionOpponent(eventType));
            sb2.append(hooliganReactionOpponent(eventType));
        }
        System.out.println(sb.toString());
        System.out.println(sb2.toString());
    }

    private String crowdReactionOwnTeam(MatchEventType eventType) {
        switch(eventType) {
            case GOAL:
                return "cheers.";
            case PENALTY:
                return "cheers the striker for the penalty.";
            case YELLOW_CARD:
                return "boos the referee.";
            case SCHWALBE:
                return "cheers for the schwalbe";
            case RED_CARD:
                return "whistles at the referee";
            case CORNER:
                return "shouts 'LOOSERS' at the other team";
        }
        return "leaves the stadium.";
    }

    private String crowdReactionOpponent(MatchEventType eventType) {
        switch(eventType) {
            case GOAL:
                return "shows dismay.";
            case PENALTY:
                return "yells the goalkeeper's name for the penalty.";
            case YELLOW_CARD:
                return "laughs at the yellow player.";
            case SCHWALBE:
                return "yells SCHWALBE!";
            case RED_CARD:
                return "cheers in celebration of the red card.";
            case CORNER:
                return "shakes their heads in disbelief";
        }
        return "leaves the stadium.";
    }

    private String hooliganReactionOwnTeam(MatchEventType eventType) {
        switch(eventType) {
            case GOAL:
                return "sets off a big wave through the stadium.";
            case PENALTY:
                return "laughs at the other team.";
            case YELLOW_CARD:
                return "shout threats at the referee.";
            case SCHWALBE:
                return "yells for a RED CARD for the other team";
            case RED_CARD:
                return "shout death-threats at the referee";
            case CORNER:
                return "all stand up and shake their hips back and forth";
        }
        return "are trashing the stadium.";
    }

    private String hooliganReactionOpponent(MatchEventType eventType) {
        switch(eventType) {
            case GOAL:
                return "are all crying.";
            case PENALTY:
                return "tries to distract the shooter.";
            case YELLOW_CARD:
                return "shouts 'BYE BYE BIRDIE'.";
            case SCHWALBE:
                return "are throwing beer-cans through the air.";
            case RED_CARD:
                return "stands up, clapping their hands while singing 'we will, we will rock you'. ";
            case CORNER:
                return "are totally quiet.";
        }
        return "are trashing the stadium.";
    }

}
