import java.util.LinkedList;

/**
 * represent an Initial round
 * @author Gabe_Demanche Chris_Chow
 */
public class InitialRound extends AbsRound {

    public InitialRound(LinkedList<Match> matches){
        super(matches);
    }

    /**
     * Looks to see if a team was a winner of this round
     * @param myTeam the desired team
     * @return true if team won
     */
    public boolean isWinner(IContestant myTeam){
      for(IContestant thisTeam :this.getMatchWinners()){
          if(thisTeam.equals(myTeam)){
              return true;
          }
      }
      return false;
    }


}
