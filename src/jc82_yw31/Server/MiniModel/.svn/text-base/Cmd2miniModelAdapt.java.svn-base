package jc82_yw31.Server.MiniModel;

import java.awt.Component;

import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.DataPacketAlgo;
import provided.datapacket.ICmd2ModelAdapter;
import comp310f13.rmiChat.IUser;

/**
 * a local adapt that connects between the command and the minimodel. 
 *
 */
public interface Cmd2miniModelAdapt extends ICmd2ModelAdapter {
	/**
	 * Gets a reference to the local IUser stub which is needed to instantiate status packets for return objects.
	 * @return The local IUser's stub.
	 */
	public abstract IUser getLocalUserStub();

	/**
	 * Appends the given string onto a text display somewhere on the host ChatApp's GUI.
	 * @param s A string to display
	 */
	public abstract void append(String s);

	/**
	 * Allows the command to give a java.awt.Component to the host ChatApp to be displayed on 
	 * its GUI somewhere. 
	 * @param name  A title for the component, useful for tabs, frame titles, etc.
	 * @param newComp  The component to display.
	 */
	public void addComponent(String name, Component newComp);

	/**
	 * calls back to the minimodel and add a user to the chatroom
	 */
	public void addUser(IUser userStub);
	/**
	 * calls back to the minimodel to remove a user stub
	 */
	public void removeUser(IUser userStub);

	/**
	 * calls back to the minimodel to save an unknown data packet
	 * @param index
	 * @param host
	 */
	public abstract void addUnknown(Class<?> index, DataPacket<Object> host);
	/**
	 * calls back to the minimodel to add a new command to the algo
	 * @param id for the command
	 * @param newCmd
	 */
	public abstract void addCmd(Class<?> id,
			ADataPacketAlgoCmd<ADataPacket, ?, Void> newCmd);
	/**
	 * calls back to the minimodel to look up a command and send it to the requester
	 * @param id
	 * @param sender
	 */
	public abstract void cmdRequested(Class<?> id, IUser sender);
	/**
	 * append the connection information on the corresponding text area in the miniview
	 * @param string
	 */
	public abstract void appendInfo(String string);
	
	/**
	 * send answer to server
	 */
	public abstract void sendAnswerToServer(int distance, int teamNO);
	
	/**
	 * add one score to one team
	 */
	public abstract void addScoreToTeam(int teamNO);
	
	/**
	 * answer one question and check who wins
	 */
	public abstract void answerOneQuestion();
	
	public abstract DataPacketAlgo<ADataPacket, Void> getAlgo();
}
