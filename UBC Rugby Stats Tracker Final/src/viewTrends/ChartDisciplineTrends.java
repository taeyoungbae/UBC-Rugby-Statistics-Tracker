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

public class ChartDisciplineTrends extends JPanel {
    private static final int W = 400;
    private static final int H = 2 * W;
    Scanner input;
    IntroBirds introBirds = new IntroBirds();
    IntroBraves introBraves = new IntroBraves();
    int columns = 38;
    int week;
    int[][] numberstats = new int[25][38];

    public ChartDisciplineTrends(String team) throws IOException {
        if (team.equals("Birds")) {
            week = introBirds.weekSetterBirds();
            loadableBirds();
        }
        if (team.equals("Braves")) {
            week = introBraves.weekSetterBraves();
            loadableBraves();
        }
        this.setLayout(new BorderLayout());
        createDataset();
        JFreeChart barChart = ChartFactory.createBarChart(
                "Discipline",
                "Weeks",
                "",
                createDataset(),
                PlotOrientation.VERTICAL,
                true, true, false);
        this.add(new ChartPanel(barChart, W, H, W, H, W, H,
        false, true, true, true, true, true));
    }



    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < week - 1; i++) {
            dataset.addValue(numberstats[i][35], "Penalties Against", "Week " + (i + 1));
            dataset.addValue(numberstats[i][36], "Yellow Card(s)", "Week " + (i + 1));
            dataset.addValue(numberstats[i][37], "Red Card(s)", "Week " + (i + 1));

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
