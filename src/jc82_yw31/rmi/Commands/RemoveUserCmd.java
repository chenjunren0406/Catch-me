package jc82_yw31.rmi.Commands;

import jc82_yw31.Client.MiniModel.Cmd2miniModelAdapt;
import jc82_yw31.Client.MiniModel.StatusFail;
import jc82_yw31.Client.MiniModel.StatusOK;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;
import comp310f13.rmiChat.IRemoveUser;
import comp310f13.rmiChat.IStatusFail;
import comp310f13.rmiChat.IStatusOk;
import comp310f13.rmiChat.IUser;
/**
 * remove user cmd class 
 * extends the datapacket algo cmd which the host type is IRemoveUser
 * @author Administrator
 *
 */
public class RemoveUserCmd extends ADataPacketAlgoCmd<ADataPacket, IRemoveUser, Void>{
	/**
	 * serialVersionUID
	 * private field model adapter point to the minimodel
	 */
	private static final long serialVersionUID = 7028138001867665133L;
	private transient Cmd2miniModelAdapt cmd2ModelAdapter;
	/**
	 * the apply method which will call the minimodel to remove the user in the chatroom
	 */
	public ADataPacket apply(Class<?> index, DataPacket<IRemoveUser> host,
			Void... params) {
		try{
			IUser user2add = host.getData().getUser();
			cmd2ModelAdapter.removeUser(user2add);

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
