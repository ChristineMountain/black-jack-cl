import java.util.Scanner;
import java.util.ArrayList;

public class Jack
{
    public static void main(String[] args)
    {
        // creating new for the program
        Scanner scan = new Scanner(System.in);
        Deck deck = new Deck();
        ArrayList<Player> players = new ArrayList<Player>();

        // variables because those ~~~~~~ KEEP SHOWING UP
        int amountPlayers;
        String name;


        // starting the game
        System.out.println("Hello! You are playing BlackJack! How many Players are playing?");
        amountPlayers = scan.nextInt();
        for(int i = 0; i < amountPlayers; i++)
        {
            System.out.println("What is player " + i + 1 + "'s name? ");
            name = scan.nextLine();
            Player player = new Player(name);
            players.add(player);

        }

        String game = "on";

        while(game.equals("on"))
        {
            // do doer first then the rest is seeing if you surivive. 
            for(Player player: players)
            {
                player.drawCard(deck);
                player.drawCard(deck);
                player.printHand();
                player. 

            }
            

        }


        // testing
        for(Card card: deck.cards)
        {
            System.out.println(card.face + " " +  card.value + " " +  card.suit);
        }
        deck.shuffle();
        System.out.println("SHUFFLED DECK");
        for(Card card: deck.cards)
        {
            System.out.println(card.face + " " +  card.value + " " +  card.suit);
        }

        Card top = deck.drawTopCard();
        System.out.println("FIRST CARD");

        System.out.println(top.face + " " + top.value + " " + top.suit);


    }
   

}