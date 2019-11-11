package viewWeek;



import model.IntroBirds;
import model.IntroBraves;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WeekFrame {
    JFrame f;
    JButton btn = new JButton("Go Back");
    String opposition;
    IntroBirds introBirds = new IntroBirds();
    IntroBraves introBraves= new IntroBraves();


    public void initializeWeekFrame(String team, int num) throws IOException { ;

        ChartPossessionWeek chartPossessionWeek = new ChartPossessionWeek(team, num);
        ChartKPIWeek chartKPIWeek = new ChartKPIWeek(team, num);

        f = new JFrame("UBC Rugby Week: " + (num + 1));
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new BorderLayout(1, 0));
        ActionListener actionListener = new ActionListener(){
            public void actionPerformed(ActionEvent actionEvent){
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.dispose();

            }
        };
        if (team.equals("Birds")){
            introBirds.loadTeamList();
            opposition = introBirds.getTeamList().get(num);
        }
        else {
            introBraves.loadTeamList();
            opposition = introBraves.getTeamList().get(num);
        }
        btn.setActionCommand("Go Back");
        btn.addActionListener(actionListener);
        JLabel jLabel = new JLabel("UBC Rugby Against : " + opposition, SwingConstants.CENTER);
        jLabel.setSize(200, 200);
        f.add(jLabel, BorderLayout.NORTH);
        f.add(chartKPIWeek, BorderLayout.EAST);
        f.add(chartPossessionWeek, BorderLayout.WEST);
        f.add((SetPiecePanel(team, num)), BorderLayout.CENTER);
        f.add(btn, BorderLayout.SOUTH);
        f.getContentPane().revalidate();
        f.pack();
        f.setVisible(true);

    }
    public JPanel SetPiecePanel(String team, int num) throws IOException {
        ChartPieScrumAttackWeek chartPieScrumAttackWeek = new ChartPieScrumAttackWeek(team, num);
        chartPieScrumAttackWeek.setBackground(Color.LIGHT_GRAY);
        chartPieScrumAttackWeek.setPreferredSize(new Dimension(200, 100));

        ChartPieScrumDefenseWeek chartPieScrumDefenseWeek = new ChartPieScrumDefenseWeek(team, num);
        chartPieScrumDefenseWeek.setBackground(Color.LIGHT_GRAY);
        chartPieScrumDefenseWeek.setPreferredSize(new Dimension(200,100));

        ChartPieLineOutOffenseWeek chartPieLineOutOffenseWeek = new ChartPieLineOutOffenseWeek(team, num);
        chartPieLineOutOffenseWeek.setBackground(Color.LIGHT_GRAY);
        chartPieLineOutOffenseWeek.setPreferredSize(new Dimension(200,100));

        ChartPieLineOutDefenseWeek chartPieLineOutDefenseWeek = new ChartPieLineOutDefenseWeek(team, num);
        chartPieLineOutDefenseWeek.setBackground(Color.LIGHT_GRAY);
        chartPieLineOutDefenseWeek.setPreferredSize(new Dimension(200,100));

//            chartPieLineOutDefenseWeek.getPreferredSize();
//            chartPieLineOutOffenseWeek.getPreferredSize();
//            chartPieScrumAttackWeek.getPreferredSize();
//            chartPieScrumDefenseWeek.getPreferredSize();

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2,2));

        Dimension panelD = new Dimension(800, 400);
        contentPane.setPreferredSize(panelD);
        contentPane.add(chartPieScrumAttackWeek);
        contentPane.add(chartPieScrumDefenseWeek);
        contentPane.add(chartPieLineOutOffenseWeek);
        contentPane.add(chartPieLineOutDefenseWeek);

        return contentPane;
    }
}


