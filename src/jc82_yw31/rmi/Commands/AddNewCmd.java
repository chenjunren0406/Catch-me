package jc82_yw31.rmi.Commands;

import jc82_yw31.Client.MiniModel.Cmd2miniModelAdapt;
import jc82_yw31.Client.MiniModel.StatusFail;
import jc82_yw31.Client.MiniModel.StatusOK;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;
import comp310f13.rmiChat.IAddCmd;
import comp310f13.rmiChat.IStatusFail;
import comp310f13.rmiChat.IStatusOk;
/**
 * add new cmd command
 * extends the datapacket algo cmd which the host type is IAddCmd
 * @author Administrator
 *
 */
public class AddNewCmd extends ADataPacketAlgoCmd<ADataPacket, IAddCmd, Void>{
	/**
	 * serialVersionUID
	 * private field model adapter point to the minimodel
	 */
	private static final long serialVersionUID = 5754909863357256535L;
	private transient Cmd2miniModelAdapt cmd2ModelAdapter;

	 /**
     * the set the command to model adapter
     */
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = (Cmd2miniModelAdapt) cmd2ModelAdpt;		
	}
	/**
	 * the apply method which will get the new cmd from the host
	 * and add the new cmd use the minimodel adapter
	 */
	@SuppressWarnings("unchecked")
	public ADataPacket apply(Class<?> index, DataPacket<IAddCmd> host,
			Void... params) {
		try{
			/**
			 * install the new cmd to the algo
			 */
			Class<?> id = host.getData().getID();
			ADataPacketAlgoCmd<ADataPacket, ?, Void> newCmd = (ADataPacketAlgoCmd<ADataPacket, ?, Void>) host.getData().getNewCmd();
	
			if(null != newCmd){
				cmd2ModelAdapter.addCmd(id,newCmd);
			}
			
			System.out.println("happy cmd");
			return new DataPacket<IStatusOk>(IStatusOk.class, cmd2ModelAdapter.getLocalUserStub(), new StatusOK());
			
		} catch (Exception e) {
			e.printStackTrace();
			return new DataPacket<IStatusFail>(IStatusFail.class, cmd2ModelAdapter.getLocalUserStub(), new StatusFail(host));
		}
	}

	
}
