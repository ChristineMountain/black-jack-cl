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


    // i print hand and check values to see if immidiatly won or lost
    public void printHand()
    {
        int allValue = 0; //mr_fowler: do we still need this here?
        for(Card card : this.hand)
        {
            System.out.println(card.face + " " + card.value + " " + card.suit);
            allValue += card.value;
        }
        System.out.println("This is your current value: " + allValue);
    
    }

    // returns the value of all the cards
    public int getValue()
    {
        int allValue = 0;
        for(Card card : this.hand)
        {
            allValue += card.value;
        }
        return allValue;
    
    }

    // changes the total on the bet
    //mr_fowler: do we still need to pass in the bet amount if its an attribute?
    public void getBet(boolean win, int betAmount)
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
        //mr_fowler: works great! In the future, if you're going to do something regardless of an if statement, consider moving it outside!
        //this.hand.clear();
        //System.out.println(this.name + " total money is now: " + this.total);
        //placing it here reduces the if statement scope sizes and makes it more clear it happens regardless win or lose!


    }


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

    // stores the bet amount
    public void betAmount()
    {
        System.out.println("How much do you want to bet?");
        int betAmount = scan.nextInt();
        scan.nextLine();
        this.bet = betAmount;
    }

}