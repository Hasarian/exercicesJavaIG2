package labo4;

import java.awt.*;

public class Side
{
    private Rectangle rectangle;
    private int nbPoints;
    public int getNbPoints(){return nbPoints;}

    public Side(int x, int y, int width, int height,int nbPoints) throws NumberException
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
        this.nbPoints=nbPoints;
    }
    public Side(int x, int y, int width, int height) throws NumberException
    {
        this(x,y,width,height,0);
    }

    public void draw(Graphics g)
    {
        g.fillRect(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
    }
    public boolean collision(Ball collidedBall)
    {
        return rectangle.intersects(collidedBall.getRectangle());
    }
}
