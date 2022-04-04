/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newassignment;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * this class will check the text file if the player has already played or not
 * if they have then they will get their relevant details or else a new player is 
 * put into the text file. all players are updated with current balance into the text file. 
 */


public class ParticipantReg {
	private HashMap<String, Participant> participant;
	private final String file;
	
	public ParticipantReg() {
		this.file="participants.txt";
		this.participant=new HashMap();
		this.getparticipant(file);
	}
	
	//reads the file for the player
	public void getparticipant(String file) {
		FileInputStream fn;
		
		try {
			fn=new FileInputStream(file);
			Scanner fileRead = new Scanner (fn);
			
			while(fileRead.hasNextLine()) {
				String line=fileRead.nextLine();
                StringTokenizer st= new StringTokenizer(line);
                Participant p=new Participant(st.nextToken(), Float.parseFloat(st.nextToken()));
                this.participant.put(p.getName(), p);
			}
			
			fn.close();
		}catch (FileNotFoundException ex) {
            Logger.getLogger(ParticipantReg.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ParticipantReg.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	//if player is not already in text file, then the new default balance is saved with them
	public Participant checkParticipant(String pName) {
		Participant p;
		if(this.participant.containsKey(pName)) {
			p=this.participant.get(pName);
		}
		else {
			p = new Participant(pName, 1000);
			this.participant.put(pName, p);
		}
		
		return p;
		
	}
	
	//updates the text file for the player with their new balance.
	public void updateBal(Participant participant) {
		this.participant.put(participant.getName(), participant);
		try {
			 FileOutputStream fOut=new FileOutputStream(this.file);
			 PrintWriter pw=new PrintWriter(fOut);
	            for(Participant p: this.participant.values()){
	                pw.println(p.getName()+" "+p.getMoney());
	            }
	            pw.close();
		}catch (FileNotFoundException ex) {
            Logger.getLogger(ParticipantReg.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}
	
	

}
