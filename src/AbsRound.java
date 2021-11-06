import java.util.LinkedList;

public abstract class AbsRound {

    LinkedList<Match> matches;
    IResults game;

    public AbsRound(LinkedList<Match> matches){
        this.matches = matches;
    }
    public LinkedList<Match> getMatchWinner(){
       return matches.add(this.game.winner());
    }

    public int getNumWinners(){
        return getMatchWinner().size();
    }
}
