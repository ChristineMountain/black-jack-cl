import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    public ArrayList<Card> cards = new ArrayList<Card>();
    Random rnd = new Random();

    Deck()
    {
        int[] values = new int[]{1,2,3,4,5,6,7,8,9,10,10,10,10};
        String [] faces = new String []{"Ace", "Two", "Three", "Four", "Five",
         "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String [] suits = new String[] {"heart", "spade", "clubs", "diamonds"};

        // making cards
        for (String suit : suits)
        {
            for (int i = 0; i < values.length; i++)
            {
                this.cards.add(new Card(suit, values[i], faces[i]));

            }
        }
       

    }

    public void shuffle()
    {
        ArrayList<Card> shufCards = new ArrayList<Card>();
        int randomNum;
        for(int i = 0; i < this.cards.size(); i++)
        {
            randomNum = rnd.nextInt(this.cards.size());
            shufCards.add(this.cards.get(randomNum));
            this.cards.remove(randomNum);

        }
    
        this.cards = shufCards;

    }

    public Card drawTopCard()
    {
        Card top;
        top = this.cards.get(0);
        this.cards.remove(0);
        return top;

    }
    
}
