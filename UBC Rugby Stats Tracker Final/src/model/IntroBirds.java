package model;

import exceptions.WrongInputException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntroBirds extends IntroTeam implements Loadable, Saveable{
    Scanner input;
    int columns = 38;


    @Override
    public void loadable() throws IOException {

        weekSetterBirds();
        input = new Scanner(new File("birdsstats.txt"));
            if (input.hasNextInt()) {
                for (int i = 0; i < (week - 1); i++ ){
                    for (int j = 0; j < columns; j++)
                        numberstats[i][j] = input.nextInt();
            }
        }
    }
    @Override
    public void loadTeamList() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("birdsteamlist.txt"));
        for (String line : lines){
            teamlist.add(line);
        }
    }

    @Override
    public void saveable() {
        PrintStream ps;
        try {
            ps = new PrintStream(new FileOutputStream("birdsstats.txt"));
            for(int row=0;row < week;row++){
                for(int col=0; col < columns;col++){
                    int i = numberstats[row][col];
                    ps.println(i);
                }
            }
            ps.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void saveWeek() throws IOException{
        PrintWriter writer = new PrintWriter("weeknumberbirds.txt", "UTF-8");
        writer.println(week);
        writer.close();
    }

    @Override
    public void saveTeamList() throws IOException {
        PrintWriter writer = new PrintWriter("birdsteamlist.txt","UTF-8");
        for (String team: teamlist){
           writer.println(team);
        }
        writer.close();
    }

}
