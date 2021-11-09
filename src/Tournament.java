import java.util.LinkedList;
/**
 * represent an tournament
 * @author Gabe_Demanche Chris_Chow
 */
public class Tournament {

    LinkedList<IWinner> rounds;
    LinkedList<IContestant> tournamentWinners = new LinkedList<>();
    LinkedList<IWinner> wonRounds;

    public Tournament(LinkedList<IWinner> rounds){
        this.rounds = rounds;
    }

    /**
     * Sees if a team won over half the rounds in a tournament
     * @param winningTeam the team to check
     * @return true if team is a valid winner and they won over half the rounds
     */
    public boolean finalWinnerIsValid(IContestant winningTeam){
        for(IWinner winRound : this.rounds){
            if(winRound.isWinner(winningTeam)){
                for(IContestant myTeam : winRound.getMatchWinners()){
                    if(winningTeam.equals(myTeam)){
                        tournamentWinners.add(myTeam);
                    }
                }
            }
            if(tournamentWinners.size() > winRound.getNumWinners()){
                wonRounds.add(winRound);
            }
        }
        return wonRounds.size() > this.rounds.size()*.5;
    }
}
