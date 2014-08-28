package jc82_yw31.Server.MiniModel;

import java.rmi.RemoteException;
import java.util.UUID;

import jc82_yw31.Server.rmi.Commands.*;

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
	 * use to make connect to minimodel
	 */
	private Cmd2miniModelAdapt Cmd2ModelAdapter;
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
		this.Cmd2ModelAdapter = Cmd2ModelAdapter;
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
		 * To show map 
		 */
		MapCmd mapCmd = new MapCmd();
		mapCmd.setCmd2ModelAdpt(Adpt);
		algo.setCmd(Amap.class, mapCmd);
		
		
		/**
		 * To tell client how to move
		 */
		
		MoveCmd moveCmd = new MoveCmd();
		moveCmd.setCmd2ModelAdpt(Adpt);
		algo.setCmd(MoveSteps.class, moveCmd);
		
		/**
		 * To tell server result of each round of move, and broadcast it other player
		 * 
		 * This command only runs on server, because the adpt is cmd2miniModelAdpt, not icmd..........Adapt
		 */
		 BroadCastMoveStepCmd broadCmd = new BroadCastMoveStepCmd();
		 broadCmd.setCmd2ModelAdpt(Adpt);;
		 algo.setCmd(ATellServerToMove.class, broadCmd);
		 
		 /**
		  * To set TeamNo to each gamePlayer
		  * 
		  * 
		  * This cmd only runs on clients side!!!
		  */
		 SetTeamNoCmd teamNoCmd = new SetTeamNoCmd();
		 teamNoCmd.setCmd2ModelAdpt(Adpt);
		 algo.setCmd(SetTeamNo.class,teamNoCmd);
		 
		 /**
		  * To tell which team win the game
		  * 
		  * This cmd only runs on clients side!!!
		  */
		 WinOrLoseCmd winOrLoseCmd = new WinOrLoseCmd();
		 winOrLoseCmd.setCmd2ModelAdpt(Adpt);
		 algo.setCmd(TeamWinPacket.class, winOrLoseCmd);
		 
		 PlayAnswerOneQuestionCmd oneQuestionCmd = new PlayAnswerOneQuestionCmd();
		 oneQuestionCmd.setCmd2ModelAdpt(Adpt);
		 algo.setCmd(AnswerQuestionPacket.class, oneQuestionCmd);
		 
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
		System.out.println("data packet from :" + dp.getSender().getName());
		return dp.execute(algo);
	}
	/**
	 * accesser to the algo of the user
	 * @return algo
	 */
	public DataPacketAlgo<ADataPacket, Void> getAlgo(){
		return this.algo;
	}
	
	/**
	 * send cmd to another user to move
	 * @param distance
	 * @param teamNO
	 */
	public void sendCmdtoGamePlayer(int distance,int teamNO){
		Cmd2ModelAdapter.sendAnswerToServer(distance, teamNO);
	}
	
}
