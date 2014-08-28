package jc82_yw31.rmi.Commands;

import jc82_yw31.Server.MiniModel.Cmd2miniModelAdapt;
import jc82_yw31.Server.MiniModel.StatusOK;
import comp310f13.rmiChat.IStatusOk;
import comp310f13.rmiChat.IStatusReject;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;

public class RejectCmd extends ADataPacketAlgoCmd<ADataPacket, IStatusReject, Void>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8507113010429318822L;
	private transient Cmd2miniModelAdapt cmd2ModelAdapter;
	@Override
	public ADataPacket apply(Class<?> index, DataPacket<IStatusReject> host,
			Void... params) {
		cmd2ModelAdapter.appendInfo(host.getData().getMsg());
		return new DataPacket<IStatusOk>(IStatusOk.class, cmd2ModelAdapter.getLocalUserStub(), new StatusOK());
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		
		this.cmd2ModelAdapter = (Cmd2miniModelAdapt) cmd2ModelAdpt;
	}

}
