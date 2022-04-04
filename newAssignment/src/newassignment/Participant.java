/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newassignment;

/*
 * Outlines the user/player, the important 
 * and relevant pieces of information.
 * 
 * @author Faraaz Khan 17985055
 */

public class Participant {
	
	private String name = null;
	
	private float money = 0;
	
	public Participant(String name, float money) {
		this.name = name;
		this.money=money;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getMoney() {
		return this.money;
	}
	
	public void setMoney(float money) {
		this.money=money;
	}

}
