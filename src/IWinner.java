import java.util.LinkedList;
/**
 * represent an IWinner
 * @author Gabe_Demanche Chris_Chow
 */
public interface IWinner  {
    public boolean isWinner(IContestant winningTeam);
    public LinkedList<IContestant> getMatchWinners();
    public int getNumWinners();
}
