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
            boolean dealerGame;
            Player dealer = new Player("dealer");
            dealer.drawCard(deck);
            dealer.drawCard(deck);
            dealer.printHand();
            if(dealer.printHand() > 21)
            {
                dealerGame = false;
            }
            while (dealer.printHand() < 16)
            {
                dealer.drawCard(deck);
                dealer.printHand();
            }

            for(Player player: players)
            {
                String turn = "going";
                System.out.println("How much do you want to bet?");
                int betAmount = scan.nextInt();
                player.drawCard(deck);
                player.drawCard(deck);
                player.printHand();
                while(turn.equals("going"))
                {
                    if(player.printHand() > 21)
                    {
                        player.bet(false, betAmount);
                    }
                    if(player.printHand() == 21)
                    {
                        player.bet(true, betAmount);
                    }
                    else
                    {
                        player.hit(deck);
                        player.printHand();
                        System.out.print("Are you done?")
                        int done;
                        done = scan.nextLine();
                        if (done.equals("done"))
                        {
                            turn = "done";
                        }
                    }
            }
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