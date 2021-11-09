import java.util.LinkedList;

/**
 * represent an abstract round
 * @author Gabe_Demanche Chris_Chow
 */
public abstract class AbsRound implements IContestant {

    LinkedList<Match> matches;
    LinkedList<IContestant> roundWinners = new LinkedList<>();

    public AbsRound(LinkedList<Match> matches){
        this.matches = matches;
    }

    /**
     * looks through all matches in the round and returns list of winners
     * @return linkedList of all round winners
     */
    public LinkedList<IContestant> getMatchWinners(){
        for(Match thisMatch : this.matches)
            roundWinners.add(thisMatch.winner());
        return roundWinners;
    }

    /**
     * Finds the number of winners in a round
     * @return int number of winners in the round
     */
    public int getNumWinners(){
        return getMatchWinners().size();
    }
}
