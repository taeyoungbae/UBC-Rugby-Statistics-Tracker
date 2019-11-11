package statisticsPackage;

import exceptions.WrongInputException;
import model.IntroTeam;

import java.util.Scanner;

public class SetPiece {
    Scanner scanner = new Scanner(System.in);
    IntroTeam introTeam;

    public SetPiece(IntroTeam introTeam) {
        this.introTeam = introTeam;
    }

    public void setPiece(){
        scrumAttack();
        scrumDefense();
        lineoutAttack();
        lineoutDefense();
    }

    private int scrumAttack(){
        System.out.println("Please input scrums won on offense: ");
        int sw = scanner.nextInt();
        System.out.println(sw);
        System.out.println("Now, input total scrums on offense: ");
        int st = scanner.nextInt();
        System.out.println(st);
        System.out.println("How many offensive scrums were graded as dominant? ");
        int sd = scanner.nextInt();
        System.out.println(sd);
        int scrumAttackResult = sw*100/st;
        System.out.println("Scrum Attack Win Percentage: " + scrumAttackResult + "%" );
        try {
//            introTeam.getStats().addStat("Scrum Attack percentage: " + scrumAttackResult + "% - Dominant: " +
//                    sd + " - Sloppy: " + ss + ".");
            introTeam.getStats().addStat("Scrum Attack success rate : "+ scrumAttackResult);
            introTeam.getStats().addStat("Scrum Attack won : "+sw + " Total scrums " +st);
            introTeam.getStats().addStat("Scrum Attack dominant : " +sd);
            introTeam.addToNumberStats(sw);
            introTeam.addToNumberStats(st);
            introTeam.addToNumberStats(sd);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return scrumAttackResult;
    }
    private int scrumDefense(){
        System.out.println("Please input scrums won on defense: ");
        int sw = scanner.nextInt();
        System.out.println(sw);
        System.out.println("Now, input total scrums on defense: ");
        int st = scanner.nextInt();
        System.out.println(st);
        System.out.println("How many defensive scrums were graded as dominant? ");
        int sd = scanner.nextInt();
        System.out.println(sd);

        int scrumDefenseResult = sw*100/st;
        System.out.println("Scrum Defense Win Percentage: " + scrumDefenseResult + "%" );
        try {
//            introTeam.getStats().addStat("Scrum Defense percentage: " + scrumDefenseResult + "% - Dominant: " +
//                    sd + " - Sloppy: " + ss + ".");
            introTeam.getStats().addStat("Scrum Defense success rate : "+scrumDefenseResult);
            introTeam.getStats().addStat("Scrum Attack won : "+sw + " Total scrums " +st);
            introTeam.getStats().addStat("Scrum Defense sloppy : " +sd);
            introTeam.addToNumberStats(sw);
            introTeam.addToNumberStats(st);
            introTeam.addToNumberStats(sd);

        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return scrumDefenseResult;
    }
    private int lineoutAttack(){
        System.out.println("Please input lineouts won on offense: ");
        int low = scanner.nextInt();
        System.out.println(low);
        System.out.println("Now, input total lineouts on offense: ");
        int lot = scanner.nextInt();
        System.out.println(lot);
        System.out.println("How many were clean wins? ");
        int cw = scanner.nextInt();
        System.out.println(cw);
        System.out.println("How many were quick throws? ");
        int qt = scanner.nextInt();
        System.out.println(qt);
        System.out.println("How many were graded as sloppy? ");
        int sw = scanner.nextInt();
        System.out.println(sw);
        int lineoutAttackResult = low * 100 / lot;
        System.out.println("Lineout Attack Win Percentage: " + lineoutAttackResult + "%" );
        try {
//            introTeam.getStats().addStat("Lineout Attack win percentage: " + lineoutAttackResult + "% - Clean wins:  " +
//                    cw + " - Quick throws: " + qt + " - Sloppy wins: " + sw + ".");
            introTeam.getStats().addStat("Lineout Attack win percentage : "+lineoutAttackResult);
            introTeam.getStats().addStat("Lineout Attack clean wins : "+cw);
            introTeam.getStats().addStat("Lineout Attack quick throws : "+qt);
            introTeam.getStats().addStat("Lineout Attack sloppy wins : "+sw);
            introTeam.addToNumberStats(low);
            introTeam.addToNumberStats(lot);
            introTeam.addToNumberStats(cw);
            introTeam.addToNumberStats(qt);
            introTeam.addToNumberStats(sw);

        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return lineoutAttackResult;
    }
    private int lineoutDefense(){
        System.out.println("Please input lineouts won on defense: ");
        int low = scanner.nextInt();
        System.out.println(low);
        System.out.println("Now, input total lineouts on defense: ");
        int lot = scanner.nextInt();
        System.out.println(lot);
        System.out.println("How many did we spoil? ");
        int spoil = scanner.nextInt();
        System.out.println(spoil);
        int lineoutDefenseResult = low * 100 / lot;
        System.out.println("Lineout Defense Win Percentage: " + lineoutDefenseResult + "%" );
        try {

            introTeam.getStats().addStat("Lineout Defense win percentage : "+lineoutDefenseResult);
            introTeam.getStats().addStat("Lineout Defense spoiled ball(s) : "+spoil);
            introTeam.addToNumberStats(low);
            introTeam.addToNumberStats(lot);
            introTeam.addToNumberStats(spoil);
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        }
        return lineoutDefenseResult;
    }
}
