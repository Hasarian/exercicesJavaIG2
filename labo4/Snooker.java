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
    public int getTotalPoints(){return  totalPoints;}
    public void addPoints(int points){totalPoints+=points;}
    private List<Side> verticalSides;
    public List<Side> getVerticalSides(){return  verticalSides;}
    private List<Side> horizontalSides;
    public List<Side> getHorizontalSides(){return  horizontalSides;}
    private Ball ball;
    public Ball getBall() { return ball; }
    private int width;
    private int height;
    public Snooker(int width,int height)
    {
        totalPoints=0;
        this.width=width;
        this.height=height;
        this.setLayout(new BorderLayout());
        ArrayList<Side> verticals= new ArrayList<Side>();
        verticalSides= Collections.synchronizedList(verticals);
        ArrayList<Side> horizontals= new ArrayList<Side>();
        horizontalSides= Collections.synchronizedList(horizontals);
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
        ball=new Ball(this,300,300,15);
        ThreadMove thread=new ThreadMove(this);
        thread.start();
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        for (Side side:verticalSides) side.draw(g);
        for(Side side:horizontalSides)side.draw(g);
        ball.draw(g);
    }

    private void initObstacles() throws NumberException
    {
        addHorizontalObstacle(120,120,width/7,3,5);
        addVerticalObstacle(300,400,3,height/4,2);
    }
    private void addHorizontalObstacle(int x, int y, int width,int heigth, int value) throws NumberException
    {
        horizontalSides.add(new Side(x,y,width,heigth,value));
        verticalSides.add(new Side(x,y,1,heigth,value*2));
        verticalSides.add(new Side(x+width,y,1,heigth,value*2));
    }
    private void addVerticalObstacle(int x, int y, int width, int height, int value)throws NumberException
    {
        verticalSides.add(new Side(x,y,width,height,value));
        horizontalSides.add(new Side(x,y,width,1,value*2));
        horizontalSides.add(new Side(x,y+width,width,1,value*2));
    }
}
