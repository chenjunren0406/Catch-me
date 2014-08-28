package jc82_yw31.Client.Model;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.UUID;

import jc82_yw31.Client.MiniModel.ChatRoom;
import jc82_yw31.Client.Model.ClientMainModel;
import jc82_yw31.Client.Model.ViewAdapter;
import jc82_yw31.Client.View.Option_Dialog;
import comp310f13.rmiChat.IChatRoom;
import comp310f13.rmiChat.IChatRoomInvite;
import comp310f13.rmiChat.IHost;
import comp310f13.rmiChat.IUser;
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
public class ClientHost implements IHost, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1324686625404757825L;
	private ClientMainModel model;
	public IHost PartHost;
	private UUID uuid;
	private IChatRoomInvite chooseInvite;
	private Option_Dialog option;
	/**
	 * the constructor of AHost
	 * @param view is the view adapter
	 * @param model is the main model 
	 * AHost has a unique UUID which identifies thhis host
	 */
	public ClientHost(ViewAdapter view, ClientMainModel model){
		uuid = UUID.randomUUID();
		this.model = model;
	}
	/**
	 * get the unique UUID of AHost
	 */
	public UUID getUUID(){
		return this.uuid;
	}
	/**
	 * get the localHostStub and set the partHost
	 */
	public void sendLocalHostStub(IHost localHostStub) throws RemoteException {
		PartHost = localHostStub;
	}
    
	/**
	 * send the invite to another host
	 * throw the chatroominfo to the host
	 */

	/**
	 * using the chatroom information provided by the remote inviter to create a concrete chatroom instantce.
	 * This avoids the potential class name conflicts between different machines that may affect the casting of local chatroom
	 */
	public boolean addToChatRoom(IChatRoom localChatRoom) throws RemoteException {
		String name = localChatRoom.getName();
		Iterable<IUser> users = localChatRoom.getUsers();
		ChatRoom chatRoom = new ChatRoom(name);
		java.util.Iterator<IUser> its = users.iterator();
		while(its.hasNext())
		{
			chatRoom.addLocalUser(its.next());		
		}
		return model.start_miniC(chatRoom);
	}
    /**
     * the the name of the host
     */
	public String getName(){
		return "Junren";		
	}

	/**
	 *  do nothing
	 */
	@Override
	public void requestInvite(IHost localHostStub) throws RemoteException {
		
		
	}
	/**
	 * this method will be called by server, server will give you the chatroomInfo
	 */
	@Override
	public UUID sendInvite(Iterable<IChatRoomInvite> chatroomInfo)
			throws RemoteException {
		
		option = new Option_Dialog(chatroomInfo);
		
		option.setModal(true);
		option.setVisible(true);
		
		chooseInvite = option.getReturnInvite();
		
		return chooseInvite.getUUID();
		
	}

}
