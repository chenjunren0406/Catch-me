package jc82_yw31.Server.rmi.Commands;

import java.rmi.RemoteException;

import jc82_yw31.Server.MiniModel.Cmd2miniModelAdapt;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;
//import rmiChat.MiniModel.Cmd2miniModelAdapt;
import comp310f13.rmiChat.IStatusOk;
/**
 * ok cmd class 
 * extends the datapacket algo cmd which the host type is IStatusOk
 * @author Administrator
 *
 */
public class OkCmd extends ADataPacketAlgoCmd<ADataPacket, IStatusOk, Void>{
	/**
	 * serialVersionUID
	 * private field model adapter point to the minimodel
	 */
	private static final long serialVersionUID = -7184340468899561589L;
	private transient Cmd2miniModelAdapt cmd2ModelAdapter;
	/**
	 * when a user receive ok datapacket, it will do nothing
	 */
	public ADataPacket apply(Class<?> index, DataPacket<IStatusOk> host,
			Void... params) {
		try {
			cmd2ModelAdapter.appendInfo(host.getSender().getName()+": successfully received the data packet");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
    /**
     * the set the command to model adapter
     */
	public void setCmd2ModelAdpt(ICmd2ModelAdapter cmd2ModelAdpt) {
		this.cmd2ModelAdapter = (Cmd2miniModelAdapt) cmd2ModelAdpt;	
	}

}
