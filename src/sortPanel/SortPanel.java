package sortPanel;

import javax.swing.*;
import java.awt.*;

public class SortPanel extends JPanel
{
    private JComboBox<String> sortStyleComboBox;
    private String[] sortStyle = {"Ascending", "Descending"};

    private JComboBox<String> sortComboBox;
    private String[] sortOptions = {"Quick sort", "Bubble sort", "Merge sort"};

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
        sortComboBox = new JComboBox<>(sortOptions);
        sortStyleComboBox = new JComboBox<>(sortStyle);
        sortingSpeedComboBox = new JComboBox<>(sortingSpeed);

        panelOne = new JPanel();
        panelTwo = new JPanel();

        sortAnimation = new SortAnimationPanel(this);

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        panelOne.add(sortAnimation);

        panelTwo.add(sortComboBox);
        panelTwo.add(sortStyleComboBox);
        panelTwo.add(sortingSpeedComboBox);
        add(panelOne);
        add(panelTwo);

    }

    /*
    Begins sorting and starts the animation
     */
    public void sort() throws InterruptedException
    {
        ArraySorter as = new ArraySorter(this);
        switch (sortingSpeedComboBox.getSelectedIndex())
        {
            case 0:
                as.setSleepTime(10);
                break;
            case 1:
                as.setSleepTime(50);
                break;
            case 2:
                as.setSleepTime(100);
                break;
        }
        switch (sortComboBox.getSelectedIndex())
        {
            case 0:
                if(sortStyleComboBox.getSelectedIndex() == 0)
                    as.quickSort(array, true);
                else
                    as.quickSort(array, false);
                break;
            case 1:
                if(sortStyleComboBox.getSelectedIndex() == 0)
                    as.bubbleSort(array, true);
                else
                    as.bubbleSort(array, false);
                break;
            case 2:
                if(sortStyleComboBox.getSelectedIndex() == 0)
                    as.mergeSort(array, true);
                else
                    as.mergeSort(array, false);
                break;
        }
    }

    /*
    Sets the array to be used and initialises repainting of the SortAnimationPanel so it matches the array
     */
    public void setArray(int[] array)
    {
        this.array = array;
        sortAnimation.setArray(array);
    }

    public SortAnimationPanel getSortAnimation()
    {
        return sortAnimation;
    }

    public int[] getArray()
    {
        return array;
    }
}
