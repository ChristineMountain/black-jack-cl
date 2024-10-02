import java.util.Scanner;
import java.util.ArrayList;

public class Jack
{
    public static void main(String[] args)
    {
        // creating new for the program
        Scanner scan = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Object> scores = new ArrayList<Object>();

        // variables because those ~~~~~~ KEEP SHOWING UP
        int amountPlayers;
        String name;


        // starting the game
        System.out.println("Hello! You are playing BlackJack! How many Players are playing?");
        amountPlayers = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i < amountPlayers; i++)
        {
            System.out.println("What is player " + (i + 1 )+ "'s name? ");
            name = scan.nextLine();
            Player player = new Player(name);
            players.add(player);

        }

        boolean game = true;

        while(game)
        {

            for(Player player: players)
            {
                System.out.println("This is " + player.name + "'s turn");
                boolean turn = true;
                player.betAmount();
                player.drawCard(deck);
                player.drawCard(deck);
                player.printHand();
                // while(turn)
                // {
                //     player.hit(deck, turn);
                //     player.printHand();
                // }
                        
                   
            
            }
            System.out.println("It's the dealer's turn ");
            Player dealer = new Player("dealer");
            boolean dealerLostGame = false;
            dealer.drawCard(deck);
            dealer.drawCard(deck);
            dealer.printHand();
            while (dealer.getValue() < 16)
            {
                dealer.drawCard(deck);
                dealer.printHand();
            }
            if(dealer.getValue() > 21)
            {
                dealerLostGame = true;

            }

            // write program for winning a round.
            for(Player player : players)
            {
                System.out.print(player.name + ",");
                if(player.getValue() > 21)
                {
                    System.out.println("You busted.");
                    player.bet(false, player.betAmount());
                }
                if (dealerLostGame)
                {
                    System.out.println("Dealer bust! Everyone who didn't bust wins!");
                    player.bet(true, player.betAmount());
                }
                if (player.getValue() == 21)
                {
                    System.out.println("Blackjack, you win no matter what. Good job");
                    player.bet(true, player.betAmount());
                }
                if(player.getValue() > dealer.getValue())
                {
                    System.out.println("You win!");
                    player.bet(true, player.betAmount());
                }

                }
        
            }

        }



    }