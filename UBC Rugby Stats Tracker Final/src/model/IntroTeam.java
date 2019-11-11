package model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class IntroTeam {
    ListOfStats stats = new ListOfStats();
    int week;
    int valuenumber = 0; //this will reset to 0 after completion of input of 1 weeks stats
    int[][] numberstats = new int[25][38]; //1st [] represents rows, 2nd columns
    List<String> teamlist = new ArrayList<>();

    public void addWeek(){
        week++;
    }
    public void resetValueNumber(){
        valuenumber = 0;
    }
    public int weekGetter(){
         return week;
    }

    public int weekSetterBirds() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("weeknumberbirds.txt"));
        File file = new File("weeknumberbirds.txt");
        if (file.length() == 0) {
            week = 1;
        }
        else
            week = Integer.parseInt(lines.get(0));

        return week;
    }
    public int weekSetterBraves() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("weeknumberbraves.txt"));
        File file = new File("weeknumberbraves.txt");
        if (file.length() == 0) {
            week = 1;
        }
        else
            week = Integer.parseInt(lines.get(0));

        return week;
    }

    public void addToNumberStats(int val){
            numberstats[week - 1][valuenumber] = val;
            valuenumber++;
        }

    public ListOfStats getStats() {
        return stats;
    }
    public int[][] getNumberstats(){
        return numberstats;
    }
    public List<String> getTeamList(){ return teamlist;}



}
