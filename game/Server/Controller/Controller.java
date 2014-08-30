package jc82_yw31.Server.Controller;

import java.awt.EventQueue;
import java.rmi.RemoteException;

import jc82_yw31.Server.Controller.Controller;
import jc82_yw31.Server.Model.MainModel;
import jc82_yw31.Server.Model.ViewAdapter;
import jc82_yw31.Server.View.ModelAdapter;
import jc82_yw31.Server.View.server_frame;
import comp310f13.rmiChat.IChatRoom;
/**
 * this is main controller of the whole game
 * @author chen
 *
 */
public class Controller {
    private MainModel model;
    private server_frame frame;
    public Controller(){
    	model = new MainModel(new ViewAdapter(){

			public void append(String s) {
				frame.append(s);
				
			}
    		
    	});
    	frame = new server_frame(new ModelAdapter(){

			@Override
			public void createLobby() {
				try {
					IChatRoom localChatRoom = model.createLobby();
					model.start_miniC(localChatRoom);
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				
			}


	
    		
    	}){

			/**
			 * 
			 */
			private static final long serialVersionUID = -4320716823137956324L;
    		
    	};
    }
    /**
     * start the main mvc
     */
    public void start(){
    	frame.start();
    	model.start_Server();
    }
    
    /**
     * main thread
     * @param args
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
