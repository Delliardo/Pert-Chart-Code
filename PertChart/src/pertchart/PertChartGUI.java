package pertchart;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;


public class PertChartGUI extends JFrame implements ActionListener
{
    //Data panel
    private JPanel mainPanel, tablePanel, resourcePanel;
    private JLabel TotalResources;
    private JTextField Resources;

    private JButton single, runSim;
    
    private DefaultTableModel preTableModel;
    private JTable preTable;
    private String[] columns = {"Activity ID", "Description", "Earliest", "Middle", "Latest", "Predecessors", "Resources"};
    private String[][] data = {{"","","","","","",""},{"","","","","","",""},{"","","","","","",""}};
    
    
    PertChartGUI()
    {
        super("Shipment Input");
        Container c = getContentPane();

        //Create main panel
        mainPanel = new JPanel();
        single = new JButton("Calculate Single Table");
        single.addActionListener(this);
        single.setToolTipText("Shows a single table.");
        runSim = new JButton("Run Simulation");
        runSim.addActionListener(this);
        runSim.setToolTipText("Calculates an average completion time.");
        mainPanel.add(single);
        mainPanel.add(runSim);
        c.add(mainPanel, BorderLayout.SOUTH);
        
        
        
        //Create table panel
        tablePanel = new JPanel();
        preTableModel = new DefaultTableModel(data, columns);
        preTable = new JTable(preTableModel);
        preTable.setPreferredScrollableViewportSize(new Dimension(500, 200));
        preTable.setFillsViewportHeight(false);
        tablePanel.add(new JScrollPane(preTable));
        c.add(tablePanel, BorderLayout.NORTH);
        
        //Create resource panel
        resourcePanel = new JPanel();
        TotalResources = new JLabel("Total Resources:");
        Resources = new JTextField(10);
        resourcePanel.add(TotalResources);
        resourcePanel.add(Resources);
        c.add(resourcePanel, BorderLayout.CENTER);
        

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        if (e.getSource() == single)
        {
            doSingleRun();
        }
    }//actionPerformed
    
    
    /**
     * Using the data from the preTable and Resource textbox, this method will call
     * the appropriate method to calculate a single Pert table.  The called method
     * should return the results in a 2d String array.  The 2D string array will
     * be used in a new table to display the results.
     */
    public void doSingleRun()
    {
        try
        {
            int resNum = Integer.parseInt(Resources.getText());
            
            String[][] tempData = {{"","","","","","",""},{"","","","","","",""},{"","","","","","",""}};
            
            SingleTableGUI gui = new SingleTableGUI(resNum, tempData);
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Enter a number in the Total Resources field.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }
}