
public class Property
{
    private String name;
    private int owner;
    private int spaceNum, groupNum;
    private int cost, rent, rent1, rent2, rent3, rent4, rent5, houseCost,hotelCost, Mortgage;
    private boolean house, house2, house3, house4, hotel, mortgage, complete,owned,railr2, railr3, railr4;
    private int rail2, rail3, rail4;

    
    public Property(String n,int sn, int gn, int c, int r, int r1, int r2, int r3, int r4, int r5, int hc, int htc, int M)
    {
        name = n;
        owner = 10;
        spaceNum = sn;
        groupNum = gn;
        cost = c;
        rent = r;
        rent1 = r1;
        rent2 = r2;
        rent3 = r3;
        rent4 = r4;
        rent5 = r5;
        houseCost = hc;
        hotelCost = htc;
        Mortgage = M;
        house = false;
        house2 = false;
        house3 = false;
        house4 = false;
        hotel = false;
        mortgage = false;
        complete = false;
        owned = false;
        
    }
    
    public Property(String n, int sn, int gn, int c, int r, int rr2, int rr3, int rr4, int M)
    {
        name = n;
        owner = 10;
        spaceNum = sn;
        groupNum = gn;
        cost = c;
        rent = r;
        rail2 = rr2;
        rail3 = rr3;
        rail4 = rr4;
        Mortgage = M;
        railr2 = false;
        railr3 = false;
        railr4 = false;
        owned = false;
        complete = false;
        mortgage = false;
        
        
    }
    
    public Property(String n,  int sn, int gn, int c,  int M)
    {
        name = n;
        spaceNum = sn;
        groupNum = gn;
        cost = c;
        owner = 10;
        Mortgage = M;
        owned = false;
        complete = false;
        mortgage = false;
    }
    
    public void changeHouse1()
    {
        house = true;
    }
    public void changeHouse2()
    {
        house2 = true;
    }
    public void changeHouse3()
    {
        house3 = true;
    }
    public void changeHouse4()
    {
        house4 = true;
    }
    
    public void changeMortgage()
    {
        mortgage = true;
    }
    public void increaseRent(int e)
    {
        rent+=e;
    }
    public void changeOwned()
    {
        owned = true;
    }
    public void changeHotel()
    {
        hotel = true;
    }
    public void changeOwner(int s)
    {
        owner = s;
    }
    
    
    public int getOwner()
    {
        return owner;
    }
    
    public String toString()
    {
        return name + "\n" + cost + "\n" + "Owner: " + owner;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getSpace()
    {
        return spaceNum;
    }
    
    public int getGroup()
    {
        return groupNum;
    }
    
    public int getCost()
    {
        return cost;
    }
    
    public int getRent()
    {
        return rent;
    }
    
    public int getMortgage()
    {
        return Mortgage;
    }
    
    public int getRent1()
    {
        return rent1;
    }
    
     public int getRent2()
    {
        return rent2;
    }
    
     public int getRent3()
    {
        return rent3;
    }
    
     public int getRent4()
    {
        return rent4;
    }
    
     public int getRent5()
    {
        return rent5;
    }
    
    public int getHouseCost()
    {
        return houseCost;
    }
    
    public int getHotelCost()
    {
        return hotelCost;
    }
    
    public boolean getHouse()
    {
        return house;
    }
    
    public boolean getHouse2()
    {
        return house2;
    }
    
    public boolean getHouse3()
    {
        return house3;
    }
    
    public boolean getHouse4()
    {
        return house4;
    }
    
    public boolean getHotel()
    {
        return hotel;
    }
    
    public boolean getmortgage()
    {
        return mortgage;
    }
    
    public boolean getComplete()
    {
        return complete;
    }
    
    public boolean getOwned()
    {
        return owned;
    }
    
    public boolean getRailr2()
    {
        return railr2;
    }
    
    public boolean getRailr3()
    {
        return railr3;
    }
    
    public boolean getRailr4()
    {
        return railr4;
    }
    
    public int getRail2()
    {
        return rail2;
    }
    
    public int getRail3()
    {
        return rail3;
    }
    
    public int getRail4()
    {
        return rail4;
    }
       

    
    
}
