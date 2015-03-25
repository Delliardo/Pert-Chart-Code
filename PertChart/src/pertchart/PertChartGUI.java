package pertchart;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class PertChartGUI extends JFrame implements ActionListener {

    //Data panel
    private JPanel projectPanel, tablePanel, resourcePanel, graph, outerPanel, northPanel;
    private JLabel TotalResources, lbl_Early, lbl_Middle, lbl_Late, lbl_Duration_Interval, projectInfo;
    private JTextField Resources, early, middle, late, durationInterval;
    private Calculations calculations;
    private JButton runSim, simulationGraph;
    private double earlyValue, middleValue, lateValue, durationValue, resourcesValue;
    private DefaultTableModel preTableModel;
    private JTable preTable;
    private Activity activity;
    private String[] columns = {"Activity ID", "Duration", "Predecessors", "Resources"};
    private String[][] data = {{"", "", "", ""}};

    PertChartGUI() {
        super("STARC");
        //Create table panel
        tablePanel = new JPanel();
        JLabel activityInfo = new JLabel("Activity Information");
        tablePanel.add(activityInfo);
        preTableModel = new DefaultTableModel(data, columns);
        preTable = new JTable(preTableModel);
        preTable.setPreferredScrollableViewportSize(new Dimension(500, 300));
        preTable.setFillsViewportHeight(false);
        preTable.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    preTableModel.addRow(new Object[]{"", "", "", ""});
                }
            }

            public void keyReleased(KeyEvent e) {
            }

            public void keyTyped(KeyEvent e) {
            }
        });
        tablePanel.add(new JScrollPane(preTable));
        add(tablePanel, BorderLayout.NORTH);

        outerPanel = new JPanel();

        northPanel = new JPanel();
        projectInfo = new JLabel("Project Information");
        northPanel.add(projectInfo);

        outerPanel.add(northPanel, BorderLayout.NORTH);

        //Create resource panel
        resourcePanel = new JPanel();

        lbl_Early = new JLabel("Early");
        lbl_Middle = new JLabel("Middle");
        lbl_Late = new JLabel("Late");
        lbl_Duration_Interval = new JLabel("Duration Interval");
        durationInterval = new JTextField(5);
        early = new JTextField(5);
        middle = new JTextField(5);
        late = new JTextField(5);
        resourcePanel.add(lbl_Early);
        resourcePanel.add(early);
        resourcePanel.add(lbl_Middle);
        resourcePanel.add(middle);
        resourcePanel.add(lbl_Late);
        resourcePanel.add(late);
        resourcePanel.add(lbl_Duration_Interval);
        resourcePanel.add(durationInterval);

        outerPanel.add(resourcePanel, BorderLayout.CENTER);

        //Create project info panel
        projectPanel = new JPanel();
        TotalResources = new JLabel("Total Resources:");
        Resources = new JTextField(5);
        projectPanel.add(TotalResources);
        projectPanel.add(Resources);
        runSim = new JButton("Run Simulation");
        runSim.addActionListener(this);
        runSim.setToolTipText("Calculates an average completion time.");
        projectPanel.add(runSim);
        simulationGraph = new JButton("Show Graph");
        simulationGraph.addActionListener(this);
        simulationGraph.setVisible(false);
        // projectPanel.add(simulationGraph);

        outerPanel.add(projectPanel, BorderLayout.SOUTH);
        //SimulatorGraph graph = new SimulatorGraph();
        //add(graph);

        add(outerPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(540, 500);
        //  pack();
        setVisible(true);
    }

    @Override
    /**
     * Detect which button the user just pressed.
     */
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == runSim) {
            runSimulator();
            System.exit(0);
        } else if (e.getSource() == simulationGraph) {
            // TODO: implement graph gui
        }

    }//actionPerformed

    /**
     * Using the data from the preTable and Resource textbox, this method will
     * call the appropriate method to calculate a single Pert table. The called
     * method should return the results in a 2d String array. The 2D string
     * array will be used in a new table to display the results.
     */
    public void runSimulator() {
        try {
            earlyValue = Double.parseDouble(this.early.getText());
            middleValue = Double.parseDouble(this.middle.getText());
            lateValue = Double.parseDouble(this.late.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error in your time estimates", "Error", JOptionPane.ERROR_MESSAGE);
        }

        calculations = new Calculations(earlyValue, middleValue, lateValue, this.durationInterval.getText());

        for (int i = 0; i < preTableModel.getRowCount(); ++i) {
            try {
                durationValue = Double.parseDouble((String) preTableModel.getValueAt(i, 1));
                resourcesValue = Double.parseDouble((String) preTableModel.getValueAt(i, 3));
                activity = new Activity((String) preTableModel.getValueAt(i, 0), durationValue,(String) preTableModel.getValueAt(i, 2) , resourcesValue);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Activity information has been entered incorrectly", "Error", JOptionPane.ERROR_MESSAGE);
            }
            calculations.activities.add(activity);
        }

        calculations.run();
        System.out.println(calculations.getPrintedResults());
        //simulationGraph.setVisible(true);

    }
}
