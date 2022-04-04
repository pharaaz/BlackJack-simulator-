/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newassignment;

/*
 * this class represents the player and their hands
 * 
 * @author Faraaz Khan 17985055
 */

public class Player extends Deck{

	protected Deck player = new Deck();
	protected Deck fullDeck;
	private float money;
	private float bet;
	
	public Player(Deck deck) {
		fullDeck = deck;
		player.pick(fullDeck);
		player.pick(fullDeck);
	}
	
	public String toString() {
		player.cardArt();
		return "Player hand: \n" +player.toString() +"\n Current value of hand: " +player.sum();
	}
	
	public void setMoney(float money) {
		this.money=money;
	}
	
	public float getMoney() {
		return this.money;
	}
	
	public void setBet(float bet) {
		this.bet=bet;
	}
	
	public float getBet() {
		return this.bet;
	}

	//method checks if the player has busted or on what value of a hand they are currently on.
	public int check() {
		int key =0;
				if(player.sum()>21) {
					System.out.println("Bust " +player.sum());
					key +=3;
					return key;
				}
				else {
					System.out.println("you have:" +player.sum());
					key +=2;
					return key;
				}
	}
	
	//picks a card and adds it to the player deck which is the player hand
	public int hit() {
		player.pick(fullDeck);
		System.out.println("Card you got: " +player.getCard(player.size()-1));
		return player.sum();
		
	}
	
	//checks if the  player has gotten a possible blackjack or not returning the appropriate value indicating whether or not blackjack was achieved. 
	public int posBlackJack() {
		int won=0;
		if(player.sum()==21) {
			won=1;
		}
		
		return won;
	}
	
	public int value() {
		return player.sum();
	}
	
	public void returnCards(Deck currentDeck) {
		player.returnC(currentDeck);
	}
	

}
