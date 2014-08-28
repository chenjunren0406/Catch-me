package jc82_yw31.rmi.Commands;

import jc82_yw31.Client.MiniModel.Cmd2miniModelAdapt;
import jc82_yw31.Client.MiniModel.StatusOK;
import map.MapLayer;
import map.MapPanel;
import provided.datapacket.ADataPacket;
import provided.datapacket.ADataPacketAlgoCmd;
import provided.datapacket.DataPacket;
import provided.datapacket.ICmd2ModelAdapter;
import comp310f13.rmiChat.IStatusOk;

/**
 * This is a cmd to add map to game model 
 * @author Junren
 *
 */
public class MapCmd extends ADataPacketAlgoCmd<ADataPacket, MapLayer, Void>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4708637199468325666L;
	private transient Cmd2miniModelAdapt cmd2ModelAdapter;
    /**
     * the constructor of the default Command
     */
	public MapCmd(){
		
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

	public ADataPacket apply(Class<?> index, DataPacket<MapLayer> host,
			Void... params) {
		MapPanel panel = new MapPanel();
		panel.addMapLayer(host.getData());
		cmd2ModelAdapter.addComponent("Junren", panel);
		return new DataPacket<IStatusOk>(IStatusOk.class, cmd2ModelAdapter.getLocalUserStub(), new StatusOK());
	}
	

}
