package com.skilldistillery.cards.blackjack;

import java.util.List;

import com.skilldistillery.cards.common.Card;

public class BlackjackHand extends Hand{
	
	// F i e l d s
	
	// C o n s t r u c t o r s
	
	public BlackjackHand() {
		super();
	}
	
	public BlackjackHand(List<Card> cards) {
		super(cards);
	}
	
	// M e t h o d s
	
	public int getHandValue() {
		int handValue = 0;
		for (Card card : this.cards) {
			handValue += card.getValue();
		}
		return handValue;
	}
	
	public boolean isBlackjack() {
		return false;
	}
	
	public boolean isBust() {
		return false;
	}
	
	@Override
	public void addCard(Card card) {
		this.cards.add(card);
	}


	@Override
	public void clear() {
		// TODO Auto-generated method stub
		super.clear();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BlackjackHand [cards=").append(cards).append("]");
		return builder.toString();
	}
	
}
