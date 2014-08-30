package jc82_yw31.Server.Model;

import java.rmi.RemoteException;
import java.util.UUID;

import jc82_yw31.Server.Model.MainModel;
import jc82_yw31.Server.Model.ViewAdapter;
import comp310f13.rmiChat.IChatRoom;
import comp310f13.rmiChat.IChatRoomInvite;
import comp310f13.rmiChat.IHost;
/**
 * implements the interface IHost 
 * A stub of this class is what the local machine gets from a remote Registry. 
 * A stub of this class is passed to the remote machine to enable
 * the remote machine to communicate back to the local machine. 
 * A stub of this type will be bound in the Registry with the name IHost.BOUND_NAME 
 * on the port IHost.CONNECTION_PORT 
 * the AHost has a partHost field, which is the host of the connected user
 * @author Administrator
 *
 */
public class AHost implements IHost{

	private MainModel model;
	public IHost PartHost;
	private UUID uuid;
	
	/**
	 * the constructor of AHost
	 * @param view is the view adapter
	 * @param model is the main model 
	 * AHost has a unique UUID which identifies thhis host
	 */
	public AHost(ViewAdapter view, MainModel model){
		uuid = UUID.randomUUID();
		this.model = model;
	}
	public void update(IChatRoom chatroom, AChatRoomInvite chatroominvite){
		
	}
	public String getName() throws RemoteException {
		return "YiNuo_Junren!";		
	}


	public UUID getUUID() throws RemoteException {
		return this.uuid;
	}


	public void sendLocalHostStub(IHost localHostStub) throws RemoteException {
		PartHost = localHostStub;	
		
	}


	public boolean addToChatRoom(IChatRoom localChatRoom)
			throws RemoteException {
		return true;
	}
 	
	public void requestInvite(final IHost localHostStub) throws RemoteException {
		Thread thread = new Thread(new Runnable(){

			@SuppressWarnings("static-access")
			@Override
			public void run() {
				UUID the_uuid;
				try {
					the_uuid = localHostStub.sendInvite(model.chatroominfo);
					localHostStub.addToChatRoom(model.map.get(the_uuid));
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
				
			}
			
		});
		thread.start();
	}

	public UUID sendInvite(Iterable<IChatRoomInvite> chatroomInfo)
			throws RemoteException {
		return IChatRoomInvite.NONE;
	}

}
