import java.util.ArrayList;
import java.util.Scanner;

public class Jack
{
    public static void main(String[] args)
    {
        // creating new scan for inputs in the program
        Scanner scan = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<Player>();
        // variables needed to add new players
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
            // creates new deck each round so it starts over
            Deck deck = new Deck();
            // shuffles the new deck
            deck.shuffle();

            // player plays
            for(Player player: players)
            {
                System.out.println("This is " + player.name + "'s turn");
                boolean turn = true;
                player.betAmount();
                player.drawCard(deck);
                player.drawCard(deck);
                while(turn)
                {
                    player.printHand();
                    turn = player.hit(deck, turn); //mr_fowler: this is clever, nice!
                }

            }

            // dealer showing play
            System.out.println("It's the dealer's turn ");
            Player dealer = new Player("dealer");
            boolean dealerLostGame = false;
            dealer.drawCard(deck);
            dealer.drawCard(deck);
            dealer.printHand();
            while (dealer.getValue() < 16)
            {
                dealer.drawCard(deck);
                dealer.printHand(); //maybe we wait until after they add all their cards to print their hand, also can we print their value?
            }
            if(dealer.getValue() > 21)
            {
                dealerLostGame = true;

            }

            // determining wins for a round
            for(Player player : players)
            {
                System.out.print(player.name + ",");
                if(player.getValue() > 21)
                {
                    System.out.println("You busted.");
                    player.getBet(false, player.bet);
                }
                else if (dealerLostGame)
                {
                    System.out.println("Dealer bust! Everyone who didn't bust wins!");
                    player.getBet(true, player.bet);
                }
                else if (player.getValue() == 21)
                {
                    System.out.println("Blackjack, you win no matter what. Good job");
                    player.getBet(true, player.bet);
                }
                else if(player.getValue() > dealer.getValue())
                {
                    System.out.println("You win!");
                    player.getBet(true, player.bet);
                }
                else
                {
                    System.out.println("You lost!");
                    player.getBet(false, player.bet);

                }

                }
        
            }

        }



    }