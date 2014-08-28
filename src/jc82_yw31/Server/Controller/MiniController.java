package jc82_yw31.Server.Controller;

import java.awt.Component;
import java.rmi.RemoteException;




import jc82_yw31.Server.MiniModel.ChatRoom;
import jc82_yw31.Server.MiniModel.MainModelAdapter;
import jc82_yw31.Server.MiniModel.MiniModel;
import jc82_yw31.Server.MiniModel.MiniViewAdapter;
import jc82_yw31.Server.MiniView.MiniModelAdapter;
import jc82_yw31.Server.MiniView.MiniView;
/**
 * the mini controller would controll the mini model and the mini view
 * so there are two fields in the controller 
 * @author Administrator
 *
 */
public class MiniController {
	private MiniModel minimodel;
	private MiniView miniview;
    /**
     * the constructor of the mini controller
     * @param mainmodeladapter is the adpater used to communicated with the main model
     * @param chatroom is the chatroom used in the mini controller
     * @throws RemoteException
     */
	public MiniController(MainModelAdapter mainmodeladapter, ChatRoom chatroom) throws RemoteException{
		minimodel = new MiniModel(new MiniViewAdapter(){
			/**
			 * calls back to the view to append String on the textArea
			 */
			public void append(String s) {
				miniview.append(s);
			}
			/**
			 * calls back to the view to add the newly joined user's to the comboBox
			 */
			@Override
			public void addUserName(String name) {
				miniview.addUserName(name);				
			}
			/**
			 * append some information on the mini view
			 */
			public void appendInfo(String s) {
				miniview.appendInfo(s);				
			}
			/**
			 * add a new component to the miniview
			 */
			@Override
			public void addComponent(final String name, final Component newComp) {

				Thread newThread = new Thread() {
				    public void run() {
				    	miniview.addComponent(name, newComp);
				    }
				};
 
				newThread.start();  
			}

		}, mainmodeladapter, chatroom);
       
		miniview = new MiniView(new MiniModelAdapter(){
			/**
			 * quit the chatroom when the window is closed. Call the quit method in minimodel to remove the user 
			 */
			public void quit() {
				minimodel.quit();	
			}
			/**
			 * send a text message to other users in the chatroom
			 */
			public void sendText(String text) {				
				minimodel.sendText(text);
			}
			/**
			 * call the invite method in minimodel and invite a remote user to the chatroom
			 */
			@Override
			public void invite(String remoteUser) {
				minimodel.invite(remoteUser);

			}
			@Override
			public void startGame() {
				minimodel.sendMap();
				
			}

		});
	}
	/**
	 * start the minicontroller by activating both the minimodel and the miniview
	 */
	public void start(){
		minimodel.start();
		miniview.start();
	}
	/**
	 * quit the chat room associated with this mini-MVC
	 */
	public void quit(){
		minimodel.quit();
	}

}