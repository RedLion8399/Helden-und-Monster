import greenfoot.*;
import javax.swing.JOptionPane;

public class Krieger extends Actor
{
    private String name;
    private int lebenspunkte;
    private int lebenMax;
    private int staerke;
    private int abwehrwert;
    //private Waffe meineWaffe;
    
    public Krieger(String pName) //, Waffe pWaffe)
    {
        getImage().scale(150, 300);
        
        name = pName;
        lebenspunkte = 50;
        lebenMax = 50;
        staerke = 6;
        abwehrwert = 4;
        //meineWaffe = pWaffe;
    }
    
    public void neustart()
    {
        staerke = 6;
    }
    
    public int angreifen()
    {
        String input = "";
        while(!(input.equals("A") || input.equals("B")))
        {
            input = JOptionPane.showInputDialog("Starker Angriff (A) oder schwacher Angriff mit Verteidigung (B)?");
        }
        int angriffswert = wuerfeln(10);
         if(input.equals("B"))
        {    
            abwehrwert = angriffswert/2 + 3;
            angriffswert = angriffswert/2;
        }
        angriffswert = angriffswert + staerke; // + meineWaffe.bonusBerechnen();
        System.out.println(name + " greift mit " + angriffswert + " Angriffspunkten an.");
        return angriffswert;
    }
    
    public void schadenBerechnen(int wert)
    {
        int abwehr = wuerfeln(20);       
        if(abwehr+abwehrwert < wert)
        {
            int abzug = wert - abwehr - abwehrwert;
            lebenspunkte = lebenspunkte - abzug;
            System.out.println(name + " erleidet " + abzug + " Schaden.");
        }
        else
        {
            System.out.println(name + " blockt den Angriff.");
        }
        abwehrwert = 3;
    }
    
    private int wuerfeln(int seitenzahl)
    {
        int i = Greenfoot.getRandomNumber(seitenzahl)+1;
        return i;
    }
    
    public int getLebenspunkte()
    {
        return lebenspunkte;
    }

}
