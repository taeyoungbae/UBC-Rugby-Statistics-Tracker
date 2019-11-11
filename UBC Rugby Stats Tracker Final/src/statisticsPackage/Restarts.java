package statisticsPackage;

import exceptions.WrongInputException;
import model.IntroTeam;

import java.util.Scanner;

public class Restarts {

    Scanner scanner = new Scanner(System.in);
    IntroTeam introTeam;
    public Restarts(IntroTeam introTeam) {
        this.introTeam = introTeam;
    }


    public void restarts(){
        restartAttack();
        restartDefense();
    }
    private int restartAttack(){
        System.out.println("Input kickoffs 'won': ");
        int kw = scanner.nextInt();
        System.out.println(kw);
        System.out.println("Now, input total number of kickoffs on attack");
        int kt = scanner.nextInt();
        System.out.println(kt);
        System.out.println(kw+ " of " +kt+ "kick-offs attack");
        int kr;
        if (kw==0) {
            kr=0;
        }
        else kr = (kw*100/kt);
        try {
            introTeam.getStats().addStat("Kick-offs attack won :" +kw);
            introTeam.getStats().addStat("Kick-offs attack attempted :"+kt);
            introTeam.getStats().addStat("Kick-offs attack success rate :"+kr);
            introTeam.addToNumberStats(kw);
            introTeam.addToNumberStats(kt);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return kw;
    }
    private int restartDefense(){
        System.out.println("Input kickoffs 'won': ");
        int kw = scanner.nextInt();
        System.out.println(kw);
        System.out.println("Now, input total number of kickoffs on defense");
        int kt = scanner.nextInt();
        System.out.println(kt);
        System.out.println(kw+ " of " +kt+ " kick-offs");
        int kr;
        if (kw==0) {
            kr=0;
        }
        else kr = (kw*100/kt);
        try {
            introTeam.getStats().addStat("Kick-offs defense won : "+kw);
            introTeam.getStats().addStat("Kick-offs defense attempted : "+kt);
            introTeam.getStats().addStat("Kick-offs defense success rate : "+kr);
            introTeam.addToNumberStats(kw);
            introTeam.addToNumberStats(kt);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return kw;
    }
}
