package viewWeek;

import model.IntroBirds;
import model.IntroBraves;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ChartPieLineOutDefenseWeek extends JPanel {

    private static final int W = 200;
    private static final int H = 2 * W;
    IntroBirds introBirds = new IntroBirds();
    IntroBraves introBraves = new IntroBraves();
    Scanner input;
    int columns = 38;
    int week;
    int num;
    int[][] numberstats = new int[25][38];

    public ChartPieLineOutDefenseWeek(String team, int num) throws IOException {
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
//        Dimension chartD = new Dimension(100, 200);
//        getPreferredSize();
        createDataset();
        JFreeChart piechart = ChartFactory.createPieChart(
                "LineOut Defense",
                createDataset(),
                true,
                true,
                false);
        this.add(new ChartPanel(piechart, W, H, W, H, W, H,
                false, true, true, true, true, true));
    }

    private PieDataset createDataset( ) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        int lineoutlost = numberstats[num][22] - numberstats[num][21];
        int lineoutwon = numberstats[num][21] - numberstats[num][23];
        dataset.setValue( "Lost " + Integer.toString(lineoutlost), lineoutlost );
        dataset.setValue( "Won" +Integer.toString(lineoutwon), lineoutwon);
        dataset.setValue( "Won - Spoiled Ball(s) "  +Integer.toString(numberstats[num][23]), numberstats[num][23]);

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
        if (input.hasNextInt()) {
            for (int i = 0; i < (week - 1); i++) {
                for (int j = 0; j < columns; j++)
                    numberstats[i][j] = input.nextInt();
            }
        }
    }
}

