package jc82_yw31.Server.Model;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.UUID;

import comp310f13.rmiChat.IChatRoom;
import comp310f13.rmiChat.IChatRoomInvite;
import comp310f13.rmiChat.IUser;

/**
 * Send charRoom invite to another's
 * @author Junren
 *
 */
public class AChatRoomInvite implements IChatRoomInvite,Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -2335881118302011513L;

	private UUID uuid;
	private IChatRoom chatroom;
	/**
	 * constructor
	 * @param chatroom the chatroom you want to invite
	 * @throws RemoteException
	 */
	public AChatRoomInvite(IChatRoom chatroom) throws RemoteException{
		this.chatroom = chatroom;
		this.uuid = UUID.randomUUID();

	}
	
	/**
	 * get the name of chatRoon
	 */
	public String getName() {
		return this.chatroom.getName();
	}
	/**
	 * get the uuid of chatroom
	 */
	public UUID getUUID() {
		return this.uuid;
	}
	
	/**
	 * get the arraylist of member of chatroom
	 */
	public Iterable<String> getUserNames() {
		Iterable<String> names = new ArrayList<String>();
		java.util.Iterator<IUser> eachUser = chatroom.getUsers().iterator();
		while(eachUser.hasNext()){
		   String user_name;
		try {
			user_name = eachUser.next().getName();
			 ((ArrayList<String>) names).add(user_name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
		return names;
	}

}
