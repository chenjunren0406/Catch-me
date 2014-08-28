package jc82_yw31.Client.MiniModel;

import java.awt.Component;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.DataPacketAlgo;
import provided.extvisitor.IExtVisitorCmd;
import provided.mixedData.IMixedDataDictionary;
import provided.mixedData.MixedDataDictionary;
import provided.rmiUtils.IRMIUtils;
import provided.rmiUtils.RMIUtils;
import provided.util.IVoidLambda;
import comp310f13.rmiChat.IAddUser;
import comp310f13.rmiChat.IChatRoom;
import comp310f13.rmiChat.IHost;
import comp310f13.rmiChat.IRemoveUser;
import comp310f13.rmiChat.ITextMessage;
import comp310f13.rmiChat.IUser;
/**
 * the minimodel has a user and a user stub
 * it also has a miniview adapter and a mainmodel adapter
 * the minimodel has a feild of chatroom and a host of inviter
 * @author Administrator
 *
 */
public class MiniModel {
	/**
	 * a boolean flag to determine if the chat room has already been quit.
	 */
	private boolean alreadyQuit = false;
	/**
	 * the adapter the minimodel uses to feed back to the miniview
	 */
	private MiniViewAdapter miniviewadapter;
	/**
	 * the adapter the minimodel uses to call back to the mainmodel
	 */
	private MainModelAdapter mainmodeladapter;
	/**
	 * the local user instance in the chat room
	 */
	private AUser user;
	/**
	 * the stub of the local user
	 */
	private IUser user_stub;

	/**
	 * reference to the chatroom that bonded with the mini-MVC
	 */
	private IChatRoom chatroom;
	/**
	 * the hashmap to store the unknown DataPacket
	 */
	private final HashMap<Class<?>, ADataPacket> unknownPackage = new HashMap<Class<?>, ADataPacket>();

	/**
	 * The Dictionary for server to use
	 */
	private MixedDataDictionary localDict = new MixedDataDictionary();
	
	/**
	 * the constructor of the minimodel. All the necessary components to create a chatroom is initiated within the constructor.
	 * It takes both the mainmodel adapter and the miniview adapter so that it could communicate with both of them without instantiating them.
	 * A chatroom is passed to the minimodel, whose information will be further used to create a local chatroom.
	 * @param miniviewadapter 
	 * @param mainmodeladapter
	 * @param chatroom
	 */
	public MiniModel(MiniViewAdapter miniviewadapter, MainModelAdapter mainmodeladapter, IChatRoom chatroom) throws RemoteException{
		this.miniviewadapter = miniviewadapter;
		this.mainmodeladapter = mainmodeladapter;
		this.chatroom = chatroom;
		init();	
	}
	/**
	 * initialize the minimodel, it generates a new local user along with the minimodel and export a user tub with it 
	 */
	public void init(){
		/**
		 * instantiate a local user to this chatroom
		 */
		user = new AUser(mainmodeladapter.getUUID(), mainmodeladapter.getName(), new Cmd2miniModelAdapt(){
			/**
			 * accesser to the local user stub
			 */
			@Override
			public IUser getLocalUserStub() {
				return user_stub;
			}
			/**
			 * calls back to the miniview of the chatroom to append a string(typically a text message)
			 */
			@Override
			public void append(String s) {
				miniviewadapter.append(s);
			}
			/**
			 * calls back to the miniview to show a new component (such as pictures)
			 */
			@Override
			public void addComponent(String name, Component newComp) {
				miniviewadapter.addComponent(name, newComp);
			}
			/**
			 * calls back to the miniview to show that a new user is entering the chat room.
			 * It also calls the chatroom to locally add the remote user stub.
			 */
			@Override
			public void addUser(IUser userStub) {
				try {
					miniviewadapter.append("welcome a new user : " + userStub.getName());
					miniviewadapter.addUserName(userStub.getName());
					chatroom.addLocalUser(userStub);
				} catch (RemoteException e) {
					e.printStackTrace();
				}				
			}
			/**
			 * calls back to the miniview to show that a user is leaving the chat room.
			 * It also calls the chatroom to locally remove the remote user stub.
			 */
			@Override
			public void removeUser(IUser userStub) {
				try {
					miniviewadapter.append("user : " + userStub.getName() + "  leaves the chat room");
					chatroom.removeLocalUser(userStub);
				} catch (RemoteException e) {
					e.printStackTrace();
				}						
			}
			/**
			 * stores the unknown dataPacket in the hashmap, which will be later retrieved when
			 * a corresponding command is installed
			 */
			@Override
			public void addUnknown(Class<?> index, DataPacket<Object> host) {
				unknownPackage.put(index, host);				
			}
			/**
			 * install a new command to the algo, and re-execute the unknown dataPacket
			 */
			@Override
			public void addCmd(Class<?> id,
					ADataPacketAlgoCmd<ADataPacket, ?, Void> newCmd) {
				newCmd.setCmd2ModelAdpt(this);
				user.getAlgo().setCmd(id, (IExtVisitorCmd<ADataPacket, Class<?>, Void, ADataPacket>) newCmd);					
				unknownPackage.get(id).execute(user.getAlgo()); 
				unknownPackage.remove(id);				
			}
			@SuppressWarnings("unchecked")
			@Override
			public void cmdRequested(Class<?> id, IUser sender) {
				if(null != user.getAlgo().getCmd(id)){
					((ChatRoom)chatroom).sendCmd(id, (ADataPacketAlgoCmd<ADataPacket, ?, Void>)user.getAlgo().getCmd(id), user_stub, sender);
				}

			}
			@Override
			public void appendInfo(String info) {
				miniviewadapter.appendInfo(info);				
			}
			@Override
			public IMixedDataDictionary getDataDict() {
				
				return localDict;
			}
		});
		/**
		 * export a user stub using the newly instantiated AUser
		 */
		try {
			user_stub = (IUser) UnicastRemoteObject.exportObject(user, IUser.CONNECTION_PORT_CLIENT);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * A command used as a wrapper around the view adapter for the IRMIUtils
	 */
	private IVoidLambda<String> outputCmd = new IVoidLambda<String> (){
		public void apply(String... strs){
			for(String s: strs) miniviewadapter.appendInfo(s);
		}
	};

	/**
	 * start the minimodel by setting the properties appropriately. Besides, retrieve all the users' names and list them in the comboBox
	 * in the miniview.
	 */
	private IRMIUtils rmiUtils = new RMIUtils(outputCmd);
	/**
	 * the start method 
	 * when start the minimodel, it will send the IAddUser kind of datapakcet to every user in the chatroom
	 * and then add the user itself into the chatroom
	 */
	public void start(){
		try {
			miniviewadapter.append("welcome a new user : " + user_stub.getName());

			IAddUser addUser = new AaddUser(user_stub);
			DataPacket<IAddUser> ds = new DataPacket<IAddUser>(IAddUser.class, user_stub, addUser);
			sendMessage(ds); //add the local user stub to the chat room after notifying other users

			chatroom.addLocalUser(user_stub);// add the local machine to the chat room

			Iterable<IUser> allUsers = chatroom.getUsers();
			java.util.Iterator<IUser> itr = allUsers.iterator();
			while(itr.hasNext()) {
				IUser eachUser = itr.next();
				miniviewadapter.addUserName(eachUser.getName()); //display the user names on the miniview
			}
			miniviewadapter.appendInfo("chatroom information : ");
			miniviewadapter.appendInfo(((ChatRoom)chatroom).chatRoomInfo());
		} catch (Exception e) {
			System.err.println("Error getting local address: " + e);
		}
	}

	/**
	 * Locate the local host_stub stored previously
	 */
	private IHost LocateLocalHost(){
		IHost localhost = null;
		try {
			Registry localregistry = rmiUtils.getLocalRegistry();		
			localhost = (IHost) localregistry.lookup(IHost.BOUND_NAME);
		} catch (Exception e) {
			miniviewadapter.appendInfo("Exception retrieving local IHost" + "\n");
			e.printStackTrace();
		}
		return localhost;
	}

	/**
	 * quit the chatroom. Remove the local user stub and notify other users to remove you from the chat room
	 */
	public void quit() {
		if(!alreadyQuit){
		chatroom.removeLocalUser(user_stub);
		IRemoveUser removeUser = new AremoveUser(user_stub);
		DataPacket<IRemoveUser> ds = new DataPacket<IRemoveUser>(IRemoveUser.class, user_stub, removeUser);
		sendMessage(ds); // pass the IRemoveUser datapacket to all users in the chat room and collect the response
		alreadyQuit = true;
		}
	}
	/**
	 * send a text message to all the users in the chat room
	 */
	public void sendText(String text) {

		ITextMessage textMessage;

		try {
			textMessage = new AtextMessage(user.getName(), text);			
			DataPacket<ITextMessage> dp = new DataPacket<ITextMessage>(ITextMessage.class, user_stub, textMessage);
			sendMessage(dp); //pass the text datapacket to all users in the chatroom and collect response
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	/**
	 * send the dataPacket to all users in the chat room and process their response
	 */
	public void sendMessage(DataPacket<?> dp){
		Iterable<ADataPacket> response = chatroom.sendMessage(dp); //pass the text datapacket to all users in the chatroom and collect response
		java.util.Iterator<ADataPacket> itr = response.iterator();
		DataPacketAlgo<ADataPacket, Void> algo = user.getAlgo();
		while(itr.hasNext())
		{
			try {
				ADataPacket next = itr.next();
				if(null != next){
					next.execute(algo);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	} 

	/**
	 * Invite a remote user to a chatroom. Wait for the response. If the invitation is accepted, send the chatroom to the user.
	 * @param remoteUser
	 */
	public void invite(final String remoteUser){
		/**
		 * creating a new thread to run the invitation process, so that the following invitation does not have to wait for the result
		 * of the former invitation
		 */
		new Thread(){
			public void run(){
				LocateLocalHost();
				miniviewadapter.appendInfo("Inviting User:" + remoteUser + "...\n");
				IHost invitee = null;
				boolean accept = true;
				try {
					Registry registry = rmiUtils.getRemoteRegistry(remoteUser);		
					invitee = (IHost) registry.lookup(IHost.BOUND_NAME);
					if(accept==true){
						invitee.addToChatRoom(chatroom);
						miniviewadapter.appendInfo(((ChatRoom)chatroom).chatRoomInfo());
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}.start(); 
	}
}
