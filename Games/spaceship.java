import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


public class spaceship extends JFrame implements KeyListener, Runnable
{
    public static int x=100, y=300;
              public   static int r=40, k=40;
             public    static int a=40, b=80;
               public  static int i=40, j=120;
               Random randy = new Random ();
                static int counter=0;
    
    public spaceship ( )
    {
        Container mainWindow = getContentPane();
        ColorPanel view = new ColorPanel (Color.WHITE);
        mainWindow.add(view);
        
        addKeyListener(this);
        setSize(800,400);
        setVisible(true);
        
        
    }
     public void run ()
    {
        
        while (true)
        {
                
               
                r-=randy.nextInt(8)+1;
                a-=randy.nextInt(8)+1;
                i-=randy.nextInt(8)+1;
                if(r<0)
                {
                k=randy.nextInt(350);
                    r=800;
                }
                
                if(a<0)
                {
                 b=randy.nextInt(350);
                    a=800;
                }
                
                
                if(i<0)
                {
                 j=randy.nextInt(350);
                    i=800;
                }
                
            
               
               if(Math.abs(x-r)<60 && Math.abs(y-k)<20)
               {
                   JOptionPane.showMessageDialog(null,"OH NO, YOU'VE BEEN HIT", "GAME OVER",JOptionPane.WARNING_MESSAGE);
                   break;
                }
                
                 if(Math.abs(x-a)<60 && Math.abs(y-b)<20)
                {
                    JOptionPane.showMessageDialog(null,"OH NO, YOU'VE BEEN HIT", "GAME OVER",JOptionPane.WARNING_MESSAGE);
                   break;
                }
                
                 if(Math.abs(x-i)<60 && Math.abs(y-j)<20)
                {
                    JOptionPane.showMessageDialog(null,"OH NO, YOU'VE BEEN HIT", "GAME OVER",JOptionPane.WARNING_MESSAGE);
                   break;
                }
                
                repaint();
                
                
                
                counter++;
                
                if(counter == 5000)
                {
                    JOptionPane.showMessageDialog(null, "You Won! Congrats","SpaceShip",JOptionPane.PLAIN_MESSAGE);
                    break;
                }
                  
                
                try
                {
                    Thread.sleep(5);
                }catch (InterruptedException e) { }
                
                
        } 
        
    }
    
    public void keyPressed( KeyEvent e )
    {
        int c = e.getKeyCode();
        
            if( c == 38 )
            {
            if(y>30)
                y -= 25;
            }
            
            if( c == 40)
            {
                
                
                if(y<330)
                y += 25;
            }
                
                
                
        repaint();
    }
 
    
    public void keyReleased( KeyEvent e)
    {}
    
    public void keyTyped(KeyEvent e )
    {}
    
    public static void main ( String [] args )
    {
        
        Thread bounceThread = new Thread (new spaceship());
        bounceThread.start();
      
    }
    
        public class ColorPanel extends JPanel
        {
            public ColorPanel( Color backColor )
            {
                setBackground(backColor);
            }
            
            public void paintComponent(Graphics g)
            {
                g.setColor(Color.BLUE);
                g.fillOval(x+15,y-20, 50,40);
                g.setColor(Color.GRAY);
                g.fillRect(x,y,80,20);
                g.setColor(Color.BLACK); 
                g.fillOval(r,k,20,20);
                g.setColor(Color.RED);
                g.fillOval(a,b,20,20);
                g.setColor(Color.BLUE);
                g.fillOval(i,j,20,20);
                 
             
                
            }
            
        }
    }
    

      