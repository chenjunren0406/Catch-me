package jc82_yw31.Server.rmi.Commands;

import java.util.Date;

import jc82_yw31.Server.MiniModel.StatusFail;
import jc82_yw31.Server.MiniModel.StatusOK;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;
import comp310f13.rmiChat.IStatusFail;
import comp310f13.rmiChat.IStatusOk;
import comp310f13.rmiChat.ITextMessage;
/**
 * The cmd to process with ITextMessage dataPacket
 *
 */
public class TextMessageCmd extends ADataPacketAlgoCmd<ADataPacket, ITextMessage, Void>{

	private static final long serialVersionUID = 1L;
	private transient ICmd2ModelAdapter cmd2ModelAdapter;
	/**
	 * adapter from the command to the minimodel
	 */
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = cmd2ModelAdpt;				
	}
	/**
	 * append the String information from the text message to the miniview
	 */
	public ADataPacket apply(Class<?> index, DataPacket<ITextMessage> host,
			Void... params) {
		try{
			String text = host.getData().getMsg();
			String name = host.getData().getName();
			Date time = host.getData().getTime();
			cmd2ModelAdapter.append(name + "("+ time + ")"+ ":" + text);
			return new DataPacket<IStatusOk>(IStatusOk.class, cmd2ModelAdapter.getLocalUserStub(), new StatusOK());
		} catch (Exception e) {
			e.printStackTrace();
			return new DataPacket<IStatusFail>(IStatusFail.class, cmd2ModelAdapter.getLocalUserStub(), new StatusFail(host));
		}
	}
}
