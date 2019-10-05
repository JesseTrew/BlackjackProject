package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;

public abstract class Hand {

	// F i e l d s

	protected List<Card> cards;

	// C o n s t r u c t o r s

	public Hand() {
		super();
		cards = createHand();
	}
	
	public Hand(List<Card> cards) {
		super();
		this.cards = cards;
	}
	
	// M e t h o d s

	private List<Card> createHand(){
		List<Card> cards = new ArrayList<>();
		return cards;
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public void clear() {
		List<Card> emptyHand = new ArrayList<Card>();
		cards = emptyHand;
	}
	
	public void showHand(){
		for (Card card : cards) {
			System.out.println(card);
		}
	}
	
	public void showDealerHand() {
		for (int i = 1; i < cards.size(); i++) {
			System.out.println(cards.get(i));
		}
	}
	
	public void showDealerHandFinal() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hand [cards=").append(cards).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cards == null) ? 0 : cards.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		if (cards == null) {
			if (other.cards != null)
				return false;
		} else if (!cards.equals(other.cards))
			return false;
		return true;
	}
	
	
	
}
