/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ICE1;

import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 *
 * @author Kunjan Patel / 991535676
 */
public class CardTrick {

    public static int randomSuit() {
        return (int) (Math.random() * 4);
    }

    public static int randomCardNumber() {
        return (int) (Math.random() * 13);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Card[] magicHand = new Card[7];

        for (int i = 0; i < magicHand.length; i++) {
            Card c = new Card();
            c.setValue(randomCardNumber());
            c.setSuit(Card.SUITS[randomSuit()]);
            magicHand[i] = c;
        }

        System.out.println("Choose suits:(Hearts, Diamonds, Spades, Clubs)");
        String userSuits = input.nextLine();

        System.out.println("Choose card number:(1-13)");
        int userCardNo = input.nextInt();

        for (int i = 0; i < magicHand.length; i++) {
            if (magicHand[i].getSuit().equals(userSuits) && magicHand[i].getValue() == userCardNo) {
                System.out.println("You found your card");
                return;
            }
        }
        System.out.println("Card not found");
    }

}
