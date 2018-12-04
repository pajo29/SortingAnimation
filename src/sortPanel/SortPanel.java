package sortPanel;

import javax.swing.*;
import java.awt.*;

public class SortPanel extends JPanel
{
    private JButton pauseButton;
    private JButton stopButton;

    private JComboBox<String> sortStyleComboBox;
    private String[] sortStyle = {"Forwad", "Backward"};

    private JComboBox<String> sortComboBox;
    private String[] sortOptions = {"Quick sort", "Bubble sort", "Mesh sort"};

    private JComboBox<String> sortingSpeedComboBox;
    private String[] sortingSpeed = {"100ms", "300ms", "500ms", "1000ms"};

    private SortAnimationPanel sortAnimation;

    public SortPanel()
    {
        pauseButton = new JButton("Pause");
        pauseButton.setEnabled(false);
        stopButton = new JButton("Stop");
        stopButton.setEnabled(false);

        sortComboBox = new JComboBox<String>(sortOptions);
        sortStyleComboBox = new JComboBox<String>(sortStyle);
        sortingSpeedComboBox = new JComboBox<String>(sortingSpeed);

        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();

        sortAnimation = new SortAnimationPanel();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        panelOne.add(sortAnimation);

        panelTwo.add(sortComboBox);
        panelTwo.add(sortStyleComboBox);
        panelTwo.add(sortingSpeedComboBox);
        panelTwo.add(pauseButton);
        panelTwo.add(stopButton);
        add(panelOne);
        add(panelTwo);
    }
}
