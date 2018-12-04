package main;

import sortPanel.view.SortPanelView;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private static MainFrame instance = null;

    private SortPanelView sortPanelOne;
    private SortPanelView sortPanelTwo;

    private JButton populateArrayButton;
    private JButton sortButton;

    private MainFrame()
    {

    }

    private void initialise()
    {
        populateArrayButton = new JButton("Populate array");
        sortButton = new JButton("Sort");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(populateArrayButton);
        buttonPanel.add(sortButton);


        JPanel sortPanel = new JPanel();
        sortPanel.setLayout(new BoxLayout(sortPanel, BoxLayout.LINE_AXIS));
        sortPanelOne = new SortPanelView();
        sortPanelTwo = new SortPanelView();
        sortPanel.add(sortPanelOne);
        sortPanel.add(sortPanelTwo);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        mainPanel.add(sortPanel);
        mainPanel.add(buttonPanel);


        add(mainPanel);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setTitle("Project");
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
