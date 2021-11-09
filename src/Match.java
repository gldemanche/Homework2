public class Match {
    IContestant team1;
    IContestant team2;
    IResult game;
    public Match(IContestant team1, IContestant team2, IResult game){
      this.team1 = team1;
      this.team2 = team2;
      this.game = game;

    }
    public IContestant winner(){
        if(this.game.isValid())
                return this.game.getWinner();
        else
            return null;
    }

}
