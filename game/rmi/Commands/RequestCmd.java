package jc82_yw31.rmi.Commands;

import jc82_yw31.Client.MiniModel.Cmd2miniModelAdapt;
import jc82_yw31.Client.MiniModel.StatusFail;
import jc82_yw31.Client.MiniModel.StatusOK;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;
import comp310f13.rmiChat.IRequestCmd;
import comp310f13.rmiChat.IStatusFail;
import comp310f13.rmiChat.IStatusOk;
import comp310f13.rmiChat.IUser;
/**
 * request cmd to request cmd for the unkown packet
 * @author Administrator
 *
 */
public class RequestCmd extends ADataPacketAlgoCmd<ADataPacket, IRequestCmd, Void>{
	
	private static final long serialVersionUID = -829865936215451104L;
	private transient Cmd2miniModelAdapt cmd2ModelAdapter;
	/**
	 * adapter from the command to the minimodel
	 */
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = (Cmd2miniModelAdapt) cmd2ModelAdpt;
	}
    /**
     * get the datatype from the host
     * and request the cmd from the sender for the same datatype
     */
	public ADataPacket apply(Class<?> index, DataPacket<IRequestCmd> host,
			Void... params) {
		try{
			Class<?> id = host.getData().getID();
			IUser sender = host.getSender();
			cmd2ModelAdapter.cmdRequested(id, sender);

			return new DataPacket<IStatusOk>(IStatusOk.class, cmd2ModelAdapter.getLocalUserStub(), new StatusOK());
		} catch (Exception e) {
			e.printStackTrace();
			return new DataPacket<IStatusFail>(IStatusFail.class, cmd2ModelAdapter.getLocalUserStub(), new StatusFail(host));
		}
	}

}
