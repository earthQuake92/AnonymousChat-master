package it.isislab.p2p.chat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import net.tomp2p.peers.PeerAddress;

public class Room implements Serializable {

	private String name;
	private int peerMax;
	private HashSet<PeerAddress> users;
	
	public Room(String name,int n) {
		
		this.name=name;
		this.peerMax=n;
		users=new HashSet<PeerAddress>();
	}

	
	public HashSet<PeerAddress> getUsers() {
		return users;
	}



	public void setUsers(HashSet<PeerAddress> users) {
		this.users = users;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPeerMax() {
		return peerMax;
	}

	public void setPeerMax(int peerMax) {
		this.peerMax = peerMax;
	}
	public void addPeer(PeerAddress p) {
		
	this.users.add(p);
	}
	public boolean removePeer(PeerAddress p) {
		for(PeerAddress t: users)
			if(t.equals(p))
			{
				users.remove(p);
				return true;
			}
		return false;
	}
}
