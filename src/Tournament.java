import java.util.LinkedList;
/**
 * represent an tournament
 * @author Gabe_Demanche Chris_Chow
 */
public class Tournament {

    LinkedList<IWinner> rounds;

    public Tournament(LinkedList<IWinner> rounds){
        this.rounds = rounds;
    }

    /**
     * Sees if a team won over half the rounds in a tournament
     * @param winningTeam the team to check
     * @return true if they won over half the rounds
     */
    public boolean finalWinnerIsValid(IContestant winningTeam){
        int count = 0;
        for(IWinner winRound : this.rounds){
            if(winRound.isWinner(winningTeam)){
                count++;
            }
        }
        return count > this.rounds.size()*.5;
    }
}
