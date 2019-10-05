package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Casino {

	Player player = new Player();
	Dealer dealer = new Dealer();
	BlackjackHand playerHand = new BlackjackHand();
	BlackjackHand dealerHand = new BlackjackHand();
	Deck deck = new Deck();
	
	public static void main(String[] args) {
		Casino c = new Casino();
		c.launch();
	}

	public void launch() {
		deck.shuffle();
		
		System.out.println("Welcome to the blackjack table at the world-famous Broken Treaty Indian Casino.");
		System.out.println("Let's play!");

		System.out.println("The dealer deals the cards.");
		player.setHand(playerHand);
		dealer.setHand(dealerHand);
		
		dealer.hand.addCard(deck.deal());
		dealer.hand.addCard(deck.deal());
		player.hand.addCard(deck.deal());
		player.hand.addCard(deck.deal());

		if (dealer.hand.getHandValue() == 21 && player.hand.getHandValue() != 21) {
			System.out.println("The dealer has blackjack. Sucks for you! You lose.");
			System.out.println("*************");
			System.out.println("  Game Over  ");
			System.out.println("*************");
		}

		System.out.println("The dealer's hand: ");
		System.out.print("One card face down and a ");
		dealer.hand.showDealerHand();
		
		System.out.println("Your hand: ");
		player.hand.showHand();
		


	}
}
