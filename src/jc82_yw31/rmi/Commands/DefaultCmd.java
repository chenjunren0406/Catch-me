package jc82_yw31.rmi.Commands;

import jc82_yw31.Client.MiniModel.ArequestCmd;
import jc82_yw31.Client.MiniModel.Cmd2miniModelAdapt;
import comp310f13.rmiChat.IRequestCmd;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;
/**
 * the default command used which when the user has no command to process the datapacket
 * */
public class DefaultCmd extends ADataPacketAlgoCmd<ADataPacket, Object, Void>{
	/**
	 * serialVersionUID
	 * private field model adapter point to the minimodel
	 */
	private static final long serialVersionUID = -3203983562115843200L;
	private transient Cmd2miniModelAdapt cmd2ModelAdapter;
    /**
     * the constructor of the default Command
     */
	public DefaultCmd(){
		
	}
	 /**
     * the set the command to model adapter
     */
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = (Cmd2miniModelAdapt) cmd2ModelAdpt;				
	}
	/**
	 * return a IRequest dataPacket to ask the sender for the command to process the data
	 */
	public ADataPacket apply(Class<?> index, DataPacket<Object> host,
			Void... params) {
		
		cmd2ModelAdapter.append("requesting the datapacket......");
		cmd2ModelAdapter.addUnknown(index,host);

		return new DataPacket<IRequestCmd>(IRequestCmd.class, cmd2ModelAdapter.getLocalUserStub(), new ArequestCmd(index));
	}
	
}
