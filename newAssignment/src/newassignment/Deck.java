/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newassignment;

import java.util.ArrayList;
import java.util.Collections;

/*
 * this class gets the all the cards for each value and suit and stores it using
 * an arraylist. 
 * has methods for adding, removing and shuffling the cards in the deck. 
 * as well as printing the individual  cards with card art. 
 * 
 * @author Faraaz Khan 17985055
 */

public class Deck {
	
	protected ArrayList<Cards> cards;
	protected String num;
	protected int suitType;
	protected String art;
	
	public Deck() {
		this.cards=new ArrayList<Cards>();
	}
	//adds all 52 cards to the deck as well as shuffling them.
	public void fullDeck() {
		for(CardSuit cardSuit : CardSuit.values()) {
			for(CardValues cardValue : CardValues.values()) {
				cards.add(new Cards(cardValue, cardSuit));
				
				
			}
		}
		
		Collections.shuffle(cards);
	}
	
	//removes a card from the deck
	public void removeCard(int pick) {
		cards.remove(pick);
	}
	
	//allows to get a card from the deck
	public Cards getCard(int pick) {
		return cards.get(pick);
	}
	
	//adds a acrd to the deck
	public void addCrad(Cards newCard) {
		cards.add(newCard);
	}
	
	//draws from deck
	public void pick(Deck from) {
		cards.add(from.getCard(0));
		from.removeCard(0);
	}
	
	//finds the value for each card in the deck
	public int sum() {
		int sum = 0;
		int ace =0;
		
		for(Cards singleCard : this.cards){
			switch(singleCard.getValue()){
			case TWO: sum += 2; break;
			case THREE: sum += 3; break;
			case FOUR: sum += 4; break;
			case FIVE: sum += 5; break;
			case SIX: sum += 6; break;
			case SEVEN: sum += 7; break;
			case EIGHT: sum += 8; break;
			case NINE: sum += 9; break;
			case TEN: sum += 10; break;
			case JACK: sum += 10; break;
			case QUEEN: sum += 10; break;
			case KING: sum += 10; break;
			case ACE: ace += 1; break;
			}
		}
		
		for(int i =0; i<ace; i++) {
			if(sum>10) {
				sum+=1;
			}
			else {
				sum +=11;
			}
		}
		
		return sum;
		
	}
	
	//the size of the deck
	public int size() {
		return cards.size();
	}
	
	
	public void returnC(Deck cc) {
		int deckSize=cards.size();
		for(int i=0;i<deckSize;i++) {
			cc.addCrad(getCard(i));
		}
		for(int i=0;i<deckSize;i++) {
			removeCard(0);
		}
	}
	
	//prints card art for each card.
	public void cardArt() {
		for(Cards aCard : cards){
			switch(aCard.getValue()){
			case TWO: num = "2"; break;
			case THREE: num = "3"; break;
			case FOUR: num = "4"; break;
			case FIVE: num = "5"; break;
			case SIX: num = "6"; break;
			case SEVEN: num = "7"; break;
			case EIGHT: num = "8"; break;
			case NINE: num = "9"; break;
			case TEN: num = "10"; break;
			case JACK: num = "J"; break;
			case QUEEN: num = "Q"; break;
			case KING: num = "K"; break;
			case ACE: num = "A"; break;
			}
			
			switch(aCard.getSuit()) {
			case SPADES: suitType =1; break;
			case DIAMONDS: suitType=2; break;
			case HEARTS: suitType=3; break;
			case CLUBS: suitType=4;break;
			}
			
			if(suitType==1) {
				if(num=="10") {
					
					art=
				             " ___________\n"
							+"| "+num +"        |\n"
							+"|    ^      |\n" 
							+"|   / \\     |\n" 
							+"|  /   \\    |\n" 
							+"| (_____)   |\n" 
							+"|    |      |\n"
							+"|        " +num+ " |\n"
							+" -----------\n" 	;
					
				}
				else {
					
					art=
					             " ___________\n"
								+"| "+num +"         |\n"
								+"|    ^      |\n" 
								+"|   / \\     |\n" 
								+"|  /   \\    |\n" 
								+"| (_____)   |\n" 
								+"|    |      |\n"
								+"|         " +num+ " |\n"
								+" -----------\n" 	;
				}
			}
			else if(suitType==2){
				if(num=="10") {
					art=
				             " ___________\n"
				            +"| "+num +"        |\n"
							+"|           |\n" 
							+"|   /\\      |\n" 
							+"|  /  \\     |\n" 
							+"|  \\  /     |\n" 
							+"|   \\/      |\n"
							+"|        " +num+ " |\n"
							+" -----------\n" 	;
					 
					
				}
				else {
					
					art=
			             " ___________\n"
			            +"| "+num +"         |\n"
						+"|           |\n" 
						+"|   /\\      |\n" 
						+"|  /  \\     |\n" 
						+"|  \\  /     |\n" 
						+"|   \\/      |\n"
						+"|         " +num+ " |\n"
						+" -----------\n" 	;
				}
			}
			else if(suitType==3){
				if(num=="10") {
					art=
				             " ___________\n"
							+"| "+num +"        |\n"
							+"|   _  _    |\n" 
							+"|  ( \\/ )   |\n" 
							+"|   \\  /    |\n" 
							+"|    \\/     |\n" 
							+"|           |\n"
							+"|        " +num+ " |\n"
							+" -----------\n" 	;
					
				}
				else {
					
					art=
			             " ___________\n"
						+"| "+num +"         |\n"
						+"|   _  _    |\n" 
						+"|  ( \\/ )   |\n" 
						+"|   \\  /    |\n" 
						+"|    \\/     |\n" 
						+"|           |\n"
						+"|         " +num+ " |\n"
						+" -----------\n" 	;
				}
				 
			}
			else if(suitType==4){
				if(num=="10") {
					art=
				             " ___________\n"
							+"| "+num +"        |\n"
							+"|     _     |\n" 
							+"|    ( )    |\n" 
							+"|   (___)   |\n" 
							+"|     |     |\n" 
							+"|           |\n"
							+"|        " +num+ " |\n"
							+" -----------\n" 	;
					
				}
				else {
					
					art=
			             " ___________\n"
						+"| "+num +"         |\n"
						+"|     _     |\n" 
						+"|    ( )    |\n" 
						+"|   (___)   |\n" 
						+"|     |     |\n" 
						+"|           |\n"
						+"|         " +num+ " |\n"
						+" -----------\n" 	;
				}
			}
			
			System.out.print(art);
		}

	}
	
	
	 public String toString() {
		 String cardOutput="";
	
		 for(Cards card:this.cards) {
			 cardOutput += "\n"  +" --->  " +card.toString();	 
		 }
		 
		 return cardOutput;
		 
	 }
	

}

