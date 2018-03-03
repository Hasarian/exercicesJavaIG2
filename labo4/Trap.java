package labo4;

import java.awt.*;

public class Trap {
    private Rectangle rectangle;

    public Trap(int x, int y, int diameter)
    {
        rectangle= new Rectangle(x,y,diameter,diameter);
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.black);
        g.fillOval(rectangle.x,rectangle.y,rectangle.width,rectangle.height);
    }
    public boolean disappear(Ball ball)
    {
        return ball.getRectangle().intersects(this.rectangle);
    }
}
