package viewTrends.statisticsPackage;


import exceptions.WrongInputException;
import model.IntroTeam;

import java.util.Scanner;

public class AgainstWhom {
    Scanner scanner = new Scanner(System.in);
    IntroTeam introTeam;
//ListOfStats
    public AgainstWhom(IntroTeam introTeam) {
        this.introTeam = introTeam;
    }

    public String againstWhom() {
       System.out.println("Which team was the game against? ");
        String against = scanner.nextLine();
        System.out.println(against);
        try {
            introTeam.getStats().addStat(against);
            introTeam.getTeamList().add(against);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } finally {
            if (against.equals("hello")) {
                againstWhom();
            }
        }
        return against;
    }
}
