package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseActionListener implements ActionListener
{



    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
//        MainFrame.getInstance().getSortPanelOne().getSortAnimation().pause();
//        MainFrame.getInstance().getSortPanelTwo().getSortAnimation().pause();
        synchronized (MainFrame.getInstance().getSortPanelOne().getSortAnimation())
        {
            try
            {
                MainFrame.getInstance().getSortPanelOne().getSortAnimation().getThread().wait(5000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

}
