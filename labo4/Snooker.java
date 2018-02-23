package labo4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Snooker extends JPanel
{

    private List<Side> verticalSides;

    public Snooker()
    {
        this.setLayout(new BorderLayout());
        ArrayList<Side> verticals= new ArrayList<Side>();
        verticalSides= Collections.synchronizedList(verticals);
        try
        {
            verticalSides.add(new Side(100, 100, 300, 500));
        }catch(Labo4Exception laboExcept)
        {
            JOptionPane.showMessageDialog(null,laboExcept.getMsg(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        for (Side side:verticalSides) side.draw(g);
    }
}
