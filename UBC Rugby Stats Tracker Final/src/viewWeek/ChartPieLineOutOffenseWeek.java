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

public class ChartPieLineOutOffenseWeek extends JPanel {

    private static final int W = 200;
    private static final int H = 2 * W;
    IntroBirds introBirds = new IntroBirds();
    IntroBraves introBraves = new IntroBraves();
    Scanner input;
    int columns = 38;
    int week;
    int num;
    int[][] numberstats = new int[25][38];

    public ChartPieLineOutOffenseWeek(String team, int num) throws IOException {
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
        Dimension chartD = new Dimension(100, 200);
        getPreferredSize();
        createDataset();
        JFreeChart piechart = ChartFactory.createPieChart(
                "LineOut Attack",
                createDataset(),
                true,
                true,
                false);
        this.add(new ChartPanel(piechart, W, H, W, H, W, H,
                false, true, true, true, true, true));

    }

    private PieDataset createDataset( ) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        int lineoutlost = numberstats[num][17] - numberstats[num][16];
        int lineoutwon = numberstats[num][16] - numberstats[num][18] - numberstats[num][19] - numberstats[num][20];
        dataset.setValue( " Won " + Integer.toString(lineoutwon), lineoutwon );
        dataset.setValue( " Won - Clean " +Integer.toString(numberstats[num][18]), numberstats[num][18]);
        dataset.setValue( "Won - Quick Throw "  +Integer.toString(numberstats[num][19]), numberstats[num][19]);
        dataset.setValue( "Won - Sloppy " +Integer.toString(numberstats[num][20]), numberstats[num][20]);
        dataset.setValue( "Lost " +Integer.toString(lineoutlost), lineoutlost);
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
