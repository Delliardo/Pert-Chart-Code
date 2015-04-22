package pertchart;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.*;

public class Results extends JFrame implements ActionListener
{
        //Data panel
    private JPanel resourcePanel, timePanel, tablePanel;
    private JLabel TotalResources, resNum, TotalTime, timeNum;
    
    //private JButton single, runSim;
    
    private DefaultTableModel resultsModel;
    private JTable resultsTable;
    //private String[] columns = {"Activity ID", "Predecessors", "A", "M", "B", "Variance", "Start Time", "Completion Time"};
    
    
    Results(Calculations calculations)
    {
        super("Results");
        
        HashMap<String, Double[]> map = calculations.getActivityResults();
        
        Double projectTime = calculations.getProjectCompletionTime();
        String[][] data = {{"", "", "", "", "", "", ""}};
        
        DefaultTableColumnModel columns = new DefaultTableColumnModel();
        //create and define columns 
        TableColumn column1 = new TableColumn(0); 
        column1.setHeaderValue("Activity ID"); // set column name 
        column1.setPreferredWidth(50); //set column width 
        
        TableColumn column2 = new TableColumn(1); 
        column2.setHeaderValue("Predecessors"); // set column name 
        column2.setPreferredWidth(50); //set column width
        
        TableColumn column3 = new TableColumn(2); 
        column3.setHeaderValue("A"); // set column name 
        column3.setPreferredWidth(15); //set column width 
        
        TableColumn column4 = new TableColumn(3); 
        column4.setHeaderValue("M"); // set column name 
        column4.setPreferredWidth(15); //set column width 
        
        TableColumn column5 = new TableColumn(4); 
        column5.setHeaderValue("B"); // set column name 
        column5.setPreferredWidth(15); //set column width 
        
        TableColumn column6 = new TableColumn(5); 
        column6.setHeaderValue("Variance (s\u00B2)"); // set column name 
        column6.setPreferredWidth(50); //set column width 
        
        TableColumn column7 = new TableColumn(6); 
        column7.setHeaderValue("Start Time"); // set column name 
        column7.setPreferredWidth(50); //set column width 
        
        TableColumn column8 = new TableColumn(7); 
        column8.setHeaderValue("Completion Time"); // set column name 
        column8.setPreferredWidth(70); //set column width 
        
        columns.addColumn(column1);
        columns.addColumn(column2);
        columns.addColumn(column3);
        columns.addColumn(column4);
        columns.addColumn(column5);
        columns.addColumn(column6);
        columns.addColumn(column7);
        columns.addColumn(column8);
        
        resultsModel = new DefaultTableModel( 0 ,8 );
        
        
        int l = calculations.activities.size();
        for (int i = 0; i < l; i++) {
            Activity a = calculations.activities.get(i);
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry e = (Map.Entry)it.next();
                if (a.getActivityId() == e.getKey()) {
                    Double[] d = (Double[])e.getValue();
                    Object[] row = {a.getActivityId(), a.getPredecessorsInput(), a.getA(), a.getM(), a.getB(), d[0], d[1], d[2]};
                    resultsModel.addRow(row);
                }
            }
        }
        
        //Create table panel
        tablePanel = new JPanel();
        tablePanel.setSize(550,300 );
        
        resultsTable = new JTable(resultsModel, columns);
        resultsTable.setPreferredScrollableViewportSize(new Dimension(650, 300));
        resultsTable.setFillsViewportHeight(true);
        
        tablePanel.add(new JScrollPane(resultsTable));
        add(tablePanel, BorderLayout.NORTH);

               
        timePanel = new JPanel();
        TotalTime = new JLabel("Project Completion Time: ");
        timeNum = new JLabel(projectTime + " " + calculations.getTimeUnit());
        timePanel.add(TotalTime);
        timePanel.add(timeNum);
        add(timePanel, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(700,450);
        //pack();
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
