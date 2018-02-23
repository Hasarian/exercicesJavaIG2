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

    public Snooker(int width,int height)
    {
        this.setLayout(new BorderLayout());
        ArrayList<Side> verticals= new ArrayList<Side>();
        verticalSides= Collections.synchronizedList(verticals);
        try
        {
            int sideWidth=10;
            verticalSides.add(new Side(100, 100,width,sideWidth ));
            verticalSides.add(new Side(100+width, 100,sideWidth,height));
            verticalSides.add(new Side(100, height+90,width,sideWidth));
            verticalSides.add(new Side(100, 100,sideWidth,height ));
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
