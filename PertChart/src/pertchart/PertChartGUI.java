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
    private String[] columns = {"Activity ID", "A", "M", "B", "Predecessors", "Resources"};
    private String[][] data = {{"", "", "", "", "", "", ""}};

    PertChartGUI() {
        super("STARC");
        //Create table panel
        tablePanel = new JPanel();
        JLabel activityInfo = new JLabel("Activity Information");
        tablePanel.add(activityInfo);
        preTableModel = new DefaultTableModel(data, columns);
        preTable = new JTable(preTableModel);
        preTable.setPreferredScrollableViewportSize(new Dimension(500, 300));
        preTable.setFillsViewportHeight(true);
        preTable.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    preTableModel.addRow(new Object[]{"", "", "", "", "", ""});
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

        
        lbl_Duration_Interval = new JLabel("Time Unit");
        durationInterval = new JTextField(5);
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
        
        outerPanel.add(projectPanel, BorderLayout.SOUTH);

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
            
        } 

    }//actionPerformed

    /**
     * Using the data from the preTable and Resource textbox, this method will
     * call the appropriate method to calculate a single Pert table. The called
     * method should return the results in a 2d String array. The 2D string
     * array will be used in a new table to display the results.
     */
    public void runSimulator() {
        
               
        calculations = new Calculations(this.durationInterval.getText(), Integer.parseInt(this.Resources.getText()));

        for (int i = 0; i < preTableModel.getRowCount(); ++i) {
            try {
                earlyValue = Double.parseDouble((String) preTableModel.getValueAt(i, 1));
                middleValue = Double.parseDouble((String) preTableModel.getValueAt(i, 2));
                lateValue = Double.parseDouble((String) preTableModel.getValueAt(i, 3));
                resourcesValue = 0.0;
                String pred = "";
                if(preTableModel.getValueAt(i, 4) != null){
                    pred = (String) preTableModel.getValueAt(i, 4);
                }
                
                if(preTableModel.getValueAt(i, 5) != null && ((String)preTableModel.getValueAt(i, 5)).length() > 0){
                    resourcesValue = Double.parseDouble((String)preTableModel.getValueAt(i, 5));
                }
   
                activity = new Activity((String) preTableModel.getValueAt(i, 0), earlyValue, middleValue, lateValue, pred , resourcesValue);
                calculations.activities.add(activity);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Activity information has been entered incorrectly", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        }

        calculations.run();
      
        Results results = new Results(calculations);
    }
}
