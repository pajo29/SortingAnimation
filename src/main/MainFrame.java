package main;

import sortPanel.SortPanel;

import javax.swing.*;

public class MainFrame extends JFrame
{
    private static MainFrame instance = null;

    private SortPanel sortPanelOne;
    private SortPanel sortPanelTwo;

    private JButton populateArrayButton;
    private JButton sortButton;

    private MainFrame()
    {
        super("Sorting animation");
    }

    private void initialise()
    {
        populateArrayButton = new JButton("Populate array");
        sortButton = new JButton("Sort");
        sortButton.setEnabled(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(populateArrayButton);
        buttonPanel.add(sortButton);


        JPanel sortPanel = new JPanel();
        sortPanel.setLayout(new BoxLayout(sortPanel, BoxLayout.LINE_AXIS));
        sortPanelOne = new SortPanel();
        sortPanelTwo = new SortPanel();
        sortPanel.add(sortPanelOne);
        sortPanel.add(sortPanelTwo);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        mainPanel.add(sortPanel);
        mainPanel.add(buttonPanel);


        add(mainPanel);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static MainFrame getInstance()
    {
        if(instance == null)
        {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }
}
