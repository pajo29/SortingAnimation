package main;

import sortPanel.SortPanel;

import javax.swing.*;
import java.util.Random;

public class MainFrame extends JFrame
{
    private static MainFrame instance = null;

    private SortPanel sortPanelOne;
    private SortPanel sortPanelTwo;

    private JButton populateArrayButton;
    private JButton sortButton;
    private JButton stopButton;

    int[] array;

    private MainFrame()
    {
        super("Sorting animation");
    }

    private void initialise()
    {
        populateArrayButton = new JButton("Populate array");


        sortButton = new JButton("Sort");
        sortButton.setEnabled(false);
        stopButton = new JButton("Stop");
        stopButton.setEnabled(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(populateArrayButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(stopButton);


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

    private int[] populateArray()
    {
        Random random = new Random();
        int[] array = new int[400];
        for(int i = 0; i < 400; i++)
        {
            array[i] = random.nextInt(400) + 1;
            System.out.println(array[i]);
        }
        return array;
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
