package viewWeek;

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

public class ChartPossessionWeek extends JPanel {
    private static final int W = 400;
    private static final int H = 2 * W;
    Scanner input;
    IntroBirds introBirds = new IntroBirds();
    IntroBraves introBraves= new IntroBraves();
    int columns = 38;
    int week;
    int num;
    int[][] numberstats = new int[25][38];

    public ChartPossessionWeek(String team, int num) throws IOException {
        this.num = num;
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
                "Possession",
                "Possession Stats",
                "",
                createDataSet(),
                PlotOrientation.VERTICAL,
                true, true, false);
        this.add(new ChartPanel(barChart, W, H, W, H, W, H,
                false, true, true, true, true, true));
    }


    private CategoryDataset createDataSet() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();


            dataset.addValue(numberstats[num][0], "Turnovers in Contact", "Turnovers in Contact");
            dataset.addValue((numberstats[num][1]), "Handling Errors", "Handling Errors");
            dataset.addValue(numberstats[num][2], "Kick Away Possession", "Kick Away Possession");
            dataset.addValue(numberstats[num][3], "Kicks Retained", "Kicks Retained");
            dataset.addValue(numberstats[num][4], "Penalties Won", "Penalties Won");
           // dataset.addValue(numberstats[num][5], "Tries Scored", "Tries Scored");
        dataset.addValue(numberstats[num][35], "Penalties Against", "Penalties Against");

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

