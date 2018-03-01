package labo4;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Snooker extends JPanel
{
    private int totalPoints;
    private PointsMeter counter;
    public PointsMeter getCounter(){return counter;}
    public int getTotalPoints(){return  totalPoints;}
    public void addPoints(int points){totalPoints+=points;}
    private List<Side> verticalSides;
    public List<Side> getVerticalSides(){return  verticalSides;}
    private List<Side> horizontalSides;
    public List<Side> getHorizontalSides(){return  horizontalSides;}
    /*private Ball ball;
    public Ball getBall() { return ball; }*/
    private List<Ball> balls;
    public List<Ball> getBalls(){return balls;}
    private int width;
    private int height;
    public Snooker(int width,int height)
    {
        totalPoints=0;
        this.width=width;
        this.height=height;
        counter=new PointsMeter(this);
        ArrayList<Side> verticals= new ArrayList<Side>();
        verticalSides= Collections.synchronizedList(verticals);
        ArrayList<Side> horizontals= new ArrayList<Side>();
        horizontalSides= Collections.synchronizedList(horizontals);
        ArrayList<Ball> ballsArray=new ArrayList<Ball>();
        balls=Collections.synchronizedList(ballsArray);
        try
        {
            int sideWidth=10;
            horizontalSides.add(new Side(100, 100,width,sideWidth ));
            verticalSides.add(new Side(100+width, 100,sideWidth,height));
            horizontalSides.add(new Side(100, height+90,width,sideWidth));
            verticalSides.add(new Side(100, 100,sideWidth,height ));
            initObstacles();
        }catch(Labo4Exception laboExcept)
        {
            JOptionPane.showMessageDialog(null,laboExcept.getMsg(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        //addBall();
        ThreadMove thread=new ThreadMove(this);
        thread.start();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        for (Side side:verticalSides) side.draw(g);
        for(Side side:horizontalSides)side.draw(g);
        for (Ball ball:balls)
        {
            ball.draw(g);
        }

    }

    private void initObstacles() throws NumberException
    {
        addHorizontalObstacle(120,120,width/7,3,5);
        addVerticalObstacle(300,400,3,height/4,2);
    }
    private void addHorizontalObstacle(int x, int y, int width,int heigth, int value) throws NumberException
    {
        horizontalSides.add(new Side(x,y,width,heigth/2,value));
        horizontalSides.add(new Side(x,y+heigth/2,width,heigth/2,value));
        verticalSides.add(new Side(x,y,1,heigth-1,value*2));
        verticalSides.add(new Side(x+width,y,1,heigth-1,value*2));
    }
    private void addVerticalObstacle(int x, int y, int width, int height, int value)throws NumberException
    {
        verticalSides.add(new Side(x,y,width/2,height,value));
        verticalSides.add(new Side(x+(width/2),y,width/2,height,value));
        horizontalSides.add(new Side(x,y,width-1,1,value*2));
        horizontalSides.add(new Side(x,y+height,width-1,1,value*2));
    }
    public void addBall()
    {
        balls.add(new Ball(this,120,130,10));
    }
}
