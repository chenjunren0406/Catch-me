package jc82_yw31.Client.MiniModel;

import java.rmi.RemoteException;
import java.util.UUID;

import jc82_yw31.rmi.Commands.*;
import provided.datapacket.ADataPacket;
import provided.datapacket.DataPacketAlgo;
import comp310f13.rmiChat.*;
/**
 * the AUser class
 * the user class has a field of user_name
 * user uuid and the visitor a datapacket algo
 * @author Administrator
 *
 */
public class AUser implements IUser {
	/**
	 * reference to the user name associated with the user
	 */
	private String user_Name;
	/**
	 * reference to the user UUID associated with the user
	 */
	private UUID user_uuid;	
	/**
	 * the algo (host) used to apply the cmds
	 */
	private final DataPacketAlgo<ADataPacket, Void> algo = new DataPacketAlgo<ADataPacket, Void>(null);
	/**
	 * the constructor of the AUser 
	 * @param user_uuid  the host's unique uuid set to this user
	 * @param user_Name  the user name
	 * @param Cmd2ModelAdapter  the to model adapter
	 */
	public AUser(UUID user_uuid, String user_Name, Cmd2miniModelAdapt Cmd2ModelAdapter){
		this.user_uuid = user_uuid;
		this.user_Name = user_Name;
		init(Cmd2ModelAdapter);
	}
	/**
	 * the initial method of the user, in which all the basic commands are installed.
	 * @param Adpt is the to minimodel adapter the user will use
	 */
	public void init(final Cmd2miniModelAdapt Adpt){
		/**
		 * Instantiate a default command for the algo; It is used if the local machine can not process the received the dataPacket.
		 */
		DefaultCmd defaultCmd = new DefaultCmd();
		defaultCmd.setCmd2ModelAdpt(Adpt); // apply the adapter to the default command 
		algo.setDefaultCmd(defaultCmd);

		/**
		 * set the adduser command , which installs a command to deal with the IAddUser datapacket. The addUserCmd is initialized during the instantiation of minimodel, which further passes
		 * the cmd to the AUser
		 */
		AddUserCmd addUserCmd = new AddUserCmd();
		addUserCmd.setCmd2ModelAdpt(Adpt);// apply the adapter to the addUserCmd command 
		algo.setCmd(IAddUser.class, addUserCmd);
		
		/**
		 * set the remove command to the visitor, remove a user from the chat room
		 */
		RemoveUserCmd removeUserCmd = new RemoveUserCmd();
		removeUserCmd.setCmd2ModelAdpt(Adpt);// apply the adapter to the addUserCmd command 
		algo.setCmd(IRemoveUser.class, removeUserCmd);

		/**
		 * install a command to deal with the ITextMessage datapacket
		 */
		TextMessageCmd textMessageCmd = new TextMessageCmd();
		textMessageCmd.setCmd2ModelAdpt(Adpt);// apply the adapter to the textMessageCmd command 
		algo.setCmd(ITextMessage.class, textMessageCmd);
		/**
		 * install a cmd received to deal with the unknown dataPacket
		 */
		AddNewCmd addCmd = new AddNewCmd();
		addCmd.setCmd2ModelAdpt(Adpt);// apply the adapter to the addCmd command 
		algo.setCmd(IAddCmd.class, addCmd);
		/**
		 * sends a command to the receiver when the receiver can process the former dataPacket
		 */
		RequestCmd requestCmd = new RequestCmd();
		requestCmd.setCmd2ModelAdpt(Adpt);
		algo.setCmd(IRequestCmd.class, requestCmd);
		/**
		 * sets the OkCmd which deals with the IStatusOk
		 */		
		OkCmd okCmd = new OkCmd();
		okCmd.setCmd2ModelAdpt(Adpt);// apply the adapter to the addUserCmd command 
		algo.setCmd(IStatusOk.class, okCmd);		
		/**
		 * The fail command. It appends a message on the miniview showing the fail message
		 */
		FailCmd failCmd = new FailCmd();
		failCmd.setCmd2ModelAdpt(Adpt);// apply the adapter to the addUserCmd command 
		algo.setCmd(IStatusFail.class, failCmd);
		
		/**
		 * set map command
		 */
//		MapCmd mapCmd = new MapCmd();
//		mapCmd.setCmd2ModelAdpt(Adpt);
//		algo.setCmd(MapLayer.class, mapCmd);
		
		RejectCmd rejectCmd = new RejectCmd();
		rejectCmd.setCmd2ModelAdpt(Adpt);
		algo.setCmd(IStatusReject.class, rejectCmd);
	}
	/**
	 * accesser to the name of the user
	 */
	public String getName() throws RemoteException {
		return user_Name;
	}
	/**
	 * accesser to the UUID of the user
	 */
	public UUID getUUID() throws RemoteException {
		return user_uuid;
	}
	/**
	 * Sends the data packet to this user from the given user to be processed.
	 * The IUser sender who is sending this message must already be in the data packet.  
	 * @param dp The data packet to send
	 * @return An ADataPacket, most likely a status data type
	 * @throws RemoteException  Required for RMI transactions.
	 */
	public ADataPacket receiveData(ADataPacket dp) throws RemoteException {
		System.out.println("packet from :" + dp.getSender().getName());
		return dp.execute(algo);
	}
	/**
	 * accesser to the algo of the user
	 * @return algo
	 */
	public DataPacketAlgo<ADataPacket, Void> getAlgo(){
		return this.algo;
	}

}
