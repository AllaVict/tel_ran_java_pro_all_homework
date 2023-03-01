package homework4_23_02;

import java.util.Random;
import java.util.Scanner;

public class Deal {
    public static void main(String[] args) {

        final int cardsForPlayer = 5;
        int players;

        final Scanner sc = new Scanner(System.in);
        final Random random = new Random();

//        final String[] suits = {"clubs", "diamonds", "hearts", "spades"};
//        final String[] rank = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        final Suits[] suits = Suits.values();
        final Rank[] rank = Rank.values();

        final int numberOfCards = suits.length * rank.length; // number of cards

        //enter number of players
        players = getPlayers(cardsForPlayer, sc, numberOfCards);

        // deck initialization
        String[] deck = new String[numberOfCards];
        deckInitialization(suits, rank, deck);

        // deck shuffling
        deckShuffling(random, numberOfCards, deck);

        // the shuffled deck is displayed
        shuffledDeckIsDisplayed(cardsForPlayer, players, deck);

    }

    private static int getPlayers(int cardsForPlayer, Scanner sc, int numberOfCards) {
        int players;
        while (true) {
            System.out.println("Enter the number of players: ");
            if (sc.hasNextInt()) {
                players = sc.nextInt();
                if (cardsForPlayer * players <= numberOfCards) {
                    break;
                } else {
                    if (players == 0) {
                        System.out.println("The game has been terminated.");
                        break;
                    } else if (players < 0) {
                        System.out.println("The number of players cannot be less than 0");
                    } else {
                        System.out.println("Too many players!");
                    }
                }
            } else {
                System.out.println("You have not entered a number, or your number is too large!");
            }
        }
        return players;
    }

    private static void shuffledDeckIsDisplayed(int cardsForPlayer, int players, String[] deck) {
        for (int i = 0; i < players * cardsForPlayer; i++) {
            System.out.println(deck[i]);

            if (i % cardsForPlayer == cardsForPlayer - 1)
                System.out.println();
        }
    }

    private static void deckShuffling(Random random, int numberOfCards, String[] deck) {
        for (int i = 0; i < numberOfCards; i++) {
            int card = i + (random.nextInt(numberOfCards - i)); // random card in the deck
            String temp = deck[card];
            deck[card] = deck[i];
            deck[i] = temp;
        }
    }

    private static void deckInitialization(Suits[] suits, Rank[] rank, String[] deck) {
        for (int i = 0; i < rank.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                deck[suits.length * i + j] = rank[i] + " " + suits[j];
            }
        }
    }


}