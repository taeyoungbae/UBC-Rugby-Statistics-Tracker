package viewTrends;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class TrendsFrame {
    JFrame f;
    JButton btn = new JButton("Go Back");


    public void initializeTrendsFrame(String team) throws IOException {
        ChartDisciplineTrends chartDisciplineTrends = new ChartDisciplineTrends(team);
        ChartSetPieceTrends chartSetPieceTrends = new ChartSetPieceTrends(team);
        ChartKPIsTrends chartKPIsTrends = new ChartKPIsTrends(team);

            f = new JFrame("UBC Rugby Trends: " + team);
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLayout(new BorderLayout(1, 0));
        ActionListener actionListener = new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.dispose();
            }
        };
        btn.setActionCommand("Go Back");
        btn.addActionListener(actionListener);
        JLabel jLabel = new JLabel("UBC Rugby Trends: " + team, SwingConstants.CENTER);
        jLabel.setSize(200, 200);
            f.add(jLabel, BorderLayout.NORTH);
            f.add(chartDisciplineTrends, BorderLayout.EAST);
            f.add(chartSetPieceTrends, BorderLayout.WEST);
            f.add(chartKPIsTrends, BorderLayout.CENTER);
            f.add(btn, BorderLayout.SOUTH);
            f.pack();
            f.setVisible(true);

            }

    }


