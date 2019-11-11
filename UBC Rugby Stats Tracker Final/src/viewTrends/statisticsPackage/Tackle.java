package viewTrends.statisticsPackage;

import exceptions.WrongInputException;
import model.IntroTeam;

import java.util.Scanner;

public class Tackle {
    Scanner scanner = new Scanner(System.in);
    IntroTeam introTeam;
    public Tackle (IntroTeam introTeam){
        this.introTeam = introTeam;
    }

    public int tackle() {
        System.out.println("Please input tackles made: ");
        int tmade = scanner.nextInt();
        System.out.println(tmade);
        System.out.println("Now, input tackles missed: ");
        int tmissed = scanner.nextInt();
        System.out.println(tmissed);
        int tackleresult = (tmade * 100 / (tmade + tmissed));
        System.out.println("Tackle percentage: " + tackleresult + "%");
        System.out.println("Input number of dominant tackles: ");
        int dt = scanner.nextInt();
        System.out.println("Number of dominant tackles: " +dt);
        System.out.println("Input number of choke tackles:");
        int ct = scanner.nextInt();
        System.out.println("Number of choke tackles: " +ct);
        System.out.println("Input number of strip tackles:");
        int st = scanner.nextInt();
        System.out.println("Number of strip tackles: " +st);
        System.out.println("Input number of turnovers in tackle:");
        int tt = scanner.nextInt();
        System.out.println("Number of turnovers in tackle: " +tt);
        try {

            introTeam.getStats().addStat("Number of tackles made : "+tmade);
            introTeam.getStats().addStat("Number of tackles missed : "+tmissed);
            introTeam.getStats().addStat("Tackle success rate : "+tackleresult);
            introTeam.getStats().addStat("Number of dominant tackles : "+dt);
            introTeam.getStats().addStat("Number of choke tackles : "+ct);
            introTeam.getStats().addStat("Number of strip tackles : "+st);
            introTeam.getStats().addStat("Number of turnovers in tackle : "+tt);
            introTeam.addToNumberStats(tmade);
            introTeam.addToNumberStats(tmissed);
            introTeam.addToNumberStats(tackleresult);
            introTeam.addToNumberStats(dt);
            introTeam.addToNumberStats(ct);
            introTeam.addToNumberStats(st);
            introTeam.addToNumberStats(tt);


        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return tackleresult;
    }
}
