import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ork extends Actor
{
    private int angriffswert;
    private int lebenspunkte;
    private int lebenMax;
    private int robustheit;
    private int zaehler;

    public Ork()
    {
        getImage().scale(200, 360);
        
        angriffswert = 12;
        lebenspunkte = 50;
        robustheit = 11;
        zaehler = 3;
    }
    
    public void neustart()
    {
        angriffswert = 12;
        lebenspunkte = 50;
        zaehler = 3;
    }
    
    public int angreifen()
    {
        int angriff = angriffswert;
        if(zaehler == 0)
        {
            angriff = angriff + 7;
            zaehler = zaehler + 3;
        }
        
        System.out.println("Der Ork greift mit " + angriff + " Angriffspunkten an.");
        
        if (zaehler == 1)
        {
            System.out.println("Der Ork plant für die nächste Runde einen stärkeren Angriff.");
        }
        zaehler --;
        
        return angriff;
    }
    
    public void schadenBerechnen(int wert)
    {
        if(robustheit < wert)
        {
            int abzug = wert - robustheit;
            lebenspunkte = lebenspunkte - abzug;
            System.out.println("Der Ork hat " + abzug + " Schaden erlitten.");
        }
        else
        {
            System.out.println("Es wurde kein Schaden erzielt.");
        }
        
    }
    
    public int getLebenspunkte()
    {
        return lebenspunkte;
    }

}

