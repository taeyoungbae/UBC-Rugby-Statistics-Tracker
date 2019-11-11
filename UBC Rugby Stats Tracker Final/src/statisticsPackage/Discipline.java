package statisticsPackage;

import exceptions.WrongInputException;
import model.IntroTeam;


import java.util.Scanner;

public class Discipline {
    Scanner scanner = new Scanner(System.in);
    IntroTeam introTeam;
    public Discipline(IntroTeam introTeam) {
        this.introTeam = introTeam;
    }


    public void discipline(){
        penaltiesAgainst();
        yellowCard();
        redCard();
    }
    private int penaltiesAgainst(){
        System.out.println("Input penalties against: ");
        int pa = scanner.nextInt();
        System.out.println("Penalties against: " +pa);
        try {
           introTeam.getStats().addStat("Penalties : " +pa);
           introTeam.addToNumberStats(pa);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return pa;
    }
    private int yellowCard(){
        System.out.println("Input number of yellow cards: ");
        int yc = scanner.nextInt();
        System.out.println("Yellow card(s): " +yc);
        try {
            introTeam.getStats().addStat("Yellow cards(s) : " +yc);
            introTeam.addToNumberStats(yc);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return yc;
    }
    private int redCard(){
        System.out.println("Input number of red cards: ");
        int rc = scanner.nextInt();
        System.out.println("Red card(s): " +rc);
        try {
            introTeam.getStats().addStat( "Red card(s) : " +rc);
            introTeam.addToNumberStats(rc);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return rc;
    }

}
