import java.util.*;
import javax.swing.*;
import java.awt.*;
public class MSquare extends JFrame
{
    private static Button button;
    private static boolean mined;
    private static int number;
    private static boolean flipped;
    public MSquare(Button b, boolean m, int n, boolean f)
    {
        button = b;
        mined = m;
        number = n;
        flipped = f;
    }
    
    public static Button getButton()
    {
        return button;
    }
    
    public static boolean getMined()
    {
        return mined;
    }
    
    public static int getNumber()
    {
        return number;
    }
    
    public static void setNumber(int i)
    {
        number = i;
    }
    
    public static boolean getFlipped()
    {
        return flipped;
    }
}
