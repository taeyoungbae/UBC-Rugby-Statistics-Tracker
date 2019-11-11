package ui;



import java.io.IOException;
import java.util.Scanner;

import exceptions.WrongInputException;
import viewTrends.TrendsFrame;
import model.*;
import statisticsPackage.*;
import viewWeek.WeekFrame;

import javax.swing.*;

public class CheckStat{


    String choice;
    public Scanner scanner;

    IntroBirds introBirds;
    IntroBraves introBraves;

    AgainstWhom againstWhom;
    Possession possession;
    Tackle tackle;
    SetPiece setPiece;
    Restarts restarts;
    Discipline discipline;

    public CheckStat() throws IOException {
        scanner = new Scanner(System.in);

        introBirds = new IntroBirds();
        introBraves = new IntroBraves();

        initializer();
    }

    private void initializer() throws IOException {
        try {
            firstLines();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
            initializer();
        } finally {
            System.out.println("Everything is finished.");
        }
    }

    private void initAllStats(IntroTeam team){
        againstWhom = new AgainstWhom(team);
        possession = new Possession(team);
        tackle = new Tackle(team);
        setPiece = new SetPiece(team);
        restarts = new Restarts(team);
        discipline = new Discipline(team);
    }

    private void firstLines() throws IOException, WrongInputException {
        System.out.println("Enter [1] for Birds or [2] for Braves");
        boolean firstInput = true;
        while (firstInput) {
            choice = scanner.nextLine();
            if (choice.equals(Integer.toString(1))){
                firstInput = false;
                System.out.println("You selected: Birds");
                introBirds.loadable();
                introBirds.loadTeamList();
                introBirds();
            } else if (choice.equals(Integer.toString(2))) {
                firstInput = false;
                System.out.println("You selected: Braves");
                introBraves.loadable();
                introBraves.loadTeamList();
                introBraves();
            }
        }
    }

    public void viewStatsInitBirds() throws IOException, WrongInputException {

        System.out.println("Enter [1] to look at overall trends, [2] to look at weekly stats, [3] to return to previous line");
        choice = scanner.nextLine();
        if (choice.equals(Integer.toString(1))) {
            SwingUtilities.invokeLater((new Runnable() {
                @Override
                public void run() {
                    try {
                        TrendsFrame trendsFrame = new TrendsFrame();
                        trendsFrame.initializeTrendsFrame("Birds");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
            if (choice.equals(Integer.toString(2))){
                weeklyStatInit("Birds");
            }
            if (choice.equals(Integer.toString(3))) {
                introBirds();
            }

    }
    public void viewStatsInitBraves() throws IOException, WrongInputException {

        System.out.println("Enter [1] to look at overall trends, [2] to look at weekly stats, or [3] to return to previous line");
        choice = scanner.nextLine();
        if (choice.equals(Integer.toString(1))) {
            SwingUtilities.invokeLater((new Runnable() {
                @Override
                public void run() {
                    try {
                        TrendsFrame trendsFrame = new TrendsFrame();
                        trendsFrame.initializeTrendsFrame("Braves");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
            if (choice.equals(Integer.toString(2))){
                weeklyStatInit("Braves");
            }
            if (choice.equals(Integer.toString(3))){
            introBraves();
            }

        }

    private void weeklyStatInit(String team) throws IOException, WrongInputException {
        String theWeek;
        if (team.equals("Birds")) {
            theWeek = Integer.toString(introBirds.weekGetter() - 1);
        } else {
            theWeek = Integer.toString(introBraves.weekGetter() - 1);
        }
        System.out.println("Which weeks stat would you like to view? Choose a week (integer) between Week [1] and [" + theWeek + "]. Type in 'return' to return to previous line");
        choice = scanner.nextLine();
        if (choice.equals("return") || choice.equals("return ")) {
            if (team.equals("Birds")){
                viewStatsInitBirds();
            }
            if (team.equals("Braves")){
                viewStatsInitBraves();
            }

        } else {
            int num = Integer.parseInt(choice) - 1;
            SwingUtilities.invokeLater((new Runnable() {
                @Override
                public void run() {
                    try {
                        WeekFrame weekFrame = new WeekFrame();
                        weekFrame.initializeWeekFrame(team, num);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
    }

    private void introBirds() throws IOException, WrongInputException {
        initAllStats(introBirds);
        while (true) {
            System.out.println("Enter [1] to enter this weeks stats, [2] to view stats, [3] to return to previous line, or 'end' to end program ");
            choice = scanner.nextLine();
            if (choice.equals(Integer.toString(1))) {
                System.out.println("Inputting stats for week : ["+introBirds.weekGetter()+"] - * Last Input was for match against " +introBirds.getTeamList().get(introBirds.weekGetter() - 2));
                statistics();
                rebootAfterAddingStatsBirds();
                }
                else if (choice.equals(Integer.toString(2))){
                viewStatsInitBirds();
            }
//            else if (choice.equals("print results") || choice.equals("print results ")) {
//                introBirds.getStats().printStats();
//                introBirds.saveWeek();
//                System.exit(0);
//            }
            if (choice.equals(Integer.toString(3))){
                firstLines();
            }
            else if (choice.equals("end") || choice.equals("end ")){
                System.out.println("Program ending");
                System.exit(0);
            }
        }
    }


    private void introBraves() throws IOException, WrongInputException {
        initAllStats(introBraves);
        while (true) {
            System.out.println("Enter [1] to enter this weeks stats, [2] to view stats, [3] to return to previous line, or 'end' to end program ");
            choice = scanner.nextLine();
            if (choice.equals(Integer.toString(1))) {
                System.out.println("Inputting stats for week : ["+introBraves.weekGetter()+"] - * Last Input was for match against " +introBraves.getTeamList().get(introBraves.weekGetter() - 2));
                statistics();
                rebootAfterAddingStatsBraves();
            }
             if (choice.equals(Integer.toString(2))){
                viewStatsInitBraves();
            }
//            else if (choice.equals("print results") || choice.equals("print results ")) {
//                introBraves.getStats().printStats();
//                introBraves.saveWeek();
//                System.exit(0);
//            }
            if (choice.equals(Integer.toString(3))){
                firstLines();
            }
            else if (choice.equals("end") || choice.equals("end ")){
                System.out.println("Program ending");
                System.exit(0);
            }
        }
    }



    private void statistics() {
        againstWhom.againstWhom();
        possession.possession();
        setPiece.setPiece();
        tackle.tackle();
        restarts.restarts();
        discipline.discipline();
    }

    private void rebootAfterAddingStatsBirds() throws IOException, WrongInputException{
        introBirds.saveable();
        introBirds.saveTeamList();
        introBirds.addWeek();
        introBirds.saveWeek();
        introBirds.resetValueNumber();
        introBirds();
    }

    private void rebootAfterAddingStatsBraves() throws IOException, WrongInputException{
        introBraves.saveable();
        introBraves.saveTeamList();
        introBraves.addWeek();
        introBraves.saveWeek();
        introBraves.resetValueNumber();
        introBraves();
    }
}








