package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopulateButtonActionListener implements ActionListener
{

    /*
    PopulateButton action is to populate an array, send it to the sortPanels where the panel will be painted according to the
    array. It also enables/disables according to the requierment.
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        int[] array = MainFrame.getInstance().populateArray();
        MainFrame.getInstance().getSortPanelOne().setArray(array);
        MainFrame.getInstance().getSortPanelTwo().setArray(array);
        MainFrame.getInstance().getSortPanelOne().getPauseButton().setEnabled(true);
        MainFrame.getInstance().getSortPanelTwo().getPauseButton().setEnabled(true);
        MainFrame.getInstance().getPopulateArrayButton().setEnabled(false);
        MainFrame.getInstance().getSortButton().setEnabled(true);
        MainFrame.getInstance().getStopButton().setEnabled(true);
    }
}
