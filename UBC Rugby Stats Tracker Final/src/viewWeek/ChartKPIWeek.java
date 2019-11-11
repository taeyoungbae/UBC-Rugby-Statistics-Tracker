package viewWeek;

import model.IntroBirds;
import model.IntroBraves;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ChartKPIWeek extends JPanel {
    private static final int W = 400;
    private static final int H = 2 * W;
    Scanner input;
    IntroBirds introBirds = new IntroBirds();
    IntroBraves introBraves= new IntroBraves();
    int columns = 38;
    int week;
    int num;
    int[][] numberstats = new int[25][38];

    public ChartKPIWeek(String team, int num) throws IOException {
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
                "KPIs",
                "KPIs",
                "Percentage (%)",
                createDataSet(),
                PlotOrientation.VERTICAL,
                true, true, false);
        this.add(new ChartPanel(barChart, W, H, W, H, W, H,
                false, true, true, true, true, true));
    }


    private CategoryDataset createDataSet() {
        int turnoverrate;
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            if (numberstats[num][30] == 0){ turnoverrate = 0;}
            else {turnoverrate = numberstats[num][30] * 100 / numberstats[num][24];}

           // dataset.setValue( "Scrum(s) Won - Dominant " +Integer.toString(numberstats[0][12]), numberstats[0][12]);
            dataset.addValue(numberstats[num][9], "Gainline Success Rate", "Gainline Success Rate");
            dataset.addValue((numberstats[num][6]), "Ball Retention Rate", "Ball Retention Rate");
            dataset.addValue(numberstats[num][7], "Ball Possession Rate", "Ball Possession Rate");
            dataset.addValue(numberstats[num][26], "Tackle Rate", "Tackle Rate");
            dataset.addValue(turnoverrate, "Turnover Rate Per Tackle", "Turnover Rate Per Tackle");

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
