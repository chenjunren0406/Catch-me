package jc82_yw31.Server.rmi.Commands;

import comp310f13.rmiChat.IStatusOk;

import jc82_yw31.Server.MiniModel.AnswerQuestionPacket;
import jc82_yw31.Server.MiniModel.Cmd2miniModelAdapt;
import jc82_yw31.Server.MiniModel.StatusOK;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;

/**
 * When play answer one question, client will send this packet to server, no matter the answer is right or not
 * @author Junren
 *
 */
public class PlayAnswerOneQuestionCmd extends ADataPacketAlgoCmd<ADataPacket,AnswerQuestionPacket , Void> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5293608128937518162L;
	
	private transient Cmd2miniModelAdapt cmd2miniModelAdapt;
	@Override
	public ADataPacket apply(Class<?> index,
			DataPacket<AnswerQuestionPacket> host, Void... params) {
		cmd2miniModelAdapt.answerOneQuestion();
		return new DataPacket<IStatusOk>(IStatusOk.class, cmd2miniModelAdapt.getLocalUserStub(), new StatusOK());
	}

	@Override
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2miniModelAdapt = (Cmd2miniModelAdapt) cmd2ModelAdpt;
	}

}
