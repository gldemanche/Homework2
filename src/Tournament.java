import java.util.LinkedList;

public class Tournament {

    LinkedList<IWinner> rounds;

    public Tournament(LinkedList<IWinner> rounds){
        this.rounds = rounds;
    }
}