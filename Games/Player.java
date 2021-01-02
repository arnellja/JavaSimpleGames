
public class Player
{
    private String name;
    private int money,space;
    private Property [] properties = new Property[40];
    private boolean jail;
    private int PropertyNum;
    private boolean OutOfJailFreeCard;
    public Player( String n)
    {
        name = n;
        space = 0;
        money = 800;
        Property [] properties = new Property[20];
        PropertyNum = 0;
        jail = false;
        OutOfJailFreeCard = false;
    }
    
    public void getOutOfJailFreeCard()
    {
        OutOfJailFreeCard = true;
    }
    
    public void useOutOfJailFreeCard()
    {
        OutOfJailFreeCard = false;
    }
    
    public boolean checkOutOfJailFreeCard()
    {
        return OutOfJailFreeCard;
    }
    
    public void addPropertyCount()
    {
        PropertyNum++;
    }
    
    public void addProperty(Property P)
    {
        properties[PropertyNum] = P;
    }
    public boolean getJail()
    {
        return jail;
    }
    public Property getProperties(int e)
    {
        return properties[e];
    }
    public int getSpace()
    {
        return space;
    }
    
    public void resetSpace(int e)
    {
        space = e;
    }
    public void changeSpace(int e)
    {
        space+=e;
    }
    
    public void addMoney(int e)
    {
        money+=e;
    }
    
    public void subMoney(int e)
    {
        money-=e;
        
    }
    
    public void getJailed()
    {
        jail = true;
    }
    
    public void changeBackJail()
    {
        jail = false;
    }
    
    public int getMoney()
    {
        return money;
    }
    
    public String getName()
    {
        return name;
    }
}
