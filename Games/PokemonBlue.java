import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 Trial 1 to create a pokemon game in java.
 */
public class PokemonBlue extends JFrame implements KeyListener, Runnable
{
    static Scanner reader = new Scanner(System.in);
    static Scanner sReader = new Scanner(System.in);
    
    public static int x = 100, y = 100;
    public static int z1 = 150, z2 = 150;
    public static String lastKey = "front";
    public PokemonBlue ()
    {
        Container mainWindow = getContentPane();
        ColorPanel view = new ColorPanel (Color.WHITE);
        mainWindow.add(view);
        
        addKeyListener(this);
        setSize(800, 400);
        setVisible(true);
    }
    
    public void run ()
    {
        while (true){
        
            repaint();
            try
                    {
                        Thread.sleep(5);
                    }catch (InterruptedException e) { }
            }
    }
    
    public void keyPressed ( KeyEvent event)
    {
        int code = event.getKeyCode();
        
            if (code == 38)
            {
                y -= 25;
                lastKey = "front";
            }
            if (code == 40)
            {
                y += 25;
                lastKey = "back";
            }
            if (code == 39)
            {
                x += 25;
                lastKey = "right";
            }
            if (code == 37)
            {
                x -= 25;
                lastKey = "left";
            }
            
    }
     public void keyReleased( KeyEvent e)
    {}
    
    public void keyTyped(KeyEvent e )
    {}
    
    public static void main ( String [] args )
    {
        
        Thread thread = new Thread (new PokemonBlue());
        thread.start();
      
    }
    
    public class ColorPanel extends JPanel
        {
            public ColorPanel( Color backColor )
            {
                setBackground(backColor);
            }
            
            public void paintComponent(Graphics g)
            {
              
                
                if (lastKey == "front"){
                g.setColor(Color.BLUE);
                g.fillOval(x, y, 20, 50);
              }
              if (lastKey == "back"){
                g.setColor(Color.RED);
                g.fillOval(x, y, 20, 50);
              }
              if (lastKey == "right"){
                g.setColor(Color.BLUE);
                g.fillOval(x, y, 20, 50);
                g.setColor(Color.RED);
                g.fillOval(x+15, y, 5, 50);
              }
              if (lastKey == "left"){
                g.setColor(Color.RED);
                g.fillOval(x, y, 5, 50);
                g.setColor(Color.BLUE);
                g.fillOval(x, y, 20, 50);
              }
              /*if (lastKey = "back"){
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
              if (lastKey = "right"){
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
              if (lastKey = "left"){
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
              } */
            }
            
        }
}
