/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newassignment;
/*
 * this class uses the plays hand value and the face card of the dealer to determine is it beneficial  
 * for the player to hit or to stay, based upon blackjack basic strategy.
 * 
 * @author Faraaz Khan, 17985055
 */

public class BasicStrategy {
	
	private int playerHand;
	private int dealerHand;
	
	public BasicStrategy(int dealerHand, int playerHand) {
		this.dealerHand=dealerHand;
		this.playerHand=playerHand;
	}
	 
	
	public void Basic() {
	
		if(dealerHand>6) {
			if(playerHand<=17) {
				System.out.println("According to basic strategy, the ideal move is to hit");
			}
			else {
				System.out.println("According to basic strategy, the ideal move is to stand unless you have an ace.");
			}
		}
		else{
			if(playerHand>=13) {
				System.out.println("According to basic strategy, the ideal move is to stand unless you have an ace.");
			}
			else if(playerHand==12 && dealerHand>3) {
				System.out.println("According to basic strategy, the ideal move is to stand unless you have an ace.");
			}
			else {
				System.out.println("According to basic strategy, the ideal move is to hit");
			}
		}
	}
	

}