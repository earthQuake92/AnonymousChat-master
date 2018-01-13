package it.isislab.p2p.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class shell {

	public static void main(String[] args) {
		try {
			int value=Integer.parseInt(args[0]);
			AnonymousChat peer0 = new AnonymousChatImpl(value, "127.0.0.1", new MessageListenerImpl(value));
			if(value==0){
			  peer0.createRoom("calcio");
			  System.out.println("Stanza calcio creata...");
			}
			System.out.println("Entro nella stanza calcio...");  
			peer0.joinRoom("calcio");
			
			String line;
			BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
			while (!(line=reader.readLine()).equalsIgnoreCase("EXIT")){
			    System.out.println("Il peer "+value+" invia :"+line);
				peer0.sendMessage("calcio",line);
			}
            peer0.leaveRoom("calcio");
            System.out.println("Uscito dalla stanza calcio..."); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
