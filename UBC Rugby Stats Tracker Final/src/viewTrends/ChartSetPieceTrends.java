package viewTrends;


import model.IntroBirds;
import model.IntroBraves;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class ChartSetPieceTrends extends JPanel {
    private static final int W = 400;
    private static final int H = 2 * W;
    Scanner input;
    IntroBirds introBirds = new IntroBirds();
    IntroBraves introBraves = new IntroBraves();
    int columns = 38;
    int week;
    int[][] numberstats = new int[25][38];

    public ChartSetPieceTrends(String team) throws IOException {
        if (team.equals("Birds")) {
            week = introBirds.weekSetterBirds();
            loadableBirds();

        }
        if (team.equals("Braves")){
            week = introBraves.weekSetterBraves();
            loadableBraves();

        }
        this.setLayout(new BorderLayout());
        JFreeChart barChart = ChartFactory.createBarChart(
                "Set Piece Trends",
                "Weeks",
                "",
                createDataSet(),
                PlotOrientation.VERTICAL,
                true, true, false);
        this.add(new ChartPanel(barChart, W, H, W, H, W, H,
                false, true, true, true, true, true));
    }


    private CategoryDataset createDataSet() {
        int scrumattackrate;
        int scrumdefenserate;
        int lineoutattackrate;
        int lineoutdefenserate;

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < (week - 1); i++) {
            if ((numberstats[i][10] == 0)) {
                scrumattackrate = 0;
            } else {scrumattackrate = (numberstats[i][10] * 100 / numberstats[i][11]);}
            if ((numberstats[i][13] == 0)){
                scrumdefenserate = 0;
            }
            else {scrumdefenserate = (numberstats[i][13] * 100 / numberstats[i][14]);}

            if ((numberstats[i][10] == 0)) {
                lineoutattackrate = 0;
            } else {lineoutattackrate = (numberstats[i][16] * 100 / numberstats[i][17]);}
            if ((numberstats[i][13] == 0)){
                lineoutdefenserate = 0;
            }
            else {lineoutdefenserate = (numberstats[i][21] * 100 / numberstats[i][22]);}

            dataset.addValue(scrumattackrate, "Scrum Attack Rate", "Week " + (i + 1));
            dataset.addValue(scrumdefenserate, "Scrum Defense Rate", "Week " + (i + 1));
            dataset.addValue(lineoutattackrate, "LineOut Attack Rate", "Week " + (i + 1));
            dataset.addValue(lineoutdefenserate, "LineOut Defence Rate", "Week " + (i + 1));

        }
        return dataset;
    }



    public void loadableBirds() throws IOException {
        input = new Scanner(new File("birdsstats.txt"));
        if (input.hasNextInt()) {
            for (int i = 0; i < (week - 1); i++) {
                for (int j = 0; j < columns; j++)
                    numberstats[i][j] = input.nextInt();
            }
        }
    }

    public void loadableBraves() throws IOException {
        input = new Scanner(new File("bravesstats.txt"));
        if (input.hasNextInt()){
            for (int i = 0; i < (week - 1); i++) {
                for (int j = 0; j < columns; j++)
                    numberstats[i][j] = input.nextInt();
            }
        }
    }
}



