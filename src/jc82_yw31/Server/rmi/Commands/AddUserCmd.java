package jc82_yw31.Server.rmi.Commands;

import jc82_yw31.Client.MiniModel.StatusOK;
import jc82_yw31.Server.MiniModel.Cmd2miniModelAdapt;
import jc82_yw31.Server.MiniModel.StatusFail;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;
import comp310f13.rmiChat.IAddUser;
import comp310f13.rmiChat.IStatusFail;
import comp310f13.rmiChat.IStatusOk;
import comp310f13.rmiChat.IUser;
/**
 * adduser cmd class 
 * extends the datapacket algo cmd which the host type is IaddUser
 * @author Administrator
 *
 */
public class AddUserCmd extends ADataPacketAlgoCmd<ADataPacket, IAddUser, Void>{
	/**
	 * serialVersionUID
	 * private field model adapter point to the minimodel
	 */
	private static final long serialVersionUID = 4204769376821222174L;
	private transient Cmd2miniModelAdapt cmd2ModelAdapter;
	/**
	 * the apply method which will call the minimodel to add the user into the chatroom
	 */
	public ADataPacket apply(Class<?> index, DataPacket<IAddUser> host,
			Void... params) {
		try{
			IUser user2add = host.getData().getUser();
			cmd2ModelAdapter.addUser(user2add); //calls back to the mini model to add a user to the chat room	
			System.out.println("new user" + host.getSender().getName());
			return new DataPacket<IStatusOk>(IStatusOk.class, cmd2ModelAdapter.getLocalUserStub(), new StatusOK());
		} catch (Exception e) {
			e.printStackTrace();
			return new DataPacket<IStatusFail>(IStatusFail.class, cmd2ModelAdapter.getLocalUserStub(), new StatusFail(host));
		}
	}
    /**
     * the set the command to model adapter
     */
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = (Cmd2miniModelAdapt) cmd2ModelAdpt;
	}

}
