package jc82_yw31.Server.Model;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import jc82_yw31.Server.Controller.MiniController;
import jc82_yw31.Server.MiniModel.*;
import jc82_yw31.Server.Model.ViewAdapter;
import comp310f13.rmiChat.IChatRoom;
import comp310f13.rmiChat.IChatRoomInvite;
import comp310f13.rmiChat.IHost;
import provided.rmiUtils.IRMIUtils;
import provided.rmiUtils.IRMI_Defs;
import provided.rmiUtils.RMIUtils;
import provided.util.IVoidLambda;


/**
 * the model class
 * it has the host stub and the remote host which it want to connect
 * the view is the viewadapter which is used to communicate with the main view
 * @author Administrator
 *
 */
public class MainModel {

	/**
	 * The RMI Registry
	 */
	private Registry registry;
	/**
	 * the adapter the controller uses to comunicate with the view
	 */
	private ViewAdapter view;
	/**
	 * the local IHost stub. Each machine only has one IHost stub.
	 */
	private IHost host_stub;
	private AHost host;
	/**
	 * reference to a remote host stub
	 */
	private IHost remote_host;
	private ArrayList<MiniController> allminiMVCs = new ArrayList<MiniController>();
	/**
	 * The arraylist to save all the current running mini-MVC systems each corresponds to a chat room. 
	 */
//	private ArrayList<ChatRoom> teams = new ArrayList<ChatRoom>();
	//private ArrayList<MiniController> allminiMVCs = new ArrayList<MiniController>();
	//private ArrayList<IChatRoomInvite> chatroominfo;
	public static Map<UUID, IChatRoom> map;
	
	public ArrayList<IChatRoomInvite> chatroominfo;
	private ArrayList<IChatRoom> chatrooms;
	/**
	 * the constructor of the main model
	 * it will set the view adapter 
	 * @param view
	 */

	public MainModel(ViewAdapter view){
		this.view = view;
		this.chatroominfo = new ArrayList<IChatRoomInvite>();
		this.chatrooms = new ArrayList<IChatRoom>();
		map = new HashMap<UUID, IChatRoom>();
	}
	/**
	 * start the miniMVC using the chatroom information passed to the miniMVC system
	 * @param localChatRoom
	 * @return boolean value indicating if the chatroom is successfully established
	 * @throws RemoteException
	 */

	/**
	 * A command used as a wrapper around the view adapter for the IRMIUtils
	 */
	private IVoidLambda<String> outputCmd = new IVoidLambda<String> (){
		public void apply(String... strs){
			for(String s: strs)view.append(s);
		}
	};

	/**
	 * Utility object used to get the Registry
	 */
	private IRMIUtils rmiUtils = new RMIUtils(outputCmd);
	/**
	 * start the server  
	 * when start, new a host, use the registry to get the host stub
	 * bind the host stub and the bound naem
	 * show some information on the view
	 */
	public void start_Server(){
		rmiUtils.startRMI(IRMI_Defs.CLASS_SERVER_PORT_SERVER);
		host = new AHost(view, this);
		try{
			
			registry = rmiUtils.getLocalRegistry();
			host_stub = (IHost) UnicastRemoteObject.exportObject(host, IHost.CONNECTION_PORT_SERVER);
			registry.rebind(IHost.BOUND_NAME, host_stub);
			view.append("IHost bound to "+ IHost.BOUND_NAME+"\n");
			view.append(System.setProperty("java.rmi.server.hostname", getLocalAddress()));

		}
		catch (Exception e) {
			System.err.println("MainModel exception:"+"\n");
			e.printStackTrace();
			System.exit(-1);
		}

	}
	
	public boolean start_miniC(IChatRoom localChatRoom) throws RemoteException{
		try{			
			/**
			 * make a new local mini-MVC system using the chat room given every time it's called.
			 */
			MiniController miniMVC = new MiniController(new MainModelAdapter(){
				/**
				 * retrieve the UUID of the local IHost
				 */
				public UUID getUUID() {
					try {
						return getHost().getUUID();
					} catch (RemoteException e) {
						e.printStackTrace();
						return null;
					}
				}
				/**
				 * retrieve the name of the local host
				 */
				public String getName() {

					try {
						return getHost().getName();
					} catch (RemoteException e) {
						e.printStackTrace();
						return null;
					}
				}

			}, (ChatRoom)localChatRoom);

			miniMVC.start(); //start the mini-MVC
			allminiMVCs.add(miniMVC);

			return true;
		}
		catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	public IChatRoom createLobby() throws RemoteException{
		ChatRoom lobby = new ChatRoom("Catch me if you can!");
		AChatRoomInvite achatroominvite = new AChatRoomInvite(lobby);
		view.append("the chatroom's name is : " + lobby.getName());
		map.put(achatroominvite.getUUID(), lobby);
		this.chatroominfo.add(achatroominvite);
		this.chatrooms.add(lobby);
		
		return lobby;
	}

    
	
	/**
	 * stop the RMI and unbind the IHost stub when the main windows is closed
	 */
	public void stop() {
		try {
			registry.unbind(IHost.BOUND_NAME);
			System.out.println("Controller: " + IHost.BOUND_NAME
					+ " has been unbound.");

			rmiUtils.stopRMI();
			quitAllchatRooms();
			System.exit(0);

		} catch (Exception e) {
			System.err.println("Controller: Error unbinding "
					+ IHost.BOUND_NAME + ":\n" + e);
			System.exit(-1);
		}
	}
	/**
	 * quit all the running chat rooms when called
	 */
	private void quitAllchatRooms() {
		
		
//		for(MiniController c:allminiMVCs){
//			c.quit();
//		}		
	}
	/**
	 * method used to get local IP address
	 * 
	 * @return local IP address
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public String getLocalAddress() throws SocketException, UnknownHostException {
		// The code below is needed for Linux to find the host's real
		// (non-loopback) IP address.
		Enumeration<NetworkInterface> nics = NetworkInterface.getNetworkInterfaces();
		while (nics.hasMoreElements()) {
			NetworkInterface nic = nics.nextElement();
			Enumeration<InetAddress> addrs = nic.getInetAddresses();
			while (addrs.hasMoreElements()) {
				InetAddress addr = addrs.nextElement();
				if (!addr.isLoopbackAddress() && (addr instanceof Inet4Address)) {
					return addr.getHostAddress();
				}
			}
		}
		return java.net.InetAddress.getLocalHost().getHostAddress();
	}
	/**
	 * accesser to the local IHost stub
	 * @return local IHost stub
	 */
	public IHost getHost() {	
		return this.host_stub;
	}
	/**
	 * accesser to the remote IHost stub
	 * @return remote host stub
	 */
	public IHost getRemoteHost() {	
		return this.remote_host;
	}


}