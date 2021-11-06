import static org.junit.Assert.*;
import org.junit.Test;

public class ExamplesHw1 {
    public ExamplesHw1() {}
    //lego teams
    LegoRobotTeam wpi = new LegoRobotTeam("WPI", "glizzy", 1);
    LegoRobotTeam rpi = new LegoRobotTeam("RPI", "strap", 5);
    LegoRobotTeam mit = new LegoRobotTeam("mit", "hammer", 5);


    //soccer teams
    SoccerTeam wpiGirls = new SoccerTeam("USA", "red", true, 4, 2);
    SoccerTeam wpiBoys = new SoccerTeam("USA", "white",false, 5, 0);
    SoccerTeam ubcGirls = new SoccerTeam("Canada", "blue", true, 4,4);
    SoccerTeam ubcBoys = new SoccerTeam("Canada", "green", false, 4, 4);


    //lego results
    LegoRobotResult game1 = new LegoRobotResult(wpi, rpi, 3, 3, true, 5, 5, false);
    LegoRobotResult game2 = new LegoRobotResult(wpi, mit, 100,100,false, 40, 30, false);
    LegoRobotResult game3 = new LegoRobotResult(wpi, rpi, 5, 5, false, 3, 3, false);
    LegoRobotResult bothValid = new LegoRobotResult(wpi, mit, 10,5,false, 12, 6, false);
    LegoRobotResult bothNotValid = new LegoRobotResult(wpi, mit, 100,50,false, 120, 60, false);
    LegoRobotResult pointsNotValid = new LegoRobotResult(wpi, mit, 100,5,false, 120, 6, false);
    LegoRobotResult tasksNotValid = new LegoRobotResult(wpi, mit, 10,50,false, 12, 60, false);
    LegoRobotResult tasksEdgeCase = new LegoRobotResult(wpi, mit, 16,8,false, 16, 8, false);
    LegoRobotResult team1NotValid = new LegoRobotResult(wpi, mit, 10,50,false, 12, 6, false);
    LegoRobotResult team2NotValid = new LegoRobotResult(wpi, mit, 10,5,false, 12, 60, false);

    //soccer results
    SoccerResult validGame = new SoccerResult(wpiGirls, wpiBoys, 3.0, 40.0);
    SoccerResult validGame2 = new SoccerResult(wpiGirls, wpiBoys, 30.0, 4.0);
    SoccerResult t1ValidGame = new SoccerResult(wpiBoys, wpiBoys, 10, 151);
    SoccerResult t2ValidGame = new SoccerResult(wpiBoys, ubcBoys, 151, 3);
    SoccerResult notValidGame = new SoccerResult(wpiBoys, ubcBoys, 151, 151);
    SoccerResult oneEdgeValidGame = new SoccerResult(wpiBoys, ubcBoys, 10, 150);
    SoccerResult secondEdgeValidGame = new SoccerResult(wpiBoys, ubcBoys, 150, 10);
    SoccerResult bothEdgeValidGame = new SoccerResult(wpiBoys, ubcBoys, 150, 150);

    //CHECKS IS VALID SOCCER
    //checks if both score valid <150
    @Test
    public void isResultValid_bothless() {
        assertTrue(validGame.isValid());
    }
    //checks soccer t1 valid ! t2
    @Test
    public void isResultValid_t1less() {
        assertFalse(t1ValidGame.isValid());
    }
    //checks soccer t1! t2 valid
    @Test
    public void isResultValid_t2less() {
        assertFalse(t2ValidGame.isValid());
    }
    //checks soccer both invalid
    @Test
    public void isResultValid_none(){
        assertFalse(notValidGame.isValid());
    }
    //checks soccer one edge case
    @Test
    public void isResultValid_oneEdge(){
        assertFalse(oneEdgeValidGame.isValid());
    }
    //tests soccer second team edge
    @Test
    public void isResultValid_secondEdge(){
        assertFalse(secondEdgeValidGame.isValid());
    }
    //tests soccer both teams edge
    @Test
    public void isResultValid_bothEdge(){
        assertFalse(bothEdgeValidGame.isValid());
    }

    //checks true robot team less than 8 attempts
    @Test
    public void robotResult_Team1Valid(){
        assertTrue(bothValid.isTeam1Valid());
    }
    //checks false robot game more than 8 attempts
    @Test
    public void robotResult_Team1NotValid(){
        assertFalse(bothNotValid.isTeam1Valid());
    }
    //checks false robot game points not valid
    @Test
    public void robotResult_Team1PointsNotValid(){
        assertFalse(pointsNotValid.isTeam1Valid());
    }
    //checks false robot game tasks not valid
    @Test
    public void robotResult_Team1TasksNotValid(){
        assertFalse(tasksNotValid.isTeam1Valid());
    }
    // edge case test
    @Test
    public void robotResult_Team1EgdeCase(){
        assertFalse(tasksEdgeCase.isTeam1Valid());
    }

    //checks true robot team less than 8 attempts
    @Test
    public void robotResult_Team2Valid(){
        assertTrue(bothValid.isTeam2Valid());
    }
    //checks false robot game both more than allowed
    @Test
    public void robotResult_Team2NotValid(){
        assertFalse(bothNotValid.isTeam2Valid());
    }
    //checks false robot points not valid
    @Test
    public void robotResult_Team2PointsNotValid(){
        assertFalse(pointsNotValid.isTeam2Valid());
    }
    // checks false robot tasks not valid
    @Test
    public void robotResult_Team2TasksNotValid(){
        assertFalse(tasksNotValid.isTeam2Valid());
    }
    // edge case test
    @Test
    public void robotResult_Team2EgdeCase(){
        assertFalse(tasksEdgeCase.isTeam2Valid());
    }


    //test isValid
    //both valid
    @Test
    public void robotResult_isValidBothTrue(){
        assertTrue(bothValid.isValid());
    }
    //both not valid
    @Test
    public void robotResult_isValidBothFalse(){
        assertFalse(bothNotValid.isValid());
    }
    //team 1 valid
    @Test
    public void robotResult_isValidTeam1(){
        assertFalse(team1NotValid.isValid());
    }
    //team 2 valid
    @Test
    public void robotResult_isValidTeam2(){
        assertFalse(team2NotValid.isValid());
    }


    //SOCCER EXPECTED
    //checks expected winner t1 ritual t2 no
    @Test
    public void isExpectToBeat_yesRitual(){
        assertTrue(wpiGirls.expectToBeat(wpiBoys));
    }
    //checks expected winner t1 no ritual t2 yes
    @Test
    public void isExpectToBeat_noRitual() {
        assertFalse(wpiBoys.expectToBeat(wpiGirls));
    }
    //checks expected winner both ritual t1 > t2 dif
    @Test
    public void isExpectToBeat_higherdif() {
        assertTrue(wpiGirls.expectToBeat(ubcGirls));
    }
    //checks expected winner both ritual  t1 < t2 dif
    @Test
    public void isExpectToBeat_lowerdif() {
        assertFalse(ubcGirls.expectToBeat(wpiGirls));
    }
    //checks expected winner no ritual t1 > t2 dif
    @Test
    public void isExpectToBeat_nr_higerdif() {
        assertTrue(wpiBoys.expectToBeat(ubcBoys));
    }
    //checks expected winner no ritual t1 < t2 dif
    @Test
    public void isExpectToBeat_nr_lowerdif() {
        assertFalse(ubcBoys.expectToBeat(wpiBoys));
    }
    //checks when record equal with rituals (false)
    @Test
    public void isExpectToBeat_r_samedif() {
        assertFalse(ubcGirls.expectToBeat(ubcGirls));
    }
    //checks when record equal no ritual (false)
    @Test
    public void isExpectToBeat_nr_samedif() {
        assertFalse(ubcBoys.expectToBeat(ubcBoys));
    }

    //ROBOT EXPECT TO Beat
    //checks when prev score t1 > t2 (true)
    @Test
    public void isExpected_higherprev() {
        assertTrue(mit.expectToBeat(wpi));
    }
    //checks when  prev score t1 < t2 (false)
    @Test
    public void isExpected_lowerprev() {
        assertFalse(wpi.expectToBeat(mit));
    }
    //checks when they are equal
    @Test
    public void isExpected_equal() {
        assertFalse(mit.expectToBeat(rpi));
    }

    //match case MATCHES TESTS
    Match soccermatch1 = new Match(validGame.team1, validGame.team2, validGame);
    Match soccermatch2 = new Match(t2ValidGame.team1, t2ValidGame.team2, t2ValidGame);
    Match soccermatch3 = new Match(t1ValidGame.team1, t1ValidGame.team2, t1ValidGame);
    Match soccermatch4 = new Match(notValidGame.team1, notValidGame.team2, notValidGame);
    Match soccermatch5 = new Match(validGame2.team1, validGame2.team2, validGame2);
    Match legomatch1 = new Match(game1.team1, game1.team2, game1);
    Match legomatch2 = new Match(game2.team1, game2.team2, game2);
    Match legomatch3 = new Match(game3.team1, game3.team2, game3);
    Match legomatch4 = new Match(team1NotValid.team1, team1NotValid.team2, team1NotValid);
    Match legomatch5 = new Match(team2NotValid.team1, team2NotValid.team2, team2NotValid);

    //soccer team getWinner tests
    //team1 wins
    @Test
    public void getWinnert1(){assertEquals(validGame.getWinner(), wpiBoys);}
    //team 2 wins
    @Test
    public void getWinnert2(){assertEquals(validGame2.getWinner(), wpiGirls);}

    //test soccer winner tests
    //match invalid team 1
    @Test
    public void winner_soccert1valid(){
        assertEquals(soccermatch2.winner(), null);
    }
    //match invalid team 2
    @Test
    public void winner_soccert2valid(){
        assertEquals(soccermatch3.winner(), null);
    }
    //match invalid both team
    @Test
    public void winner_soccerbothvalid(){
        assertEquals(soccermatch4.winner(), null);
    }
    //team1 has higher score
    @Test
    public void winner_soccer1(){
        assertEquals(soccermatch5.winner(), wpiGirls);
    }
    //team2 has higher score
    @Test
    public void winner_soccer2(){
        assertEquals(soccermatch1.winner(), wpiBoys);
    }

    //lego getScore tests
    // 0 points 0 tasks fell
    @Test
    public void zeroScoreAndFall() {assertEquals(game1.getScore(0.0,0,true), -5.0, 0.001);}
    // 0 points 0 tasks no fall
    @Test
    public void zeroScoreAndNoFall() {assertEquals(game1.getScore(0.0,0,false), 0.0, 0.001);}
    // 10 p 5 t fall
    @Test
    public void validScoreAndFall() {assertEquals(game1.getScore(10.0,5,true), 10.0, 0.001);}
    // 10p 5t no fall
    @Test
    public void validScoreAndNoFall() {assertEquals(game1.getScore(10.0,5,false), 15.0, 0.001);}

    // lego getWinner tests
    // team 1 wins
    @Test
    public void getWinnerlegot1(){assertEquals(game1.getWinner(), rpi);}
    //team 2 wins
    @Test
    public void getWinnerlegot2(){assertEquals(game3.getWinner(), wpi);}

    //lego Winner tests
    // match both invalid
    @Test
    public void winner_robotNotValidScoreboth(){
        assertEquals(legomatch2.winner(), null);
    }
    //team 1 invalid
    @Test
    public void winner_robotNotValidScoret1(){
        assertEquals(legomatch4.winner(), null);
    }
    //team 2 invalid
    @Test
    public void winner_robotNotValidScoret2(){
        assertEquals(legomatch5.winner(), null);
    }
    // team 1 has higher score
    @Test
    public void winner_robot1(){
        assertEquals(legomatch3.winner(), wpi);
    }
    // team 2 has higher score
    @Test
    public void winner_robot2(){
        assertEquals(legomatch1.winner(), rpi);
    }

}

