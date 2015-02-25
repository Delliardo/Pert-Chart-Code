package pertchart;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class SingleTableGUI extends JFrame implements ActionListener
{
        //Data panel
    private JPanel resourcePanel, timePanel, tablePanel;
    private JLabel TotalResources, resNum, TotalTime, timeNum;

    //private JButton single, runSim;
    
    private DefaultTableModel singleRunModel;
    private JTable singleRunTable;
    private String[] columns = {"Activity ID", "Description", "Begin", "End", "Resources", "Available", "Predecessor"};
    
    
    SingleTableGUI(int resInt, String[][] data)
    {
        super("Single Run results");
        Container c = getContentPane();

        //Create main panel
        resourcePanel = new JPanel();
        TotalResources = new JLabel("Total Resources:");
        resNum = new JLabel(Integer.toString(resInt));
        resourcePanel.add(TotalResources);
        resourcePanel.add(resNum);
        c.add(resourcePanel, BorderLayout.CENTER);
        
        timePanel = new JPanel();
        TotalTime = new JLabel("Total time to complete Project:");
        timeNum = new JLabel("4.5");
        timePanel.add(TotalTime);
        timePanel.add(timeNum);
        c.add(timePanel, BorderLayout.SOUTH);
        
        
        //Create table panel
        tablePanel = new JPanel();
        singleRunModel = new DefaultTableModel(data, columns);
        singleRunTable = new JTable(singleRunModel);
        singleRunTable.setPreferredScrollableViewportSize(new Dimension(500, 200));
        singleRunTable.setFillsViewportHeight(false);
        tablePanel.add(new JScrollPane(singleRunTable));
        c.add(tablePanel, BorderLayout.NORTH);
        

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(200,350);
        pack();
        setVisible(true);
    }
    
    
    @Override
    /**
     * Detect which button the user just pressed.
     */
    public void actionPerformed(ActionEvent e)
    {

    }//actionPerformed
}
