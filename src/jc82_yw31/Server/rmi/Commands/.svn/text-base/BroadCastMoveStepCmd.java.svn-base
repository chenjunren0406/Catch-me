package jc82_yw31.Server.rmi.Commands;

import comp310f13.rmiChat.IStatusOk;

import jc82_yw31.Server.MiniModel.ATellServerToMove;
import jc82_yw31.Server.MiniModel.Cmd2miniModelAdapt;
import jc82_yw31.Server.MiniModel.StatusOK;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;

/**
 * This cmd is use to handle when client answer the right question
 * 
 * This cmd only run on the server side
 * @author Junren
 *
 */
public class BroadCastMoveStepCmd extends ADataPacketAlgoCmd<ADataPacket, ATellServerToMove, Void>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 410175459015823123L;

	private transient Cmd2miniModelAdapt cmd2miniModelAdapt;
	@Override
	public ADataPacket apply(Class<?> index,
			DataPacket<ATellServerToMove> host, Void... params) {
		
		cmd2miniModelAdapt.sendAnswerToServer(host.getData().getdistance(), host.getData().getTeamNO());
		cmd2miniModelAdapt.addScoreToTeam(host.getData().getTeamNO());
		return new DataPacket<IStatusOk>(IStatusOk.class, cmd2miniModelAdapt.getLocalUserStub(), new StatusOK());
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		
		this.cmd2miniModelAdapt = (Cmd2miniModelAdapt) cmd2ModelAdpt;
	}

}
