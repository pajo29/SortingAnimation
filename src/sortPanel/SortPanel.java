package sortPanel;

import javax.swing.*;

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

    private int[] array;

    public SortPanel()
    {
        pauseButton = new JButton("Pause");
        pauseButton.setEnabled(false);

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
        add(panelOne);
        add(panelTwo);
    }

    public void setArray(int[] array)
    {
        this.array = array;

    }
}
