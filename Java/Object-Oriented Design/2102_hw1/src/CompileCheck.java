public class CompileCheck {
  public static void main(String[] args) {
    
    /* 
     These are all nonsense calls just designed to check that
     the correct class and interface names are defined and
     that methods have the expected input and output types.
     These are not checking for correct answers beyond types.
     */
    
    // dummy variables for the outputs
    boolean boolResult;
    IContestant contResult;
    double dbResult;
    
    // Create samples of each contestant, result, and match
    SoccerTeam soccerTeamCheck = new SoccerTeam("WPI", "maroon", false, 4, 6);
    LegoRobotTeam robotsTeamCheck = new LegoRobotTeam("WPI","goat cheese", 7);
    SoccerResult soccerResultCheck = new SoccerResult(soccerTeamCheck, 
soccerTeamCheck, 10.5,15.2);
    LegoRobotResult robotsResultCheck = new LegoRobotResult(robotsTeamCheck, 
robotsTeamCheck, 3.1, 5, true, 3.2, 2, false);
    Match soccerMatchCheck = new Match(soccerTeamCheck, soccerTeamCheck, 
soccerResultCheck);
    Match robotsMatchCheck = new Match(robotsTeamCheck, robotsTeamCheck, 
robotsResultCheck); 
    
    // Try calling all methods
    
    // isValid
    boolResult = soccerResultCheck.isValid();
    boolResult = robotsResultCheck.isValid();
    
    // getScore
    dbResult = robotsResultCheck.getScore(3.2, 1, false);
    
    // getWinner
    contResult = soccerResultCheck.getWinner();
    contResult = robotsResultCheck.getWinner();
    
    // winner
    contResult = soccerMatchCheck.winner();
    contResult = robotsMatchCheck.winner();
    
    // expectToBeat
    boolResult = soccerTeamCheck.expectToBeat(soccerTeamCheck);
    boolResult = robotsTeamCheck.expectToBeat(robotsTeamCheck);
    
    System.out.println("Congrats! Your program compiled and ran!");
    
  }
}