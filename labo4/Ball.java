package labo4;

import java.awt.*;

public class Ball
{
    private Rectangle rectangle;
    private Snooker snooker;

    public Ball(Snooker snooker,int x, int y, int sideLenght)
    {
        this.snooker=snooker;
        rectangle=new Rectangle(x,y,sideLenght,sideLenght);
    }

    public void draw(Graphics g)
    {
        g.fillOval(rectangle.x,rectangle.y, rectangle.width,rectangle.height);

    }
}
