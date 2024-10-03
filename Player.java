import java.util.ArrayList;
import java.util.Scanner;


public class Player
{
    public Scanner scan = new Scanner(System.in);
    public ArrayList<Card> hand = new ArrayList<Card>();
    public String name;
    public int total = 100;
    public int bet = 0;


    // player essantials
    Player(String name)
    {
        this.name = name;
    }

    // adds card to the deck
    public void drawCard(Deck deck)
    {
        hand.add(deck.drawTopCard());
    }


    // prints out what is in hand and current value
    public void printHand()
    {
        int allValue = 0;
        for(Card card : this.hand)
        {
            System.out.println(card.face + " " + card.value + " " + card.suit);
            allValue += card.value;
        }
        System.out.println("This is your current value: " + allValue);
    
    }

    // returns the value
    public int getValue()
    {
        int allValue = 0;
        for(Card card : this.hand)
        {
            allValue += card.value;
        }
        return allValue;
    
    }

    // deals with the product of wins and looses
    public void totalBet(boolean win, int betAmount)
    {
        scan.nextLine();
        if (win)
        {
            this.total += betAmount;
            this.hand.clear();
            System.out.println(this.name + " total money is now: " + this.total);
        }
        else
        {
            this.total -= betAmount;
            this.hand.clear();
            System.out.println(this.name + " total money is now: " + this.total);

        }  


    }

    // adds another card when hit and returns true when stays 
    public boolean hit(Deck deck, boolean game)
    {

        System.out.println("Do you want to be hit? type hit or stay");
        String hitOrNot = scan.nextLine();
        if (hitOrNot.equals("hit"))
        {
            hand.add(deck.drawTopCard());
            return true;

        }
        else
        {
            System.out.println("You are staying.");
            return false;

        }


    }

    // stores the bet amount for each player
    public void betAmount()
    {
        System.out.println("How much do you want to bet?");
        int betAmount = scan.nextInt();
        scan.nextLine();
        this.bet = betAmount;
    }

}