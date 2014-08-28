package jc82_yw31.Server.rmi.Commands;

import jc82_yw31.Server.MiniModel.Cmd2miniModelAdapt;
import jc82_yw31.Server.MiniModel.StatusOK;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;
import comp310f13.rmiChat.IStatusFail;
import comp310f13.rmiChat.IStatusOk;
/**
 * fail cmd class 
 * extends the datapacket algo cmd which the host type is IStatusFail
 * @author Administrator
 *
 */
public class FailCmd extends ADataPacketAlgoCmd<ADataPacket, IStatusFail, Void>{
	/**
	 * serialVersionUID
	 * private field model adapter point to the minimodel
	 */
	private static final long serialVersionUID = 2045931910154156561L;
	private transient Cmd2miniModelAdapt cmd2ModelAdapter;
	/**
	 * the apply method which will call the minimodel to notify the user there is something wrong
	 */
	public ADataPacket apply(Class<?> index, DataPacket<IStatusFail> host,
			Void... params) {
		cmd2ModelAdapter.appendInfo(host.getData().getMsg());
		return new DataPacket<IStatusOk>(IStatusOk.class, cmd2ModelAdapter.getLocalUserStub(), new StatusOK());
	}

    /**
     * the set the command to model adapter
     */
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = (Cmd2miniModelAdapt) cmd2ModelAdpt;
		
	}

}
