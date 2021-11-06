class SoccerResult implements IResults{
    SoccerTeam team1;
    SoccerTeam team2;
    double team1Points;
    double team2Points;

    public SoccerResult(SoccerTeam team1, SoccerTeam team2, double team1Points, double team2Points) {
        this.team1 = team1;
        this.team2 = team2;
        this.team1Points = team1Points;
        this.team2Points = team2Points;
    }

    public boolean isValid(){
        return team1Points < 150 && team2Points < 150;
    }

    public SoccerTeam getWinner(){
        if(team1Points > team2Points)
            return team1;
        else
            return team2;
    }
}