package jc82_yw31.Server.MiniModel;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.UUID;

import jc82_yw31.Client.MiniModel.AaddCmd;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import comp310f13.rmiChat.IAddCmd;
import comp310f13.rmiChat.IChatRoom;
import comp310f13.rmiChat.IUser;
/**
 * the chatroom which basically is a users' arraylist
 * @author Administrator
 *
 */
public class ChatRoom implements IChatRoom,Serializable{

	private static final long serialVersionUID = 5792290997783420304L;

	private String chatRoomName;
	private ArrayList<IUser> users;
	private UUID uuid;
	/**
	 * get the chatroom information 
	 * the information include the chatroom name and the number of user in the chatroom
	 * @return
	 */
	public String chatRoomInfo()
	{
		String info = new String();
		info = info.concat("the chatRoomName is : ");
		info = info.concat(chatRoomName);
		info = info.concat("\n");
		info = info.concat("users' number in this chatRoom is :");
		String temp = new String("" + users.size());
		info = info.concat(temp);
		return info;
	}
	/**
	 * get the users number in the chatroom
	 * @return
	 */
	public int getUserSize(){
		return users.size();
	}
	/**
	 * get the user information of the chatroom
	 * @return
	 * @throws RemoteException
	 */
	public String[] getUsersInfo() throws RemoteException{
		String[] user_info = new String[users.size()];
		for(int i = 0; i < users.size(); i++){
			user_info[i].concat("user's name is : ");
			user_info[i].concat(users.get(i).getName());
			user_info[i].concat(";  user's UUID is : ");
			user_info[i].concat(users.get(i).getUUID().toString());
		}
		return user_info;
	}
	/**
	 * the constructor of the chatroom
	 * it will new a arraylist of the users
	 * @param chatRoomName
	 */
	public ChatRoom(String chatRoomName){
		this.chatRoomName = chatRoomName;
		users = new ArrayList<IUser>();
		this.uuid = UUID.randomUUID();
	}
	/**
	 * get the chatroom's name
	 */
	public String getName() {
		return chatRoomName;
	}
	

	/**
	 * add the local user stub to the chatroom
	 */
	public void addLocalUser(IUser newUserStub) {
		boolean alreadyIn = false;
		java.util.Iterator<IUser> eachUser = users.iterator();
		while(eachUser.hasNext()){
			try {
				if(eachUser.next().getUUID() == newUserStub.getUUID())
					alreadyIn = true;
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		if(!alreadyIn){
			users.add(newUserStub);
		}
	}
	/**
	 * remove the stub of local user from the chatroom
	 */
	@Override
	public void removeLocalUser(IUser userStub) {

		users.remove(userStub);
	}
	/**
	 * accesser to all the user stubs included in the chatroom
	 */
	public Iterable<IUser> getUsers() {
		return users;
	}

	/**
	 * send the message to every one in the chatroom 
	 * the message will be sent in every user in the chatroom's arraylist
	 */
	public Iterable<ADataPacket> sendMessage(ADataPacket dp) {
		ArrayList<ADataPacket> dataPackets = new ArrayList<ADataPacket>();
		java.util.Iterator<IUser> eachUser = users.iterator();
		while(eachUser.hasNext())
		{
			try {
				ADataPacket returnPackage = eachUser.next().receiveData(dp);
				dataPackets.add(returnPackage);
			} catch (RemoteException e) {
				e.printStackTrace();
			}	
		}
		return dataPackets;
	}
	/**
	 * send cmd 
	 * @param id is the kind of the datapacket
	 * @param cmd the cmd to be sent
	 * @param userStub the user stub
	 * @param sender the visitor of the cmd, will add the cmd
	 */
	public void sendCmd(Class<?> id,
			ADataPacketAlgoCmd<ADataPacket, ?, Void> cmd,
			IUser userStub,
			IUser sender) {
		IAddCmd cmdMessage = new AaddCmd(cmd, id);
		DataPacket<IAddCmd> dp = new DataPacket<IAddCmd>(IAddCmd.class, userStub, cmdMessage);
		try {
			sender.receiveData(dp);
		} catch (RemoteException e) {
			e.printStackTrace();
		}		
	}
	public UUID getUUID() {
		return this.uuid;
	}

}
