package labo5;

import javax.swing.*;
import java.awt.*;

public class StringPanel extends JPanel
{
    JLabel label;

    public StringPanel(String message)
    {
        super();
        label= new JLabel(message);
        this.setLayout(new FlowLayout());
        this.add(label);
    }
}
