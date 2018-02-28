package labo4;

import java.awt.*;

public class Ball
{
    private Rectangle rectangle;
    public Rectangle getRectangle(){return rectangle;}
    private Snooker snooker;
    private int deltaX=5;
    private int deltaY=5;


    public Ball(Snooker snooker,int x, int y, int sideLenght)
    {
        this.snooker=snooker;
        rectangle=new Rectangle(x,y,sideLenght,sideLenght);
    }

    public void draw(Graphics g)
    {
        g.fillOval(rectangle.x,rectangle.y, rectangle.width,rectangle.height);

    }
    public void move()
    {
        rectangle.add(rectangle.x+=deltaX,rectangle.y+=deltaY);
        for(Side side:snooker.getVerticalSides())
        {
            if(side.collision(this))
            {
                deltaX*=-1;
                snooker.addPoints(side.getNbPoints());
            }
        }
        for (Side side:snooker.getHorizontalSides())
        {
            if (side.collision(this))
            {
                deltaY*=-1;
                snooker.addPoints(side.getNbPoints());
            }
        }
    }
}
