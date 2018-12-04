package sortPanel;

import javax.swing.*;
import java.awt.*;

public class SortAnimationPanel extends JPanel implements Runnable
{

    private int[] array;

    public SortAnimationPanel()
    {
        setPreferredSize(new Dimension(400, 400));
        setMinimumSize(new Dimension(400, 400));
        setMaximumSize(new Dimension(400, 400));

    }

    @Override
    public void paint(Graphics g)
    {
        super.paintComponents(g);

        for(int i = 0; i < 400; i ++)
        g.drawLine(i, 400, i,  400-array[0]);

    }

    @Override
    public void run()
    {

    }
}
