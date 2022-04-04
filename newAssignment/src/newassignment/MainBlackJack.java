/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newassignment;

import java.util.Scanner;

/*
 * This is the main method of my assessment, I choose to do the 
 * topic of BlackJack.
 * 
 * This project will simulate a player vs dealer blackjack game, where the dealer must draw to 17.
 * Project also uses basic strategy for blackjack to assist the player to make good decisions in game. 
 * 
 * All players are saved onto a text file with their balance so they can continue playing with same balance.
 * 
 * 
 * @author Faraaz Khan pgx2172
 */

public class MainBlackJack {
	public static void main(String[] args) {
            	
		Deck currentDeck = new Deck();
		currentDeck.fullDeck();
		float money=0;
		int p1Total=0;
		int dealTotal=0;
		ParticipantReg ps =new ParticipantReg();
		boolean exit = false;
		float bet=0;
			
		Scanner input = new Scanner(System.in);
		
		/*
		 * checks if player is saved in text file, to continue balance or new user balance is given.
		 */
		
		System.out.println("Welcomeeeeee to Faraaz's casino!");
		System.out.println("Please enter your name to continue with Balance, or new name for new balance: (press 'X' to quit)");
		String user = input.next();
		Participant participant = ps.checkParticipant(user);
		
		//Option for player to exit program
		if(user.equalsIgnoreCase("X")) {
			exit=true;
		}
		else {
			
			System.out.println("Good to see you " +participant.getName() +" , your balance is currently at: $" +participant.getMoney());
			money=participant.getMoney();
		}
		
		 
		while(exit==false) {
			
			if(money > 0) {
				//player and dealer 
				Player p1 = new Player(currentDeck);
				Dealer deal = new Dealer(currentDeck);
				p1.setMoney(money);
				
				boolean hit = true;
				boolean round = false;
				boolean valid = false;
				
				while(valid==false) {
					
					System.out.print("Avaliable balance: $");
					System.out.printf("%.2f", money);
					System.out.println(". How much would you like to bet? (press 'X' to quit)");
					
					//Checks if there is an input mismatch or not.
					String option = input.next();
					valid=isValidAnswer(option);
					if(valid==true) {
						 
						if(option.equalsIgnoreCase("X")) {
							
							exit=true;
							break;
						}
						else {
							bet=Float.parseFloat(option);
						}
					}
					
				}
				
				if(exit==true) {
					break;
				}

				p1.setBet(bet);
				//Checks if bet amount is less than the balance.
				if(p1.getBet()>money) {
					System.out.println("Sorry but you do not have that much avaliable credit, please re-enter bet ammount");
					round = true;
				}
				else {
					//prints out the player and dealer cards
						System.out.println(p1.toString());
						
						System.out.println(deal.toString());
						
						//Checks if player has got a blackjack or not.
						int p1BlackJack = p1.posBlackJack();
						int dealBlackJack= deal.posBlackJack();
						
						if(p1BlackJack==1&&dealBlackJack!=p1BlackJack) {
							System.out.println("Congrulations!!! You got BlackJack! Thats a 3:2 pay out");
							money+=(bet*1.5f);
							hit=false;
							round=true;
						}
						
				//if blackjack was awarded to player, there is no need to hit or stay. 
						while(hit==true) {
							
				//before player is asked to hit, they are informed about basic strategy and what's the best option.
							BasicStrategy bg = new BasicStrategy(deal.faceCardValue(),p1.value());
							bg.Basic();
					    
						System.out.println("(1) hit or (2) stay? (press 1 to hit or 2 stay)");
						String answer = input.next();
						
				//if user input is invalid, user will have to keep inputting until correct. 	
						
						if(answer.equals("1")) {
							
							p1Total=p1.hit();
							int key = p1.check();
							if(key == 3) {
								money-=bet;
								round=true;
								break;
							}
						}
						else if(answer.equals("2")) {
							p1Total = p1.value();
							break;
						}
						else {
							System.out.println("Invalid Input. Please input your answer again: ");
						}
						
					}
						
					System.out.println(deal.toString());
					
					dealTotal=deal.value();
    //below is the possible scenarios when playing against a dealer in blackjack
					if(dealTotal>16 && dealTotal>p1Total&& round==false) {
						System.out.println("The dealer won!");
						money-=bet;
						round=true;
					}
					
					if(round ==false) {
						dealTotal=deal.hit();
						
					}
					
					System.out.println("Dealer hand: "  +dealTotal  + "      |           Your hand:"+p1Total);
					
					if(dealTotal>21&& round==false) {
						System.out.println("Dealer bust! You won!! Congratulations!");
						money+=bet;
						round =true;
						
					}
					if(dealTotal==p1Total&& round==false) {
						System.out.println("Push, it is a tie. No one won.");
						round=true;
					}
					if(dealTotal < p1Total && round==false && dealTotal>16) {
						System.out.println("You won!! Congratulations!");
						money+=bet;
						round = true;
					}
					else if(round==false) {
						System.out.println("You lost");
						System.out.println("delaer won");
						money-=bet;
						round=true;
						
					}
					//returns the cars used in the hand to the deck
					p1.returnCards(currentDeck);
					deal.returnCards(currentDeck);
					System.out.println("The round is over. ");
				
				}

			}
			//Safety option if the player were to lose all there money, they can still play on provided they redeposit.  
			else {
				System.out.println("Your Balance is empty! Would you like to redeposit another $1000? 1 for yes or 2 for no.");
				String decision = input.next();
	
				if(decision.equals("1")) {
					
					money += 1000;
				
				}
				else if(decision.equals("2")) {
					break;
				}
				else {
					System.out.println("Invalid Input. Please input your answer again: ");
				}
				
				
			}
			
			
			
		
		}
		
	//saves the balance with the player, player is updated in text file.
		System.out.println("Good bye!");
		participant.setMoney(money);
		ps.updateBal(participant);
		input.close();
	}
	
	//used to check input was valid and no mismatch was occurring. Option for "x" to be used as an exit option.
	public static boolean isValidAnswer(String option) {
        
        try {
            Float.parseFloat(option);
        }  catch (Exception e) {
            if(option.equalsIgnoreCase("x")){
                return true;
            }
            System.out.print("Invalid Input. Please input your answer again: ");
            return false;
        }
        return true;
    }
     


}
