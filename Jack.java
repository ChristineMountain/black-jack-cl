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
                System.out.print("This is " + player.name + "'s turn");
                String turn = "going";
                player.betAmount();
                player.drawCard(deck);
                player.drawCard(deck);
                player.printHand();
                while(turn.equals("going"))
                {
                    if(player.getValue() > 21)
                    {
                        System.out.print("You busted. ");
                        player.printHand();
                        scores.add(player.getValue());
                    }
                    if(player.getValue() == 21)
                    {
                        System.out.print("BLACKJACK");
                        player.printHand();
                        scores.add(player.getValue());
                    }
                    else
                    {
                        player.hit(deck);
                        if(player.hit(deck))
                        {   player.printHand();
                            player.hit(deck);
                        }
                        else
                        {
                            System.out.print("You are staying at this value: " + player.getValue());
                            scores.add(player.getValue());
                        }
                       
                    }
                   
            }
            }
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
                if(player.getValue() > 21)
                {
                    player.bet(false, player.betAmount());
                }
                if (dealerLostGame)
                {
                    player.bet(true, player.betAmount());
                }
                if (player.getValue() == 21)
                {
                    player.bet(true, player.betAmount());
                }
                if(player.getValue() > dealer.getValue())
                {
                    player.bet(true, player.betAmount());
                }

                }
        
            }

        }



    }