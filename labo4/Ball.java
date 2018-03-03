package labo4;

import java.awt.*;
import java.util.Random;

public class Ball
{
    private static final Color[] colors={Color.BLACK,Color.DARK_GRAY,Color.GRAY,Color.BLUE,Color.GREEN,Color.YELLOW,Color.white};
    private Rectangle rectangle;
    public Rectangle getRectangle(){return rectangle;}
    private Snooker snooker;
    private int deltaX;
    private int deltaY;
    private int colorReference;
    private boolean toDelete;
    public boolean toDelete(){return toDelete;}

    public Ball(Snooker snooker,int x, int y, int sideLenght)
    {
        this.snooker=snooker;
        rectangle=new Rectangle(x,y,sideLenght,sideLenght);
        colorReference=0;
        deltaX= (int)Math.random()*100+1;
        deltaY= (int) Math.random()*100+1;
        toDelete=false;

    }

    public void draw(Graphics g)
    {
        g.setColor(colors[colorReference]);
        g.fillOval(rectangle.x,rectangle.y, rectangle.width,rectangle.height);

    }
    public void move()
    {
        if(snooker.getTrap().disappear(this)) toDelete=true;
        else {
            rectangle.add(rectangle.x += deltaX, rectangle.y += deltaY);
            for (Side side : snooker.getVerticalSides()) {
                if (side.collision(this)) {
                    deltaX *= -1;
                    snooker.addPoints(side.getNbPoints());
                    colorChange();
                }
            }
            for (Side side : snooker.getHorizontalSides()) {
                if (side.collision(this)) {
                    deltaY *= -1;
                    snooker.addPoints(side.getNbPoints());
                    colorChange();
                }
            }
            for (Ball ball : snooker.getBalls()) {
                if (ball != this) {
                    if (rectangle.intersects(ball.rectangle)) {
                        int temp = deltaX * 2;
                        deltaX = deltaY / 2;
                        deltaY = temp;
                    }
                }
            }
        }
    }
    public void colorChange()
    {
        if(colorReference<colors.length-1)colorReference++;
        else colorReference=0;
    }
}
