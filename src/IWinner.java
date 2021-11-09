import java.util.LinkedList;

public interface IWinner  {
    public boolean isWinner(IContestant winningTeam);
    public LinkedList<IContestant> getMatchWinners();
    public int getNumWinners();
}
