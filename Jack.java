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
<<<<<<< HEAD
                System.out.print("This is " + player.name + "'s turn");
                String turn = "going";
=======
                System.out.println("This is " + player.name + "'s turn");
                boolean turn = true;
>>>>>>> f77f59b (reupdate)
                player.betAmount();
                player.drawCard(deck);
                player.drawCard(deck);
                player.printHand();
<<<<<<< HEAD
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
=======
                // while(turn)
                // {
                //     player.hit(deck, turn);
                //     player.printHand();
                // }
                        
                   
            
            }
            System.out.println("It's the dealer's turn ");
>>>>>>> f77f59b (reupdate)
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
<<<<<<< HEAD
                if(player.getValue() > 21)
                {
=======
                System.out.print(player.name + ",");
                if(player.getValue() > 21)
                {
                    System.out.println("You busted.");
>>>>>>> f77f59b (reupdate)
                    player.bet(false, player.betAmount());
                }
                if (dealerLostGame)
                {
<<<<<<< HEAD
=======
                    System.out.println("Dealer bust! Everyone who didn't bust wins!");
>>>>>>> f77f59b (reupdate)
                    player.bet(true, player.betAmount());
                }
                if (player.getValue() == 21)
                {
<<<<<<< HEAD
=======
                    System.out.println("Blackjack, you win no matter what. Good job");
>>>>>>> f77f59b (reupdate)
                    player.bet(true, player.betAmount());
                }
                if(player.getValue() > dealer.getValue())
                {
<<<<<<< HEAD
=======
                    System.out.println("You win!");
>>>>>>> f77f59b (reupdate)
                    player.bet(true, player.betAmount());
                }

                }
        
            }

        }



    }