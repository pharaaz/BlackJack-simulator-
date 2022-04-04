/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newassignment;

/*
 * the dealer is a type of player, hence the inheritance. 
 * 
 * @author Faraaz Khan 17985055
 */

public class Dealer extends Player{
	
	protected Deck dealer = new Deck();
	protected Deck fullDeck;
	private int faceValue;

	public Dealer(Deck deck) {
		super(deck);
		fullDeck = deck;
		dealer.pick(fullDeck);
		dealer.pick(fullDeck);
	}
	
	public String toString() {
		return "Dealers hand is: \n" +dealer.getCard(0).toString() +" and a hidden card";
 	}
	
	@Override
	public int hit() {
		while(dealer.sum()<17) {
			dealer.pick(fullDeck);
			System.out.println("Dealers hit card: " +dealer.getCard(dealer.size()-1).toString());
		}
		
		return dealer.sum();
	}
	
	public int value() {
		return dealer.sum();
	}
	
	@Override
	public int posBlackJack() {
		int won=0;
		if(dealer.sum()==21) {
			won=1;
		}
		
		return won;
	}
	
	@Override
	public void returnCards(Deck currentDeck) {
		dealer.returnC(currentDeck);
	}
	
	//to determine what the face card of the dealer is. 
	public int faceCardValue() {
		Cards face=dealer.getCard(0);
		
			switch(face.getValue()){
			case TWO: faceValue = 2; break;
			case THREE: faceValue = 3; break;
			case FOUR: faceValue = 4; break;
			case FIVE: faceValue = 5; break;
			case SIX: faceValue = 6; break;
			case SEVEN: faceValue = 7; break;
			case EIGHT: faceValue = 8; break;
			case NINE: faceValue = 9; break;
			case TEN: faceValue = 10; break;
			case JACK: faceValue = 10; break;
			case QUEEN: faceValue = 10; break;
			case KING: faceValue = 10; break;
			case ACE: faceValue = 11; break;
			}
		
		
		return faceValue;
		
	}
}

