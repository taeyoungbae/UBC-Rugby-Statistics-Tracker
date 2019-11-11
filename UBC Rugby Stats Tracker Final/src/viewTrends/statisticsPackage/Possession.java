package viewTrends.statisticsPackage;

import exceptions.WrongInputException;
import model.IntroTeam;

import java.util.Scanner;

public class Possession {
    Scanner scanner = new Scanner(System.in);
    IntroTeam introTeam;
    public Possession(IntroTeam introTeam) {
        this.introTeam = introTeam;
    }

    public void possession(){
        turnoverInContact();
        handlingErrors();
        kickAwayPossession();
        kicksRetained();
        penaltiesWon();
        triesScored();
        ballRetention();
        ballPossession();
        passesCompleted();
        gainlineSuccessRate();
    }

    private int turnoverInContact(){
        System.out.println("Input turnovers in contact: ");
        int toic = scanner.nextInt();
        System.out.println("Turnovers in contact: " +toic);
        try {
            introTeam.getStats().addStat("Turnovers in contact :" + toic);
            introTeam.addToNumberStats(toic);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return toic;
    }

    private int handlingErrors() {
        System.out.println("Input Handling Errors: ");
        int he = scanner.nextInt();
        System.out.println("Handling Errors: " +he);
        try {
            introTeam.getStats().addStat("Handling errors : " +he);
            introTeam.addToNumberStats(he);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return he;
    }
    private int kickAwayPossession(){
        System.out.println("Input possessions kicked away: ");
        int kap = scanner.nextInt();
        System.out.println("KAP: " +kap);
        try {
            introTeam.getStats().addStat("Possessions kicked away : " + kap);
            introTeam.addToNumberStats(kap);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return kap;
    }
    private int kicksRetained(){
        System.out.println("Input kicks retained: ");
        int kr = scanner.nextInt();
        System.out.println("KR: " +kr);
        try {
            introTeam.getStats().addStat("Kicks retained : " +kr);
            introTeam.addToNumberStats(kr);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return kr;
    }
    private int penaltiesWon(){
        System.out.println("Input penalties won: ");
        int pw = scanner.nextInt();
        System.out.println("PW: " +pw);
        try {
            introTeam.getStats().addStat("Penalties won : " +pw);
            introTeam.addToNumberStats(pw);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return pw;
    }
    private int triesScored(){
        System.out.println("Input tries scored: ");
        int ts = scanner.nextInt();
        System.out.println("Tries Scored: " +ts);
        try {
            introTeam.getStats().addStat("Tries scored : " +ts);
            introTeam.addToNumberStats(ts);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return ts;
    }
    private int ballRetention(){
        System.out.println("Input ball retention rate: ");
        int br = scanner.nextInt();
        System.out.println("Ball Retention rate: " +br+ "%");
        try {
            introTeam.getStats().addStat("Ball Retention rate : " +br);
            introTeam.addToNumberStats(br);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return br;
    }
    private int ballPossession(){
        System.out.println("Input ball possession rate: ");
        int bp = scanner.nextInt();
        System.out.println("Ball possession rate: " +bp+ "%");
        try {
            introTeam.getStats().addStat("Ball Possession rate : " +bp);
            introTeam.addToNumberStats(bp);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return bp;
    }
    private int passesCompleted(){
        System.out.println("Input number of passes complete: ");
        int pc = scanner.nextInt();
        System.out.println("Number of passes complete: " +pc+ "%");
        try {
            introTeam.getStats().addStat("Passes complete : " +pc);
            introTeam.addToNumberStats(pc);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return pc;
    }
    private int gainlineSuccessRate(){
        System.out.println("Input gainline success rate: ");
        int glsr = scanner.nextInt();
        System.out.println("Gainline success rate: " +glsr+ "%");
        try {
            introTeam.getStats().addStat("Gainline success rate : " +glsr);
            introTeam.addToNumberStats(glsr);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return glsr;
    }
}
