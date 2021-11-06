import java.util.LinkedList;

/**
 * represent an advanced round
 * @author Gabe_Demanche Chris_Chow
 */
public class AdvancedRound extends AbsRound{

    LinkedList<IContestant> prevRoundWinners = new LinkedList<IContestant>();
    public AdvancedRound(LinkedList<Match> matches, LinkedList<IContestant> prevRoundWinners){
        super(matches);
        this.prevRoundWinners = prevRoundWinners;
    }

    /**
     * Looks to see if a team won in the previous round
     * @param myTeam the desired team
     * @return true if team won in previous round
     */
    public boolean isWinner(IContestant myTeam){
        for(IContestant thisTeam : this.prevRoundWinners) {
            if (thisTeam.equals(myTeam)) {
                return true;
            }
        }
        return false;
    }
}
