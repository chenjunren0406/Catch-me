package jc82_yw31.Client.Controller;



import java.awt.EventQueue;
import java.rmi.RemoteException;











import jc82_yw31.Client.Model.*;
import jc82_yw31.Client.View.*;

/**
 * the main controller 
 * the controller has a model and a view 
 * which the controller would controll
 * @author Administrator
 *
 */
public class Controller {
	private ClientMainModel model;
	
	private client_frame view;
    /**
     * the constructor of the controller
     * @throws RemoteException
     */
	public Controller() throws RemoteException{
		/**
		 * instantiate an object of the main model
		 */
		model = new ClientMainModel(new ViewAdapter(){
			/**
			 * calls back to the main view and append the String on the textArea
			 */
			public void append(String s) {
				view.append(s);
			}
			/**
			 * calls back to the main view and pops up a dialog to invite the local user to a chatroom
			 */
			@SuppressWarnings("unused")
			public boolean sendInvite(String chatroomInfo) {
				view.append(chatroomInfo);
			//	return view.getInvited(chatroomInfo);	
				return true;
			}
		});
		/**
		 * instantiate an object of the main view
		 */
		view = new client_frame(new ModelAdapter(){
			/**
			 * create a chat room on the local machine
			 */
//			public void creatChatRoom(String nameOfchatroom) {
//
//				IChatRoom chatroom = new ChatRoom(nameOfchatroom); //instantiate a new empty chatroom
//				/**
//				 * starting the mini-MVC and add the local user stub to the chatroom
//				 */
//				try {
//					model.start_miniC(chatroom);
//				} catch (RemoteException e) {
//					e.printStackTrace();
//				}
//			}
			/**
			 * stop the RMI and quit the application.
			 */
			@Override
			public void quit() {
				model.stop();				
			}

			@Override
			public void ConnectAndMakeChooseOption(String ipaddress) {
				// TODO Auto-generated method stub
				model.connect(ipaddress);
			}

			@Override
			public void join() {
				// TODO Auto-generated method stub
				model.MakeOption();
			}
			
		});


	}
	/**
	 * Starts the view then the model.  The view needs to be started first so that it can display 
	 * the model status updates as it starts.
	 */
	public void start(){
		view.start();
		model.start_client();
	}

	/**
	 * the main method starts the system by starting the main controller
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					(new Controller()).start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}

}