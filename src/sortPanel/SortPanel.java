package sortPanel;

import javax.swing.*;
import java.awt.*;

public class SortPanel extends JPanel
{
    private JButton pauseButton;

    private JComboBox<String> sortStyleComboBox;
    private String[] sortStyle = {"Ascending", "Descending"};

    private JComboBox<String> sortComboBox;
    private String[] sortOptions = {"Quick sort", "Bubble sort", "Mesh sort"};

    private JComboBox<String> sortingSpeedComboBox;
    private String[] sortingSpeed = {"Fast", "Medium", "Slow"};

    private SortAnimationPanel sortAnimation;

    private JPanel panelOne;
    private JPanel panelTwo;

    private int[] array;

    /*
    Initialises the SortPanel, adds required buttons, comboBoxes and panels to match the requierment
     */
    public SortPanel()
    {
        pauseButton = new JButton("Pause");
        pauseButton.setEnabled(false);

        sortComboBox = new JComboBox<>(sortOptions);
        sortStyleComboBox = new JComboBox<>(sortStyle);
        sortingSpeedComboBox = new JComboBox<>(sortingSpeed);

        panelOne = new JPanel();
        panelTwo = new JPanel();

        sortAnimation = new SortAnimationPanel();

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        panelOne.add(sortAnimation);

        panelTwo.add(sortComboBox);
        panelTwo.add(sortStyleComboBox);
        panelTwo.add(sortingSpeedComboBox);
        panelTwo.add(pauseButton);
        add(panelOne);
        add(panelTwo);
    }

    /*
    Sets the array to be used and initialises repainting of the SortAnimationPanel so it matches the array
     */
    public void setArray(int[] array)
    {
        this.array = array;
        sortAnimation.setArray(array);
    }

    public JButton getPauseButton() {
        return pauseButton;
    }
}
