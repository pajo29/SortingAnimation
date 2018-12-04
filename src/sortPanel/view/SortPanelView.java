package sortPanel.view;

import javax.swing.*;
import java.awt.*;

public class SortPanelView extends JPanel
{
    private JButton pauseButton;
    private JButton stopButton;

    private JComboBox<String> sortComboBox;
    private String[] sortOptions = {"Quick sort", "Bubble sort", "Mesh sort"};

    //private SortAnimationPanel sortAnimation;

    public SortPanelView()
    {
        pauseButton = new JButton("Pause");
        stopButton = new JButton("Stop");

        sortComboBox = new JComboBox<String>(sortOptions);

        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        panelOne.add(new Label());

        panelTwo.add(sortComboBox);
        panelTwo.add(pauseButton);
        panelTwo.add(stopButton);
        add(panelOne);
        add(panelTwo);
    }
}
