import java.util.ArrayList;
import java.util.Scanner;

public class Jack
{
    public static void main(String[] args)
    {
        // creating new scan for inputs in the program
        Scanner scan = new Scanner(System.in);
        // makes list of players
        ArrayList<Player> players = new ArrayList<Player>();
        // variables made to make adding players
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

        // playing game with set amount of players
        boolean game = true;

        while(game)
        {
            // makes deck in while so it clears after every game :)
            Deck deck = new Deck();
            // shuffle the new deck
            deck.shuffle();

            // player getting to play
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
                    turn = player.hit(deck, turn);
                }
            }

            // dealer showing the process of their play
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

            // determining win and looses
            for(Player player : players)
            {
                System.out.print(player.name + ",");
                if(player.getValue() > 21)
                {
                    System.out.println("You busted.");
                    player.totalBet(false, player.bet);
                }
                else if (dealerLostGame)
                {
                    System.out.println("Dealer bust! Everyone who didn't bust wins!");
                    player.totalBet(true, player.bet);
                }
                else if (player.getValue() == 21)
                {
                    System.out.println("Blackjack, you win no matter what. Good job");
                    player.totalBet(true, player.bet);
                }
                else if(player.getValue() > dealer.getValue())
                {
                    System.out.println("You win!");
                    player.totalBet(true, player.bet);
                }
                else
                {
                    System.out.println("You lost!");
                    player.totalBet(false, player.bet);
                }
                }
            }
        }
    }