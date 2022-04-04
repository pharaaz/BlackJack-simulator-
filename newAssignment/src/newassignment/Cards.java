/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newassignment;

/*
 * class used for each individual card
 * @author Faraaz Khan 17985055
 */

public class Cards {
	
	private CardValues value;
	private CardSuit suit;
	
	
	public Cards (CardValues value,CardSuit suit) {
		this.value=value;
		this.suit=suit;
	}
	
	//toString to print out the indivual cards. 
	public String toString() {
		return"Cards are: " +this.suit +"-----" +this.value;
	}
	
	public CardSuit getSuit() {
		return this.suit;
	}
	
	public CardValues getValue() {
		return this.value;
	}
	
	

}