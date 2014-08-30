package jc82_yw31.Client.Model;

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
import java.util.UUID;

import jc82_yw31.Client.Controller.*;
import jc82_yw31.Client.MiniModel.ChatRoom;
import jc82_yw31.Client.MiniModel.MainModelAdapter;
import comp310f13.rmiChat.IChatRoom;
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
public class ClientMainModel {

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
	/**
	 * reference to a remote host stub
	 */
	private IHost remote_host;
	/**
	 * The arraylist to save all the current running mini-MVC systems each corresponds to a chat room. 
	 */
	private ArrayList<MiniController> allminiMVCs = new ArrayList<MiniController>();
	/**
	 * the constructor of the main model
	 * it will set the view adapter 
	 * @param view
	 */

	public ClientMainModel(ViewAdapter view){
		this.view = view;
	}
	/**
	 * start the miniMVC using the chatroom information passed to the miniMVC system
	 * @param localChatRoom
	 * @return boolean value indicating if the chatroom is successfully established
	 * @throws RemoteException
	 */
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
	public void start_client(){
		rmiUtils.startRMI(IRMI_Defs.CLASS_SERVER_PORT_CLIENT);
		IHost host = new ClientHost(view, this);
		try{
			registry = rmiUtils.getLocalRegistry();
			host_stub = (IHost) UnicastRemoteObject.exportObject(host,IHost.CONNECTION_PORT_CLIENT);
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
	
	
	
	/**
	 * stop the RMI and unbind the IHost stub when the main windows is closed
	 */
	public void stop() {
		try {
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
		for(MiniController c:allminiMVCs){
			c.quit();
		}		
	}
	/**
	 * method used to get local IP address
	 * 
	 * @return local IP address
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public String getLocalAddress() throws SocketException, UnknownHostException {
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
	
	/**
	 * connect to server
	 * @param IpAddress address of server
	 */
	public void connect(String IpAddress){
		
		/*
		 * get ServerRegistry
		 */
		Registry remoteRegistry = rmiUtils.getRemoteRegistry(IpAddress);
		try{
		/*
		 * get serverHost
		 */
		remote_host = (IHost) remoteRegistry.lookup(IHost.BOUND_NAME);
		/*
		 * send server ownHost
		 */
		remote_host.sendLocalHostStub(host_stub);
		remote_host.requestInvite(host_stub);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * pop a view with some options of chatroom
	 */
	public void MakeOption(){
		
		
				try {
					
					remote_host.requestInvite(host_stub);
					
				} catch (RemoteException e) {
					e.printStackTrace();
				}
			}
		
		
	
	

}