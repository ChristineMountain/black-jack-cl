import java.util.ArrayList;
import java.util.Scanner;
import javax.management.NotificationBroadcaster;

public class Player
{
    public Scanner scan = new Scanner(System.in);
    public ArrayList<Card> hand = new ArrayList<Card>();
    public String name;
    public int total = 100;


    // player essantials
    Player(String name)
    {
        this.name = name;
    }

    public void drawCard(Deck deck)
    {
        hand.add(deck.drawTopCard());
    }


    // i print hand and check values to see if immidiatly won or lost

    public boolean printHand()
    {
        int allValue = 0;
        for(Card card : this.hand)
        {
            System.out.println(card.face + " " + card.value + " " + card.suit);
            allValue += card.value;
        }
        System.out.println("This is your current value: " + allValue);
        if(allValue > 21)
        {
            return false;
        }
        if(allValue == 21)
        {
            return true; 
        }
    
    }

    public void bet(boolean win)
    {
        System.out.println("How much do you want to bet?");
        int betAmount = scan.nextInt();
        scan.nextLine();
        if (win)
        {
            this.total += betAmount;
        }
        else
        {
            this.total -= betAmount;

        }  


    }

    public void hit(Deck deck)
    {
        System.out.println("Do you want to be hit? type hit or no");
        String hitOrNot = scan.nextLine();
        if (hitOrNot.equals("hit"))
        {
            hand.add(deck.drawTopCard());

        }
        

    }

}