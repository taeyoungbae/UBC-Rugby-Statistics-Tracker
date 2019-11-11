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


public class ChartKPIsTrends extends JPanel {
    private static final int W = 400;
    private static final int H = 2 * W;
    Scanner input;
    IntroBirds introBirds = new IntroBirds();
    IntroBraves introBraves= new IntroBraves();
    int columns = 38;
    int week;
    int[][] numberstats = new int[25][38];

    public ChartKPIsTrends(String team) throws IOException {
        if (team.equals("Birds")) {
            week = introBirds.weekSetterBirds();
            loadableBirds();
        }
        if (team.equals("Braves")) {
            week = introBraves.weekSetterBraves();
            loadableBraves();
        }
        this.setLayout(new BorderLayout());
        JFreeChart barChart = ChartFactory.createBarChart(
                "KPIs",
                "Weeks",
                "",
                createDataSet(),
                PlotOrientation.VERTICAL,
                true, true, false);
        this.add(new ChartPanel(barChart, W, H, W, H, W, H,
                false, true, true, true, true, true));
    }


    private CategoryDataset createDataSet() {
        int turnoverrate;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < (week - 1); i++) {
            if (numberstats[i][30] == 0){ turnoverrate = 0;}
            else {turnoverrate = numberstats[i][30] * 100 / numberstats[i][24];}

            dataset.addValue(numberstats[i][9], "Gainline Success Rate", "Week " + (i + 1));
            dataset.addValue(numberstats[i][7], "Ball Possession Rate", "Week " + (i + 1));
            dataset.addValue(numberstats[i][26], "Tackle Rate", "Week " + (i + 1));
            dataset.addValue(turnoverrate, "Turnover Rate Per Tackle", "Week " + (i + 1));
           // dataset.addValue((numberstats[i][30]), "Turnovers in Tackle", "Week " + (i + 1));

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

