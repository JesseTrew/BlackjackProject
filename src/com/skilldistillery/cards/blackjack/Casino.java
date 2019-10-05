package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class Casino {

	Player player = new Player();
	Dealer dealer = new Dealer();
	BlackjackHand playerHand = new BlackjackHand();
	BlackjackHand dealerHand = new BlackjackHand();
	Deck deck = new Deck();
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		Casino c = new Casino();
		c.launch();
	}

	public void launch() {
		Boolean keepGoing = true;
		
		deck.shuffle();

		System.out.println("*******************************************************************************");
		System.out.println("Welcome to the blackjack table at the world-famous Broken Treaty Indian Casino.");
		System.out.println("*******************************************************************************");
		System.out.println();
		System.out.println("Let's play!");
		System.out.println();
		System.out.println("The dealer deals the cards.");
		System.out.println();
		player.setHand(playerHand);
		dealer.setHand(dealerHand);

		dealer.hand.addCard(deck.deal());
		dealer.hand.addCard(deck.deal());
		player.hand.addCard(deck.deal());
		player.hand.addCard(deck.deal());

		System.out.println("The dealer's hand: ");
		System.out.println("One card face down");
		dealer.hand.showDealerHand();
		System.out.println();

		System.out.println("Your hand: ");
		player.hand.showHand();
		System.out.println();
		
		if (dealer.hand.getHandValue() == 21 && player.hand.getHandValue() != 21) {
			System.out.println("The dealer has blackjack. Sucks for you! You lose.");
			System.out.println("*************");
			System.out.println("  Game Over  ");
			System.out.println("*************");
			keepGoing = false;
		}

		
		if (player.hand.getHandValue() == 21) {
			System.out.println("You got Blackjack! You win!!");
			System.out.println();
			System.out.println("*************");
			System.out.println("  Game Over  ");
			System.out.println("*************");
			keepGoing = false;
		}

		while (keepGoing) {
			System.out.println("Would you like to hit or stay?");
			System.out.println("1) Hit");
			System.out.println("2) Stay");
			int menuSelection = kb.nextInt();
			switch (menuSelection) {
			case 1:
				player.hand.addCard(deck.deal());
				System.out.println("Your hand: ");
				player.hand.showHand();
				System.out.println();
				if (player.hand.getHandValue() == 21) {
					System.out.println("You got Blackjack! You win!!");
					System.out.println("*************");
					System.out.println("  Game Over  ");
					System.out.println("*************");
					keepGoing = false;
					break;
				}
				
				if (player.hand.getHandValue() > 21) {
					System.out.println("You busted. You lose!");
					System.out.println("*************");
					System.out.println("  Game Over  ");
					System.out.println("*************");
					keepGoing = false;
					break;
				}
				
				if (dealer.hand.getHandValue() < 17) {
					dealer.hand.addCard(deck.deal());
					
					if (dealer.hand.getHandValue() == 21 && player.hand.getHandValue() != 21) {
						System.out.println("The dealer's hand: ");
						dealer.hand.showDealerHandFinal();
						System.out.println("The dealer has blackjack. Sucks for you! You lose.");
						System.out.println("*************");
						System.out.println("  Game Over  ");
						System.out.println("*************");
						keepGoing = false;
						break;
					}
					System.out.println("The dealer's hand: ");
					System.out.print("One card face down and a ");
					dealer.hand.showDealerHand();
				}
				if(dealer.hand.getHandValue() >= 17) {
					System.out.println("The dealer stays.");
				}
				break;
				
			case 2:
				while (dealer.hand.getHandValue() < 21) {
					if (dealer.hand.getHandValue() < 17) {
						dealer.hand.addCard(deck.deal());
						System.out.println("The dealer's hand: ");
						if (dealer.hand.getHandValue() == 21) {
							dealer.hand.showDealerHandFinal();
							System.out.println("The dealer has blackjack. Sucks for you! You lose.");
							System.out.println("*************");
							System.out.println("  Game Over  ");
							System.out.println("*************");
							keepGoing = false;
							break;
						}
						if (dealer.hand.getHandValue() > 21) {
							dealer.hand.showDealerHandFinal();
							System.out.println("The dealer busted. You win!");
							System.out.println("*************");
							System.out.println("  Game Over  ");
							System.out.println("*************");
							keepGoing = false;
							break;
						}
						dealer.hand.showDealerHand();
					}
					
					if (dealer.hand.getHandValue() >= 17) {
						System.out.println();
						System.out.println("***********************");
						System.out.println("      Final result     ");
						System.out.println("***********************");
						System.out.println();
						System.out.println("Your hand: ");
						player.hand.showHand();
						System.out.println();
						System.out.println();
						System.out.println("The dealer's hand: ");
						dealer.hand.showDealerHandFinal();
						System.out.println();
						if(dealer.hand.getHandValue() >= player.hand.getHandValue()) {
							System.out.println();
							System.out.println("The dealer wins!");
							keepGoing = false;
							break;
						}
						if(dealer.hand.getHandValue() < player.hand.getHandValue()) {
							System.out.println();
							System.out.println("You win!");
							keepGoing = false;

							break;
						}
					}
				}

			}
		}

	}
}
