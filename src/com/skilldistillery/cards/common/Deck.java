package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {

	// F i e l d s

	private List<Card> cards;

	// C o n s t r u c t o r s

	public Deck() {
		cards = createDeck();
	}

	// M e t h o d s
	private List<Card> createDeck() {
		List<Card> deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		return deck;
	}

	public int checkDeckSize(){
		return cards.size();
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card deal() {
		return cards.remove(0);
		
	}
	
}
