package labo4;

import java.awt.*;

public class Side
{
    private Rectangle rectangle;

    public Side(int x, int y, int width, int height) throws NumberException
    {
        if(x<0||y<0||width<1||height<1)
        {
            String error="";
            if(x<0)error+=x+"\n";
            if(y<0)error+=y+"\n";
            if(width<1)error+=width+"\n";
            if(height<1)error+=height;

            throw new NumberException(error);
        }
        rectangle= new Rectangle(x,y,width,height);
    }

    public void draw(Graphics g)
    {
        g.drawRect(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
    }
}
