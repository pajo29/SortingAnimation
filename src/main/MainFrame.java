package main;

import sortPanel.ArraySorter;
import sortPanel.SortPanel;

import javax.swing.*;
import java.util.Random;

public class MainFrame extends JFrame
{
    /*
    Class MainFrame uses Singleton Pattern, instance is used to initialise the class and later to access the same instance.
     */
    private static MainFrame instance = null;

    private SortPanel sortPanelOne;
    private SortPanel sortPanelTwo;

    private JButton populateArrayButton;
    private JButton sortButton;
    private JButton stopButton;
    private JButton pauseButton;

    private int iterationCounter = 0;

    /*
    Private constructor for Singleton patter, where we set the title of the frame
     */
    private MainFrame()
    {
        super("Sorting animation");
    }

    /*
    Method initialise creates neccessary buttons, panels and initialises the sortPanels.
     */
    private void initialise()
    {
        populateArrayButton = new JButton("Populate array");


        sortButton = new JButton("Sort");
        sortButton.setEnabled(false);

        stopButton = new JButton("Stop");
        stopButton.setEnabled(false);

        pauseButton = new JButton("Pause");
        pauseButton.setEnabled(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(populateArrayButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(pauseButton);


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

        populateArrayButton.addActionListener(new PopulateButtonActionListener());

        sortButton.addActionListener(e ->
        {
            sortPanelOne.getSortAnimation().start("Thread one");
            sortPanelTwo.getSortAnimation().start("Thread two");
            sortButton.setEnabled(false);
        });

        pauseButton.addActionListener(e ->
        {   MainFrame.getInstance().getSortPanelOne().getSortAnimation().getThread().interrupt();
            MainFrame.getInstance().getSortPanelTwo().getSortAnimation().getThread().interrupt();
            MainFrame.getInstance().getSortPanelOne().getSortAnimation().pauseAnimation();
            MainFrame.getInstance().getSortPanelTwo().getSortAnimation().pauseAnimation();
        });

        stopButton.addActionListener(e -> {
            MainFrame.getInstance().getSortPanelOne().getSortAnimation().getThread().interrupt();
            MainFrame.getInstance().getSortPanelTwo().getSortAnimation().getThread().interrupt();
            getPauseButton().setEnabled(false);
            getPopulateArrayButton().setEnabled(true);
            getSortButton().setEnabled(false);
            getStopButton().setEnabled(false);
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /*
    Method populateArray is used to make a random array to be sorted later.
     */
    public int[] populateArray()
    {
        Random random = new Random();
        int[] array = new int[400];
        for(int i = 0; i < 400; i++) {
            array[i] = random.nextInt(400) + 1;

        }
        return array;
    }

    public void returnToStartState()
    {
        if(++iterationCounter == 2)
        {
            getPauseButton().setEnabled(false);
            getPopulateArrayButton().setEnabled(true);
            getSortButton().setEnabled(false);
            getStopButton().setEnabled(false);
        }
    }

    public void setIterationCounter(int iterationCounter)
    {
        this.iterationCounter = iterationCounter;
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

    public SortPanel getSortPanelOne() {
        return sortPanelOne;
    }

    public SortPanel getSortPanelTwo() {
        return sortPanelTwo;
    }


    public JButton getPopulateArrayButton() {
        return populateArrayButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public JButton getSortButton() {
        return sortButton;
    }

    public JButton getPauseButton()
    {
        return pauseButton;
    }
}
