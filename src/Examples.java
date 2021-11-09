import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;

public class Examples {

    public Examples() {

    }


    //lego teams
    LegoRobotTeam wpi = new LegoRobotTeam("WPI", "glizzy", 1);
    LegoRobotTeam rpi = new LegoRobotTeam("RPI", "strap", 5);
    LegoRobotTeam mit = new LegoRobotTeam("mit", "hammer", 5);

    //soccer teams
    SoccerTeam wpiGirls = new SoccerTeam("USA", "red", true, 4, 2);
    SoccerTeam wpiBoys = new SoccerTeam("USA", "white", false, 5, 0);
    SoccerTeam ubcGirls = new SoccerTeam("Canada", "blue", true, 4, 4);
    SoccerTeam ubcBoys = new SoccerTeam("Canada", "green", false, 4, 4);

    //lego results
    LegoRobotResult game1 = new LegoRobotResult(wpi, rpi, 3, 3, true, 5, 5, false);
    LegoRobotResult game2 = new LegoRobotResult(wpi, mit, 100, 100, false, 40, 30, false);
    LegoRobotResult game3 = new LegoRobotResult(wpi, rpi, 5, 5, false, 3, 3, false);
    LegoRobotResult bothValid = new LegoRobotResult(wpi, mit, 10, 5, false, 12, 6, false);
    LegoRobotResult bothNotValid = new LegoRobotResult(wpi, mit, 100, 50, false, 120, 60, false);
    LegoRobotResult pointsNotValid = new LegoRobotResult(wpi, mit, 100, 5, false, 120, 6, false);
    LegoRobotResult tasksNotValid = new LegoRobotResult(wpi, mit, 10, 50, false, 12, 60, false);
    LegoRobotResult tasksEdgeCase = new LegoRobotResult(wpi, mit, 16, 8, false, 16, 8, false);
    LegoRobotResult team1NotValid = new LegoRobotResult(wpi, mit, 10, 50, false, 12, 6, false);
    LegoRobotResult team2NotValid = new LegoRobotResult(wpi, mit, 10, 5, false, 12, 60, false);

    //soccer results
    SoccerResult validGame = new SoccerResult(wpiGirls, wpiBoys, 3.0, 40.0);
    SoccerResult validGame2 = new SoccerResult(wpiGirls, wpiBoys, 30.0, 4.0);
    SoccerResult validGame3 = new SoccerResult(ubcGirls, ubcBoys, 3.0, 40.0);
    SoccerResult validGame4 = new SoccerResult(ubcGirls, ubcBoys, 30.0, 4.0);
    SoccerResult t1ValidGame = new SoccerResult(wpiBoys, wpiBoys, 10, 151);
    SoccerResult t2ValidGame = new SoccerResult(wpiBoys, ubcBoys, 151, 3);
    SoccerResult notValidGame = new SoccerResult(wpiBoys, ubcBoys, 151, 151);
    SoccerResult oneEdgeValidGame = new SoccerResult(wpiBoys, ubcBoys, 10, 150);
    SoccerResult secondEdgeValidGame = new SoccerResult(wpiBoys, ubcBoys, 150, 10);
    SoccerResult bothEdgeValidGame = new SoccerResult(wpiBoys, ubcBoys, 150, 150);

    //matches
    Match soccermatch1 = new Match(validGame.team1, validGame.team2, validGame);        //wpiBoys
    Match soccermatch2 = new Match(validGame2.team1, validGame2.team2, validGame2);     //wpiGirls
    Match soccermatch3 = new Match(validGame3.team1, validGame2.team2, validGame3);     //ubcBoys
    Match soccermatch4 = new Match(validGame4.team1, validGame4.team2, validGame4);     //ubcGirls
    Match soccermatch5 = new Match(notValidGame.team1, notValidGame.team2, notValidGame);
    Match soccermatch6 = new Match(validGame2.team1, validGame2.team2, validGame2);     //wpiGirls
    Match legomatch1 = new Match(game1.team1, game1.team2, game1);
    Match legomatch2 = new Match(game3.team1, game3.team2, game3);

    //initial rounds
    //empty round
    InitialRound iRoundempty = new InitialRound(new LinkedList<>());
    LinkedList<IContestant> emptyContestant = new LinkedList<IContestant>();
    //null round
    LinkedList<Match> nullSoccerMatches = new LinkedList<>();
    InitialRound iRoundnull = new InitialRound(nullSoccerMatches);
    LinkedList<IContestant> nullContestant = new LinkedList<>();
    //one winner round
    LinkedList<Match> wpiSoccerMatches = new LinkedList<>();
    InitialRound iRoundOneWinner = new InitialRound(wpiSoccerMatches);
    LinkedList<IContestant> contestantsOneWinner = new LinkedList<>();
    //two winner round
    LinkedList<Match> ubcSoccerMatches = new LinkedList<>();
    InitialRound iRoundTwoWinner = new InitialRound(ubcSoccerMatches);
    LinkedList<IContestant> contestantsTwoWinner = new LinkedList<>();
    //same winner round
    LinkedList<Match> wpiGirlsSoccerMatches = new LinkedList<>();
    InitialRound iRoundSameWinner = new InitialRound(wpiGirlsSoccerMatches);
    LinkedList<IContestant> contestantsSameWinner = new LinkedList<>();

    //advanced rounds
    //empty round
    AdvancedRound aRoundempty = new AdvancedRound(new LinkedList<Match>(), emptyContestant);
    //null round
    AdvancedRound aRoundnull = new AdvancedRound(nullSoccerMatches, nullContestant);
    //one winner round
    AdvancedRound aRoundOneWinner = new AdvancedRound(wpiSoccerMatches, contestantsOneWinner);
    //multiple winner round
    AdvancedRound aRoundTwoWinner = new AdvancedRound(ubcSoccerMatches, contestantsTwoWinner);
    //same winner round
    AdvancedRound aRoundSameWinner = new AdvancedRound(wpiGirlsSoccerMatches, contestantsSameWinner);


    @Before
    public void setup(){
        //null match
        nullSoccerMatches.add(soccermatch5);
        nullContestant.add(null);
        //one winner
        wpiSoccerMatches.add(soccermatch1);
        contestantsOneWinner.add(wpiBoys);
        //two winners
        ubcSoccerMatches.add(soccermatch3);
        ubcSoccerMatches.add(soccermatch4);
        contestantsTwoWinner.add(ubcBoys);
        contestantsTwoWinner.add(ubcGirls);
        //same winner
        wpiGirlsSoccerMatches.add(soccermatch2);
        wpiGirlsSoccerMatches.add(soccermatch6);
        contestantsSameWinner.add(wpiGirls);
        contestantsSameWinner.add(wpiGirls);

    }
    // Test initial round getMatchWinner
    // empty list
    // null round
    // 1 winner
    // multiple winners
    // same winners

    @Test
    public void getInitialMatchWinner_emptyList () {
        assertEquals(iRoundempty.getMatchWinners(), emptyContestant);
    }
    @Test
    public void getInitialMatchWinner_null() {
        assertEquals(iRoundnull.getMatchWinners(), nullContestant);
    }
    @Test
    public void getInitialMatchWinner_onewinner () {
        assertEquals(iRoundOneWinner.getMatchWinners(), contestantsOneWinner);
    }
    @Test
    public void getInitialMatchWinner_twowinner () {
        assertEquals(iRoundTwoWinner.getMatchWinners(), contestantsTwoWinner);
    }
    @Test
    public void getInitialMatchWinner_samewinner () {
        assertEquals(iRoundSameWinner.getMatchWinners(), contestantsSameWinner);
    }

    // Test advanced round getMatchWinner
    // empty list
    // null round
    // 1 winner
    // multiple winners
    // same winners

    @Test
    public void getAdvMatchWinner_emptyList () {
        assertEquals(aRoundempty.getMatchWinners(), emptyContestant);
    }
    @Test
    public void getAdvMatchWinner_null() {
        assertEquals(aRoundnull.getMatchWinners(), nullContestant);
    }
    @Test
    public void getAdvMatchWinner_onewinner () {
        assertEquals(aRoundOneWinner.getMatchWinners(), contestantsOneWinner);
    }
    @Test
    public void getAdvMatchWinner_twowinner () {
        assertEquals(aRoundTwoWinner.getMatchWinners(), contestantsTwoWinner);
    }
    @Test
    public void getAdvMatchWinner_samewinner () {
        assertEquals(aRoundSameWinner.getMatchWinners(), contestantsSameWinner);
    }

    // test initial getNumWinners
    // empty
    // null
    // one winner
    // multiple winners
    // same winners

    @Test
    public void getInitialNumWinners_empty(){
        assertEquals(iRoundempty.getNumWinners(), 0);
    }
    @Test
    public void getInitialNumWinners_null(){
        assertEquals(iRoundnull.getNumWinners(), 1);
    }
    @Test
    public void getInitialNumWinners_oneWinner(){
        assertEquals(iRoundOneWinner.getNumWinners(), 1);
    }
    @Test
    public void getInitialNumWinners_twoWinner(){
        assertEquals(iRoundTwoWinner.getNumWinners(), 2);
    }
    @Test
    public void getInitialNumWinners_sameWinner(){
        assertEquals(iRoundSameWinner.getNumWinners(), 2);
    }

    // test advanced getNumWinners
    // empty
    // null
    // one winner
    // multiple winners

    @Test
    public void getAdvNumWinners_empty(){
        assertEquals(aRoundempty.getNumWinners(), 0);
    }
    @Test
    public void getAdvNumWinners_null(){
        assertEquals(aRoundnull.getNumWinners(), 1);
    }
    @Test
    public void getAdvNumWinners_oneWinner(){
        assertEquals(aRoundOneWinner.getNumWinners(), 1);
    }
    @Test
    public void getAdvNumWinners_twoWinner(){
        assertEquals(aRoundTwoWinner.getNumWinners(), 2);
    }
    @Test
    public void getAdvNumWinners_sameWinner(){
        assertEquals(aRoundSameWinner.getNumWinners(), 2);
    }

    // Tests initial round isWinner
    // myTeam is not valid
    // empty list
    // not winner
    // is winner

    @Test
    public void isWinnerInitial_notValidmyTeam(){
        assertFalse(iRoundTwoWinner.isWinner(null));
    }
    @Test
    public void isWinnerInitial_emptyList(){
        assertFalse(iRoundempty.isWinner(wpiBoys));
    }
    @Test
    public void isWinnerInitial_notWinner(){
        assertFalse(iRoundTwoWinner.isWinner(wpiBoys));
    }
    @Test
    public void isWinnerInitial_isWinner(){
        assertTrue(iRoundTwoWinner.isWinner(ubcBoys));
    }

    // Tests advanced round isWinner
    // myTeam is not valid
    // empty list
    // not winner
    // is winner

    @Test
    public void isWinnerAdv_notValidmyTeam(){
        assertFalse(aRoundTwoWinner.isWinner(null));
    }
    @Test
    public void isWinnerAdv_emptyList(){
        assertFalse(aRoundempty.isWinner(wpiBoys));
    }
    @Test
    public void isWinnerAdv_notWinner(){
        assertFalse(aRoundTwoWinner.isWinner(wpiBoys));
    }
    @Test
    public void isWinnerAdv_isWinner(){
        assertTrue(aRoundTwoWinner.isWinner(ubcBoys));
    }

}
