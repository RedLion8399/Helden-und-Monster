import greenfoot.*;
import javax.swing.JOptionPane;

public class Spiel extends World
{
    private Krieger held;
    private Ork monster;
    private boolean heldDran;
    private int runde;
    
    public Spiel()
    {    
        super(600, 400, 1);        
        
        String name = JOptionPane.showInputDialog("Gib deinen Namen ein");
        held = new Krieger(name); //, new Waffe("Eisen"));
        monster = new Ork();
        
        addObject(held, 100, 230);
        addObject(monster, 500, 200);
        
        heldDran = true;
        runde = 1;
    }
    
    public void act()
    {
        while(held.getLebenspunkte() > 0 && monster.getLebenspunkte()>0)
        {
            if(heldDran)
            {
                System.out.println("Runde " + runde + " - Lebenspunkte Spieler: " + held.getLebenspunkte()
                + " Lebenspunkte Gegner: " + monster.getLebenspunkte());
                int angriff = held.angreifen();
                monster.schadenBerechnen(angriff);
                heldDran = false;
            }
            else
            {
                int angriff = monster.angreifen();
                held.schadenBerechnen(angriff);
                heldDran = true;
                runde ++;
                System.out.println();
            }
        }
        
        if(held.getLebenspunkte() <= 0)
        {
            System.out.println("Game Over");
        }
        else
        {
            System.out.println("Gewonnen!");
        }
    }
    
    public void neustart()
    {
        heldDran = true;
        held.neustart();
        monster.neustart();
    }
}
