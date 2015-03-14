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
        preTable.addKeyListener(new KeyListener()
            {
                public void keyPressed(KeyEvent e)
                {
                    if (e.getKeyCode()==KeyEvent.VK_ENTER)
                    {
                        preTableModel.addRow(new Object[]{"", ""});
                    } 
                }
                public void keyReleased(KeyEvent e) { }
                public void keyTyped(KeyEvent e) { } 
            });
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
        
        else if (e.getSource() == runSim)
        {
            runSimulator();
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
            
            /**call method singRun(resNum, preTableModel)
             * that method needs to return a 2d char array for table building.
             */
            
            //Some test code for preTableModel data retrieval
            for(int i = 0; i < preTableModel.getRowCount(); ++i)
            {
                for(int j = 0; j < preTableModel.getColumnCount(); ++j)
                {
                    System.out.print(preTableModel.getValueAt(i, j) + " ");
                }
                System.out.println("");
            }
            
            String[][] tempData = {{"","","","","","",""},{"","","","","","",""},{"","","","","","",""}};
            
            SingleTableGUI gui = new SingleTableGUI(resNum, tempData);
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Enter a number in the Total Resources field.", "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    public void runSimulator()
    {
        try
        {
            int resNum = Integer.parseInt(Resources.getText());
            
            while(true)
            {
                try
                {
                    String input = JOptionPane.showInputDialog("Enter number of runs:");
                    int numRuns = Integer.parseInt(input);
                    break;
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Use a number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Enter a number in the Total Resources field.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        /**
         * Call method simulation(resNum, preTableModel, numRuns)
         * returns average project completion time.
         */
    }
}