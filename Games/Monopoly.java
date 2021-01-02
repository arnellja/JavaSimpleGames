
//building houses and hotels, checking for houses or hotels, changing rent;

import java.util.*;
import java.text.*;
import java.lang.*;

public class Monopoly
{
    static Scanner reader = new Scanner(System.in);
    static Scanner sreader = new Scanner(System.in);
    static Random randy = new Random();
    static Player [] players;
    static Property [] board = new Property[40];
    
    static String yn;
    
    public static void main (String [] args)
    {
       int u;
       int m;
       String n1, n2, n3, n4;
        p("Welcome to Monopoly!");
        p("Enter the number of players.");
        m = reader.nextInt();
        String str1;
        players = new Player[m];
        
        
       for(int x = 0; x<m; x++)
       {
           p("Enter player " + x + "'s name");
           str1 = sreader.nextLine();
           players[x] = new Player(str1);
        }
        String str;
        
        String yn;
       
        int NOU=28;
        int e =0;
        int r;
        setBoard();
        while(NOU!=0)
        {
           for(int x = 0; x<m; x++)
           {
             
               if(players[x].getJail() == false)
               {
                p("It is "+ players[x].getName() +"'s turn");
                p("Enter 1 to roll dice.");
                r = reader.nextInt();
                   e = roleDice();
               p("\n");
               p("You rolled a " +e);
               p("\n");
               players[x].changeSpace(e);
               if(players[x].getSpace()>=40)
               {
               players[x].resetSpace(players[x].getSpace() -40);
               players[x].addMoney(200);
             }
               if(!(players[x].getSpace() == 0 || players[x].getSpace() == 2 ||players[x].getSpace() == 4 || players[x].getSpace() == 7 ||players[x].getSpace() == 10 || players[x].getSpace() == 17 ||players[x].getSpace() == 20 || players[x].getSpace() == 22 ||players[x].getSpace() == 30 || players[x].getSpace() == 33 ||players[x].getSpace() == 36 || players[x].getSpace() == 38))
               goodProperty(x,NOU);
               else if(players[x].getSpace()== 0)
               {
                   p("Pass Go");
                }
               else if (players[x].getSpace() == 2)
               {
                   p("Community Chest");
                   communityChest(x,players[x],NOU);
                }
               else if (players[x].getSpace() == 4)
               {
                   incomeTax(players[x]);
                }
               else if(players[x].getSpace()== 7)
               {
                   p("Chance");
                   chance(x,players[x],NOU);
                }
               else if (players[x].getSpace() == 10)
               {
                   p("Visiting Jail");
                }
               else if (players[x].getSpace() == 17)
               {
                   p("Community Chest");
                   communityChest(x,players[x],NOU);
                }
               else if(players[x].getSpace()== 20)
               {
                   p("Free Parking");
                }
               else if (players[x].getSpace() == 22)
               {
                   p("Chance"); 
                   chance(x,players[x],NOU);
                }
               else if (players[x].getSpace() == 30)
               {
                   goToJail(players[x]);
                   if(players[x].checkOutOfJailFreeCard() == false)
                   r = -1;
                }
               else if(players[x].getSpace()== 33)
               {
                   p("Community Chest");
                   communityChest(x,players[x],NOU);
                }
               else if (players[x].getSpace() == 36)
               {
                   p("Chance");
                   chance(x,players[x],NOU);
                }
               else if (players[x].getSpace() == 38)
               {
                   luxoryTax(players[x]);
                }
               
             
                while(r!=-1)
                {
                    p("\n\n\n\nEnter the action you desire.");
                    p("1. Display Properties\n2. Display Funds\n3. Build house\n4. Build hotel\n5. Mortgage an estate");
                    p("-1. End turn");
                    p("100. End game");
                    r= reader.nextInt();
                    if(r == 1)
                    {
                        for(int z=0; z<40; z++)
                        {
                            if(players[x].getProperties(z) != null)
                            System.out.println(players[x].getProperties(z));
                            else
                            break;
                        }
                    }
                    else if (r==2)
                    {
                        System.out.println("$"+players[x].getMoney());
                    }
                    else if (r==3)
                    {
                       p("Enter the name of the estate you want to build a house on.");
                       yn = sreader.nextLine();
                       for(int q = 0; q<40; q++)
                       {
                           if(players[x].getProperties(q).getName().toLowerCase().equals(yn.toLowerCase()))
                           {
                               if(players[x].getProperties(q).getComplete())
                               {
                                   if(players[x].getProperties(q).getHouseCost() < players[x].getMoney())
                                   {
                                       if(checkHouse(players[x].getProperties(q),players[x]))
                                       {
                                           p("Congratulations, you have built a house on " + players[x].getProperties(q).getName());
                                           if(players[x].getProperties(q).getHouse() == false)
                                           {
                                               players[x].getProperties(q).increaseRent(players[x].getProperties(q).getRent1() - players[x].getProperties(q).getRent());
                                            }
                                            else if(players[x].getProperties(q).getHouse2() == false)
                                            {
                                                players[x].getProperties(q).increaseRent(players[x].getProperties(q).getRent2() - players[x].getProperties(q).getRent1());
                                            }
                                            else if(players[x].getProperties(q).getHouse3() == false)
                                            {
                                                players[x].getProperties(q).increaseRent(players[x].getProperties(q).getRent3() - players[x].getProperties(q).getRent2());
                                            }
                                            else if(players[x].getProperties(q).getHouse4() == false)
                                            {
                                                players[x].getProperties(q).increaseRent(players[x].getProperties(q).getRent4() - players[x].getProperties(q).getRent3());
                                            }
                                        }
                                    }
                                    else
                                    p("You do not have enough money to build a house");
                                }
                                else
                                {
                                    p("You do not own all necessary estates to build a house.");
                                }
                                break;
                            }
                        }
                    }
                    else if (r==4)
                    {
                     p("Enter the name of the estate you want to build a hotel on.");
                       yn = sreader.nextLine();
                       for(int q = 0; q<40; q++)
                       {
                           if(players[x].getProperties(q).getName().toLowerCase().equals(yn.toLowerCase()))
                           {
                               if(players[x].getProperties(q).getHouse4())
                               {
                                   if(players[x].getProperties(q).getHotelCost()<players[x].getMoney())
                                   {
                                       p("Congrats, you have built a hotel on "+ players[x].getProperties(q).getName());
                                       players[x].getProperties(q).changeHotel();
                                       players[x].getProperties(q).increaseRent(players[x].getProperties(q).getRent5() - players[x].getProperties(q).getRent4());
                                    }
                                   else
                                   p("You do not have enough money to build a hotel.");
                                }
                                else
                                {
                                    p("You have not previously built enough houses.");
                                }
                                break;
                            }
                        }
                    }
                    else if (r==5)
                    {
                       p("Enter the name of the estate you want to take a mortgage on.");
                       yn = sreader.nextLine();
                       for(int q = 0; q<40; q++)
                       {
                           if(players[x].getProperties(q).getName().toLowerCase().equals(yn.toLowerCase()))
                           {
                                players[x].addMoney(players[x].getProperties(q).getMortgage());
                                players[x].getProperties(q).changeMortgage();
                                p("You have taken a mortgage out on "+ players[x].getProperties(q).getName());
                                break;
                            }
                        } 
                    }
                    else if(r==100)
                    {
                        endGame();
                        break;
                    }
                    else
                    break;
                }
               r=1;
            }
             players[x].changeBackJail();  
               
            }
        }
        p("All properties are owned.");
        endGame();
        
    }
    
    public static void p(String s)
    {
        System.out.println(s);
    }
    
    public static int roleDice()
    {
        return randy.nextInt(10)+2;
    }
    
    public static void setBoard()
    {
        board[0] = new Property("Pass Go", 1, 0, 0,0,0,0,0,0,0,0,0,0);
        board[2] = new Property("Community Chest", 3, 0, 0,0,0,0,0,0,0,0,0,0);
        board[4] = new Property("Income Tax", 5, 0, 0,0,0,0,0,0,0,0,0,0);
        board[7] = new Property("Chance", 8, 0, 0,0,0,0,0,0,0,0,0,0);
        board[10] = new Property("Jail", 11, 0, 0,0,0,0,0,0,0,0,0,0);
        board[17] = new Property("Community Chest", 18, 0, 0,0,0,0,0,0,0,0,0,0);
        board[20] = new Property("Free Parking", 21, 0, 0,0,0,0,0,0,0,0,0,0);
        board[22] = new Property("Chance", 23, 0, 0,0,0,0,0,0,0,0,0,0);
        board[30] = new Property("Go To Jail!", 31, 0, 0,0,0,0,0,0,0,0,0,0);
        board[33] = new Property("Community Chest", 34, 0, 0,0,0,0,0,0,0,0,0,0);
        board[36] = new Property("Chance", 37, 0, 0,0,0,0,0,0,0,0,0,0);
        board[38] = new Property("Luxory Tax", 39, 0, 0,0,0,0,0,0,0,0,0,0);
        
        board[1] = new Property("Mediterranean Avenue", 2, 1, 60, 2,10,30,90,160,250,50,50,30);
        board[3] = new Property("Baltic Avenue", 4, 1, 60, 4, 20, 60, 180, 320, 450, 50,50,30);
        
        board[5] = new Property("Reading Railroad", 6, 2, 200, 25,50,100,200,100);
        board[6] = new Property("Oriental Avenue", 7, 3, 100, 6, 30,90, 270, 400,550,50,50,50);
        board[8] = new Property("Vermont Avenue", 9,3,100,6,30,90,270,400,550,50,50,50);
        board[9] = new Property("Conneticut Avenue", 10, 3, 120, 8, 40,100,300,450,600,50,50,60);
        board[11] = new Property("St.Charles Place", 12, 4, 140, 10, 50, 150,450,625,750,100,100,70);
        board[12] = new Property("Electric Company", 13, 5, 150, 75);
        board[13] = new Property("States Avenue", 14, 4, 140, 10,50,150,450,625,750,100,100,70);
        board[14] = new Property("Virginia Avenue", 15, 4, 160, 12,60,180,500,700,900,100,100,80);
        board[15] = new Property("Pennsylvania Railroad", 16, 2, 200,25,50,100,200,100);
        board[16] = new Property("St.James Place", 17, 6, 180, 14,70,200,550,750,950,100,100,90);
        board[18] = new Property("Tennessee Avenue", 19,6,180,14,70,200,550,750,950,100,100,90);
        board[19] = new Property("New York Avenue", 20,6, 200, 16,80,220,600,800,1000,100,100,100);
        board[21] = new Property("Kentucky Avenue", 22,7,220,18,90,250,700,875,1050,150,150,110);
        board[23] = new Property("Indiana Avenue", 24, 7,220,18,90,250,700,875,1050,150,150,110);
        board[24] = new Property("Illinois Avenue", 25, 7,240,20,100,300,750,925,1100,150,150,120);
        board[25] = new Property("B. & O. Railroad",26, 2, 200,25,50,100,200,100);
        board[26] = new Property("Atlantic Avenue", 27, 8, 260,22,110,330,800,975,1150,150,150,130);
        board[27] = new Property("Ventnor Avenue", 28, 8, 260, 22, 110,330,800,975,1150,150,150,130);
        board[28] = new Property("Water Works", 29,5, 150,75);
        board[29] = new Property("Marvin Gardens", 30,8,280,24,120,360,850,1025,1200,150,150,140);
        board[31] = new Property("Pacific Avenue", 32,9,300,26,130,390,900,1100,1275,200,200,150);
        board[32] = new Property("North Carolina Avenue", 33,9,300,26,130,390,900,1100,1275,200,200,150);
        board[34] = new Property("Pennsyvania Avenue", 35,9,320,28,150,450,1000,1200,1400,200,200,160);
        board[35] = new Property("Short Line Railroad", 36, 2, 200,25,50,100,200,100);
        board[37] = new Property("Park Place",38,10,350,35,175,500,1100,1300,1500,200,200,175);
        board[39] = new Property("Boardwalk",40,10,400,50,200,600,1400,1700,2000,200,200,200);
        
    }
    
    public static void goodProperty(int x,int NOU)
    {
        System.out.println(board[players[x].getSpace()]);
                if(board[players[x].getSpace()].getOwned())
                {
                    p("That space is owned by " + players[board[players[x].getSpace()].getOwner()].getName());
                    p("You owe $" + board[players[x].getSpace()].getRent());
                    players[board[players[x].getSpace()].getOwner()].addMoney(board[players[x].getSpace()].getRent());
                    players[x].subMoney(board[players[x].getSpace()].getRent());
                }
                else if(board[players[x].getSpace()].getOwned() == false)
                {
                   p("That space is not owned, would you like to purchase?");
                   p("The cost is $"+board[players[x].getSpace()].getCost());
                   yn = sreader.nextLine();
                   if(yn.toLowerCase().equals( "yes") || yn.toLowerCase().equals ("y"))
                   {
                       if(players[x].getMoney() >= board[players[x].getSpace()].getCost())
                       {
                           p("Congrats, you now own " + board[players[x].getSpace()].getName());
                           players[x].subMoney(board[players[x].getSpace()].getCost());
                           board[players[x].getSpace()].changeOwned();
                           board[players[x].getSpace()].changeOwner(x);
                           NOU-=1;
                           players[x].addProperty(board[players[x].getSpace()]);
                           players[x].addPropertyCount();
                        }
                        else
                        {
                            p("Sorry, you don't have sufficient funds to make that purchase.");
                        }
                    }
                    else
                    {
                        p("No purchase made");
                    }
                }
    }
    
    public static boolean checkOwnership(Property p, Player x)
    {
        if(players[p.getOwner()].getName().equals(x.getName()))
        return true;
        else
        return false;
    }
    
    public static boolean checkHotel(Property p, Player x)
    {
        if(p.getHouse4() && p.getComplete() && x.getMoney() >= p.getHotelCost() && checkOwnership(p,x))
        {
            return true;
        }
        else
        return false;
    }
    
    public static boolean checkHouse(Property p, Player x)
    {
        if(p.getComplete() && checkOwnership(p,x) && x.getMoney()>=p.getCost())
        {
            if(p.getHouse())
            {
                return checkHouse2(p,x);
            }
            else 
            p.changeHouse1();
            return true;
        }
        else
        return false;
        
    }
    
    
    public static boolean checkHouse2(Property p, Player x)
    {
        if(p.getHouse2())
        return checkHouse3(p,x);
        else 
        {
            p.changeHouse2();
            return true;
        
       }
    }
    
    public static boolean checkHouse3(Property p,Player x)
    {
        if(p.getHouse3())
        return checkHouse4(p,x);
        else 
        {
        p.changeHouse3();
        return true;
        
       }
    }
    
    public static boolean checkHouse4(Property p, Player x)
    {
        return true;
    }
    
    
    public static void communityChest(int y, Player x, int NOU)
    {
      int e = randy.nextInt(14)+1;
      if(e==1)
      {
          goToJail(x);
        }
      else if(e==2)
      {
         p("Advance to GO");
          x.resetSpace(0);
          x.addMoney(200); 
        }
      else if(e==3)
      {
          p("Grand Opera Opening, collect $50 from each player");
          x.addMoney(200);
          for(int q = 0; q<4; q++)
          {
              players[q].subMoney(50);
            }
        }
      else if(e==4)
      {
          p("Income Tax Refund, Collect $20");
          x.addMoney(20);
        }
      else if(e==5)
      {
          p("Get out of Jail Free Card.");
          x.getOutOfJailFreeCard();
        }
      else if(e==6)
      {
          p("Life Insurance Matures, collect $100");
          x.addMoney(100);
        }
      else if(e == 7)
      {
          p("Pay school tax of $150");
          x.subMoney(150);
        }
      else if(e == 8)
      {
          p("You inherit $100");
          x.addMoney(100);
        }
      else if(e == 9)
      {
          p("You win second prize in a beauty contest, collect $10");
          x.addMoney(10);
        }
      else if(e == 10)
      {
          p("Bank error in your favor, collect $200");
          x.addMoney(200);
        }
      else if(e ==11)
      {
          p("New Child, pay hospital $100");
          x.subMoney(100);
        }
      else if(e ==12)
      {
          p("Christmas funds mature");
          x.addMoney(100);
        }
      else if(e == 13)
      {
          p("From the sale of a stock you recieve $45");
          x.addMoney(45);
        }
      else if(e==14)
      {
        p("Collect $25 for officiating a wedding");
        x.addMoney(25);
        }
      else if(e==15)
      {
          p("Broken leg, pay the doctor $50");
          x.subMoney(50);
        }
      
    }
    
    public static void chance(int y,Player x, int NOU)
    {
        int e = randy.nextInt(11)+1;
      if(e==1)
      {p("Take a walk on the boardwalk");
        x.resetSpace(39);
        goodProperty(y,NOU);
        
      }
      else if(e==2)
      {
          p("Go back 3 spaces");
          x.resetSpace(x.getSpace()-3);
          if(x.getSpace() == 4)
          incomeTax(x);
          else if(x.getSpace() == 33)
          communityChest(y,x,NOU);
          else
          goodProperty(y,NOU);
          
        }
      else if(e==3)
      {
          p("Advance to GO");
          x.resetSpace(0);
          x.addMoney(200);
        }
      else if(e==4)
      {
          p("Advance to Illinois Avenue");
          x.resetSpace(24);
          goodProperty(y,NOU);
        }
      else if(e==5)
      {
          p("Pay the poor tax of $15");
          x.subMoney(15);
          
        }
      else if(e==6)
      {
          p("Bank pays you dividend of $50");
          x.addMoney(50);
        }
      else if(e == 7)
      {
         p("Advance to St. Charles Place, collect $200 if you pass go.");
          if(x.getSpace() > 11)
          {
          x.addMoney(200);
        }
          x.resetSpace(11);
          goodProperty(y,NOU);
        }
      else if(e == 8)
      {
          p("You are elected Chairman of the Board, pay everyone $50 each");
          x.subMoney(200);
          for(int q = 0; q<4; q++)
          {
              players[q].addMoney(50);
            }
        }
      else if(e == 9)
      {
          p("Your building and loan matures, collect $150");
          x.addMoney(150);
          
        }
      else if(e == 10)
      {
          p("Get out of Jail Free Card.");
          x.getOutOfJailFreeCard();
        }
      else if(e ==11)
      {
          p("Advance to Reading Railroad, collect $200 if you pass go.");
          if(x.getSpace() > 5)
          {
          x.addMoney(200);
        }
          x.resetSpace(5);
          goodProperty(y,NOU);
        }
      
      else if(e==12)
      {goToJail(x);}
      
    }
    
    public static void incomeTax(Player x)
    {
        int e = x.getMoney();
        double b = ((double)(.1*e));
        int c = ((int)(b));
        
        if(200<=c)
        {
            p("You landed on income tax, pay $200");
            x.subMoney(200);
        }
        else 
        {
            p("You landed on income tax, pay $"+c);
            x.subMoney(c);
        }
    }
    
    public static void luxoryTax(Player x)
    {
        p("You landed on Luxory Tax, pay $75");
        x.subMoney(75);
    }
    
    public static void goToJail(Player x)
    {
        p("Go to Jail");
        x.getJailed();
    }
    
    
    public static void endGame()
    {
        
        int p=0,q=0,r=0,i=0;
        
        String winner = null;
        for(int m = 0; m<players.length; m++)
        {
        while(players[m].getProperties(p) != null)
        {
            players[m].addMoney(players[m].getProperties(p).getCost());
            p++;
        }
        
      }
      for(int m = 0; m<players.length; m++)
      {
        System.out.println(players[m].getName() + "\n" + players[m].getMoney());
        System.out.println("\n\n");
      }  
      
      for(int m = 0; m< players.length; m++)
      {
          if(m!= players.length - 1)
          {
              if(players[m].getMoney() > players[m+1].getMoney())
              {
                  winner = players[m].getName(); 
                }
            }
          
        }
        p("The winner is " + winner);
    }
}
